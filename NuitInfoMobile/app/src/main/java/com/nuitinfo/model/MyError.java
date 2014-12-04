package com.nuitinfo.model;

/**
 * Created by tiby on 04/12/2014.
 */
public class MyError {

    public String Message;
    public boolean Success;

    public MyError(String _message, boolean _success) {
        this.Message = _message ;
        this.Success = _success ;
    }
}
