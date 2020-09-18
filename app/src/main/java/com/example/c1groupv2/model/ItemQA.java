package com.example.c1groupv2.model;

public class ItemQA {

    private String id, question, answer, lessonId;

    public ItemQA() {
    }

    public ItemQA(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public ItemQA(String question, String answer, String lessonId) {
        this.question = question;
        this.answer = answer;
        this.lessonId = lessonId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getLessonId() {
        return lessonId;
    }

    public void setLessonId(String lessonId) {
        this.lessonId = lessonId;
    }
}
