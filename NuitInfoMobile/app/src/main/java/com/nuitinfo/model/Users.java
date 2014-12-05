package com.nuitinfo.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.nuitinfo.Util.VolleyUtility;
import com.nuitinfo.model.interfaces.IBaseCallback;
import com.nuitinfo.model.interfaces.IUser;

import java.lang.reflect.Type;
import java.util.ArrayList;

import static com.nuitinfo.Util.Constants.GLOBAL_URL;

/**
 * Created by tiby on 04/12/2014.
 */
public class Users {

    public ArrayList<User> users;

    public static class User {

        private static final String LOGIN = "/auth/signin";
        private static final String LOGOUT = "/auth/signup";

        public String _id;
        public String email;
        public String created;
        public String country;
        public String state;
        public String city;
        public String zipcode;
        public String street;
        public String birthdate;
        public String description;
        public String picture;
        public String lastname;
        public String firstname;
        public String[] roles;

        public static void connexion(String email, String pwd, final IUser callback) {
            String url = GLOBAL_URL + LOGIN;

            ParamRequests paramsObj = new ParamRequests();
            paramsObj.list.add(new ParamRequests.ParamRequest("email", email));
            paramsObj.list.add(new ParamRequests.ParamRequest("password", pwd));

            VolleyUtility.makePostRequest(url, paramsObj, new IBaseCallback() {

                @Override
                public void responseError(Base result) {

                    // Parse response into my object
                    Type collectionType = new TypeToken<User>() {
                    }.getType();
                    // return deserializer object
                    User tmp = new User();
                    Gson gson = new GsonBuilder().create();
                    tmp = gson.fromJson(result.message, collectionType);

                    callback.userResponseError(tmp);
                }

                @Override
                public void response(Base result) {

                    // Parse response into my object
                    Type collectionType = new TypeToken<User>() {
                    }.getType();
                    // return deserializer object
                    User tmp = new User();
                    Gson gson = new GsonBuilder().create();
                    tmp = gson.fromJson(result.message, collectionType);

                    callback.userResponse(tmp);
                }
            });
        }

        public static void deconnexion(int id, final IUser callback) {
            String url = GLOBAL_URL + LOGOUT;

            ParamRequests paramsObj = new ParamRequests();
            paramsObj.list.add(new ParamRequests.ParamRequest("id", String.valueOf(id)));

            VolleyUtility.makePostRequest(url, paramsObj, new IBaseCallback() {

                @Override
                public void responseError(Base result) {

                    // Parse response into my object
                    Type collectionType = new TypeToken<User>() {
                    }.getType();
                    // return deserializer object
                    User tmp = new User();
                    Gson gson = new GsonBuilder().create();
                    tmp = gson.fromJson(result.message, collectionType);

                    callback.userResponseError(tmp);
                }

                @Override
                public void response(Base result) {

                    // Parse response into my object
                    Type collectionType = new TypeToken<User>() {
                    }.getType();
                    // return deserializer object
                    User tmp = new User();
                    Gson gson = new GsonBuilder().create();
                    tmp = gson.fromJson(result.message, collectionType);

                    callback.userResponse(tmp);
                }
            });
        }
    }
}
