package com.example.saurab.abc.apimodel;

/**
 * Created by saurab on 2/7/2016.
 */
public class SearchResultModel {
    int ID,UserId,CategoryId,Name,Status;
    String Description,Bannerimageurl,Phonenumber,EmailID,Address,CreatedOn;
    float Longitude,Latitude;

    public SearchResultModel(int ID, int userId, int categoryId, int name, int status, String description, String bannerimageurl, String phonenumber, String emailID, String address, String createdOn, float longitude, float latitude) {
        this.ID = ID;
        UserId = userId;
        CategoryId = categoryId;
        Name = name;
        Status = status;
        Description = description;
        Bannerimageurl = bannerimageurl;
        Phonenumber = phonenumber;
        EmailID = emailID;
        Address = address;
        CreatedOn = createdOn;
        Longitude = longitude;
        Latitude = latitude;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int categoryId) {
        CategoryId = categoryId;
    }

    public int getName() {
        return Name;
    }

    public void setName(int name) {
        Name = name;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getBannerimageurl() {
        return Bannerimageurl;
    }

    public void setBannerimageurl(String bannerimageurl) {
        Bannerimageurl = bannerimageurl;
    }

    public String getPhonenumber() {
        return Phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        Phonenumber = phonenumber;
    }

    public String getEmailID() {
        return EmailID;
    }

    public void setEmailID(String emailID) {
        EmailID = emailID;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCreatedOn() {
        return CreatedOn;
    }

    public void setCreatedOn(String createdOn) {
        CreatedOn = createdOn;
    }

    public float getLongitude() {
        return Longitude;
    }

    public void setLongitude(float longitude) {
        Longitude = longitude;
    }

    public float getLatitude() {
        return Latitude;
    }

    public void setLatitude(float latitude) {
        Latitude = latitude;
    }
}
