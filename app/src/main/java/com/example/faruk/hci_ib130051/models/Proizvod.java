package com.example.faruk.hci_ib130051.models;

import com.example.faruk.hci_ib130051.network.events.FResponse;
import com.google.gson.annotations.SerializedName;


public class Proizvod extends FResponse {

    @SerializedName("Id")
    private int id;

    @SerializedName("Naziv")
    private String naziv;

    @SerializedName("Cijena")
    private double cijena;

    @SerializedName("Slika")
    private String slika;

    @SerializedName("Kategorija")
    private String kategorija;

    @SerializedName("Aktivan")
    private boolean aktivan;

    @SerializedName("Obrisan")
    private boolean obrisan;

    @SerializedName("Vlasnik")
    private String vlasnik;

    @SerializedName("Koristen")
    private boolean koristen;

    @SerializedName("VlasnikId")
    private int vlasnikId;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getCijena() {
        return cijena;
    }

    public void setCijena(double cijena) {
        this.cijena = cijena;
    }

    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

    public int getVlasnikId() {
        return vlasnikId;
    }

    public void setVlasnikId(int vlasnikId) {
        this.vlasnikId = vlasnikId;
    }

    public boolean isAktivan() {
        return aktivan;
    }

    public void setAktivan(boolean aktivan) {
        this.aktivan = aktivan;
    }
}
