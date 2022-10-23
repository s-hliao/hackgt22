package com.example.hackgt22.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hackgt22.R;
import com.example.hackgt22.databinding.FragmentPlantGridBinding;
import com.example.hackgt22.databinding.FragmentReservoirBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ReservoirFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ReservoirFragment extends Fragment {
    FragmentReservoirBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentReservoirBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }
}