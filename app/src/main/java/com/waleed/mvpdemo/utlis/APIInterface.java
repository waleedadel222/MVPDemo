package com.waleed.mvpdemo.utlis;

import com.waleed.mvpdemo.model.Persons;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {


    @GET("bins/cj2br")
    public Call<Persons[]> getPersons();


}
