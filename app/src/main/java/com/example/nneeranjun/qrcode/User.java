package com.example.nneeranjun.qrcode;


import android.graphics.Bitmap;

import com.google.gson.Gson;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import java.util.Random;
import java.util.UUID;

/**
 * Created by nneeranjun on 10/6/17.
 */



public class User {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String snapchat;
    private String instagram;
    private String twitter;
    private String location;
    private String facebook;
    private Bitmap qrcode;
    private Bitmap picture;
    private String identifier;






    public User(String firstName, String lastName, String phoneNumber, String snapchat, String instagram, String twitter, String location, Bitmap picture){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.snapchat = snapchat;
        this.instagram = instagram;
        this.twitter = twitter;

        this.location=location;
        this.identifier = UUID.randomUUID().toString();
        generateQrCode();

    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSnapchat() {
        return snapchat;
    }

    public String getInstagram() {
        return instagram;
    }



    public String getTwitter() {
        return twitter;
    }

    public String getLocation() {
        return location;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public void setSnapchat(String snapchat) {
        this.snapchat = snapchat;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    public void setLocation(String location) {
        this.location = location;
    }

    public void setPicture(Bitmap picture) {
        this.picture = picture;
    }



    public Bitmap generateQrCode(){
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        Gson gson = new Gson();
        String objectString = gson.toJson(this);

        try {
            BitMatrix bitMatrix = multiFormatWriter.encode("nigger", BarcodeFormat.QR_CODE,700,700);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            qrcode = bitmap;
        }catch (WriterException e){
            e.printStackTrace();
        }
        return qrcode;
    }


    public Bitmap getQrcode() {
        return qrcode;
    }

    public String getIdentifier(){
        return identifier;
    }

    public Bitmap getPicture() {
        return picture;
    }
}
