package com.example.inmobiliariasinapirest;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.inmobiliariasinapirest.modelo.Propietario;
import com.example.inmobiliariasinapirest.request.ApiClient;

public class MainActivityViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<Boolean> loginMutable;
    private MutableLiveData<Sensor> llamadaMutable;
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }
    public LiveData<Boolean> getLogin(){
        if(loginMutable == null){
            loginMutable = new MutableLiveData<>();
        }
        return loginMutable;
    }
    public LiveData<Sensor> getLlamada(){
        if(llamadaMutable == null){
            llamadaMutable = new MutableLiveData<>();
        }
        return llamadaMutable;
    }

    public void login(String email, String clave){
        Propietario propietario = ApiClient.getApi().login(email, clave);
        if(propietario != null){
            loginMutable.setValue(true);
        }else{
            Toast.makeText(context, "Error en el inicio de sesion", Toast.LENGTH_SHORT).show();
        }
    }

    public void setLlamadaListener(){
        llamadaMutable.setValue(new Sensor(context));
    }
}
