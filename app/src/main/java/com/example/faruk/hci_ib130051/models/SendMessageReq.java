package com.example.faruk.hci_ib130051.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class SendMessageReq {
    @SerializedName("Naslov")
    private String naslov;

    @SerializedName("Sadrzaj")
    private String sadrzaj;

    @SerializedName("DatumVrijeme")
    private String datumVrijeme;

    @SerializedName("PrimaocId")
    private int primaocId;

    @SerializedName("PosiljaocId")
    private int posiljaocId;

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getSadrzaj() {
        return sadrzaj;
    }

    public void setSadrzaj(String sadrzaj) {
        this.sadrzaj = sadrzaj;
    }

    public String getDatumVrijeme() {
        return datumVrijeme;
    }

    public void setDatumVrijeme(String datumVrijeme) {
        this.datumVrijeme = datumVrijeme;
    }

    public int getPrimaocId() {
        return primaocId;
    }

    public void setPrimaocId(int primaocId) {
        this.primaocId = primaocId;
    }

    public int getPosiljaocId() {
        return posiljaocId;
    }

    public void setPosiljaocId(int posiljaocId) {
        this.posiljaocId = posiljaocId;
    }
}
