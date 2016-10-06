package com.example.faruk.hci_ib130051.network.events;

import com.example.faruk.hci_ib130051.models.Opstina;

import java.util.List;

public class GetOpstineResponse extends FResponse {

    private List<Opstina> opstinas;

    public List<Opstina> getOpstinas() {
        return opstinas;
    }

    public void setOpstinas(List<Opstina> opstinas) {
        this.opstinas = opstinas;
    }

}
