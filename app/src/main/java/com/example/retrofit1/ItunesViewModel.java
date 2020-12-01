package com.example.retrofit1;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItunesViewModel extends AndroidViewModel {

    MutableLiveData<Itunes.Respuesta> respuestaMutableLiveData = new MutableLiveData<>();

    public ItunesViewModel(@NonNull Application application) {
        super(application);
    }

    public void obtener(){
        Itunes.api.obtener().enqueue(new Callback<Itunes.Respuesta>() {
            @Override
            public void onResponse(@NonNull Call<Itunes.Respuesta> call, @NonNull Response<Itunes.Respuesta> response) {
                respuestaMutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<Itunes.Respuesta> call, @NonNull Throwable t) {}
        });
    }
}