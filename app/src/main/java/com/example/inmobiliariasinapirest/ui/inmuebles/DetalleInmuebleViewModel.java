package com.example.inmobiliariasinapirest.ui.inmuebles;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.inmobiliariasinapirest.modelo.Inmueble;
import com.example.inmobiliariasinapirest.request.ApiClient;


public class DetalleInmuebleViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<Inmueble> inmuebleMutable;
    public DetalleInmuebleViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Inmueble> getInmueble(){
        if(inmuebleMutable == null){
            inmuebleMutable = new MutableLiveData<>();
        }
        return inmuebleMutable;
    }

    public void setInmueble(Inmueble inmueble){
        inmuebleMutable.setValue(inmueble);
    }

    public void modificarEstadoInmueble(Boolean disponible){
        Inmueble inmueble = inmuebleMutable.getValue();
        inmueble.setEstado(disponible);
        ApiClient.getApi().actualizarInmueble(inmueble);
    }
    // TODO: Implement the ViewModel
}