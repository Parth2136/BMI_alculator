package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edwei,edhei;
        TextView txtinter,txtres;
        Button btnres,btnreset;

        edwei=findViewById(R.id.edwei);
        edhei=findViewById(R.id.edhei);

        txtinter=findViewById(R.id.txtinter);
        txtres=findViewById(R.id.txtres);

        btnres=findViewById(R.id.btnres);
        btnreset=findViewById(R.id.btnreset);

        btnres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strwei=edwei.getText().toString();
                String strhei=edhei.getText().toString();

                if (strwei.equals("")){
                    edwei.setError("Please Enter Your Weight");
                    edwei.requestFocus();
                    return;
                }
                if (strhei.equals("")){
                    edhei.setError("Please Enter Your Height");
                    edhei.requestFocus();
                    return;
                }

                float weight = Float.parseFloat(strwei);
                float height = Float.parseFloat(strhei)/100;

                float bmivalue = BMICalculate(weight,height);

                txtinter.setText(interpretBMI(bmivalue));
                txtres.setText("BMI= "+bmivalue);

            }
        });
        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edwei.setText("");
                edhei.setText("");
                txtinter.setText("");
                txtres.setText("");
            }
        });

    }
    public float BMICalculate(float weight,float height){
        return weight / (height * height);
    }
    public String interpretBMI(float bmivalue){
        if(bmivalue<16){
            return "Servely Underweight";
        }
        else if (bmivalue<18){
            return "Underweight";
        }
        else if (bmivalue<25){
            return "Normal";
        }
        else if (bmivalue<30){
            return "Overweight";
        }
        else
            return "Obese";
    }
}