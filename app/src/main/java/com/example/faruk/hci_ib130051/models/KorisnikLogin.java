package com.example.faruk.hci_ib130051.models;

import com.example.faruk.hci_ib130051.network.events.FResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class KorisnikLogin extends FResponse {

    @SerializedName("Id")
    private int id;

    @SerializedName("OpstinaId")
    @Expose
    private int opstinaId;

    @SerializedName("Ime")
    @Expose
    private String ime;

    @SerializedName("Prezime")
    @Expose
    private String prezime;

    @SerializedName("Email")
    @Expose
    private String email;

    @SerializedName("KorisnickoIme")
    @Expose
    private String korisnickoIme;

    @SerializedName("LozinkaHash")
    @Expose
    private String lozinkaHash;

    @SerializedName("Slika")
    @Expose
    private String slika;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOpstinaId() {
        return opstinaId;
    }

    public void setOpstinaId(int opstinaId) {
        this.opstinaId = opstinaId;
    }

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
}
