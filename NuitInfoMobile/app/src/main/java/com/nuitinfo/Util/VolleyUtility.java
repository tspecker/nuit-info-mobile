package com.nuitinfo.Util;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.nuitinfo.AppController;
import com.nuitinfo.model.Base;
import com.nuitinfo.model.ParamRequests;
import com.nuitinfo.model.interfaces.IBaseCallback;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created by tiby on 04/12/2014.
 */
public class VolleyUtility {


    public static void makePostRequest(String url, final ParamRequests paramObj, final IBaseCallback callback) {
        String language = Locale.getDefault().getLanguage();
        String tag_json_obj = "json_obj_req";
        final String TAG = "Volley";
        StringRequest jsonObjReq = new StringRequest(Method.POST,
                url,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {

                        Base result = new Base(response, true);
                        callback.response(result);
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "MyError: " + error.getMessage());
                NetworkResponse responseNetwork = error.networkResponse;

                Base result = new Base(error.getMessage(), false);
                callback.responseError(result);
                // TODO
                /*if (responseNetwork != null) {


                }*/
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();

                for (ParamRequests.ParamRequest param : paramObj.list) {
                    params.put(param.Key, param.Value);
                }
                return params;
            }
        };

        // Adding request to request queue
        int socketTimeout = 50000;//30 seconds - change to what you want
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, 1, 1);
        jsonObjReq.setRetryPolicy(policy);
        AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);
    }

    public static void makeGetRequest(String url, final ParamRequests paramObj, final IBaseCallback callback) {
        String language = Locale.getDefault().getLanguage();
        String tag_json_obj = "json_obj_req";
        final String TAG = "Volley";
        StringRequest jsonObjReq = new StringRequest(Method.GET,
                url,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {

                        Base result = new Base(response, true);
                        callback.response(result);
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "MyError: " + error.getMessage());
                NetworkResponse responseNetwork = error.networkResponse;

                Base result = new Base(error.getMessage(), false);
                callback.responseError(result);

                // TODO
                /*if (responseNetwork != null) {


                }*/
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();

                for (ParamRequests.ParamRequest param : paramObj.list) {
                    params.put(param.Key, param.Value);
                }
                return params;
            }
        };

        // Adding request to request queue
        int socketTimeout = 50000;//30 seconds - change to what you want
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, 1, 1);
        jsonObjReq.setRetryPolicy(policy);
        AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);
    }
}
