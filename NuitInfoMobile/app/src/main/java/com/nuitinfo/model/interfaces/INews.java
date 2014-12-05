package com.nuitinfo.model.interfaces;

import com.nuitinfo.model.News;

/**
 * Created by tspecker on 05/12/14.
 */
public interface INews {
    void newsResponseError(News obj);


    void newsResponse(News obj);
}
