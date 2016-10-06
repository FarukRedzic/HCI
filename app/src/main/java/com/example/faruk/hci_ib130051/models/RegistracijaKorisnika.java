package com.example.faruk.hci_ib130051.models;

import android.content.Intent;

import com.google.gson.annotations.SerializedName;


public class RegistracijaKorisnika {
    @SerializedName("Ime")
    private String ime;

    @SerializedName("Prezime")
    private String prezime;

    @SerializedName("Email")
    private String email;

    @SerializedName("Telefon")
    private String telefon;

    @SerializedName("KorisnickoIme")
    private String korisnickoIme;

    @SerializedName("LozinkaHash")
    private String lozinkaHash;
    //public String LozinkaSalt = "";

    @SerializedName("Slika")
    private String slika;
    //public Integer Aktivan = 1;
    //public Boolean chkKorisnickiNalog = false;

    @SerializedName("OpstinaId")
    private Integer opstinaId;
    //public Integer UlogaId = 2;
    //public Boolean IsTrgovina = false;
    @SerializedName("Adresa")
    private String adresa;
    //public int Id = -1;
    //public String Popularnost = "";
    //public String ImePrezime = "";
    //public String Opstina = "";


    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinkaHash() {
        return lozinkaHash;
    }

    public void setLozinkaHash(String lozinkaHash) {
        this.lozinkaHash = lozinkaHash;
    }

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

    public Integer getOpstinaId() {
        return opstinaId;
    }

    public void setOpstinaId(Integer opstinaId) {
        this.opstinaId = opstinaId;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
}