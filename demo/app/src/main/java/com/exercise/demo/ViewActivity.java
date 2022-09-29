package com.exercise.demo;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.exercise.demo.data.api.CarApi;
import com.exercise.demo.data.fragment.CarDialogWindow;
import com.exercise.demo.data.model.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ViewActivity extends AppCompatActivity {

    /**
     * List to display all models
     */
    ListView listView;

    /**
     * TextView to know about failure
     */
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_activity);
        listView = findViewById(R.id.listView);
        textView = findViewById(R.id.textView);
        setListView();
    }

    private void setListView() {
        Retrofit retrofit = new Retrofit.Builder().
                baseUrl(CarApi.JSON_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CarApi carApi = retrofit.create(CarApi.class);
        Call<List<Car>> call = carApi.getCars();
        call.enqueue(new Callback<List<Car>>() {
            @Override
            public void onResponse(Call<List<Car>> call, Response<List<Car>> response) {
                List<Car> carList =response.body();
                if (carList == null) {
                    throw new AssertionError();
                }
                //desc sort
                List<Car> sortList = new ArrayList<>();
                for (int i = carList.size()-1; i >= 0; i--) {
                    sortList.add(carList.get(i));
                }
                List<String> cars = new ArrayList<>(sortList.size());
                for (Car car : sortList) {
                    cars.add("Car #" + car.getId());
                }
                //set field to ListView
                listView.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, cars));
                //add actionListener to ListView button
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                        Car selectedCar = sortList.get(position);
                        CarDialogWindow dialogWindow = new CarDialogWindow(selectedCar.getId(), selectedCar.getMark(),
                                selectedCar.getDoorCount(), selectedCar.getAccounting());
                        dialogWindow.show(getSupportFragmentManager(), "custom");
                    }
                });
            }

            @Override
            public void onFailure(Call<List<Car>> call, Throwable t) {
                textView.setText("Failure Connection");
                t.printStackTrace();
            }
        });
    }

}

