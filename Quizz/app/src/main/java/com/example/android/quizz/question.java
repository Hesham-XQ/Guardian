package com.example.android.quizz;

/**
 * Created by SAMO on 1/14/2018.
 */

public class question {

    private String mq ;
    private String manswer1 ;
    private String manswer2 ;
    private String manswer3 ;

    public question(String q, String answer1, String answer2 , String answer3) {
        mq = q;
        manswer1 = answer1;
        manswer2 = answer2;
        manswer3 = answer3;
    }

    public String getq() {
        return mq;
    }
    public String getanswer1() {return manswer1;}
    public String getanswer2() {
        return manswer2;
    }
    public String getanswer3() {
        return manswer3;
    }


}
