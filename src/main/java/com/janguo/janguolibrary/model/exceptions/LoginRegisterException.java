package com.janguo.janguolibrary.model.exceptions;

public class LoginRegisterException extends RuntimeException{
    public LoginRegisterException(){
        super();
    }
    public LoginRegisterException(String massage){
        super(massage);
    }
    public LoginRegisterException(String massage,Throwable cause){
        super(massage,cause);
    }

    public LoginRegisterException(Throwable cause){
        super(cause);
    }
}
