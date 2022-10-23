package com.example.hackgt22.ui;

import static com.firebase.ui.auth.AuthUI.getApplicationContext;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.hackgt22.R;
import com.example.hackgt22.databinding.FragmentPlantGridBinding;
import com.example.hackgt22.databinding.FragmentPlantInfoBinding;
import com.example.hackgt22.model.Plant;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.model.Document;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlantInfoFragment extends Fragment {
    private FragmentPlantInfoBinding binding;
    private CollectionReference plantsRef;
    private Map<String, Plant> plants;
    private List<String> plantNames;
    private ArrayAdapter<String> adapter;
    @SuppressLint("RestrictedApi")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentPlantInfoBinding.inflate(inflater, container, false);


        FirebaseFirestore rootRef = FirebaseFirestore.getInstance();
        plantsRef = rootRef.collection("Plant");
        Spinner spinner = binding.plantSpinner;
        plants = new HashMap<>();
        plantNames = new ArrayList<String>();
        plantNames.add(0, "Select a plant");
         adapter = new ArrayAdapter<String>(getApplicationContext(),
                        android.R.layout.simple_spinner_item, plantNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        refreshAction();

        binding.swipeRefresh.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        refreshAction();
                        binding.swipeRefresh.setRefreshing(false);
                    }
                }
        );

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if(plants.containsKey(spinner.getSelectedItem().toString())){
                    Plant p = plants.get(spinner.getSelectedItem().toString());

                    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

                    DatabaseReference databaseReference
                            = firebaseDatabase.getReference();
                    DatabaseReference getImage
                            = databaseReference.child(p.getName());

                    getImage.get().addOnSuccessListener(new OnSuccessListener<DataSnapshot>() {
                        @Override
                        public void onSuccess(DataSnapshot dataSnapshot) {
                            String link = dataSnapshot.getValue(
                                    String.class);
                            Picasso.get().load(link).into(binding.plantView);
                        }
                    });

                    String description  = "";
                    if(p.isNutrientIntensive()){
                        description+="Nutrient Intensive\n";
                    }
                    if(p.isWaterIntensive()){
                        description+="Water Intensive\n";
                    }
                    description+="Grows in "+ p.getGrowthTime()+" days \n";

                    binding.plantDescription.setText(
                            "Description:\n"+
                            description);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return binding.getRoot();
    }

    public void refreshAction(){
        plants.clear();
        plantNames.clear();
        plantNames.add(0, "Select a plant");
        plantsRef.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(@NonNull QuerySnapshot queryDocumentSnapshots) {
                for(DocumentSnapshot doc :queryDocumentSnapshots.getDocuments()){
                    plantNames.add((String)doc.get("name"));
                    plants.put((String)doc.get("name"), doc.toObject(Plant.class));
                }
                adapter.notifyDataSetChanged();
            }
        });


    }
}