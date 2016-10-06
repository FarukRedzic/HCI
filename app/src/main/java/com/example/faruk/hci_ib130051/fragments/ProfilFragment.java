package com.example.faruk.hci_ib130051.fragments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.faruk.hci_ib130051.R;
import com.example.faruk.hci_ib130051.models.Korisnik;
import com.example.faruk.hci_ib130051.models.KorisnikLogin;
import com.example.faruk.hci_ib130051.util.AppHelper;

public class ProfilFragment extends FFragment {

    private ImageView ivSlika;
    private TextView tvIme;
    private TextView tvPrezime;
    private TextView tvEmail;
    private TextView tvOpcina;
    private TextView tvAdresa;
    private TextView tvTrgovina;

    @Override
    public boolean isTopLevelFragment() {
        return false;
    }

    public static ProfilFragment newInstance() {

        Bundle args = new Bundle();

        ProfilFragment fragment = new ProfilFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profil, container, false);

        ivSlika = (ImageView)view.findViewById(R.id.ivSlika);
        tvIme = (TextView)view.findViewById(R.id.tvIme);
        tvPrezime = (TextView)view.findViewById(R.id.tvPrezime);
        tvEmail = (TextView)view.findViewById(R.id.tvEmail);
        tvOpcina = (TextView)view.findViewById(R.id.tvOpcina);
        tvAdresa = (TextView)view.findViewById(R.id.tvAdresa);
        tvTrgovina = (TextView)view.findViewById(R.id.tvTrgovina);

        KorisnikLogin korisnik = AppHelper.getInstance().getLoginData();

        if (korisnik.getSlika() != null) {
            byte[] decodedString = Base64.decode(korisnik.getSlika(), Base64.DEFAULT);
            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

            ivSlika.setImageBitmap(decodedByte);
        }

        tvIme.setText("Ime: " + korisnik.getIme());
        tvPrezime.setText("Prezime: " + korisnik.getPrezime());
        tvEmail.setText("Email: " + korisnik.getEmail());

        return view;
    }
}
