package com.example.hackgt22.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.hackgt22.ContactUsActivity;
import com.example.hackgt22.FAQ;
import com.example.hackgt22.R;
import com.example.hackgt22.TermsActivity;
import com.example.hackgt22.databinding.FragmentHomeBinding;
import com.example.hackgt22.databinding.FragmentWarningBinding;
import com.example.hackgt22.databinding.ItemHelpBinding;
import com.example.hackgt22.databinding.ItemLinksBinding;


public class WarningFragment extends Fragment {

    private String mTitle[] = {
            "Maintenance - Filter",
            "Maintenance - Nutrients",
            "Harvest Alert",
            "Critical System Damage"
    };
    private String mDescription[] = {
            "Replace filter on Farm 3 - Dirty or Malfunction",
            "Nutrient solution low in Reservoir 1 - Please refill",
            "Plant 5 on Farm 2 overripe - Avoid spoilage and pests",
            "System damage - Contact customer service"

    };
    private int images[] = {
            R.drawable.ic_baseline_access_time_filled_24,
            R.drawable.ic_baseline_grass_24,
            R.drawable.ic_baseline_bug_report_24,
            R.drawable.ic_baseline_warning_24
    };

    private FragmentWarningBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentWarningBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ListView listView = binding.listWarning;
        final Context c = getContext();

        WarningFragment.MyAdapter adapter = new WarningFragment.MyAdapter(c, mTitle, mDescription, images);
        listView.setAdapter(adapter);

        return root;
    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];

        MyAdapter(Context c, String title[], String description[], int imgs[]) {
            super(c, R.layout.item_links, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;
        }

        View row;
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            ItemHelpBinding binding = ItemHelpBinding.inflate(layoutInflater, parent, false);

            binding.helpImage.setImageResource(rImgs[position]);
            binding.helpMain.setText(rTitle[position]);
            binding.helpSub.setText(rDescription[position]);

            return binding.getRoot();
        }
    }



}