package com.example.faruk.hci_ib130051.fragments;

import android.support.v4.app.Fragment;

import com.example.faruk.hci_ib130051.bus.OttoBus;


public abstract class FFragment extends Fragment {

    abstract public boolean isTopLevelFragment();

    @Override
    public void onStart() {
        super.onStart();
        OttoBus.getInstance().register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        OttoBus.getInstance().unregister(this);
    }

}
