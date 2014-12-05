package com.nuitinfo.model;

import com.nuitinfo.Util.VolleyUtility;
import com.nuitinfo.model.interfaces.IBaseCallback;
import com.nuitinfo.model.interfaces.IUser;

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

        public int id;

        public static void connexion(String email, String pwd, final IUser callback) {
            String url = GLOBAL_URL + LOGIN;

            ParamRequests paramsObj = new ParamRequests();
            paramsObj.list.add(new ParamRequests.ParamRequest("email", email));
            paramsObj.list.add(new ParamRequests.ParamRequest("pwd", pwd));

            VolleyUtility.makeGetRequest(url, paramsObj, new IBaseCallback() {

                @Override
                public void responseError(Base result) {
                    callback.userResponseError(result);
                }

                @Override
                public void response(Base result) {
                    callback.userResponse(result);
                }
            });
        }

        public static void deconnexion(int id, final IUser callback) {
            String url = GLOBAL_URL + LOGOUT;

            ParamRequests paramsObj = new ParamRequests();
            paramsObj.list.add(new ParamRequests.ParamRequest("id", String.valueOf(id)));

            VolleyUtility.makeGetRequest(url, paramsObj, new IBaseCallback() {

                @Override
                public void responseError(Base result) {
                    callback.userResponseError(result);
                }

                @Override
                public void response(Base result) {
                    callback.userResponse(result);
                }
            });
        }
    }
}
