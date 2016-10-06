package com.example.faruk.hci_ib130051.network.events;

import com.example.faruk.hci_ib130051.models.Proizvod;

import java.util.List;

public class GetProizvodiByParamsResponse extends FResponse {

    private List<Proizvod> proizvodList;
    private boolean aktivni;

    public List<Proizvod> getProizvodList() {
        return proizvodList;
    }

    public void setProizvodList(List<Proizvod> proizvodList) {
        this.proizvodList = proizvodList;
    }

    public boolean isAktivni() {
        return aktivni;
    }

    public void setAktivni(boolean aktivni) {
        this.aktivni = aktivni;
    }
}
