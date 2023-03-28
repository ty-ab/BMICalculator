package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    TextInputEditText height;
    TextInputEditText weight;

    TextInputEditText bmiValue;

    Button calButton;
    Button clButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        height = findViewById(R.id.weightId);
        weight = findViewById(R.id.heigthId);

        bmiValue = findViewById(R.id.bmiValue);

        calButton = findViewById(R.id.buttonCaculate);
        clButton = findViewById(R.id.buttonClear);


        calButton.setOnClickListener(v -> {
            if (!Objects.requireNonNull(height.getText()).toString().isEmpty() && !Objects.requireNonNull(weight.getText()).toString().isEmpty()) {
                double w = Double.parseDouble(height.getText().toString());
                double h = Double.parseDouble(weight.getText().toString());
                double result = (w / (h * h));
                bmiValue.setText(Double.toString(Math.round(result)));
            } else {
                Toast.makeText(this,"input incomplete",Toast.LENGTH_SHORT).show();
            }
        });

        clButton.setOnClickListener(v -> {
            height.setText("");
            weight.setText("");
            bmiValue.setText("");
        });
    }
}