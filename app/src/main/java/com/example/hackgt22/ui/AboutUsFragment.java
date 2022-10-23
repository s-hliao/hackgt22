package com.example.hackgt22.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.hackgt22.ContactUsActivity;
import com.example.hackgt22.FAQ;
import com.example.hackgt22.R;
import com.example.hackgt22.TermsActivity;
import com.example.hackgt22.databinding.FragmentAboutUsBinding;
import com.example.hackgt22.databinding.FragmentHelpBinding;
import com.example.hackgt22.databinding.ItemHelpBinding;
import com.example.hackgt22.databinding.ItemLinksBinding;


public class AboutUsFragment extends Fragment {

    String mTitle[] = {
            "Georgia Tech",
            "Facebook",
            "Instagram",
            "Twitter"

    };
    int images[] = {
            R.mipmap.gt_logo,
            R.mipmap.facebook_logo,
            R.mipmap.instagram_logo,
            R.mipmap.twitter_logo
    };

    FragmentAboutUsBinding binding;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        binding = FragmentAboutUsBinding.inflate(inflater, container, false);

        ListView listView = binding.listLinks;
        final Context c = getContext();

        AboutUsFragment.MyAdapter adapter = new AboutUsFragment.MyAdapter(c, mTitle, images);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent browserIntent = null;
                switch (position){
                    case 0:
                        browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.gatech.edu/"));
                        break;
                    case 1:
                        browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/georgiatech/"));
                        break;
                    case 2:
                        browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/georgiatech/"));
                        break;
                    case 3:
                        browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/GeorgiaTech"));
                        break;
                }

                if (browserIntent != null)
                    startActivity(browserIntent);
            }
        });
        return binding.getRoot();





    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        int rImgs[];

        MyAdapter(Context c, String title[],  int imgs[]) {
            super(c, R.layout.item_links, title);
            this.context = c;
            this.rTitle = title;
            this.rImgs = imgs;
        }

        View row;
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            ItemLinksBinding binding = ItemLinksBinding.inflate(layoutInflater, parent, false);
            binding.linksImage.setImageResource(rImgs[position]);
            binding.linksMain.setText(rTitle[position]);

            return binding.getRoot();
        }
    }
}