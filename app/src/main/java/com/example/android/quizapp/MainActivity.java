package com.example.android.quizapp;

import com.example.android.quizapp.R;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /**
     * Global strings for the results summary listing
     */
    EditText userInput;
    RadioButton radioOne;
    RadioButton radioThree;
    RadioButton radioFour;
    RadioButton radioFive;
    RadioButton radioSix;
    RadioButton radioNine;
    RadioButton radioTen;
    CheckBox firstCheckBoxQuestionTwo;
    CheckBox secondCheckBoxQuestionTwo;
    CheckBox thirdCheckBoxQuestionTwo;
    CheckBox fourthCheckBoxQuestionTwo;
    CheckBox firstCheckBoxQuestionSeven;
    CheckBox secondCheckBoxQuestionSeven;
    CheckBox thirdCheckBoxQuestionSeven;
    CheckBox fourthCheckBoxQuestionSeven;
    String questionOneResultsSummary;
    String questionTwoResultsSummary;
    String questionThreeResultsSummary;
    String questionFourResultsSummary;
    String questionFiveResultsSummary;
    String questionSixResultsSummary;
    String questionSevenResultsSummary;
    String questionEightResultsSummary;
    String questionNineResultsSummary;
    String questionTenResultsSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioOne = (RadioButton) findViewById(R.id.question_One_Second_Ans);
        firstCheckBoxQuestionTwo = (CheckBox) findViewById(R.id.question_Two_First_Ans);
        secondCheckBoxQuestionTwo = (CheckBox) findViewById(R.id.question_Two_Second_Ans);
        thirdCheckBoxQuestionTwo = (CheckBox) findViewById(R.id.question_Two_Third_Ans);
        fourthCheckBoxQuestionTwo = (CheckBox) findViewById(R.id.question_Two_Fourth_Ans);
        radioThree = (RadioButton) findViewById(R.id.question_Three_Fourth_Ans);
        radioFour = (RadioButton) findViewById(R.id.question_Four_First_Ans);
        radioFive = (RadioButton) findViewById(R.id.question_Five_Second_Ans);
        radioSix = (RadioButton) findViewById(R.id.question_Six_First_Ans);
        firstCheckBoxQuestionSeven = (CheckBox) findViewById(R.id.question_Seven_First_Ans);
        secondCheckBoxQuestionSeven = (CheckBox) findViewById(R.id.question_Seven_Second_Ans);
        thirdCheckBoxQuestionSeven = (CheckBox) findViewById(R.id.question_Seven_Third_Ans);
        fourthCheckBoxQuestionSeven = (CheckBox) findViewById(R.id.question_Seven_Fourth_Ans);
        userInput = (EditText) findViewById(R.id.question_Eight);
        radioNine = (RadioButton) findViewById(R.id.question_Nine_First_Ans);
        radioTen = (RadioButton) findViewById(R.id.question_Ten_Second_Ans);

    }

    /**
     * Displays the score as a toast
     */

    public void displayScore(View view) {
        int score = calculateScore();
        String scoreMessage = getString(R.string.final_Score, score);
        scoreMessage += "\n" + questionOneResultsSummary;
        scoreMessage += "\n" + questionTwoResultsSummary;
        scoreMessage += "\n" + questionThreeResultsSummary;
        scoreMessage += "\n" + questionFourResultsSummary;
        scoreMessage += "\n" + questionFiveResultsSummary;
        scoreMessage += "\n" + questionSixResultsSummary;
        scoreMessage += "\n" + questionSevenResultsSummary;
        scoreMessage += "\n" + questionEightResultsSummary;
        scoreMessage += "\n" + questionNineResultsSummary;
        scoreMessage += "\n" + questionTenResultsSummary;

        Toast.makeText(this, scoreMessage, Toast.LENGTH_LONG).show();

    }

    /**
     * Calculates total questions answered correctly
     *
     * @return score
     */

    public int calculateScore() {
        int score = 0;

        //Checks if question one is answered correctly

        if (radioOne.isChecked()) {
            score++;
            questionOneResultsSummary = getString(R.string.questionOneIsCorrect);
        } else {
            questionOneResultsSummary = getString(R.string.questionOneIsWrong);
        }

        //Checks if question two is answered correctly

        if (!firstCheckBoxQuestionTwo.isChecked() && secondCheckBoxQuestionTwo.isChecked() && !thirdCheckBoxQuestionTwo.isChecked() && fourthCheckBoxQuestionTwo.isChecked()) {
            score++;
            questionTwoResultsSummary = getString(R.string.questionTwoIsCorrect);
        } else {
            questionTwoResultsSummary = getString(R.string.questionTwoIsWrong);
        }

        //Checks if question three is answered correctly

        if (radioThree.isChecked()) {
            score++;
            questionThreeResultsSummary = getString(R.string.questionThreeIsCorrect);
        } else {
            questionThreeResultsSummary = getString(R.string.questionThreeIsWrong);
        }

        //Checks if question four is answered correctly

        if (radioFour.isChecked()) {
            score++;
            questionFourResultsSummary = getString(R.string.questionFourIsCorrect);
        } else {
            questionFourResultsSummary = getString(R.string.questionFourIsWrong);
        }

        //Checks if question five is answered correctly

        if (radioFive.isChecked()) {
            score++;
            questionFiveResultsSummary = getString(R.string.questionFiveIsCorrect);
        } else {
            questionFiveResultsSummary = getString(R.string.questionFiveIsWrong);
        }

        //Checks if question six is answered correctly

        if (radioSix.isChecked()) {
            score++;
            questionSixResultsSummary = getString(R.string.questionSixIsCorrect);
        } else {
            questionSixResultsSummary = getString(R.string.questionSixIsWrong);
        }

        //Checks if question seven is answered correctly

        if (!firstCheckBoxQuestionSeven.isChecked() && !secondCheckBoxQuestionSeven.isChecked() && thirdCheckBoxQuestionSeven.isChecked() && fourthCheckBoxQuestionSeven.isChecked()) {
            score++;
            questionSevenResultsSummary = getString(R.string.questionSevenIsCorrect);
        } else {
            questionSevenResultsSummary = getString(R.string.questionSevenIsWrong);
        }

        //Checks if question eight is answered correctly

        String questionEight = userInput.getText().toString();
        if (questionEight.equalsIgnoreCase("memphis")) {
            score++;
            questionEightResultsSummary = getString(R.string.questionEightIsCorrect);
        } else {
            questionEightResultsSummary = getString(R.string.questionEightIsWrong);
        }

        //Checks if question nine is answered correctly

        if (radioNine.isChecked()) {
            score++;
            questionNineResultsSummary = getString(R.string.questionNineIsCorrect);
        } else {
            questionNineResultsSummary = getString(R.string.questionNineIsWrong);
        }

        //Checks if question ten is answered correctly

        if (radioTen.isChecked()) {
            score++;
            questionTenResultsSummary = getString(R.string.questionTenIsCorrect);
        } else {
            questionTenResultsSummary = getString(R.string.questionTenIsWrong);
        }

        return score;

    }

}
