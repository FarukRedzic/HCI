package com.example.faruk.hci_ib130051.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.faruk.hci_ib130051.R;
import com.example.faruk.hci_ib130051.adapters.DolaznePorukeAdapter;
import com.example.faruk.hci_ib130051.models.Poruka;
import com.example.faruk.hci_ib130051.network.RestFactoryClient;
import com.example.faruk.hci_ib130051.network.events.GetDolaznePorukeResponse;
import com.example.faruk.hci_ib130051.services.FactoryService;
import com.example.faruk.hci_ib130051.util.AppHelper;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;


public class DolaznePorukeFragment extends FFragment {

    private ListView lvDolaznePoruke;
    private DolaznePorukeAdapter dolaznePorukeAdapter;
    private List<Poruka> porukaList = new ArrayList<>();

    @Override
    public boolean isTopLevelFragment() {
        return true;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dolazne_poruke, container, false);

        lvDolaznePoruke = (ListView)view.findViewById(R.id.lvDolaznePoruke);
        dolaznePorukeAdapter = new DolaznePorukeAdapter(getContext(), R.layout.list_item_dolazne_poruke, porukaList);
        lvDolaznePoruke.setAdapter(dolaznePorukeAdapter);

        FactoryService.getDolaznePoruke(AppHelper.getInstance().getLoginData().getId());

        return view;
    }

    @Subscribe
    public void getDolaznePoruke(GetDolaznePorukeResponse response) {
        if (response.isOk()) {
            porukaList.clear();
            porukaList.addAll(response.getPorukaList());
            dolaznePorukeAdapter.notifyDataSetChanged();
        }
        else {
            Toast.makeText(getContext(), response.getErrorMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
