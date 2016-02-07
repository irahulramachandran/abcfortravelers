package com.example.saurab.abc.async.callback;

import com.example.saurab.abc.vo.HttpResponseVO;

/**
 * Created by saurab on 2/6/2016.
 */
public interface AsyncCallBackInterface {


    void asyncCallBackFunction(HttpResponseVO result, String apiUrl);
}
