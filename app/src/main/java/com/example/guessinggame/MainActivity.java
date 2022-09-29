package com.example.guessinggame;

import static android.widget.Toast.LENGTH_LONG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {

    Button mainClose;
    Button btnGoToSecAct;
    Button btnGoToSecAct_1;
    Button btnGoToSecAct_2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnGoToSecAct = findViewById(R.id.main_normal);
        btnGoToSecAct_1 = findViewById(R.id.main_eazy);
        btnGoToSecAct_2 = findViewById(R.id.main_hard);

        View.OnClickListener oclBtnGoToSecAct = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.main_normal:
                        Intent intent = new Intent(MainActivity.this, Normal_lvl.class);
                        intent.putExtra("Around", 1000);
                        startActivity(intent);
                        break;
                    case R.id.main_eazy:
                        Intent intent_2 = new Intent(MainActivity.this, Eazy_lvl.class);
                        intent_2.putExtra("Qube", 100);
                        startActivity(intent_2);
                        break;
                    case R.id.main_hard:
                        Intent intent_3 = new Intent(MainActivity.this, Hard_lvl.class);
                        intent_3.putExtra("Vogue", 1000);
                        startActivity(intent_3);
                        break;

                }


            }
        };
        btnGoToSecAct.setOnClickListener(oclBtnGoToSecAct);
        btnGoToSecAct_1.setOnClickListener(oclBtnGoToSecAct);
        btnGoToSecAct_2.setOnClickListener(oclBtnGoToSecAct);


    }


}