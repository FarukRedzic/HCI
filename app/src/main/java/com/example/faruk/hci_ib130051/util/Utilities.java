package com.example.faruk.hci_ib130051.util;

import com.example.faruk.hci_ib130051.models.RegistracijaKorisnika;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Utilities {

    public static String ConvertObjectToString(Object obj){
        Gson gson =  new GsonBuilder().create();
        return gson.toJson(obj);
    }

}
