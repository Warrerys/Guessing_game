package com.example.guessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Normal_lvl extends AppCompatActivity {

    TextView mainTextView;
    EditText mainNum;
    Button mainButton;
    Button mainClose;
    int Check;
    int theHundred;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Button btnGoToMainAct = findViewById(R.id.main_menu_1);
        Button main_Btn_1 = (Button) findViewById(R.id.mainBtn_1);

        mainTextView = findViewById(R.id.mainTxt_1);
        mainNum = findViewById(R.id.main_Num_1);

        mainButton = findViewById(R.id.mainBtn_1);
        mainButton.setOnClickListener(oclBtnGoToMainAct);


        btnGoToMainAct.setOnClickListener(oclBtnGoToMainAct);
        Main();
    }

    public int Main() {
        Bundle XY = getIntent().getExtras();
        if (XY != null) {
            theHundred = (int) (Math.random() * XY.getInt("Around") + 100);

        }
        return 0;
    }

    final View.OnClickListener oclBtnGoToMainAct = new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            switch (view.getId()) {
                case R.id.mainBtn_1:

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
                    } else if (Check > 1000 || Check < 100) {
                        mainTextView.setText("Число не входит в диапазон");
                    }

                    if (tmp.length() == 0) {
                        mainTextView.setText("Введите значение");
                    }
                    break;
                case R.id.main_menu_1:
                    Intent intent = new Intent(Normal_lvl.this, MainActivity.class);
                    startActivity(intent);
                    break;

            }

        }

    };


}
