package com.example.hackgt22.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hackgt22.R;
import com.example.hackgt22.databinding.FragmentFarmBinding;
import com.example.hackgt22.databinding.FragmentReservoirBinding;

public class FarmFragment extends Fragment {


    FragmentFarmBinding binding;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFarmBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}