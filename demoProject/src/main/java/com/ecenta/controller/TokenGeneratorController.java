package com.ecenta.controller;
import com.ecenta.data.AuthToken;
import com.ecenta.data.LoginData;
import com.ecenta.util.TokenProvider;
import com.ecenta.util.TokenResponse;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/token")
public class TokenGeneratorController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenUtil;

    @RequestMapping(value = "/generate-token", method = RequestMethod.POST)
    public String register(@RequestBody LoginData loginUser) throws AuthenticationException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        TokenResponse tokenResponse=new TokenResponse();
        tokenResponse.setStatus(200);
        tokenResponse.setToken(token);
        Gson gson=new Gson();
        return gson.toJson(tokenResponse);
    }

}
