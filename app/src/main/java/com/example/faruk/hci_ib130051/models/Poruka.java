package com.example.faruk.hci_ib130051.models;

import com.example.faruk.hci_ib130051.network.events.FResponse;
import com.google.gson.annotations.SerializedName;

import java.util.Date;


public class Poruka extends FResponse {

    @SerializedName("Id")
    private int id;

    @SerializedName("Date")
    private Date date;

    @SerializedName("Naslov")
    private String naslov;

    @SerializedName("Sadrzaj")
    private String sadrzaj;

    @SerializedName("Procitana")
    private boolean procitana;

    @SerializedName("PosiljaocId")
    private int posiljaocId;

    @SerializedName("PrimaocId")
    private int primaocId;

    @SerializedName("Poslao")
    private String poslao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

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

    public boolean isProcitana() {
        return procitana;
    }

    public void setProcitana(boolean procitana) {
        this.procitana = procitana;
    }

    public int getPosiljaocId() {
        return posiljaocId;
    }

    public void setPosiljaocId(int posiljaocId) {
        this.posiljaocId = posiljaocId;
    }

    public int getPrimaocId() {
        return primaocId;
    }

    public void setPrimaocId(int primaocId) {
        this.primaocId = primaocId;
    }

    public String getPoslao() {
        return poslao;
    }

    public void setPoslao(String poslao) {
        this.poslao = poslao;
    }
}
