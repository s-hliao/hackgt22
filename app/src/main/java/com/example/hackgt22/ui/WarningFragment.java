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
            "Replace Filter - Dirty or Malfunction",
            "Nutrient Solution Low - Please Replace",
            "Fruit Overripe - Avoid Spoilage and Pests",
            "System Damage - Contact Customer Service Urgently"

    };
    private int images[] = {
            R.drawable.ic_baseline_warning_24,
            R.drawable.ic_baseline_grass_24,
            R.drawable.ic_baseline_bug_report_24,
            R.drawable.ic_baseline_help_24
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