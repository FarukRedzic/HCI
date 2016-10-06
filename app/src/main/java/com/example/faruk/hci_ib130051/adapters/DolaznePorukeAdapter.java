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
import com.example.faruk.hci_ib130051.models.Poruka;

import java.util.List;

public class DolaznePorukeAdapter extends ArrayAdapter<Poruka> {

    private int resource;
    private List<Poruka> poruke;

    public DolaznePorukeAdapter(Context context, int resource, List<Poruka> poruke) {
        super(context, resource, poruke);
        this.resource = resource;
        this.poruke = poruke;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Poruka poruka = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(resource, parent, false);
        }

        TextView tvPosiljaoc = (TextView)convertView.findViewById(R.id.tvPoslao);
        TextView tvMessage = (TextView)convertView.findViewById(R.id.tvMessage);

        tvPosiljaoc.setText(poruka.getPoslao());
        tvMessage.setText(poruka.getNaslov());


        return convertView;
    }
}
