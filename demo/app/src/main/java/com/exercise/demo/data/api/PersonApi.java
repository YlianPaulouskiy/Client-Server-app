package com.exercise.demo.data.api;

import com.exercise.demo.data.model.Person;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PersonApi {

    String JSON_API = "https://www.simplifiedcoding.net/demos/";

    @GET("marvel")
    Call<List<Person>> getPersons();

}
