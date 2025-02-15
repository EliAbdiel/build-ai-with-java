package com.springai.model;

public class Question {

    private String question;
    private String foodName;

    public Question(String question, String foodName) {
        this.question = question;
        this.foodName = foodName;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
}
