package com.example.faruk.hci_ib130051.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.faruk.hci_ib130051.R;
import com.example.faruk.hci_ib130051.models.Korisnik;

import java.util.List;

public class ListKorisniciAdapter extends ArrayAdapter<Korisnik> {

    private int resource;
    private List<Korisnik> korisnici;
    public ListKorisniciAdapter(Context context, int resource, List<Korisnik> korisnici) {
        super(context, resource, korisnici);
        this.resource = resource;
        this.korisnici = korisnici;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Korisnik korisnik = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(resource, parent, false);
        }

        ImageView ivSlika = (ImageView)convertView.findViewById(R.id.ivSlika);
        TextView tvKorisnickoIme = (TextView)convertView.findViewById(R.id.tvKorisnickoIme);
       // TextView tvImePrezime = (TextView)convertView.findViewById(R.id.tvImePrezime);
        TextView tvOpstina = (TextView)convertView.findViewById(R.id.tvOpstina);
        TextView tvAdresa = (TextView)convertView.findViewById(R.id.tvAdresa);
        TextView tvEmail = (TextView)convertView.findViewById(R.id.tvEmail);
        TextView tvTelefon = (TextView)convertView.findViewById(R.id.tvTelefon);

        if (korisnik.getSlika() != null && !TextUtils.isEmpty(korisnik.getSlika())) {
            byte[] decodedString = Base64.decode(korisnik.getSlika(), Base64.DEFAULT);
            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

            ivSlika.setImageBitmap(decodedByte);
        }

        tvKorisnickoIme.setText(korisnik.getKorisnickoIme());
        //tvImePrezime.setText(korisnik.getIme() + " " + korisnik.getPrezime());
        tvOpstina.setText("Opstina: " + korisnik.getOpstina());
        tvAdresa.setText("Adresa: " + korisnik.getAdresa());
        tvEmail.setText("Email: " + korisnik.getEmail());
        tvTelefon.setText("Telefon: " + korisnik.getTelefon());

        return convertView;
    }
}
