package com.example.saurab.abc.util;

/**
 * Created by saurab on 2/6/2016.
 */
public interface Constants {

    String FROM_PARENT = "FROM_PARENT";
    String CAMERA_IMAGE_URI = "cameraImageUri";
    String CROP_URI = "CROP_URI";
    String FROM_CHILD = "cameraImageUri";
    String FROM_CROP = "FROM_CROP";

    String CROP_TYPE = "crop_type";
    String STR_URI = "uri";
    // Intent's extra that contains the message to be displayed.
    String EXTRA_MESSAGE = "message";

    // On boarding message..
    String HELLO = "Hello, ";
    String THANKS_FOR_JOINING = " ! Thank you for joining us";

    //String

    // HTTP Headers and their Values.
    String HTTP_HEADER_USER_AGENT = "User-Agent";
    String HTTP_HEADER_ACCEPT = "Accept";
    String HTTP_HEADER_USER_AGENT_VALUE = "Kitenga/1.0";
    String HTTP_HEADER_ACCEPT_VAUE_JSON = "application/json";
    String HTTP_HEADER_ACCEPT_VAUE_PDF = "application/pdf";
    String HTTP_HEADER_AUTHORIZATION = "Authorization";

    String HTTP_HEADER_CACHE_CONTROL = "Cache-Control";
    String HTTP_HEADER_CONTENT_LENGTH = "Content-Length";
    String HTTP_HEADER_CONTENT_TYPE = "Content-Type";
    String HTTP_HEADER_TOKEN = "token";
    Object HTTP_HEADER_DATE = "Date";
    String HTTP_HEADER_AUTHORIZATION_BASIC_APPEND = "Basic";
    String HTTP_TYPE_POST = "POST";

    // HTTP Response Codes
    int HTTP_OK_200 = 200;
    int HTTP_CREATED_201 = 201;
    int HTTP_ACCEPTED_202 = 202;
    int HTTP_FORBIDDEN_401 = 401;
    int HTTP_UNAUTHORIZED_403 = 403;
    int HTTP_INTERNAL_SERVER_ERROR_500 = 500;
    int HTTP_BAD_REQUEST_400 = 400;

    // General Constants.
    String HTML_BR = "<br/>";
    String NEWLINE = "\n";
    String STR_EQUAL = "=";
    String STR_KB = " Kb";
    String STR_SEPERATOR = "~";
    String STR_BLANK = "";
    String STR_NOT_AVAILABLE = "NA";
    String STR_COMMA = ",";
    String URL_SEPARATOR = "/";
    String STR_MAX_AGE = "max-age";
    String STR_ERROR = "Error";
    String STR_ACTIVE = "Active";
    String STR_CLOSE = "Close";
    String STR_OK = "Ok";
    String STR_CONFIRM = "Confirm";
    String STR_INFO = "Information";
    String STR_WARNING = "Warning";
    String STR_CANCEL = "Cancel";
    String STR_NULL = "null";
    String STR_COLON = ":";
    String STR_SORT_BY = "SORT BY";
    String STR_FILE = "file";
    String PLUS = "+";
    String STR_YES = "Yes";
    String STR_NO = "No";
    String STR_FATHER = "Father";
    String STR_MOTHER = "Mother";
    String STR_GUARDIAN = "Guardian";
    String STR_MOM = "m";
    String STR_DAD = "f";
    String STR_GUARD = "g";
    String JK_DOB = "dob";
    String JK_NUMBEROFCHILDREN = "numberOfChildren";
    String JK_CHILD_INFO = "childInfo";
    String STR_INTEREST = "Interests";
    String STR_SELECT_BIRTH = "Select year of birth";
    String STR_NOWEB_DATA = "No data found from web!!!";
    String STR_ACTIVITY_CENTER = "Places";
    String STR_EVENTS = "Events";
    String STR_SERVICES = "Services";
    // CAM INFO

    /*{"Take Photo", "Choose from Gallery",
            "Cancel"};*/

    String STR_TK_PIC = "Take Photo";
    String STR_CHOOSE_GAL = "Choose from Gallery";
    String STR_ADD_PIC = "Add Photo!";
    String STR_SELECT_FILE = "Select File";
    // Splace Screen Text...


    // SPLACE_1

    String SPLACE_1_UP = "Thinks, recommends and saves time for you";
    String SPLACE_1_DOWN = "";

    //SPLACE_2
    String SPLACE_2_UP = "Manages your calendar through timely reminders and updates";
    String SPLACE_2_DOWN = "";

    //SPLACE_3
    String SPLACE_3_UP = "Search and enjoy activities in your neighbourhood";
    String SPLACE_3_DOWN = "";

