package com.example.inmobiliariasinapirest.ui.inmuebles;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import com.example.inmobiliariasinapirest.modelo.Inmueble;
import com.example.inmobiliariasinapirest.request.ApiClient;

import java.util.List;

public class InmueblesViewModel extends AndroidViewModel {


    private Context context;
    private MutableLiveData<List<Inmueble>> listaInmueblesMutable;

    public InmueblesViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public LiveData<List<Inmueble>> setInmuebles(){
        if(listaInmueblesMutable == null){
            listaInmueblesMutable = new MutableLiveData<>();
        }
        return listaInmueblesMutable;
    }

    public void setListaInmueblesMutable(){
        listaInmueblesMutable.setValue(ApiClient.getApi().obtnerPropiedades());
    }
}