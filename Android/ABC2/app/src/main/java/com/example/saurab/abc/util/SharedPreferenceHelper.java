package com.example.saurab.abc.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by saurab on 2/6/2016.
 */
public class SharedPreferenceHelper {

    // getting Abc Prefs
    public static SharedPreferences getTellofyPrefs(Context context) {
        SharedPreferences shared = context.getSharedPreferences(
                Constants.SP_PREFS, Context.MODE_PRIVATE);
        return shared;
    }


    // set Cropped Profile Pic
    public static void setCroppedUriPic(String value, Context context) {
        SharedPreferences.Editor editor = getTellofyPrefs(context).edit();
        editor.putString(Constants.SP_CROPED_URI, value);
        editor.apply();
    }

    // get Cropped Profile Pic
    public static String getCroppedUriPic(Context context) {
        return getTellofyPrefs(context).getString(Constants.SP_CROPED_URI, "");

    }


    // set Cropped Profile Pic
    public static void setCroppedProfilePic(String value, Context context) {
        SharedPreferences.Editor editor = getTellofyPrefs(context).edit();
        editor.putString(Constants.SP_PROFILE_PIC, value);
        editor.apply();
    }

    // get Cropped Profile Pic
    public static String getCroppedProfilePic(Context context) {
        return getTellofyPrefs(context).getString(Constants.SP_PROFILE_PIC, "");

    }

    // set isFirst
    public static void setNewUser(Boolean isFirst,
                                  Context context) {
        SharedPreferences.Editor editor = getTellofyPrefs(context).edit();
        editor.putBoolean(Constants.SP_NEW_USER, isFirst);
        editor.commit();
    }

    // get isFirst
    public static Boolean getNewUser(Context context) {
        return getTellofyPrefs(context).getBoolean(Constants.SP_NEW_USER, false);
    }


    // set isFirstLogin
    public static void setNewLogin(Boolean isFirst,
                                   Context context) {
        SharedPreferences.Editor editor = getTellofyPrefs(context).edit();
        editor.putBoolean(Constants.SP_NEW_LOGIN, isFirst);
        editor.commit();
    }

    // get isFirstLogin
    public static Boolean getNewLogin(Context context) {
        return getTellofyPrefs(context).getBoolean(Constants.SP_NEW_LOGIN, true);
    }


    // set isFbLogin
    public static void setFbLogin(Boolean isFirst,
                                  Context context) {
        SharedPreferences.Editor editor = getTellofyPrefs(context).edit();
        editor.putBoolean(Constants.SP_ISFB_LOG, isFirst);
        editor.commit();
    }

    // get isFbLogin
    public static Boolean getFbLogin(Context context) {
        return getTellofyPrefs(context).getBoolean(Constants.SP_ISFB_LOG, false);
    }

    // set isGPlusLogin
    public static void setGPlusLogin(Boolean isFirst,
                                     Context context) {
        SharedPreferences.Editor editor = getTellofyPrefs(context).edit();
        editor.putBoolean(Constants.SP_ISGPLUS_LOG, isFirst);
        editor.commit();
    }

    // get isGPlusLogin
    public static Boolean getGPlusLogin(Context context) {
        return getTellofyPrefs(context).getBoolean(Constants.SP_ISGPLUS_LOG, false);
    }


    // set isAppLogin
    public static void setAppLogin(Boolean isFirst,
                                   Context context) {
        SharedPreferences.Editor editor = getTellofyPrefs(context).edit();
        editor.putBoolean(Constants.SP_ISAPP_LOG, isFirst);
        editor.commit();
    }

    // get isAppLogin
    public static Boolean getAppLogin(Context context) {
        return getTellofyPrefs(context).getBoolean(Constants.SP_ISAPP_LOG, false);
    }

    //Profile_IMG
// set Profile_IMG
    public static void setProfile_IMG(String value, Context context) {
        SharedPreferences.Editor editor = getTellofyPrefs(context).edit();
        editor.putString(Constants.SP_Profile_IMG, value);
        editor.commit();
    }

    // get  Profile_IMG URL
    public static String getProfile_IMG(Context context) {
        return getTellofyPrefs(context).getString(Constants.SP_Profile_IMG, "");

    }

    // set GPLUS_IMAGE URL
    public static void setGPLUS_IMG(String value, Context context) {
        SharedPreferences.Editor editor = getTellofyPrefs(context).edit();
        editor.putString(Constants.SP_GPLUS_PIC, value);
        editor.commit();
    }

    // get  GPLUS_IMAGE URL
    public static String getGPLUS_IMG(Context context) {
        return getTellofyPrefs(context).getString(Constants.SP_GPLUS_PIC, "");

    }


    // set CITY NAME
    public static void setCityName(String value, Context context) {
        SharedPreferences.Editor editor = getTellofyPrefs(context).edit();
        editor.putString(Constants.SP_CITY_NAME, value);
        editor.commit();
    }

