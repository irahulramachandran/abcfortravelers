package com.example.saurab.abc.async.controller;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;

import com.example.saurab.abc.R;
import com.example.saurab.abc.async.AsyncUtils;
import com.example.saurab.abc.base.activity.BaseActivity;
import com.example.saurab.abc.fragment.BaseFragment;
import com.example.saurab.abc.util.Constants;
import com.example.saurab.abc.util.EndPoint;
import com.example.saurab.abc.util.HttpUtil;
import com.example.saurab.abc.util.Utility;
import com.example.saurab.abc.vo.HttpResponseVO;

import org.json.JSONObject;

/**
 * Created by saurab on 2/6/2016.
 */
public class AbcApiAsyncTasks extends AsyncTask<Void, Void, HttpResponseVO> {
    BaseActivity context;
    String usr;
    String pwd;
    JSONObject requestJson;
    String urlAppendString;
    String apiUrl;
    // ProgressDialog pd;
    BaseFragment fragment;
    String path;
    boolean isShowProgress = true;
    Boolean isLastImage = true;
    int pageNumber;
    Dialog dialog;

    //for GET and DELETE
    public AbcApiAsyncTasks(String apiUrl, String urlAppendString, BaseActivity context, BaseFragment fragment) {
        this.context = context;
        this.apiUrl = apiUrl;
        this.urlAppendString = urlAppendString;
        this.fragment = fragment;

    }

    //for GET and DELETE Activity
    public AbcApiAsyncTasks(String apiUrl, String urlAppendString, BaseActivity context) {
        this.context = context;
        this.apiUrl = apiUrl;
        this.urlAppendString = urlAppendString;

    }

    //for GET and DELETE Activity
    public AbcApiAsyncTasks(String apiUrl, String urlAppendString, BaseActivity context, boolean isShowProgress) {
        this.context = context;
        this.apiUrl = apiUrl;
        this.urlAppendString = urlAppendString;
        this.isShowProgress = isShowProgress;

    }

    //for GET and DELETE with progress
    public AbcApiAsyncTasks(String apiUrl, String urlAppendString, BaseActivity context, BaseFragment fragment, boolean isShowProgress) {
        this.context = context;
        this.apiUrl = apiUrl;
        this.urlAppendString = urlAppendString;
        this.fragment = fragment;
        this.isShowProgress = isShowProgress;

    }

    //for GET with pageNumber
    public AbcApiAsyncTasks(String apiUrl, int pageNumber, BaseActivity context, BaseFragment fragment, Boolean isShowProgress) {
        this.context = context;
        this.apiUrl = apiUrl;
        this.urlAppendString = pageNumber + "";
        this.fragment = fragment;
        this.isShowProgress = isShowProgress;
    }


    //for Upload image file using POST Method
    public AbcApiAsyncTasks(String apiUrl, String urlAppendString, String path, BaseActivity context) {
        this.context = context;
        this.apiUrl = apiUrl;
        this.urlAppendString = urlAppendString;
        this.path = path;

    }

    //for Upload image file using POST Method
    public AbcApiAsyncTasks(String apiUrl, String urlAppendString, String path, BaseActivity context, boolean isShowProgress, Boolean isLastImage) {
        this.context = context;
        this.apiUrl = apiUrl;
        this.isShowProgress = isShowProgress;
        this.urlAppendString = urlAppendString;
        this.path = path;
        this.isLastImage = isLastImage;

    }


    public AbcApiAsyncTasks(String apiUrl, String urlAppendString, String path, BaseActivity context, boolean isShowProgress) {
        this.context = context;
        this.isShowProgress = isShowProgress;
        this.apiUrl = apiUrl;
        this.urlAppendString = urlAppendString;
        this.path = path;

    }

    //for LOGIN
    public AbcApiAsyncTasks(String apiUrl, JSONObject requestJson, String usr, String pwd, BaseActivity context, boolean isShowProgress) {
        this.context = context;
        this.apiUrl = apiUrl;
        this.usr = usr;
        this.pwd = pwd;
        this.requestJson = requestJson;
        this.isShowProgress = isShowProgress;

    }

    //for POST ACTIVITY
    public AbcApiAsyncTasks(String apiUrl, JSONObject requestJson, BaseActivity context) {
        this.context = context;
        this.apiUrl = apiUrl;
        this.requestJson = requestJson;

    }


