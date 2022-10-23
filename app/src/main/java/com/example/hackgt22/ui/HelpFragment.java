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
import com.example.hackgt22.databinding.FragmentHelpBinding;
import com.example.hackgt22.databinding.FragmentHomeBinding;
import com.example.hackgt22.databinding.ItemHelpBinding;
import com.example.hackgt22.databinding.ItemLinksBinding;


public class HelpFragment extends Fragment {

    private String mTitle[] = {
            "FAQ",
            "Contact Us",
            "Terms of Use and Licensing",
    };
    private String mDescription[] = {
            "Common questions on how to use MyVFarm",
            "Need additional help?",
            "Review terms of service"
    };
    private int images[] = {
            R.drawable.ic_baseline_question_mark_24,
            R.drawable.ic_baseline_chat_24,
            R.drawable.ic_baseline_text_snippet_24
    };

    private FragmentHelpBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentHelpBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ListView listView = binding.listHelp;
        final Context c = getContext();

        HelpFragment.MyAdapter adapter = new HelpFragment.MyAdapter(c, mTitle, mDescription, images);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    startActivity(new Intent(getActivity(), FAQ.class));
                } else if (position == 1) {
                    startActivity(new Intent(getActivity(), ContactUsActivity.class));
                } else if (position == 2) {
                    startActivity(new Intent(getActivity(), TermsActivity.class));
                }
            }
        });
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