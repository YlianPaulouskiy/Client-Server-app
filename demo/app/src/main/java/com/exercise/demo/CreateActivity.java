package com.exercise.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.exercise.demo.data.api.CarApi;
import com.exercise.demo.data.fragment.CarDialogWindow;
import com.exercise.demo.data.model.Car;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CreateActivity extends AppCompatActivity {

    /**
     * to enter auto mark
     */
    EditText markText;

    /**
     * check accounting auto or not
     */
    CheckBox checkAccounting;

    /**
     * get amount of doors
     */
    NumberPicker amountDoors;

    /**
     * check result of operation
     */
    TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_activity);
        amountDoors = findViewById(R.id.amountDoors);
        amountDoorsSetting();
        markText = findViewById(R.id.mark);
        checkAccounting = findViewById(R.id.accounting);
        resultView = findViewById(R.id.resultView);
    }

    /**
     * Button click:
     * go back to main menu
     *
     * @param view v
     */
    public void goToMainActivity(View view) {
        Intent intent = new Intent(CreateActivity.this, MainActivity.class);
        startActivity(intent);
    }

    /**
     * Button click:
     * create model
     *
     * @param view v
     */
    public void createModel(View view) {
        Retrofit retrofit = new Retrofit.Builder().
                baseUrl(CarApi.JSON_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CarApi carApi = retrofit.create(CarApi.class);
        Call<Car> call = carApi.saveCar(markText.getText().toString(), amountDoors.getValue(), checkAccounting.isChecked());
        call.enqueue(new Callback<Car>() {
            @Override
            public void onResponse(Call<Car> call, Response<Car> response) {
                resultView.setText("Success");
            }

            @Override
            public void onFailure(Call<Car> call, Throwable t) {
                resultView.setText("Error");
            }
        });
    }

    /**
     * Tune number picker
     */
    private void amountDoorsSetting() {
        String[] values = {"2", "4", "6", "8"};
        amountDoors.setMinValue(2);
        amountDoors.setMaxValue(5);
        amountDoors.setDisplayedValues(values);
        amountDoors.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        amountDoors.setWrapSelectorWheel(false);
    }

}