    //for POST Fragment
    public AbcApiAsyncTasks(String apiUrl, JSONObject requestJson, BaseFragment fragment) {
        this.fragment = fragment;
        this.apiUrl = apiUrl;
        this.requestJson = requestJson;

    }

    public AbcApiAsyncTasks(String apiUrl, JSONObject requestJson, BaseActivity context, boolean isShowProgress) {
        this.context = context;
        this.apiUrl = apiUrl;
        this.requestJson = requestJson;
        this.isShowProgress = isShowProgress;

    }

    //for POST and PUT other than Login
    public AbcApiAsyncTasks(String apiUrl, JSONObject requestJson, BaseActivity context, BaseFragment fragment) {
        this.context = context;
        this.apiUrl = apiUrl;
        this.requestJson = requestJson;
        this.fragment = fragment;
    }

    //for POST and PUT other than Login with progress
    public AbcApiAsyncTasks(String apiUrl, JSONObject requestJson, BaseActivity context, BaseFragment fragment, boolean isShowProgress) {
        this.context = context;
        this.apiUrl = apiUrl;
        this.requestJson = requestJson;
        this.fragment = fragment;
        this.isShowProgress = isShowProgress;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();


        if (isShowProgress) {
           /* pd = new ProgressDialog(context);
            pd.setMessage(Constants.INFO_LOADING);
            pd.setCancelable(false);
            pd.show();*/


            dialog = new Dialog(context, android.R.style.Theme_Black_NoTitleBar);
            dialog.setContentView(R.layout.progress_dialog);
            dialog.getWindow().setBackgroundDrawableResource(R.color.transparent);
            dialog.setCancelable(false);
            dialog.show();
        }


    }

    @Override
    protected HttpResponseVO doInBackground(Void... params) {
        final HttpResponseVO vo = new HttpResponseVO();

        if (!AsyncUtils.isOnline(context)) {
            vo.setError(Constants.INFO_NO_NETWORK);
            return vo;
        }

        try {

            //Login
            if (apiUrl.equals(EndPoint.LOGIN_URL)) {
                HttpUtil.post(apiUrl, requestJson.toString()
                        .getBytes(), AsyncUtils.getCommonAuthHeaders(context), vo);
            }
            //All GET Methods
            else if (apiUrl.equals(EndPoint.GET_USER_PROFILE)
                    ) {
                HttpUtil.get(apiUrl + urlAppendString, AsyncUtils.getCommonAuthHeaders(context), vo);
            }

            // For UPLOAD IMAGE

            else if (
                   apiUrl.equals(EndPoint.UPLOAD_REVIEW_IMAGE)
                  ) {
                HttpUtil.uploadFile(apiUrl + urlAppendString, path, vo);
            }

            //All POST Methods
            else if (apiUrl.equals(EndPoint.REGISTER) ||
                    apiUrl.equals(EndPoint.LOGIN_URL) ||
                    apiUrl.equals(EndPoint.FORGOT_PASS)
                   ) {
                HttpUtil.post(apiUrl, requestJson.toString()
                        .getBytes(), AsyncUtils.getCommonAuthHeaders(context), vo);
            }


        } catch (Exception e) {
            vo.setError(e.getMessage());
            try {
                dialog.dismiss();
            } catch (Exception ex) {

            }
        }


        return vo;

    }

    @Override
    protected void onPostExecute(HttpResponseVO result) {
        super.onPostExecute(result);
        if (isLastImage) {
            result.setIsLastImage(true);
        }
        if (result.getResponseCode() == 0) {
            result.setError(Constants.INFO_CANNOT_CONNECT);
        } else if (result.getResponseCode() != Constants.HTTP_OK_200) {
            if (result.getError() == null) {
                try {
                    JSONObject obj = new JSONObject(result.getResponse());
                    String message = obj.getString(Constants.JK_MESSAGE);
                    message.replaceAll("\"", "");
                    result.setError(message);
                    if (Utility.isNullOrEmpty(message)) {
                        result.setError(Constants.INFO_SOMETHING_WRONG);
                    }

                } catch (Exception e) {
                    result.setError(Constants.INFO_SOMETHING_WRONG);
                }
            }
        }
        try {
            dialog.dismiss();
        } catch (Exception ex) {

        }


        if (fragment == null) {
            context.asyncCallBackFunction(result, apiUrl);
        } else {
            fragment.asyncCallBackFunction(result, apiUrl);
        }
    }
}

