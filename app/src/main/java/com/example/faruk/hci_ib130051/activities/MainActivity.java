package com.example.faruk.hci_ib130051.activities;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.faruk.hci_ib130051.bus.OttoBus;
import com.example.faruk.hci_ib130051.fragments.FFragment;

public abstract class MainActivity extends AppCompatActivity {

    private boolean busRegistered;

    @Override
    protected void onStart() {
        super.onStart();
        if (!busRegistered) {
            OttoBus.getInstance().register(this);
            busRegistered = true;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        OttoBus.getInstance().unregister(this);
    }

    public void showNewFragment(Class<? extends FFragment> fragmentClass, Integer whereToPlaceId, Bundle bundle) {
        String tag = fragmentClass.getCanonicalName();

        FragmentManager fm = getSupportFragmentManager();
        FFragment newFragment = null;

        try {
            newFragment = (FFragment)fragmentClass.newInstance();

            if (bundle != null) {
                newFragment.setArguments(bundle);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        FragmentTransaction fragTM = fm.beginTransaction();
        fragTM.replace(whereToPlaceId, newFragment, tag);

        if (newFragment.isTopLevelFragment()) {
            // dont add to stack if top level fragment
        } else {
            fragTM.addToBackStack(tag);
        }

        fragTM.commit();
    }}
