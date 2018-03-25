package com.example.android.quizz;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by SAMO on 1/14/2018.
 */

public class quiz extends AppCompatActivity{

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            // Get the view from new_activity.xml
            setContentView(R.layout.question_list);


            // Create a list of words
            final ArrayList<question> q = new ArrayList<question>();
            q.add(new question("one", "lutti", "lutti" ,"lutti"));
            q.add(new question("two", "otiiko", "two", "otiiko"));
            q.add(new question("three", "tolookosu","two", "otiiko"));
            q.add(new question("four", "oyyisa","two", "otiiko"));
            q.add(new question("five", "massokka","two", "otiiko"));
            q.add(new question("six", "temmokka","two", "otiiko"));
            q.add(new question("seven", "kenekaku", "two", "otiiko"));
            q.add(new question("eight", "kawinta","two", "otiiko"));
            q.add(new question("nine", "wo’e","two", "otiiko"));
            q.add(new question("ten", "na’aacha","two", "otiiko"));


            QuestionAdapter adapt = new QuestionAdapter(this ,q);
            ListView listView = (ListView) findViewById(R.id.list);
            listView.setAdapter(adapt);
        }
/*
    QuestionAdapter adapter = new QuestionAdapter(this, q, R.color.category_numbers);
    ListView listView = (ListView) findViewById(R.id.list);
     listView.setAdapter(adapter);
*/






}

