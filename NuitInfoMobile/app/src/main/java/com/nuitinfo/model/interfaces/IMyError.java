package com.nuitinfo.model.interfaces;

import com.nuitinfo.model.MyError;

/**
 * Created by tiby on 05/12/2014.
 */
public interface IMyError {

    void responseError(MyError result);

    void response(MyError result);

}
