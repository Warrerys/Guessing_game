package com.example.guessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Eazy_lvl extends AppCompatActivity {
    TextView mainTextView;
    EditText mainNum;
    Button mainButton;
    Button btnGoToMainAct_1;
    int Check;
    int theNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        mainTextView = findViewById(R.id.mainTxt_2);
        mainNum = findViewById(R.id.main_Num_2);

        mainButton = findViewById(R.id.mainBtn_2);

        mainButton.setOnClickListener(oclBtnGoToMainAct);

        btnGoToMainAct_1 = findViewById(R.id.main_menu_2);
        btnGoToMainAct_1.setOnClickListener(oclBtnGoToMainAct);

        Main_2();
    }

    public int Main_2() {
        Bundle XY = getIntent().getExtras();
        if (XY != null) {
            theNumber = (int) (Math.random() * XY.getInt("Qube") + 1);

        }
        return 0;
    }

    final View.OnClickListener oclBtnGoToMainAct = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.mainBtn_2:

                    String tmp = mainNum.getText().toString();
                    if (tmp.length() != 0) {
                        tmp = mainNum.getText().toString();
                        Check = Integer.valueOf(tmp);
                    }

                    if (Check > theNumber) {
                        mainTextView.setText("Cлишком много. Попробуй еще.");
                        mainNum.setText("");
                    }

                    if (Check < theNumber) {
                        mainTextView.setText("Cлишком мало. Попробуй еще.");
                        mainNum.setText("");
                    }

                    if (Check == theNumber) {
                        mainTextView.setText(" Ты победитель! Сыграй еще разок.");
                    } else if (Check > 100 || Check < 0) {
                        mainTextView.setText("Число не входит в диапазон");
                    }

                    if (tmp.length() == 0) {
                        mainTextView.setText("Введите значение");
                    }
                    break;
                case R.id.main_menu_2:
                    Intent intent_2 = new Intent(Eazy_lvl.this, MainActivity.class);
                    startActivity(intent_2);
                    break;

            }

        }
    };

}