    // get  CITY NAME
    public static String getCityName(Context context) {
        return getTellofyPrefs(context).getString(Constants.SP_CITY_NAME, "");

    }

    // set FB_LAST_NAME
    public static void setFB_LASTNAME(String value, Context context) {
        SharedPreferences.Editor editor = getTellofyPrefs(context).edit();
        editor.putString(Constants.FB_LAST_NAME, value);
        editor.commit();
    }

    // get  FB_LAST_NAME
    public static String getFB_LASTNAME(Context context) {
        return getTellofyPrefs(context).getString(Constants.FB_LAST_NAME, "");

    }

    // set LATITUDE
    public static void setLATITUDE(String value, Context context) {
        SharedPreferences.Editor editor = getTellofyPrefs(context).edit();
        editor.putString(Constants.APP_LATITUDE, value);
        editor.commit();
    }

    // get  LATITUDE
    public static String getLATITUDE(Context context) {
        return getTellofyPrefs(context).getString(Constants.APP_LATITUDE, "");

    }


    // set LONGITUDE
    public static void setLONGITUDE(String value, Context context) {
        SharedPreferences.Editor editor = getTellofyPrefs(context).edit();
        editor.putString(Constants.APP_LONGITUDE, value);
        editor.commit();
    }

    // get  LONGITUDE
    public static String getLONGITUDE(Context context) {
        return getTellofyPrefs(context).getString(Constants.APP_LONGITUDE, "");

    }


    // set GPLUS_FIRST_NAME
    public static void setGPLUS_FIRSTNAME(String value, Context context) {
        SharedPreferences.Editor editor = getTellofyPrefs(context).edit();
        editor.putString(Constants.G_FIRST_NAME, value);
        editor.commit();
    }

    // get  GPLUS_FIRST_NAME
    public static String getGPLUS_FIRSTNAME(Context context) {
        return getTellofyPrefs(context).getString(Constants.G_FIRST_NAME, "");

    }

    // set GPLUS_LAST_NAME
    public static void setGPLUS_LASTNAME(String value, Context context) {
        SharedPreferences.Editor editor = getTellofyPrefs(context).edit();
        editor.putString(Constants.G_LAST_NAME, value);
        editor.commit();
    }

    // get  GPLUS_LAST_NAME
    public static String getGPLUS_LASTNAME(Context context) {
        return getTellofyPrefs(context).getString(Constants.G_LAST_NAME, "");

    }


    // set APP_FIRST_NAME
    public static void setAPP_FIRSTNAME(String value, Context context) {
        SharedPreferences.Editor editor = getTellofyPrefs(context).edit();
        editor.putString(Constants.APP_FIRST_NAME, value);
        editor.commit();
    }

    // get  APP_FIRST_NAME
    public static String getAPP_FIRSTNAME(Context context) {
        return getTellofyPrefs(context).getString(Constants.APP_FIRST_NAME, "");

    }

    // set APP_LAST_NAME
    public static void setAPP_LASTNAME(String value, Context context) {
        SharedPreferences.Editor editor = getTellofyPrefs(context).edit();
        editor.putString(Constants.APP_LAST_NAME, value);
        editor.commit();
    }

    // get  APP_LAST_NAME
    public static String getAPP_LASTNAME(Context context) {
        return getTellofyPrefs(context).getString(Constants.APP_LAST_NAME, "");

    }


    // set FbId
    public static void setFbId(String value, Context context) {
        SharedPreferences.Editor editor = getTellofyPrefs(context).edit();
        editor.putString(Constants.SP_FB_ID, value);
        editor.commit();
    }

    // get  fbid
    public static String getFbId(Context context) {
        return getTellofyPrefs(context).getString(Constants.SP_FB_ID, "");

    }

    // set Token
    public static void setToken(String value, Context context) {
        SharedPreferences.Editor editor = getTellofyPrefs(context).edit();
        editor.putString(Constants.SP_TOKEN, value);
        editor.commit();
    }

    // get  Token
    public static String getToken(Context context) {
        return getTellofyPrefs(context).getString(Constants.SP_TOKEN, "");

    }


    // set Email
    public static void setEmail(String value, Context context) {
        SharedPreferences.Editor editor = getTellofyPrefs(context).edit();
        editor.putString(Constants.SP_EMAIL_ID, value);
        editor.commit();
    }

    // get  Email
    public static String getEmail(Context context) {
        return getTellofyPrefs(context).getString(Constants.SP_EMAIL_ID, "");

    }


    // set UserId
    public static void setUserId(String value, Context context) {
        SharedPreferences.Editor editor = getTellofyPrefs(context).edit();
        editor.putString(Constants.SP_USERID, value);
        editor.commit();
    }

    // get  UserId
    public static String getUserId(Context context) {
        return getTellofyPrefs(context).getString(Constants.SP_USERID, "");

    }


