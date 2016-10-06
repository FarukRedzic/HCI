package com.example.faruk.hci_ib130051.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.faruk.hci_ib130051.models.Korisnik;
import com.example.faruk.hci_ib130051.models.KorisnikLogin;
import com.google.gson.Gson;


public class AppHelper {

    public static final AppHelper APP_HELPER = new AppHelper();

    private static final String SHARED_PREFERENCES = "shared_preferences";
    public static final String USER_SESSION = "USER_SESSION";

    private SharedPreferences sharedPreferences;
    private Context context;
    private Gson gson = new Gson();

    public static AppHelper getInstance() {
        return APP_HELPER;
    }

    public void initAppHelperWithContext(Context context) {
        this.context = context;
    }

    public void setLoginData(KorisnikLogin response) {
        SharedPreferences.Editor editor = this.context.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE).edit();
        editor.putString(USER_SESSION, gson.toJson(response));
        editor.commit();
    }

    public KorisnikLogin getLoginData() {
        SharedPreferences prefs = this.context.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE);
        return gson.fromJson(prefs.getString(USER_SESSION, null), KorisnikLogin.class);
    }
}
