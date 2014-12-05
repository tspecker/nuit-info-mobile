package com.nuitinfo.model.interfaces;

import com.nuitinfo.model.Base;

/**
 * Created by tiby on 05/12/2014.
 */
public interface IBaseCallback {

    void responseError(Base result);

    void response(Base result);

}
