package com.example.faruk.hci_ib130051.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.faruk.hci_ib130051.fragments.AktivniProizvodiFragment;
import com.example.faruk.hci_ib130051.fragments.ProdaniProizvodiFragment;
import com.example.faruk.hci_ib130051.fragments.ProfilFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return ProfilFragment.newInstance();
            case 1:
                return AktivniProizvodiFragment.newInstance();
            case 2:
                return ProdaniProizvodiFragment.newInstance();
        }

        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Licni profil";
            case 1:
                return "Aktivni proizvodi";
            case 2:
                return "Prodani proizvodi";
        }

        return "";
    }
}
