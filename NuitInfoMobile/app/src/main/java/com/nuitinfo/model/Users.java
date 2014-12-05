package com.nuitinfo.model;

import com.nuitinfo.Util.VolleyUtility;
import com.nuitinfo.model.interfaces.IMyError;
import com.nuitinfo.model.interfaces.IUser;

import java.util.ArrayList;

/**
 * Created by tiby on 04/12/2014.
 */
public class Users {

    public ArrayList<User> users;

    public Users() {

    }

    public static class User {

        public int id;

        public static void connexion(String email, String pwd, final IUser callback) {


            String url = "urlalazeub";
            ParamRequests paramObj = new ParamRequests();
            VolleyUtility.connexion(url, paramObj, new IMyError() {

                @Override
                public void responseError(MyError result) {
                    callback.userResponseError(result);
                }

                @Override
                public void response(MyError result) {
                    callback.userResponse(result);
                }
            });


        }
    }
}
