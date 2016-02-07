package com.example.saurab.abc.async;

/**
 * Created by saurab on 2/6/2016.
 */
import android.content.Context;
import android.net.ConnectivityManager;
import android.util.Base64;
import android.util.Log;


import com.example.saurab.abc.util.Constants;
import com.example.saurab.abc.util.SharedPreferenceHelper;
import com.example.saurab.abc.util.Utility;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;


public class AsyncUtils {

    public static boolean isOnline(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo()
                .isConnectedOrConnecting());
    }

    public static String getAuthorizationHeader(String uname, String pswd) {
        return Base64
                .encodeToString(
                        (uname + Constants.STR_COLON + pswd).getBytes(),
                        Base64.NO_WRAP);
    }


    public static Map<String, String> getCommonAuthHeaders(Context ctx) {
        Map<String, String> headers = new HashMap<String, String>();
//        headers.put(
//                Constants.HTTP_HEADER_AUTHORIZATION,
//                Constants.HTTP_HEADER_AUTHORIZATION_BASIC_APPEND
//                        + Constants.SPACE
//                        + AsyncUtils.getAuthorizationHeader(usr, pwd));
        headers.put(Constants.HTTP_HEADER_CONTENT_TYPE,
                Constants.HTTP_HEADER_ACCEPT_VAUE_JSON);
        String tokenAuth = SharedPreferenceHelper.getToken(ctx);
        Log.d("simple string", "" + tokenAuth);

        /*byte[] data = new byte[0];
        try {
            data = tokenAuth.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String base64 = Base64.encodeToString(data, Base64.DEFAULT);
        Log.d("encode string","base64");*/

        if (!Utility.isNullOrEmpty(tokenAuth)) {
            //headers.put(Constants.HTTP_HEADER_AUTHORIZATION, tokenAuth);
            headers.put(Constants.HTTP_HEADER_AUTHORIZATION, Base64
                    .encodeToString(
                            (tokenAuth).getBytes(),
                            Base64.NO_WRAP));
        }

        return headers;
    }


}

