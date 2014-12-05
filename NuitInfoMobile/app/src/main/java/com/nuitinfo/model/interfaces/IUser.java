package com.nuitinfo.model.interfaces;

import com.nuitinfo.model.Base;
import com.nuitinfo.model.Users;

/**
 * Created by tspecker on 05/12/14.
 */
public interface IUser {
    void userResponseError(Users.User result);

    void userResponse(Users.User result);
}
