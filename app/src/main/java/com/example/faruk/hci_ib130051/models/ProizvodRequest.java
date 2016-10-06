package com.example.faruk.hci_ib130051.models;

import com.google.gson.annotations.SerializedName;


public class ProizvodRequest {

    @SerializedName("Aktivan")
    private boolean aktivan;

    @SerializedName("Cijena")
    private double cijena;

    @SerializedName("Id")
    private int id;

    @SerializedName("Kategorija")
    private String kategorija;

    @SerializedName("Koristen")
    private boolean koristen;

    @SerializedName("Naziv")
    private String naziv;

    @SerializedName("Obrisan")
    private boolean obrisan;


    public boolean isAktivan() {
        return aktivan;
    }

    public void setAktivan(boolean aktivan) {
        this.aktivan = aktivan;
    }

    public double getCijena() {
        return cijena;
    }

    public void setCijena(double cijena) {
        this.cijena = cijena;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }

    public boolean isKoristen() {
        return koristen;
    }

    public void setKoristen(boolean koristen) {
        this.koristen = koristen;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public boolean isObrisan() {
        return obrisan;
    }

    public void setObrisan(boolean obrisan) {
        this.obrisan = obrisan;
    }
}
