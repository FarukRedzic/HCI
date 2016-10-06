package com.example.faruk.hci_ib130051.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.faruk.hci_ib130051.R;
import com.example.faruk.hci_ib130051.adapters.PagerAdapter;


public class MojProfilFragment extends FFragment {

    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;

    @Override
    public boolean isTopLevelFragment() {
        return true;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_moj_profil, container, false);

        viewPager = (ViewPager)view.findViewById(R.id.viewPager);

        pagerAdapter = new PagerAdapter(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        return view;
    }
}
