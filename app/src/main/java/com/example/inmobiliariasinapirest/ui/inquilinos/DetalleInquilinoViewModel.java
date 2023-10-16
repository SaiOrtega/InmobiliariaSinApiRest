package com.example.inmobiliariasinapirest.ui.inquilinos;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.inmobiliariasinapirest.modelo.Inmueble;
import com.example.inmobiliariasinapirest.modelo.Inquilino;
import com.example.inmobiliariasinapirest.request.ApiClient;


public class DetalleInquilinoViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<Inquilino> inquilinoMutable;
    public DetalleInquilinoViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public LiveData<Inquilino> getInquilino(){
        if(inquilinoMutable == null){
            inquilinoMutable = new MutableLiveData<>();
        }
        return inquilinoMutable;
    }

    public void setInquilinoMutable(Inmueble inmueble){
        inquilinoMutable.setValue(ApiClient.getApi().obtenerInquilino(inmueble));
    }
    // TODO: Implement the ViewModel
}