package com.example.inmobiliariasinapirest;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.inmobiliariasinapirest.modelo.Propietario;
import com.example.inmobiliariasinapirest.request.ApiClient;

public class MenuActivityViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<Propietario> propietarioMutable;
    public MenuActivityViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }
    public LiveData<Propietario> getPropietario(){
        if(propietarioMutable == null){
            propietarioMutable = new MutableLiveData<>();
        }
        return propietarioMutable;
    }
    public void getPropietarioMutable(){
        propietarioMutable.setValue(ApiClient.getApi().obtenerUsuarioActual());
    }

}
