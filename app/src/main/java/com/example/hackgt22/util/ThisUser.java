package com.example.hackgt22.util;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hackgt22.AuthActivity;
import com.example.hackgt22.MainActivity;
import com.example.hackgt22.model.DatabaseUser;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


import javax.annotation.Signed;


public class ThisUser{

    private FirebaseFirestore fireStore;

    private static String uid;
    private static String displayName;
    private static DocumentReference userRef;

    // First time initializing
    public ThisUser(final MainActivity activity) {

        FirebaseAuth auth = FirebaseAuth.getInstance();
        uid = auth.getCurrentUser().getUid();
        displayName = auth.getCurrentUser().getDisplayName();
        fireStore = FirebaseFirestore.getInstance();

        final CollectionReference usersCollection = fireStore.collection("DatabaseUser");
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        userRef = usersCollection.document(user.getUid());

    }

    public static String getUid() {
        return uid;
    }

    public static String getDisplayName() {
        return displayName;
    }


    public static void redirect(final AppCompatActivity thisActivity) {

        // If the user is signed in
        FirebaseAuth auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() != null) {

            FirebaseFirestore fireStore = FirebaseFirestore.getInstance();
            final CollectionReference usersCollection = fireStore.collection("DatabaseUser");

            final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            DocumentReference databaseUserRef = usersCollection.document(user.getUid());

            databaseUserRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if (task.isSuccessful()) {
                        DocumentSnapshot document = task.getResult();

                        // If the user doesn't exist in firebase
                        if (!document.exists()) {
                            usersCollection.document(user.getUid()).set(new DatabaseUser(
                                    displayName = user.getDisplayName()
                            ));

                        } else{

                        }

                        thisActivity.startActivity(new Intent(thisActivity.getApplicationContext(), MainActivity.class));
                        thisActivity.finish();
                    }
                }
            });
        }

        // If a user is not signed in, show the auth ui activity
        else {
            thisActivity.startActivity(new Intent(thisActivity.getApplicationContext(), AuthActivity.class));
            thisActivity.finish();
        }
    }
}

