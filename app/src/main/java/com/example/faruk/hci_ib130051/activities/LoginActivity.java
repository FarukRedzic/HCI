package com.example.faruk.hci_ib130051.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.faruk.hci_ib130051.R;
import com.example.faruk.hci_ib130051.models.Korisnik;
import com.example.faruk.hci_ib130051.models.KorisnikLogin;
import com.example.faruk.hci_ib130051.services.FactoryService;
import com.example.faruk.hci_ib130051.util.AppHelper;
import com.squareup.otto.Subscribe;

public class LoginActivity extends MainActivity {

    TextView txtKorisnickoIme, txtLozinka;
    Button btnPrijava;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtKorisnickoIme = (TextView) findViewById(R.id.txtKorisnickoIme);
        txtLozinka = (TextView) findViewById(R.id.txtLozinka);
        btnPrijava = (Button) findViewById(R.id.btnPrijava);


        btnPrijava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FactoryService.getKorisnik(txtKorisnickoIme.getText().toString());
            }
        });
    }

    @Subscribe
    public void onGetKorisnik(KorisnikLogin korisnik) {
        if (korisnik.isOk()) {
            if (!txtLozinka.getText().toString().equals(korisnik.getLozinkaHash())) {
                Toast.makeText(LoginActivity.this,"Neispravno korisničko ime ili lozinka!",Toast.LENGTH_LONG).show();
                txtKorisnickoIme.setText("");
                txtLozinka.setText("");
            }
            else {
                txtKorisnickoIme.setText("");
                txtLozinka.setText("");

                AppHelper.getInstance().setLoginData(korisnik);
                final Intent intent = new Intent(LoginActivity.this, DrawerActivity.class);
                startActivity(intent);
            }
        }
        else {
            Toast.makeText(this, "Neispravno korisničko ime ili lozinka!", Toast.LENGTH_SHORT).show();
            txtKorisnickoIme.setText("");
            txtLozinka.setText("");
        }
    }

}
