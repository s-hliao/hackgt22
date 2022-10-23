package com.example.hackgt22.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.hackgt22.ui.PlantGridFragment;
import com.example.hackgt22.ui.PlantInfoFragment;
import com.example.hackgt22.ui.WarningFragment;

public class PlantPagerAdapter extends FragmentPagerAdapter {

    public PlantPagerAdapter(@NonNull FragmentManager fm)
    {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                return new PlantGridFragment();
            case 1:
                return new PlantInfoFragment();
            case 2:
                return new WarningFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch(position){
            case 0:
                return "Plant Grid";
            case 1:
                return "Plant Info";
            case 2:
                return "Warning";
            default:
                return null;
        }
    }
}
