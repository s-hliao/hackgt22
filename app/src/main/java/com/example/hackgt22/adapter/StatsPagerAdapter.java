package com.example.hackgt22.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.hackgt22.ui.FarmFragment;
import com.example.hackgt22.ui.PlantGridFragment;
import com.example.hackgt22.ui.PlantInfoFragment;
import com.example.hackgt22.ui.ReservoirFragment;
import com.example.hackgt22.ui.WarningFragment;

public class StatsPagerAdapter extends FragmentPagerAdapter {

    public StatsPagerAdapter(@NonNull FragmentManager fm)
    {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                return new ReservoirFragment();
            case 1:
                return new FarmFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch(position){
            case 0:
                return "Reservoir";
            case 1:
                return "Farm";
            default:
                return null;
        }
    }
}
