package com.example.saurab.abc.util;

/**
 * Created by saurab on 2/6/2016.
 */
public interface EndPoint {

    // ABC SERVER..
    String BASE_URL = "http://175.100.151.230:8080/abc";
    String BASE = "http://175.100.151.230:8080/";



    String REGISTER = BASE_URL + "/user/register";
    String LOGIN_URL = BASE_URL + "/login/auth";

    String FORGOT_PASS = BASE_URL + "/bypass/user/forgotPassword";




    String GET_USER_PROFILE = BASE_URL + "/user/get";


    String UPLOAD_REVIEW_IMAGE = BASE_URL + "/upload/bypass/review/picture/";


}
