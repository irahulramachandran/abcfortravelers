package com.example.saurab.abc.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.saurab.abc.R;
import com.example.saurab.abc.async.controller.AbcApiAsyncTasks;
import com.example.saurab.abc.base.activity.BaseActivity;
import com.example.saurab.abc.util.Constants;
import com.example.saurab.abc.util.EndPoint;
import com.example.saurab.abc.util.SharedPreferenceHelper;
import com.example.saurab.abc.util.Utility;
import com.example.saurab.abc.vo.HttpResponseVO;

import org.json.JSONObject;

/**
 * Created by saurab on 2/6/2016.
 */
public class Login extends BaseActivity {
    TextView login_btn;
 EditText et_email,et_pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        login_btn = (TextView) findViewById(R.id.login_btn);
        et_email=(EditText)findViewById(R.id.et_email);
        et_pass=(EditText)findViewById(R.id.et_pass);


        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JSONObject obj = new JSONObject();
                if (et_email.getText().toString().trim()
                        .equals(Constants.STR_BLANK)) {
                    showMessage(Constants.INFO_ENTER_EMAIL);
                } else if (et_pass.getText().toString().trim()
                        .equals(Constants.STR_BLANK)) {
                    showMessage(Constants.INFO_ENTER_PASSWORD);
                } else if (!isOnline()) {
                    showMessage(Constants.INFO_NO_NETWORK);
                } else if (!Utility.isValidEmail(et_email.getText().toString().trim())) {
                    showMessage(Constants.INFO_ENTER_VALID_EMAIL);

                } else {
                    try {
                        SharedPreferenceHelper.setAppLogin(true, Login.this);
                        SharedPreferenceHelper.setGPlusLogin(false, Login.this);
                        SharedPreferenceHelper.setFbLogin(false, Login.this);

                        obj.put("UserName", et_email.getText().toString().trim());
                        obj.put("password", et_pass.getText().toString().trim());
                        obj.put(Constants.JK_USERTYPE, "1");
                        obj.put(Constants.JK_SOURCE, Constants.JK_SOURCE_VAL);
                    } catch (Exception e) {

                    }

                    new AbcApiAsyncTasks(EndPoint.
                            LOGIN_URL, obj, Login.this).execute();
                }
            }
        });
    }

    @Override
    public void asyncCallBackFunction(HttpResponseVO result, String apiUrl) {
        super.asyncCallBackFunction(result, apiUrl);
        if (result.getResponseCode() == Constants.HTTP_OK_200) {

            if (apiUrl.equals(EndPoint.LOGIN_URL)) {
                JSONObject obj = null;
                String token = null;
                String userId = null;
                String base64 = null;
                String firstname = null;
                String email = null;
                String imgURl = null;
                boolean status = false;
                String lastname = null;
                Boolean isFirst = false;
                try {

                    obj = new JSONObject(result.getResponse());

                    userId = obj.getString("UserID");

                    SharedPreferenceHelper.setUserId(userId, this);
                    gotoClass(Home.class);

                } catch (Exception e) {

                }


            }


        } else {
            if (result.getError().equals("No value for first name")) {
                showMessage("It seems some network problem,please try again");
            } else {
                showMessage(result.getError());
            }
        }
    }
}
