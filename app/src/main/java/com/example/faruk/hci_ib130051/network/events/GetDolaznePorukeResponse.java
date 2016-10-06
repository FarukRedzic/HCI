package com.example.faruk.hci_ib130051.network.events;

import com.example.faruk.hci_ib130051.models.Poruka;

import java.util.List;


public class GetDolaznePorukeResponse extends FResponse {

    private List<Poruka> porukaList;

    public List<Poruka> getPorukaList() {
        return porukaList;
    }

    public void setPorukaList(List<Poruka> porukaList) {
        this.porukaList = porukaList;
    }
}
