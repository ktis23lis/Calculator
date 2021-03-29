package com.example.calculator;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;



import java.io.Serializable;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity  implements Serializable {
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9,
            btn0, btnShare, btnMultiply, btnMin, btnSum, btnEquals, buttonClear;
    private SwitchCompat aSwitch;
    private TextView inputTextView, outputTextView, caseTextView;
    private String helperProcess;
    private final ArrayList<String> arrayList = new ArrayList<>();
    private String arrayHelper;
    private String equalsHelper;
    private String operator;
    private String stringAboutSecondNum;
    private String outputTextViewHelper;
    private float result;
    private int firstNum;
    private int secondNum;
    final static String inputTextViewKey = "INPUT_KEY";
    final static String outputTextViewKey = "OUTPUT_KEY";
    final static String caseTextViewKey = "CASE_KEY";
    final static String arrayKey = "Array_KEY";
    SharedPreferences sharedPreferences = null;
    final static String booleanKey = "night_mode";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findView();
        buttonNum();
        buttonOption();
        equalsMethod();
        changeTheme();


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
        aSwitch = findViewById(R.id.aSwitch);



    }


    @SuppressLint("SetTextI18n")
    private void buttonNum() {
        buttonClear.setOnClickListener(v -> {
            inputTextView.setText("");
            outputTextView.setText("");
            caseTextView.setText("");
            arrayList.remove(0);

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
        arrayHelper = inputTextView.getText().toString();
        arrayList.add(arrayHelper);
    }

    @SuppressLint("SetTextI18n")
    private void equalsMethod() {
        btnEquals.setOnClickListener(v -> {
            if (arrayList.size() > 0) {
                firstNum = Integer.parseInt(arrayList.get(0));
            } else firstNum = Integer.parseInt("0");
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
                        outputTextView.setText(R.string.error_main);
                    break;
            }
        });
//
//        sharedPreferences = getSharedPreferences("night", 0);
//        Boolean booleanValue = sharedPreferences.getBoolean(booleanKey, true);
//        if (booleanValue){
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//            aSwitch.setChecked(true);
//        }
//        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked){
//                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//                    aSwitch.setChecked(true);
//                    SharedPreferences.Editor editor = sharedPreferences.edit();
//                    editor.putBoolean(booleanKey, true);
//                    editor.commit();
//                }else {
//                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//                    aSwitch.setChecked(false);
//                    SharedPreferences.Editor editor = sharedPreferences.edit();
//                    editor.putBoolean(booleanKey, false);
//                    editor.commit();
//                }
//            }
//        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(caseTextViewKey, operator);
        outState.putString(caseTextViewKey, caseTextView.getText().toString());
        outState.putString(inputTextViewKey, stringAboutSecondNum);
        outState.putString(inputTextViewKey, inputTextView.getText().toString());
        outState.putString(outputTextViewKey, outputTextViewHelper);
        outState.putString(outputTextViewKey, outputTextView.getText().toString());

        outState.putString(arrayKey, arrayHelper);
        if (arrayList.size() > 0) {
            outState.putString(arrayKey, arrayList.get(0));
        }

    }

    @Override
    public void onRestoreInstanceState(Bundle saveInstanceState) {
        super.onRestoreInstanceState(saveInstanceState);
        operator = saveInstanceState.getString(caseTextViewKey);
        caseTextView.setText(operator);
        stringAboutSecondNum = saveInstanceState.getString(inputTextViewKey);
        inputTextView.setText(stringAboutSecondNum);
        outputTextViewHelper = saveInstanceState.getString(outputTextViewKey);
        outputTextView.setText(outputTextViewHelper);
        arrayHelper = saveInstanceState.getString(arrayKey);
        arrayList.add(arrayHelper);
    }


    private void changeTheme(){
        sharedPreferences = getSharedPreferences("night", 0);
        Boolean booleanValue = sharedPreferences.getBoolean(booleanKey, true);
        if (booleanValue){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            aSwitch.setChecked(true);
        }
        aSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                aSwitch.setChecked(true);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean(booleanKey, true);
                editor.commit();
            }else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                aSwitch.setChecked(false);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean(booleanKey, false);
                editor.commit();
            }
        });

    }
}





