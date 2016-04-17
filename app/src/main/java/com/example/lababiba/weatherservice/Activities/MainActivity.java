package com.example.lababiba.weatherservice.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lababiba.weatherservice.R;
import com.example.lababiba.weatherservice.Service.MyService;

import static com.example.lababiba.weatherservice.Controller.WebServiceClient.connect;


public class MainActivity extends AppCompatActivity {

    Button btnStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        btnStart = (Button) findViewById(R.id.start);
        setContentView(R.layout.activity_main);
    }

    public void onClickStartButton(View view){
        startService(new Intent(this, MyService.class));
        connect();
    }

}
