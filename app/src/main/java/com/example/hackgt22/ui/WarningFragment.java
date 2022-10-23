package com.example.hackgt22.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hackgt22.R;
import com.example.hackgt22.databinding.FragmentReservoirBinding;
import com.example.hackgt22.databinding.FragmentWarningBinding;


public class WarningFragment extends Fragment {

    FragmentWarningBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentWarningBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }
}