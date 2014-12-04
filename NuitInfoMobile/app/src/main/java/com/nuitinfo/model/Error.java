package com.nuitinfo.model;

/**
 * Created by tiby on 04/12/2014.
 */
public class Error {

    public String Message;
    public Boolean Success;

    public Error(String _message, boolean _success) {
        this.Message = _message ;
        this.Success = _success ;
    }
}
