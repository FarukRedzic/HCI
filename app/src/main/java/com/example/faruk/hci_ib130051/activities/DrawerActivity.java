package com.example.faruk.hci_ib130051.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.faruk.hci_ib130051.R;
import com.example.faruk.hci_ib130051.fragments.DolaznePorukeFragment;
import com.example.faruk.hci_ib130051.fragments.MojProfilFragment;
import com.example.faruk.hci_ib130051.fragments.PregledKorisnikaFragment;
import com.example.faruk.hci_ib130051.fragments.PregledProizvodaFragment;
import com.example.faruk.hci_ib130051.models.Korisnik;
import com.example.faruk.hci_ib130051.util.AppHelper;

import org.w3c.dom.Text;

public class DrawerActivity extends MainActivity {

    private ImageView ivMenu;
    private DrawerLayout drawerLayout;
    private LinearLayout leftDrawer;
    private LinearLayout llPregledKorisnika;
    private LinearLayout llPregledProizvoda;
    private LinearLayout llDolaznePoruke;
    private LinearLayout llOdjava;
    private TextView tvToolbarTitle;
    private LinearLayout llMojProfil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        ivMenu = (ImageView)findViewById(R.id.ivMenu);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        leftDrawer = (LinearLayout)findViewById(R.id.left_drawer);
        llPregledKorisnika = (LinearLayout)findViewById(R.id.llPregledKorisnika);
        llPregledProizvoda = (LinearLayout)findViewById(R.id.llPregledProizvoda);
        llDolaznePoruke = (LinearLayout)findViewById(R.id.llDolaznePoruke);
        tvToolbarTitle = (TextView)findViewById(R.id.tvToolbarTitle);
        llOdjava = (LinearLayout)findViewById(R.id.llOdjava);
        llMojProfil = (LinearLayout)findViewById(R.id.llMojProfil);

        ivMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleDrawer();
            }
        });

        llPregledKorisnika.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNewFragment(PregledKorisnikaFragment.class, R.id.content_frame, null);
                toggleDrawer();
                tvToolbarTitle.setText("Pregled korisnika");
            }
        });

        llPregledProizvoda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNewFragment(PregledProizvodaFragment.class, R.id.content_frame, null);
                toggleDrawer();
                tvToolbarTitle.setText("Pregled proizvoda");

            }
        });

        llOdjava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppHelper.getInstance().setLoginData(null);
                Intent i = new Intent(getBaseContext(), LoginActivity.class);
                startActivity(i);
            }
        });

        llMojProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNewFragment(MojProfilFragment.class, R.id.content_frame, null);
                toggleDrawer();
                tvToolbarTitle.setText("Moj profil");
            }
        });

        llDolaznePoruke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNewFragment(DolaznePorukeFragment.class, R.id.content_frame, null);
                toggleDrawer();
                tvToolbarTitle.setText("Dolazne poruke");
            }
        });

    }

    private void toggleDrawer() {
        if (drawerLayout.isDrawerOpen(leftDrawer)) {
            drawerLayout.closeDrawer(leftDrawer);
        }
        else {
            drawerLayout.openDrawer(leftDrawer);
        }
    }
}
