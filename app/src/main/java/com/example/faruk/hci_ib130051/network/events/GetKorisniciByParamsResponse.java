package com.example.faruk.hci_ib130051.network.events;

import com.example.faruk.hci_ib130051.models.Korisnik;

import java.util.List;


public class GetKorisniciByParamsResponse extends FResponse {

    private List<Korisnik> korisnikList;

    public List<Korisnik> getKorisnikList() {
        return korisnikList;
    }

    public void setKorisnikList(List<Korisnik> korisnikList) {
        this.korisnikList = korisnikList;
    }
}
