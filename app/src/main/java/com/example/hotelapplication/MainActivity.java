package com.example.hotelapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener, CompoundButton.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener {

    String names[] = {"Single Bed Room", "Double Bed Room","Window Bed Room","Balcony Bed Room","Luxury Bed Room"};
    ArrayList<Rooms> roomList = new ArrayList<>();
    Spinner spinner;
    ImageView image1,image2;
    TextView price, quantity;
    RadioButton rbNormal,rbSuper,rbLuxury, rbSuite;
    CheckBox parking, breakfast, free;
    SeekBar seekbar;
    Button order;

    public static double originalPrice = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fillData();

        spinner = findViewById(R.id.spinner);
        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        price = findViewById(R.id.price);
        quantity = findViewById(R.id.quantity);
        rbNormal = findViewById(R.id.rbNormal);
        rbSuper = findViewById(R.id.rbSuper);
        rbLuxury = findViewById(R.id.rbLuxury);
        rbSuite = findViewById(R.id.rbSuite);
        parking = findViewById(R.id.parking);
        breakfast = findViewById(R.id.breakfast);
        free = findViewById(R.id.free);
        seekbar = findViewById(R.id.seekBar);
        order = findViewById(R.id.order);

        // ************************************* Spinner ******************************
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,names);
        spinner.setAdapter(aa);
        spinner.setOnItemSelectedListener(this);

        //*************************************RadioButtons ***********************************
        rbNormal.setOnClickListener(this);
        rbSuper.setOnClickListener(this);
        rbLuxury.setOnClickListener(this);
        rbSuite.setOnClickListener(this);

        // ******************************* Checkboxes Action ********************************
        parking.setOnCheckedChangeListener(this);
        breakfast.setOnCheckedChangeListener(this);
        free.setOnCheckedChangeListener(this);

        // ************************ SeekBAr Event ***************************************
        seekbar.setOnSeekBarChangeListener(this);


        originalPrice = roomList.get(0).getPrice();



    }

    public void fillData(){
        roomList.add(new Rooms(names[0],55.5, "single1","single2"));
        roomList.add(new Rooms(names[1],65.5,"double1","double2"));
        roomList.add(new Rooms(names[2],75.5,"window1","window2"));
        roomList.add(new Rooms(names[3],85.5,"balcony1","balcony2"));
        roomList.add(new Rooms(names[4],95.5,"luxury","luxury2"));
    }

    // *************************** Spinner Fucntion **************************
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        price.setText(String.valueOf(roomList.get(position).getPrice()));
        originalPrice = roomList.get(position).getPrice();
        int imageid1 = getResources().getIdentifier(roomList.get(position).getImage1(),"drawable",getPackageName());
        int imageid2 = getResources().getIdentifier(roomList.get(position).getImage2(),"drawable",getPackageName());

        image1.setImageResource(imageid1);
        image2.setImageResource(imageid2);
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    // *********************************** Radio Button Function ********************************
    @Override
    public void onClick(View v) {


        if (v.getId() == R.id.rbNormal){
            price.setText(String.valueOf(originalPrice));
        }
        else if (v.getId() == R.id.rbSuper){
            price.setText(String.valueOf(originalPrice + (0.25 * originalPrice)));
        }
        else if (v.getId() == R.id.rbLuxury){
            price.setText(String.valueOf(originalPrice + (0.50 * originalPrice)));
        }
        else if (v.getId() == R.id.rbSuite){
            price.setText(String.valueOf(originalPrice + (1 * originalPrice)));
        }
    }

    // ***************************************** Check boxes Function ********************************
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        double currentPrice = Double.parseDouble(price.getText().toString());


        if (buttonView.getId() == R.id.parking){
            if (parking.isChecked()){
                currentPrice += 25;
            }else{
                currentPrice -= 25;
            }
        }
        if (buttonView.getId() == R.id.breakfast){
            if (breakfast.isChecked()){
                currentPrice += 20;
            }
            else{
                currentPrice -= 20;
            }
        }
        if (buttonView.getId() == R.id.free){
            if (free.isChecked()){
                currentPrice += (0.1 * currentPrice);
            }
            else{
                currentPrice -= (0.1 * currentPrice);
            }
        }
        price.setText(String.format("%.2f",currentPrice));

    }

    // ****************************** SeekBAR FUNCTION ***************************
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        quantity.setText(String.valueOf(progress));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}