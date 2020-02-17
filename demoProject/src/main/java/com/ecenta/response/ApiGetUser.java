package com.ecenta.response;

import com.ecenta.data.UserData;
import com.ecenta.entity.UserEntity;
import com.ecenta.request.CreateUserRequest;
import com.google.gson.annotations.Expose;

public class ApiGetUser {
    private String code;
    private String message;
    @Expose
    private UserData data;

    public ApiGetUser(String code, String message, UserData data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserData getData() {
        return data;
    }

    public void setData(UserData data) {
        this.data = data;
    }
}
