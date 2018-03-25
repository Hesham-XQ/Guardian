package com.example.android.quizz;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by SAMO on 1/14/2018.
 */

public class QuestionAdapter extends ArrayAdapter {

/*
    public QuestionAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }
*/
    public QuestionAdapter(Context context, ArrayList<question> pquestion ) {
        super(context,0,pquestion);
       // mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        question my_word= (question) getItem(position);
        TextView questionText = (TextView) listItemView.findViewById(R.id.question_id);
        questionText.setText(my_word.getq());

        RadioButton answer1 = (RadioButton) listItemView.findViewById(R.id.answer_1);
        answer1.setText(my_word.getanswer1());

        RadioButton answer2 = (RadioButton) listItemView.findViewById(R.id.answer_2);
        answer1.setText(my_word.getanswer2());

        RadioButton answer3 = (RadioButton) listItemView.findViewById(R.id.answer_3);
        answer1.setText(my_word.getanswer3());


        return listItemView;
    }

}