    // SPLACE_4
    String SPLACE_4_UP = "Customises recommendations relevant to your kid's interests";
    String SPLACE_4_DOWN = "";

    //SPLACE_5
    String SPLACE_5_UP = "Promotes your businesses to kids and parents";
    String SPLACE_5_DOWN = "";

    // Error / Information Messages




    String FORGOTPASS_SUBMIT = "Password sent to your email id successfully";
    String INFO_DEVICE_LOCATION_INFO = "Device is getting location info";
    String ERR_SERVER_MAINTANANCE = "Server is under Maintanance Try Later";
    String INFO_LOADING = "Loading..Please Wait";
    String INFO_VALID_FIRST_NAME = "First Name should not be greater than 16 character";
    String INFO_VALID_LAST_NAME = "Last Name should not be greater than 16 character";
    String INFO_NO_NETWORK = "No NetWork Please Try Later";
    String INFO_SOMETHING_WRONG = "Ooops..Something Went Wrong";
    String INFO_ENTER_EMAIL = "Please Enter Email ID";
    String INFO_INVALID_LOGIN = "Invalid usrname or password";
    String INFO_SIGN_UP = "Please sign up";
    String INFO_ENTER_VALID_EMAIL = "Please Enter valid Email ID";
    String INFO_ENTER_VALID_PASSWORD = "Password field should contain minimum of 6 characters with atleast one character and one number";
    String INFO_PASSWORD_DIFFERENT = "Old password and New password Should be Different";
    String INFO_ENTER_PASSWORD = "Please Enter Password";
    String INFO_ENTER_OLD_PASSWORD = "Please Enter Old Password";
    String INFO_ENTER_NEW_PASSWORD = "Please Enter New Password";
    String INFO_ENTER_CONFIRM_PASSWORD = "Please Enter Confirm New Password";
    String INFO_PASSWORD_NOT_MACHING = "Passwords are not Matching";
    String INFO_PASSWORD_CHANGED = "Password changed successfully";
    String INFO_ENTER_PHONE = "Please Enter Phone Number";
    String INFO_ENTER_VALID_PHONE = "Please Enter Valid Phone Number";
    String INFO_ENTER_USERNAME = "Please Enter Username";
    String INFO_ENTER_FIRST_NAME = "Please Enter Name";
    String INFO_ENTER_LAST_NAME = "Please Enter Last Name";
    String INFO_ENTER_NUMBER = "Please Enter Phone Number";
    String INFO_ENTER_CHILD_NAME = "Please Enter Code";
    String INFO_CANNOT_CONNECT = "Cannot Connect to Internet";

    String INFO_REVIEW_ADDED ="Review Added Successfully";
    String INFO_REVIEW_ADDED_SUCCESSFULLY = "Review Added Successfully";
    String INFO_SUCCESSFULLY_REGESTERED = "Registration successful!! Your password has been sent to the registered mail Id.";

    String INFO_LOGOUT = "Would you like to logout?";
    String STR_LOGOUT = "Logout";
    String STR_TAB_NO = "tab_no";
    String STR_SKIP = "skip";
    // gps message...
    String INFO_GPS_TITLE = "GPS Confirmation";
    String INFO_GPS_MESSAGE = "Please enable GPS";
    String INFO_YES = "YES";
    String INFO_NO = "NO";
    // Json Keys
    String JK_ID = "id";
    String JK_PHONE = "mobile";
    String JK_EMAIL = "email";
    String JK_PASSWORD = "password";


    String HTTP_JK_AUTHORIZATION = "Authorization";


    String JK_DOWNLOADPATH = "downloadPath";
    String JK_SOCIALMEDIAID = "socialMediaID";
    String JK_ADDRESSLINE1 = "addressLine1";
    String JK_ADDRESSLINE2 = "addressLine2";
    String JK_ADDRESSLINE = "addressLine";
    String JK_CITY = "city";
    String JK_STATE = "state";
    String JK_COUNTRY = "country";
    String JK_MOBILE = "mobile";
    String JK_PINCODE = "pincode";

    String JK_LATITUDE = "latitude";
    String JK_LONGITUDE = "longitude";
    String JK_SOURCE = "source";
    String JK_PAGE = "page";


    String JK_YOB = "yob";
    String JK_OCCUPATION = "occupation";

    String JK_INTERESTLIST = "interestList";
    String JK_NEWINTERESTLIST = "newInterestList";

    String JK_INTERESTS = "interests";
    String JK_NEWINTERESTS = "newInterests";

