package com.nuitinfo.model.interfaces;

import com.nuitinfo.model.Base;

/**
 * Created by tspecker on 05/12/14.
 */
public interface IUser {
    void userResponseError(Base result);

    void userResponse(Base result);
}
