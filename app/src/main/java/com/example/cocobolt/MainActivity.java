package com.example.cocobolt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    menu=(Button) findViewById(R.id.BTmenu);
    Intent intent = new Intent(MainActivity.this, MainMenu.class);


    menu.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {startActivity(intent);}
    });
    }
}