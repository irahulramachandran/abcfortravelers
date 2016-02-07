package com.example.saurab.abc.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
public class SignUp extends BaseActivity {
    Button signup_button;
    RadioButton business, consumer;
    EditText et_email, et_phone, et_pass, et_name;
    TextView already_member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        already_member = (TextView) findViewById(R.id.already_member);
        et_email = (EditText) findViewById(R.id.et_email);
        et_pass = (EditText) findViewById(R.id.et_password);
        et_phone = (EditText) findViewById(R.id.et_mobile);
        et_name = (EditText) findViewById(R.id.et_name);

        signup_button = (Button) findViewById(R.id.signup_button);
        business = (RadioButton) findViewById(R.id.business_radio);
        consumer = (RadioButton) findViewById(R.id.consumer_radio);

        already_member.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoClass(Login.class);
            }
        });

        signup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (et_name.getText().toString()
                        .equals(Constants.STR_BLANK)) {
                    showMessage(Constants.INFO_ENTER_FIRST_NAME);
                } else if (et_email.getText().toString()
                        .equals(Constants.STR_BLANK)) {
                    showMessage(Constants.INFO_ENTER_EMAIL);
                } else if (!isOnline()) {
                    showMessage(Constants.INFO_NO_NETWORK);
                } else if (!Utility.isValidEmail(et_email.getText().toString().trim())) {
                    showMessage(Constants.INFO_ENTER_VALID_EMAIL);

                } else if (!et_phone.getText().toString().trim().equals("") && et_phone.getText().toString().trim().length() < 10 || et_phone.getText().toString().trim().length() > 20) {
                    showMessage(Constants.INFO_ENTER_VALID_PHONE);
                } else {
                    int usertype = 0;
                    RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup1);
                    String radiovalue = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();
                    if (radiovalue.equals("Consumer")) {
                        usertype = 1;
                    } else if (radiovalue.equals("Business")) {
                        usertype = 2;
                    }
                    JSONObject data = new JSONObject();
                    try {


                        data.put("Name", et_name.getText().toString().trim());
                        data.put("EmailID", et_email.getText().toString().trim());
                        data.put("Phonenumber", et_phone.getText().toString().trim());
                        data.put("Password", et_pass.getText().toString());
                        data.put("Usertype", usertype);

                        new AbcApiAsyncTasks(EndPoint.
                                REGISTER, data, SignUp.this).execute();
                        signup_button.setEnabled(false);

                    } catch (Exception e) {

                    }

                }
            }
        });
    }


    @Override
    public void asyncCallBackFunction(HttpResponseVO result, String apiUrl) {
        super.asyncCallBackFunction(result, apiUrl);
        signup_button.setEnabled(true);
        if (result.getResponseCode() == Constants.HTTP_OK_200) {
            if (apiUrl.equals(EndPoint.REGISTER)) {
                JSONObject obj = null;
                try {
                    obj = new JSONObject(result.getResponse());
                    SharedPreferenceHelper.setUserId(obj.getString("ID"), this);

                    Intent intent = new Intent(this, Login.class);
                    showMessage(Constants.INFO_SUCCESSFULLY_REGESTERED, intent);
                    gotoClass(Home.class);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }


        } else

        {
            if (result.getError().equals("No value for first name")) {
                showMessage("It seems some network problem,please try again");
            } else {
                showMessage(result.getError());
            }
        }
    }
}
