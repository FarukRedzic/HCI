package com.example.faruk.hci_ib130051.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.faruk.hci_ib130051.R;
import com.example.faruk.hci_ib130051.adapters.ListProizvodiAdapter;
import com.example.faruk.hci_ib130051.models.Poruka;
import com.example.faruk.hci_ib130051.models.Proizvod;
import com.example.faruk.hci_ib130051.models.SendMessageReq;
import com.example.faruk.hci_ib130051.network.events.GetProizvodiByParamsResponse;
import com.example.faruk.hci_ib130051.services.FactoryService;
import com.example.faruk.hci_ib130051.util.AppHelper;
import com.squareup.otto.Subscribe;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PregledProizvodaFragment extends FFragment {

    private EditText etKeyword;
    private Button btnSearch;
    private ListView lvProizvodi;
    private ListProizvodiAdapter listProizvodiAdapter;
    private List<Proizvod> proizvodList = new ArrayList<>();

    @Override
    public boolean isTopLevelFragment() {
        return true;
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pregled_proizvoda, container, false);

        etKeyword = (EditText)view.findViewById(R.id.etKeyword);
        btnSearch = (Button)view.findViewById(R.id.btnSearch);
        lvProizvodi = (ListView)view.findViewById(R.id.lvProizvodi);

        listProizvodiAdapter = new ListProizvodiAdapter(getContext(), R.layout.list_item_proizvodi, proizvodList);
        lvProizvodi.setAdapter(listProizvodiAdapter);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String key = TextUtils.isEmpty(etKeyword.getText().toString()) ? "null" : etKeyword.getText().toString();

                FactoryService.getProizvodiByParams(key, 0, AppHelper.getInstance().getLoginData().getId());
            }
        });

        lvProizvodi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Proizvod proizvod = proizvodList.get(position);

                AlertDialog.Builder sendMessageDialog = new AlertDialog.Builder(getContext());
                View sendMessageDialogView = inflater.inflate(R.layout.send_message_dialog, null);

                final EditText etMessageText = (EditText)sendMessageDialogView.findViewById(R.id.etMessageText);
                Button btnSend = (Button)sendMessageDialogView.findViewById(R.id.btnPosalji);

                sendMessageDialog.setView(sendMessageDialogView);

                btnSend.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        // send message request
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

                        SendMessageReq sendMessageReq = new SendMessageReq();
                        sendMessageReq.setNaslov(etMessageText.getText().toString());
                        sendMessageReq.setDatumVrijeme(formatter.format(new Date()));
                        sendMessageReq.setSadrzaj(etMessageText.getText().toString());
                        sendMessageReq.setPosiljaocId(AppHelper.getInstance().getLoginData().getId());
                        sendMessageReq.setPrimaocId(proizvod.getVlasnikId());
                        FactoryService.sendMessage(sendMessageReq);
                    }
                });

                sendMessageDialog.show();
            }
        });

        return view;
    }


    @Subscribe
    public void sendMessageResponse(Poruka poruka) {
        if (poruka.isOk()) {
            Toast.makeText(getContext(), "Poruka poslana!", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getContext(), poruka.getErrorMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Subscribe
    public void getProizvodi(GetProizvodiByParamsResponse response) {
        if (response.isOk()) {
            proizvodList.clear();
            proizvodList.addAll(response.getProizvodList());
            listProizvodiAdapter.notifyDataSetChanged();
        }
        else {
            Toast.makeText(getContext(), response.getErrorMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
