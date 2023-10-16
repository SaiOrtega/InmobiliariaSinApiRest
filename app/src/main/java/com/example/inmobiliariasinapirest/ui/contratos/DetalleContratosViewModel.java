package com.example.inmobiliariasinapirest.ui.contratos;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.inmobiliariasinapirest.modelo.Contrato;
import com.example.inmobiliariasinapirest.modelo.Inmueble;
import com.example.inmobiliariasinapirest.request.ApiClient;


public class DetalleContratosViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<Contrato> contratoMutable;

    public DetalleContratosViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }
    public LiveData<Contrato> getContrato(){
        if(contratoMutable == null){
            contratoMutable = new MutableLiveData<>();
        }
        return contratoMutable;
    }

    public void setContrato(Inmueble inmueble){
        Contrato contrato = ApiClient.getApi().obtenerContratoVigente(inmueble);
        contratoMutable.setValue(contrato);
    }
    // TODO: Implement the ViewModel
}