package com.nuitinfo.model;

import java.util.ArrayList;

/**
 * Created by tiby on 04/12/2014.
 */
public class ParamRequests {

    public ArrayList<ParamRequest> list;

    public static class ParamRequest {
        public String Key;
        public String Value;

        public ParamRequest(String _key, String _value) {
            this.Key = _key;
            this.Value = _value;
        }
    }
}
