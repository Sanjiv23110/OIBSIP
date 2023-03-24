package com.example.myapplicationforunitconversion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // declaring widgets

    EditText editText;
    TextView textView3, textView4, textView5, valueofpounds;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    // instantiating Widgets

    textView3 = findViewById(R.id.textView3);
    textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);
        valueofpounds = findViewById(R.id.valueofpounds);


    editText = findViewById(R.id.editTextNumber);
    button = findViewById(R.id.button);


//    adding a click event
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                calling convertfrom kilo to pound
                ConvertFromKiloToPound();
            }
        });












    }

    private void ConvertFromKiloToPound() {


//        this method is for converting the values entered in the edit text
//        from kilo to pounds

        String valueEnterinKilo=editText.getText().toString();

//        converting string to number
        double Kilo = Double.parseDouble(valueEnterinKilo);
//KILO TO POUNDS
        double pounds = Kilo * 2.205;



        valueofpounds.setText("" + pounds);


    }
}