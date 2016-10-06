package com.example.faruk.hci_ib130051;

import android.app.Application;

import com.example.faruk.hci_ib130051.network.RestFactoryClient;
import com.example.faruk.hci_ib130051.util.AppHelper;

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Retrofit
        RestFactoryClient.resetClient();

        // SharedPreferences
        AppHelper.getInstance().initAppHelperWithContext(this);
    }
}
