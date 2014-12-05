package com.nuitinfo.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.nuitinfo.Util.VolleyUtility;
import com.nuitinfo.model.interfaces.IBaseCallback;
import com.nuitinfo.model.interfaces.INews;

import java.lang.reflect.Type;
import java.util.ArrayList;

import static com.nuitinfo.Util.Constants.GLOBAL_URL;

/**
 * Created by tspecker on 04/12/14.
 */
public class News {


    private static final String NEWS = "news";
    public ArrayList<Article> news;


    public static class Article {

        public int id;

    }


    public static void getNews(String email, String pwd, final INews callback) {
        // TODO modifer NEWS
        String url = GLOBAL_URL + NEWS;

        ParamRequests paramsObj = new ParamRequests();
        paramsObj.list.add(new ParamRequests.ParamRequest("email", email));
        paramsObj.list.add(new ParamRequests.ParamRequest("pwd", pwd));

        // TODO change method
        VolleyUtility.connexion(url, paramsObj, new IBaseCallback() {

            @Override
            public void responseError(Base result) {
                // Parse response into my object
                Type collectionType = new TypeToken<News>() {
                }.getType();
                // return deserializer object
                News tmp = new News();
                Gson gson = new GsonBuilder().create();
                tmp = gson.fromJson(result.message, collectionType);
                callback.newsResponseError(tmp);
            }

            @Override
            public void response(Base result) {
                // Parse response into my object
                Type collectionType = new TypeToken<News>() {
                }.getType();
                // return deserializer object
                News tmp = new News();
                Gson gson = new GsonBuilder().create();
                tmp = gson.fromJson(result.message, collectionType);
                callback.newsResponse(tmp);
            }
        });
    }
}
