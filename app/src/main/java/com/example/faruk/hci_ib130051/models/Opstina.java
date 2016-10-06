package com.example.faruk.hci_ib130051.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Opstina {

    @SerializedName("Id")
    @Expose
    public int id;
    
    @SerializedName("Naziv")
    @Expose
    public String naziv;

}