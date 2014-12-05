package com.nuitinfo.model.interfaces;

import com.nuitinfo.model.MyError;

/**
 * Created by tspecker on 05/12/14.
 */
public interface IUser {
    void userResponseError(MyError result);

    void userResponse(MyError result);
}
