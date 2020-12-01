package com.example.retrofit1;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class Itunes {
    class Respuesta {
        List<Mundial> documents;
    }

    class Mundial {
        String name;
        Fields fields;
    }
    class Fields {
        Value Mundial;
        Value Year;
        Value Ganador;
        Value Imagen;
    }
    class Value {
        String stringValue;
    }
    public static Api api = new Retrofit.Builder()
            .baseUrl("https://firestore.googleapis.com/v1/projects/retrofitmundial/databases/(default)/documents/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api.class);

    public interface Api {
        @GET("Mundiales")
        Call<Respuesta> obtener();
    }
}
