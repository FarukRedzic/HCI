package com.example.faruk.hci_ib130051.network.events;


import android.text.TextUtils;

import retrofit2.Retrofit;

public class FResponse {

    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public boolean isOk() {
        return TextUtils.isEmpty(errorMessage);
    }
}
