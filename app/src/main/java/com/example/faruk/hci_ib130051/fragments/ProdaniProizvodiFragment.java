package com.example.faruk.hci_ib130051.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.faruk.hci_ib130051.R;
import com.example.faruk.hci_ib130051.adapters.ListProizvodiAdapter;
import com.example.faruk.hci_ib130051.models.Proizvod;
import com.example.faruk.hci_ib130051.models.ProizvodResponse;
import com.example.faruk.hci_ib130051.network.events.GetProizvodiByParamsResponse;
import com.example.faruk.hci_ib130051.services.FactoryService;
import com.example.faruk.hci_ib130051.util.AppHelper;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

public class ProdaniProizvodiFragment extends FFragment {

    private ListView lvProdaniProizvodi;
    private ListProizvodiAdapter listProizvodiAdapter;
    private List<Proizvod> prodaniProizvodi = new ArrayList<>();

    @Override
    public boolean isTopLevelFragment() {
        return false;
    }

    public static ProdaniProizvodiFragment newInstance() {
        
        Bundle args = new Bundle();
        
        ProdaniProizvodiFragment fragment = new ProdaniProizvodiFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_neaktivni_proizvodi, container, false);

        lvProdaniProizvodi = (ListView)view.findViewById(R.id.lvNeaktivniProizvodi);

        listProizvodiAdapter = new ListProizvodiAdapter(getContext(), R.layout.list_item_proizvodi, prodaniProizvodi);
        lvProdaniProizvodi.setAdapter(listProizvodiAdapter);

        FactoryService.getNeAktivniProizvodi(-1, AppHelper.getInstance().getLoginData().getId());

        lvProdaniProizvodi.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Proizvod proizvod = prodaniProizvodi.get(position);

                FactoryService.updateProizvod(proizvod.getId(), proizvod.isAktivan());

                return false;
            }
        });

        return view;
    }

    @Subscribe
    public void getAktivniProizvodi(GetProizvodiByParamsResponse response) {
        if (response.isOk()) {
            if (!response.isAktivni()) {
                prodaniProizvodi.clear();
                prodaniProizvodi.addAll(response.getProizvodList());

                listProizvodiAdapter.notifyDataSetChanged();
            }
        }
        else {
            Toast.makeText(getContext(), response.getErrorMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Subscribe
    public void getUpdatedProizvod(ProizvodResponse proizvod) {
        if (proizvod.isOk()) {
            if (proizvod.isAktivan()) {
                Toast.makeText(getContext(), "Artikl prebacen u aktivne!", Toast.LENGTH_SHORT).show();
                FactoryService.getNeAktivniProizvodi(-1, AppHelper.getInstance().getLoginData().getId());
                FactoryService.getAktivniProizvodi(-1, AppHelper.getInstance().getLoginData().getId());
            }
        }
        else {
            Toast.makeText(getContext(), proizvod.getErrorMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
