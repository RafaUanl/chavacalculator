package com.example.arkstdio.chavacalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button one = (Button) findViewById(R.id.one);
        one.setOnClickListener(this);
        Button two = (Button) findViewById(R.id.two);
        two.setOnClickListener(this);
        Button three = (Button) findViewById(R.id.three);
        three.setOnClickListener(this);
        Button four = (Button) findViewById(R.id.four);
        four.setOnClickListener(this);
        Button five = (Button) findViewById(R.id.five);
        five.setOnClickListener(this);
        Button six = (Button) findViewById(R.id.six);
        six.setOnClickListener(this);
        Button seven = (Button) findViewById(R.id.seven);
        seven.setOnClickListener(this);
        Button eight = (Button) findViewById(R.id.eight);
        eight.setOnClickListener(this);
        Button nine = (Button) findViewById(R.id.nine);
        nine.setOnClickListener(this);
        Button cero = (Button) findViewById(R.id.zero);
        cero.setOnClickListener(this);
        Button point = (Button) findViewById(R.id.point);
        point.setOnClickListener(this);

    }


        @Override
        public  void onClick(View v){
        String response = "";
        
                switch (v.getId()){
                    case R.id.one:
                        response = "1";
                        break;
                    case R.id.two:
                        response = "2";
                        break;
                    case R.id.three:
                        response = "3";
                        break;
                    case R.id.four:
                        response = "4";
                        break;
                    case R.id.five:
                        response = "5";
                        break;
                    case R.id.six:
                        response = "6";
                        break;
                    case R.id.seven:
                        response = "7";
                        break;
                    case R.id.eight:
                        response = "8";
                        break;
                    case R.id.nine:
                        response = "9";
                        break;
                    case R.id.zero:
                        response = "0";
                        break;
                    case  R.id.point:
                        response = ".";
                        break;


            }

                assignationValue(response);
        }


//   Global Variables
    double result = 0;
    String firstNumber = "", secondNumber = "", operator = null, showData = "0";

//    Display the result of the operation
    private void displayResult(String message){
        TextView displayTextView = findViewById(R.id.display);
        displayTextView.setText(message);

    }

//    Display all the data of the operation
    private void showHistory(String chain){
        TextView  historyTextView = findViewById(R.id.history);
        historyTextView.setText(chain);
    }

// Clean the data and the variables
    public void cleaner(View v){
        firstNumber = "";
        secondNumber = "";
        showData = "";
        operator = null;
        displayResult(showData);
        showHistory(showData);
        System.out.println("first " + firstNumber);
        System.out.println("second " + secondNumber);
        System.out.println("operator " + operator);
        System.out.println("data " + showData);
        System.out.println("Result " +result);

    }

    public void calculator(View v){
        String histories = firstNumber + " " + operator + " " + secondNumber;
        result = calculateResult(firstNumber, secondNumber, operator);
        String solution = String.valueOf(result);
        displayResult(solution);
        showHistory(histories);
        firstNumber = String.valueOf(result);
        secondNumber = "";
    }


    public void operation(View view){

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
            case R.id.module:
                operator = "%";
                break;

        }

    }

    private void assignationValue(String numberValue){
        if(operator != null){
            secondNumber += numberValue;
            displayResult(secondNumber);
        }else{
            firstNumber += numberValue;
            displayResult(firstNumber);
        }
        System.out.println(numberValue);

    }

    private  double calculateResult(String firstN, String secondN, String operation){
        double solution, first,second;
        first = Double.valueOf(firstN);
        second = Double.valueOf(secondN);


        if(operation.equals("+")){
            solution = first + second;
        }else if(operation.equals("-")){
            solution = first - second;
        }else if(operation.equals("*")){
            solution = first * second;
        }else if(operation.equals("%")){
            solution = first % second;
        } else{
            solution = first / second;
        }

        return solution;
    }

}
