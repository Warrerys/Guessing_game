package com.example.guessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Hard_lvl extends AppCompatActivity {
    TextView mainTextView;
    EditText mainNum;
    Button mainButton;
    Button btnGoToMainAct_3;
    int Check;
    int theHundred;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        mainTextView = findViewById(R.id.mainTxt_3);
        mainNum = findViewById(R.id.main_Num_3);

        mainButton = findViewById(R.id.mainBtn_3);

        mainButton.setOnClickListener(oclBtnGoToMainAct);

        btnGoToMainAct_3 = findViewById(R.id.main_menu_3);
        btnGoToMainAct_3.setOnClickListener(oclBtnGoToMainAct);

        Main_3();
    }

    public int Main_3() {
        Bundle XY = getIntent().getExtras();
        if (XY != null) {
            theHundred = (int) (Math.random() * XY.getInt("Vogue") + 1);

        }
        return 0;
    }

    final View.OnClickListener oclBtnGoToMainAct = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.main_menu_3:
                    Intent intent_3 = new Intent(Hard_lvl.this, MainActivity.class);
                    startActivity(intent_3);
                    break;
                case R.id.mainBtn_3:

                    String tmp = mainNum.getText().toString();
                    if (tmp.length() != 0) {
                        tmp = mainNum.getText().toString();
                        Check = Integer.valueOf(tmp);
                    }

                    if (Check > theHundred) {
                        mainTextView.setText("Cлишком много. Попробуй еще.");
                        mainNum.setText("");
                    }

                    if (Check < theHundred) {
                        mainTextView.setText("Cлишком мало. Попробуй еще.");
                        mainNum.setText("");
                    }

                    if (Check == theHundred) {
                        mainTextView.setText(" Ты победитель! Сыграй еще разок.");
                    } else if (Check > 1000 || Check < 0) {
                        mainTextView.setText("Число не входит в диапазон");
                    }

                    if (tmp.length() == 0) {
                        mainTextView.setText("Введите значение");
                    }
                    break;

            }
        }
    };
}