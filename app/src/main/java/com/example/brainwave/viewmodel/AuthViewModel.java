package com.example.brainwave.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.brainwave.repository.AuthRepository;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AuthViewModel extends AndroidViewModel {
    private MutableLiveData<FirebaseUser> firebaseUserMutableLiveData;
    private FirebaseUser currentUser;
    private AuthRepository repository;

    public MutableLiveData<FirebaseUser> getFirebaseUserMutableLiveData() {
        return firebaseUserMutableLiveData;
    }

    public FirebaseUser getCurrentUser() {
        return currentUser;
    }

    public AuthViewModel(@NonNull Application application) {
        super(application);

        repository= new AuthRepository(application);
        currentUser= repository.getCurrentUser();
        firebaseUserMutableLiveData= repository.getFirebaseUserMutableLiveData();
    }
    public void signUp(String email, String pass){
        repository.signUp(email, pass);
    }
    public void logIn(String email, String pass){
        repository.logIn(email, pass);
    }
    public void signOut(){
        repository.signOut();
    }
}
