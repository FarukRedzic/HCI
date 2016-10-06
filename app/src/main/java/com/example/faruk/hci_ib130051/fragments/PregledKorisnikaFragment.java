package com.example.faruk.hci_ib130051.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.faruk.hci_ib130051.R;
import com.example.faruk.hci_ib130051.adapters.ListKorisniciAdapter;
import com.example.faruk.hci_ib130051.models.Korisnik;
import com.example.faruk.hci_ib130051.network.events.GetKorisniciByParamsResponse;
import com.example.faruk.hci_ib130051.services.FactoryService;
import com.example.faruk.hci_ib130051.util.AppHelper;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

public class PregledKorisnikaFragment extends FFragment {

    private EditText etKeyword;
    private Button btnSearch;
    private ListView lvKorisnici;
    private ListKorisniciAdapter listKorisniciAdapter;
    private List<Korisnik> korisnikList = new ArrayList<>();

    @Override
    public boolean isTopLevelFragment() {
        return true;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pregled_korisnika, container, false);

        etKeyword = (EditText)view.findViewById(R.id.etKeyword);
        btnSearch = (Button)view.findViewById(R.id.btnSearch);
        lvKorisnici = (ListView)view.findViewById(R.id.lvKorisnici);

        listKorisniciAdapter = new ListKorisniciAdapter(getContext(), R.layout.list_item_korisnik, korisnikList);
        lvKorisnici.setAdapter(listKorisniciAdapter);


        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String key = TextUtils.isEmpty(etKeyword.getText().toString()) ? "null" : etKeyword.getText().toString();
                FactoryService.getKorisniciByParams(key, false, AppHelper.getInstance().getLoginData().getId());
            }
        });

        return view;
    }

    @Subscribe
    public void onGetKorisnici(GetKorisniciByParamsResponse getKorisniciByParamsResponse) {
        if (getKorisniciByParamsResponse.isOk()) {
            korisnikList.clear();
            korisnikList.addAll(getKorisniciByParamsResponse.getKorisnikList());
            listKorisniciAdapter.notifyDataSetChanged();
        }
        else {
            Toast.makeText(getContext(), getKorisniciByParamsResponse.getErrorMessage(), Toast.LENGTH_SHORT).show();
        }
    }

}
