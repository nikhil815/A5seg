package com.example.weightconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText edittext1,editext2;
    private Spinner spinner1,spinner2;
    private int count=0;
    private UnitConverter.Weight unitconverter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edittext1=(EditText)findViewById(R.id.edittext1);
        editext2=(EditText)findViewById(R.id.edittext2);
        spinner1 =(Spinner)findViewById(R.id.spinner1);
        spinner2=(Spinner)findViewById(R.id.spinner2);
        spinner1.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);

        List<String> weight = new ArrayList<>();
        weight.add("MilliGram");
        weight.add("CentiGram");
        weight.add("DeciGram");
        weight.add("Gram");
        weight.add("KiloGram");
        weight.add("MetricTonne");
        weight.add("Pounds");
        weight.add("Ounces");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, weight);
        spinner1.setAdapter(dataAdapter);
        spinner2.setAdapter(dataAdapter);


        unitconverter=new UnitConverter.Weight();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String item = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    public void onNothingSelected(AdapterView<?> arg0) {}

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn0:
                edittext1.setText(edittext1.getText()+"0");
                break;

            case R.id.btn1:
                edittext1.setText(edittext1.getText()+"1");
                break;

            case R.id.btn2:
                edittext1.setText(edittext1.getText()+"2");
                break;

            case R.id.btn3:
                edittext1.setText(edittext1.getText()+"3");
                break;

            case R.id.btn4:
                edittext1.setText(edittext1.getText()+"4");
                break;

            case R.id.btn5:
                edittext1.setText(edittext1.getText()+"5");
                break;

            case R.id.btn6:
                edittext1.setText(edittext1.getText()+"6");
                break;

            case R.id.btn7:
                edittext1.setText(edittext1.getText()+"7");
                break;

            case R.id.btn8:
                edittext1.setText(edittext1.getText()+"8");
                break;

            case R.id.btn9:
                edittext1.setText(edittext1.getText()+"9");
                break;

            case R.id.btndecimal:
                if (count==0)
                {
                    edittext1.setText(edittext1.getText()+".");
                    count++;
                }
                break;

            case R.id.btnclear:
                edittext1.setText("");
                editext2.setText("");
                count=0;
                break;

            case R.id.btnBackspace:
                if( edittext1.length()!= 0 ){
                    String text=edittext1.getText().toString();
                    if(text.endsWith("."))
                        count=0;
                    String newText=text.substring(0,text.length()-1);
                    edittext1.setText(newText);
                }
                break;

            case R.id.btnequal:
                int val1=spinner1.getSelectedItemPosition();
                int val2=spinner2.getSelectedItemPosition();
                double value=Double.parseDouble(edittext1.getText().toString());
                double result=evaluate(val1,val2,value);
                editext2.setText(result+"");
                break;
        }
    }

    public double evaluate(int val1,int val2,double value) {
        double answer=0.0;

        if( val1 == val2 ){

            return value;

        }else{
            switch (val1){
                case 0:
                    answer = unitconverter.MilligramToKilogram(value);
                    break;
                case 1:
                    answer = unitconverter.CentigramToKilogram(value);
                    break;
                case 2:
                    answer = unitconverter.DecigramToKilogram(value);
                    break;
                case 3:
                    answer = unitconverter.GramToKilogram(value);
                    break;
                case 4:
                    answer = value;
                    break;
                case 5:
                    answer = unitconverter.MetricTonnesToKilogram(value);
                    break;
                case 6:
                    answer = unitconverter.PoundsToKilogram(value);
                    break;
                case 7:
                    answer = unitconverter.OuncesToKilogram(value);
                    break;
            }

            switch (val2){
                case 0:
                    answer = unitconverter.KilogramToMilligram(answer);
                    break;
                case 1:
                    answer = unitconverter.KilogramToCentigram(answer);
                    break;
                case 2:
                    answer = unitconverter.KilogramToDecigram(answer);
                    break;
                case 3:
                    answer = unitconverter.KilogramToGram(answer);
                    break;
                case 5:
                    answer = unitconverter.KilogramToMetricTonnes(answer);
                    break;
                case 6:
                    answer = unitconverter.KilogramToPounds(answer);
                    break;
                case 7:
                    answer = unitconverter.KilogramToOunces(answer);
                    break;
            }
            return answer;
        }
    }
}
