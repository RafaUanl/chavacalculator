package com.example.arkstdio.chavacalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    double result = 0;
    double firstNumber = 0;
    double secondNumber = 0;
    String showData = "0";
    String operator = null;


    private void displayResult(String message){
        TextView displayTextView = findViewById(R.id.display);
        displayTextView.setText(message);

    }

    private void showHistory(String chain){
        TextView  historyTextView = findViewById(R.id.history);
        historyTextView.setText(chain);
    }


    public void cleaner(View view){
        result = 0;
        firstNumber =0;
        secondNumber = 0;
        showData = "0";
        displayResult(showData);
        showHistory(showData);

    }

    public void calculator(View v){
        String histories = firstNumber + " " + operator + " " + secondNumber;
        result = calculateResult(firstNumber, secondNumber, operator);
        String solution = String.valueOf(result);
        displayResult(solution);
        showHistory(histories);
        firstNumber = result;
    }


    public String operation(View view){

        switch (view.getId()){
            case R.id.plus:
                operator = "+";
                break;

            case R.id.minus:
                 operator = "-";
                 break;

            case R.id.divide:
                operator = "/";
                break;

            case R.id.multiple:
                operator = "*";
                break;

        }
        return operator;
    }

    public void valueNumbers(View view){
        int response;

        switch (view.getId()){
            case R.id.one:
                response = 1;
                break;
            case R.id.two:
                response = 2;
                break;
            case R.id.three:
                response = 3;
                break;
            case R.id.four:
                response = 4;
                break;
            case R.id.five:
                response = 5;
                break;
            case R.id.six:
                response = 6;
                break;
            case R.id.seven:
                response = 7;
                break;
            case R.id.eight:
                response = 8;
                break;
            case R.id.nine:
                response = 9;
                break;
            default:
                response = 0;
                break;

        }

        assignationValue(response);
    }

    private void assignationValue(double numberValue){
        if(firstNumber > 0){
            secondNumber = numberValue;
        }else {
            firstNumber = numberValue;
        }
    }

    private  double calculateResult(double first, double second, String operation){
        double solution;

        if(operation.equals("+")){
            solution = first + second;
        }else if(operation.equals("-")){
            solution = first - second;
        }else if(operation.equals("*")){
            solution = first * second;
        }else{
            solution = first / second;
        }

        return solution;
    }

}
