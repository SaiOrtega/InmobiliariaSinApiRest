package com.example.inmobiliariasinapirest.ui.contratos;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.inmobiliariasinapirest.modelo.Inmueble;
import com.example.inmobiliariasinapirest.request.ApiClient;

import java.util.List;

public class ContratosViewModel extends AndroidViewModel {

    private MutableLiveData<List<Inmueble>> listaInmueblesMutable;

    public ContratosViewModel(@NonNull Application application) {
        super(application);

    }

    public LiveData<List<Inmueble>> setInmuebles(){
        if(listaInmueblesMutable == null){
            listaInmueblesMutable = new MutableLiveData<>();
        }
        return listaInmueblesMutable;
    }

    public void setListaInmueblesMutable(){
        listaInmueblesMutable.setValue(ApiClient.getApi().obtenerPropiedadesAlquiladas());
    }


    // TODO: Implement the ViewModel
}