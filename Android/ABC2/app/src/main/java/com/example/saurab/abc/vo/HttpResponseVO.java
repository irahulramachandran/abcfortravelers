package com.example.saurab.abc.vo;

/**
 * Created by saurab on 2/6/2016.
 */
public class HttpResponseVO {

    private int responseCode;
    private long contentLength;
    private String contentType;
    private String response;
    private String error;
    private String userId;
    private Boolean isLastImage;

    public Boolean getIsLastImage() {
        return isLastImage;
    }

    public void setIsLastImage(Boolean isLastImage) {
        this.isLastImage = isLastImage;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public HttpResponseVO() {
        this.contentLength = 0;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public long getContentLength() {
        return contentLength;
    }

    public void setContentLength(long contentLength) {
        this.contentLength = contentLength;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String applicationType) {
        this.contentType = applicationType;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
