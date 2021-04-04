package com.CabPortal.Services;

import com.CabPortal.DAO.DBHandler;
import com.CabPortal.models.RegisterUserRequest;
import com.CabPortal.models.RegisterUserResponse;


public class UserService {

    private DBHandler dbHandler;

    public UserService(DBHandler dbHandler) {
        this.dbHandler=dbHandler;
    }

    public RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest)  throws  Exception{
        return null;
    }
}
