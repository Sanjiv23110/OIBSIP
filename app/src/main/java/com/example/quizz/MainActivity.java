package com.example.quizz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button A,B,C,D;
    Button  submitbtn;


    int score=0;
    int totalQuestion = QuestionAnswer.question.length;
    int currentQuestionIndex=0;
    String selectedAnswer=":";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        totalQuestionsTextView=findViewById(R.id.total_question);
        questionTextView=findViewById(R.id.question);
        A=findViewById(R.id.ans_a);
        B=findViewById(R.id.ans_b);
        C=findViewById(R.id.ans_c);
        D=findViewById(R.id.ans_d);
        submitbtn=findViewById(R.id.submit_btn);



        A.setOnClickListener(this);
        B.setOnClickListener(this);
        C.setOnClickListener(this);
        D.setOnClickListener(this);
        submitbtn.setOnClickListener(this);

        totalQuestionsTextView.setText("Total questions :"+totalQuestion);


        loadNewQuestion();

    }

    @Override
    public void onClick(View view) {

        A.setBackgroundColor(Color.WHITE);
        B.setBackgroundColor(Color.WHITE);
        C.setBackgroundColor(Color.WHITE);
        D.setBackgroundColor(Color.WHITE);


        Button clickedButton=(Button)view;
        if (clickedButton.getId()==R.id.submit_btn){
            if(selectedAnswer.equals(QuestionAnswer.correctAnswers[currentQuestionIndex])){
                score++;
            }
            currentQuestionIndex++;
            loadNewQuestion();


        }else {
            selectedAnswer=clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.MAGENTA);
        }


    }

    void loadNewQuestion(){

        if (currentQuestionIndex ==totalQuestion){
            finishQuiz();
            return;
        }



        questionTextView.setText(QuestionAnswer.question[currentQuestionIndex]);
        A.setText(QuestionAnswer.choices[currentQuestionIndex][0]);
        B.setText(QuestionAnswer.choices[currentQuestionIndex][1]);
        C.setText(QuestionAnswer.choices[currentQuestionIndex][2]);
        D.setText(QuestionAnswer.choices[currentQuestionIndex][3]);

    }
    void finishQuiz(){
        String passStatus ="";
        if(score> totalQuestion*0.60){
            passStatus="Passed";

        }else {
            passStatus="Failed";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Score is "+"out of"+totalQuestion)
                .setPositiveButton("Restart",(dialogInterface, i) -> restartQuiz())
                .setCancelable(false)
                .show();



    }
    void restartQuiz(){
        score=0;
        currentQuestionIndex=0;
        loadNewQuestion();
    }
}