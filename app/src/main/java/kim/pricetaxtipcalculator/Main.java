package kim.pricetaxtipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class Main extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private double taxRate, price, tipRate;
    private int person;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner dropdown = (Spinner) findViewById(R.id.province);
        String[] items = { "Alberta","British Columbia","Manitoba","New brunswick",
                "Newfoundland and Labrador","Nova Scotia","Northwest Territories","Ontario",
                "PEI","Quebec","Saskatchewan","Yukon"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,items);
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(this);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                taxRate = 5;
                break;
            case 1:
                taxRate = 12;
                break;
            case 2:
                taxRate = 13;
                break;
            case 3:
                taxRate = 15;
            case 4:
                taxRate = 15;
            case 5:
                taxRate = 15;
            case 6:
                taxRate = 5;
            case 7:
                taxRate = 13;
            case 8:
                taxRate = 15;
            case 9:
                taxRate = 15;
            case 10:
                taxRate = 11;
            case 11:
                taxRate = 15;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        taxRate = -1;
    }

    public void tip_20(View view){
        EditText tip = (EditText) findViewById(R.id.tip);
        tip.setText("20");
    }
    public void tip_15(View view){
        EditText tip = (EditText) findViewById(R.id.tip);
        tip.setText("15");
    }
    public void tip_10(View view) {
        EditText tip = (EditText) findViewById(R.id.tip);
        tip.setText("10");
    }
    public void person_1(View view) {
        EditText tip = (EditText) findViewById(R.id.person);
        tip.setText("1");
    }
    public void person_2(View view) {
        EditText tip = (EditText) findViewById(R.id.person);
        tip.setText("2");
    }
    public void person_3(View view) {
        EditText tip = (EditText) findViewById(R.id.person);
        tip.setText("3");
    }
    public void submit(View view) {
        try{
            TextView result = (TextView) findViewById(R.id.result);
            EditText param1 = (EditText) findViewById(R.id.price);
            EditText param2 = (EditText) findViewById(R.id.tip);
            EditText param3 = (EditText) findViewById(R.id.person);
            price = Double.parseDouble(param1.getText().toString());
            tipRate = Double.parseDouble(param2.getText().toString());
            person = Integer.parseInt(param3.getText().toString());

            double taxVal = price*taxRate/100;
            double tipVal = (price + taxVal)*(tipRate)/100;
            double total = price + taxVal + tipVal;
            double eachPrice = total/person;
            String text = String.format("Tax : $%.2f\nTip : $%.2f\nTotal price : $%.2f\n",taxVal,tipVal,total);
            if (person != 1){
                text += String.format("price per person : $%.2f",eachPrice);
            }
            text+="\n\nThank you to use my application!";
            result.setText(text);
        }catch(Exception e){
            TextView result = (TextView) findViewById(R.id.result);
            result.setText("Something was wrong!\nPossibly your input is missing!");
        }


    }
}