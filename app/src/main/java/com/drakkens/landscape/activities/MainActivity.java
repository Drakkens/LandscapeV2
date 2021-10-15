package com.drakkens.landscape.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;


import com.drakkens.landscape.R;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends Activity {

    private int currentQuestionNum = 0;
    private final ArrayList<String> questionList = new ArrayList<>(Arrays.asList("Marrakesh is the capital of Morocco",
            "Waterloo has the greatest number of tube platforms in London",
            "M&M stands for Mars and Moordale",
            "There are 219 episodes of Friends",
            "H&M stands for Hennes & Mauritz",
            "Madonna's real name is Madonna",
            "Alexander Fleming discovered penicillin",
            "Your 'radius' bone is in your leg",
            "An octopus has three hearts",
            "Bananas are curved because they grow upwards towards the sun"));

    private final ArrayList<Boolean> questionAnswerList = new ArrayList<>(Arrays.asList(false, true, false, false, true, true, true, false, true, true));

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView answerTextView = findViewById(R.id.answer);
        TextView questionTextView = findViewById(R.id.questionView);
        questionTextView.setText(questionList.get(0));

        Button nextButton = findViewById(R.id.nextButton);
        Button previousButton = findViewById(R.id.previousButton);
        Button falseButton = findViewById(R.id.falseButton);
        Button trueButton = findViewById(R.id.trueButton);

        nextButton.setOnClickListener(v -> {
            if (currentQuestionNum != questionList.size()-1) {
                currentQuestionNum++;
                answerTextView.setText("");

            }


            populateQuestion(currentQuestionNum);

        });
        
        previousButton.setOnClickListener(v -> {
            if (currentQuestionNum != 0) {
                currentQuestionNum--;
                answerTextView.setText("");

            }

            populateQuestion(currentQuestionNum);

        });
        
        falseButton.setOnClickListener(v -> checkAnswer(false, questionAnswerList.get(currentQuestionNum)));
        trueButton.setOnClickListener(v -> checkAnswer(true, questionAnswerList.get(currentQuestionNum)));

    }

    private void checkAnswer(boolean userAnswer, boolean questionAnswer) {
        TextView answerTextView = findViewById(R.id.answer);

        if (userAnswer == questionAnswer) {
            answerTextView.setText("Correct!");

        }

        else {
            answerTextView.setText("Incorrect!");

        }
    }

    private void populateQuestion(int currentNum) {
        TextView questionTextView = findViewById(R.id.questionView);
        questionTextView.setText(questionList.get(currentNum));

    }


}