    // set FirstName
    public static void setFirstName(String value, Context context) {
        SharedPreferences.Editor editor = getTellofyPrefs(context).edit();
        editor.putString(Constants.SP_FIRSTNAME, value);
        editor.commit();
    }

    // get  Token
    public static String getFirstName(Context context) {
        return getTellofyPrefs(context).getString(Constants.SP_FIRSTNAME, "");

    }

    // set LastName
    public static void setLastName(String value, Context context) {
        SharedPreferences.Editor editor = getTellofyPrefs(context).edit();
        editor.putString(Constants.SP_LASTNAME, value);
        editor.commit();
    }

    // get LastName
    public static String getLastName(Context context) {
        return getTellofyPrefs(context).getString(Constants.SP_LASTNAME, "");

    }


    // set Password
    public static void setPassword(String value, Context context) {
        SharedPreferences.Editor editor = getTellofyPrefs(context).edit();
        editor.putString(Constants.SP_PASSWORD, value);
        editor.commit();
    }

    // get Password
    public static String getPassword(Context context) {
        return getTellofyPrefs(context).getString(Constants.SP_PASSWORD, "");

    }


    // set Location
    public static void setLocation(String value, Context context) {
        SharedPreferences.Editor editor = getTellofyPrefs(context).edit();
        editor.putString(Constants.SP_LOCATION, value);
        editor.commit();
    }

    // get Password
    public static String getLocation(Context context) {
        return getTellofyPrefs(context).getString(Constants.SP_LOCATION, "");

    }

    // set Location
    public static void setGender(String value, Context context) {
        SharedPreferences.Editor editor = getTellofyPrefs(context).edit();
        editor.putString(Constants.SP_GENDER, value);
        editor.commit();
    }

    // get Password
    public static String getGender(Context context) {
        return getTellofyPrefs(context).getString(Constants.SP_GENDER, "");

    }

    // set Location
    public static void setFromAge(String value, Context context) {
        SharedPreferences.Editor editor = getTellofyPrefs(context).edit();
        editor.putString(Constants.SP_FROMAGE, value);
        editor.commit();
    }

    // get Password
    public static String getFromAge(Context context) {
        return getTellofyPrefs(context).getString(Constants.SP_FROMAGE, "");

    }

    // set Location
    public static void setToAge(String value, Context context) {
        SharedPreferences.Editor editor = getTellofyPrefs(context).edit();
        editor.putString(Constants.SP_TOAGE, value);
        editor.commit();
    }

    // get Password
    public static String getToAge(Context context) {
        return getTellofyPrefs(context).getString(Constants.SP_TOAGE, "");

    }

    // set Location
    public static void setDistance(int value, Context context) {
        SharedPreferences.Editor editor = getTellofyPrefs(context).edit();
        editor.putInt(Constants.SP_DISTANCE, value);
        editor.commit();
    }

    // get Password
    public static int getDistance(Context context) {
        return getTellofyPrefs(context).getInt(Constants.SP_DISTANCE, 0);

    }

    // set Location
    public static void setBudget(String value, Context context) {
        SharedPreferences.Editor editor = getTellofyPrefs(context).edit();
        editor.putString(Constants.SP_BUDGET, value);
        editor.commit();
    }

    // get Password
    public static String getBudget(Context context) {
        return getTellofyPrefs(context).getString(Constants.SP_BUDGET, "");

    }


    // set Location
    public static void setCategory(String value, Context context) {
        SharedPreferences.Editor editor = getTellofyPrefs(context).edit();
        editor.putString(Constants.SP_CATEGORY, value);
        editor.commit();
    }

    // get Password
    public static String getCategory(Context context) {
        return getTellofyPrefs(context).getString(Constants.SP_CATEGORY, "");

    }


    // set Location
    public static void setCategoryId(int value, Context context) {
        SharedPreferences.Editor editor = getTellofyPrefs(context).edit();
        editor.putInt(Constants.SP_CATEGORYID, value);
        editor.commit();
    }

    // get Password
    public static int getCategoryId(Context context) {
        return getTellofyPrefs(context).getInt(Constants.SP_CATEGORYID, 0);

    }


    // filter latitude....

    // set Location
    public static void setFilterLat(String value, Context context) {
        SharedPreferences.Editor editor = getTellofyPrefs(context).edit();
        editor.putString(Constants.SP_FILTERLAT, value);
        editor.commit();
    }

    // get Password
    public static String getFilterLat(Context context) {
        return getTellofyPrefs(context).getString(Constants.SP_FILTERLAT, "");

    }

    // filter longitude...


    public static void setFilterLong(String value, Context context) {
        SharedPreferences.Editor editor = getTellofyPrefs(context).edit();
        editor.putString(Constants.SP_FILTERLONG, value);
        editor.commit();
    }

    // get Password
    public static String getFilterLong(Context context) {
        return getTellofyPrefs(context).getString(Constants.SP_FILTERLONG, "");

    }

}