    String JK_FIRST_NAME = "firstname";
    String JK_LAST_NAME = "lastname";
    String JK_PROFILEIMAGEPATH = "profileImagePath";

    String JK_GENDER = "gender";
    String JK_ISRESETPASSWORD = "isResetPassword";

    String JK_PROFILE_PIC = "profilePic";


    String JK_MALE = "male";
    String JK_FEMALE = "female";
    String JK_FB_FIRST_NAME = "first_name";
    String JK_FB_LAST_NAME = "last_name";

    String BUNDLE_FIRST_NAME = "first_name";
    String BUNDLE_LAST_NAME = "last_name";
    String BUNDLE_PROFILE_PIC = "profile_pic";

    String STR_CATEGORY = "category";

    String STR_CATEGORY_ARRAY = "data";

    String BUNDLE_KEY = "Key";


    ///////////////////////
    String JK_NAME = "name";
    String JK_MESSAGE = "message";
    String JK_USERNAME = "username";
    String JK_USERTYPE = "userType";

    String JK_OLD_PASSWORD = "oldPassword";
    String JK_NEW_PASSWORD = "newPassword";

    String JK_SOURCE_VAL = "android";
    // Shared Preference Constants
    String SP_ISFIRST = "isFirst";


    String SP_Profile_IMG = "SP_Profile_IMG";
    String SP_GPLUS_PIC = "SP_GPLUS_PIC";
    String G_FIRST_NAME = "G_FIRST_NAME";
    String SP_CITY_NAME = "SP_CITY_NAME";
    String APP_FIRST_NAME = "APP_FIRST_NAME";
    String G_LAST_NAME = "G_LAST_NAME";
    String FB_LAST_NAME = "FB_LAST_NAME";
    String APP_LAST_NAME = "APP_LAST_NAME";
    String APP_LATITUDE = "APP_LATITUDE";
    String APP_LONGITUDE = "APP_LONGITUDE";

    String SP_USERID = "SP_USERID";
    String SP_TOKEN = "SP_TOKEN"; //SP_FBID
    String SP_FB_ID = "SP_FB_ID";
    String SP_ISFB_LOG = "SP_ISFB_LOG";

    String SP_ISGPLUS_LOG = "SP_ISGPLUS_LOG";
    String SP_ISAPP_LOG = "SP_ISAPP_LOG";
    String SP_EMAIL_ID = "SP_EMAIL_ID";
    String SP_FIRSTNAME = "SP_FIRSTNAME";
    String SP_LASTNAME = "SP_LASTNAME";
    String SP_PASSWORD = "SP_PASSWORD";
    String SP_PROFILE_PIC = "SP_PROFILE_PIC";
    String SP_CROPED_URI = "SP_CROPED_URI";

    // for filter screen

    String SP_LOCATION = "SP_LOCATION";
    String SP_GENDER = "SP_GENDER";

    String SP_CATEGORY = "SP_CATEGORY";

    String SP_CATEGORYID = "SP_CATEGORYID";
    String SP_BUDGET = "SP_BUDGET";
    String SP_DISTANCE = "SP_DISTANCE";
    String SP_TOAGE = "SP_TOAGE";
    String SP_FROMAGE = "SP_FROMAGE";
    String SP_FILTERLAT = "SP_FILTERLAT";

    String SP_FILTERLONG = "SP_FILTERLONG";

    String SP_PREFS = "SP_PREFS";
    String SP_NEW_USER = "SP_NEW_USER";
    String SP_NEW_LOGIN = "SP_NEW_LOGIN";


    //font Constants
    String FONT_FOLDER = "fonts";
    String FONT_TRADEGOTHICNEXTLTPRO_BD = "TradeGothicNextLTPro-Bd.otf";
    String FONT_TRADEGOTHICNEXTLTPRO_LT = "TradeGothicNextLTPro-Lt.otf";
    String FONT_TRADEGOTHICNEXTLTPRO_RG = "TradeGothicNextLTPro-Rg.otf";
    String FONT_GEORGIAPRO_SEMIBOLD = "GeorgiaPro-SemiBold.ttf";
    String FONT_OMNES_SEMIBOLDITALIC = "Omnes-SemiboldItalic.otf";

    String FONT_NOVO_REGULAR = "proximanova-reg-webfont.ttf";
    String FONT_NOVO_SBOLD = "proximanova-sbold-webfont.ttf";
    String FONT_NOVO_LIGHT = "proximanova-light-webfont.ttf";

    String FONT_LATO_ITALIC = "Lato-Italic.ttf";
    String FONT_LATO_REGULAR = "Lato-Regular.ttf";
}
