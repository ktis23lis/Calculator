package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity  implements Serializable {
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9,
            btn0, btnShare, btnMultiply, btnMin, btnSum, btnEquals, buttonClear;
    private TextView inputTextView, outputTextView, caseTextView;
    private String helperProcess;
    private ArrayList arrayList;
    private String arrayHelper;
    private String equalsHelper;
    private String operator;
    private String stringAboutSecondNum;
    private float result;
    private int firstNum;
    private int secondNum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findView();
        buttonNum();
        buttonOption();
        equalsMethod();
    }

    private void findView() {
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        btn7 = findViewById(R.id.button7);
        btn8 = findViewById(R.id.button8);
        btn9 = findViewById(R.id.button9);
        btn0 = findViewById(R.id.button0);
        btnShare = findViewById(R.id.buttonShare);
        btnMultiply = findViewById(R.id.buttonMultiply);
        btnMin = findViewById(R.id.buttonMin);
        btnSum = findViewById(R.id.buttonSum);
        btnEquals = findViewById(R.id.buttonEquals);
        inputTextView = findViewById(R.id.inputTextView);
        outputTextView = findViewById(R.id.outputTextView);
        buttonClear = findViewById(R.id.buttonClear);
        caseTextView = findViewById(R.id.caseTextView);

    }


    @SuppressLint("SetTextI18n")
    private void buttonNum() {
        buttonClear.setOnClickListener(v -> {
            inputTextView.setText("");
            outputTextView.setText("");
            caseTextView.setText("");

        });

        btn1.setOnClickListener(v -> {
            helperProcess = inputTextView.getText().toString();
            inputTextView.setText(helperProcess + "1");
        });

        btn2.setOnClickListener(v -> {
            helperProcess = inputTextView.getText().toString();
            inputTextView.setText(helperProcess + "2");
        });

        btn3.setOnClickListener(v -> {
            helperProcess = inputTextView.getText().toString();
            inputTextView.setText(helperProcess + "3");
        });

        btn4.setOnClickListener(v -> {
            helperProcess = inputTextView.getText().toString();
            inputTextView.setText(helperProcess + "4");
        });

        btn5.setOnClickListener(v -> {
            helperProcess = inputTextView.getText().toString();
            inputTextView.setText(helperProcess + "5");
        });

        btn6.setOnClickListener(v -> {
            helperProcess = inputTextView.getText().toString();
            inputTextView.setText(helperProcess + "6");
        });

        btn7.setOnClickListener(v -> {
            helperProcess = inputTextView.getText().toString();
            inputTextView.setText(helperProcess + "7");
        });

        btn8.setOnClickListener(v -> {
            helperProcess = inputTextView.getText().toString();
            inputTextView.setText(helperProcess + "8");
        });

        btn9.setOnClickListener(v -> {
            helperProcess = inputTextView.getText().toString();
            inputTextView.setText(helperProcess + "9");
        });
        btn0.setOnClickListener(v -> {
            helperProcess = inputTextView.getText().toString();
            inputTextView.setText(helperProcess + "0");
        });

    }

    @SuppressLint("SetTextI18n")
    private void buttonOption() {
        btnShare.setOnClickListener(v -> {
            helperProcess = caseTextView.getText().toString();
            caseTextView.setText(helperProcess + "/");
            if (btnShare.isClickable()) {
                arrayListInit();
                inputTextView.setText(" ");
                operator = "/";
            }
        });

        btnMin.setOnClickListener(v -> {
            helperProcess = caseTextView.getText().toString();
            caseTextView.setText(helperProcess + "-");
            if (btnShare.isClickable()) {
                arrayListInit();
                inputTextView.setText(" ");
                operator = "-";
            }
        });

        btnMultiply.setOnClickListener(v -> {
            helperProcess = caseTextView.getText().toString();
            caseTextView.setText(helperProcess + "*");
            if (btnShare.isClickable()) {
                arrayListInit();
                inputTextView.setText(" ");
                operator = "*";
            }

        });
        btnSum.setOnClickListener(v -> {
            helperProcess = caseTextView.getText().toString();
            caseTextView.setText(helperProcess + "+");
            if (btnShare.isClickable()) {
                arrayListInit();
                inputTextView.setText(" ");
                operator = "+";
            }
        });

    }

    private void arrayListInit() {
        arrayList = new ArrayList();
        arrayHelper = inputTextView.getText().toString();
        arrayList.add(arrayHelper);
    }

    private void equalsMethod() {
        btnEquals.setOnClickListener(v -> {
            firstNum = Integer.parseInt(arrayList.get(0).toString());
            stringAboutSecondNum = inputTextView.getText().toString();
            secondNum = Integer.parseInt(stringAboutSecondNum.trim());
            switch (operator) {
                case "+":
                    result = firstNum + secondNum;
                    equalsHelper = Integer.toString((int) result);
                    outputTextView.setText(equalsHelper);
                    break;
                case "-":
                    result = firstNum - secondNum;
                    equalsHelper = Integer.toString((int) result);
                    outputTextView.setText(equalsHelper);
                    break;
                case "*":
                    result = firstNum * secondNum;
                    equalsHelper = Integer.toString((int) result);
                    outputTextView.setText(equalsHelper);
                    break;
                case "/":
                    if (secondNum != 0) {
                        result = (float) firstNum / (float) secondNum;
                        equalsHelper = Float.toString(result);
                        outputTextView.setText(equalsHelper);
                    } else
                        outputTextView.setText("ERROR");
                    break;
            }
        });

    }




}