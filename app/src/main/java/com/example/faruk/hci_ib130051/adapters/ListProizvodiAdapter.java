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
import com.example.faruk.hci_ib130051.models.Proizvod;

import java.util.List;

public class ListProizvodiAdapter extends ArrayAdapter<Proizvod> {

    private int resource;
    private List<Proizvod> proizvodi;

    public ListProizvodiAdapter(Context context, int resource, List<Proizvod> proizvodi) {
        super(context, resource, proizvodi);
        this.resource = resource;
        this.proizvodi = proizvodi;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Proizvod proizvod = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(resource, parent, false);
        }

        ImageView ivSlika = (ImageView)convertView.findViewById(R.id.ivSlika);
        TextView tvNaziv = (TextView)convertView.findViewById(R.id.tvNaziv);
        TextView tvCijena = (TextView)convertView.findViewById(R.id.tvCijena);
        TextView tvKategorija = (TextView)convertView.findViewById(R.id.tvKategorija);


        if (proizvod.getSlika() != null) {
            byte[] decodedString = Base64.decode(proizvod.getSlika(), Base64.DEFAULT);
            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

            ivSlika.setImageBitmap(decodedByte);
        }

        tvNaziv.setText(proizvod.getNaziv());
        tvCijena.setText("Cijena: " + proizvod.getCijena());
        tvKategorija.setText(proizvod.getKategorija());

        return convertView;
    }
}
