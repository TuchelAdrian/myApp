package com.ecenta.response;

import com.ecenta.data.UserData;
import com.ecenta.entity.UserEntity;

import java.util.List;

public class ApiGetAllUsersResponse {
    private String code;
    private List<UserData> data;
    private String message;

    public void setCode(String code) {
        this.code = code;
    }

    public void setUsers(List<UserData> users) {
        this.data = users;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public List<UserData> getUsers() {
        return data;
    }

    public String getMessage() {
        return message;
    }
}
