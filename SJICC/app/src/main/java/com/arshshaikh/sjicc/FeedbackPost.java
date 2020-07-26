package com.arshshaikh.sjicc;

public class FeedbackPost {

    private int answer1,answer2,answer3;

    public FeedbackPost(int answer1, int answer2, int answer3) {
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
    }

    public int getAnswer1() {
        return answer1;
    }

    public int getAnswer2() {
        return answer2;
    }

    public int getAnswer3() {
        return answer3;
    }
}
