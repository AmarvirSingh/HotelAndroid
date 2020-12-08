package com.example.hotelapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

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
        if (v.getId() == R.id.rbSuper){
            price.setText(String.valueOf(originalPrice + (0.25 * originalPrice)));
        }
        if (v.getId() == R.id.rbLuxury){
            price.setText(String.valueOf(originalPrice + (0.50 * originalPrice)));
        }
        if (v.getId() == R.id.rbSuite){
            price.setText(String.valueOf(originalPrice + (1 * originalPrice)));
        }
    }
}