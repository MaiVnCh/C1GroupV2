package com.example.c1groupv2.model;

public class ItemTeilADetails {

    private String  teilType, number, theme,instruction, example, content, answer, lessonId;
    private int id;
    public ItemTeilADetails() {
    }

    public ItemTeilADetails(int id, String teilType, String number, String theme, String instruction, String example, String content, String answer, String lessonId) {
        this.id = id;
        this.teilType = teilType;
        this.number = number;
        this.theme = theme;
        this.instruction = instruction;
        this.example = example;
        this.content = content;
        this.answer = answer;
        this.lessonId = lessonId;
    }

    public ItemTeilADetails(String teilType, String number, String theme, String instruction, String example, String content, String answer, String lessonId) {
        this.teilType = teilType;
        this.number = number;
        this.theme = theme;
        this.instruction = instruction;
        this.example = example;
        this.content = content;
        this.answer = answer;
        this.lessonId = lessonId;
    }

    public ItemTeilADetails(String teilType, String number, String theme, String instruction, String example, String content, String answer) {
        this.teilType = teilType;
        this.number = number;
        this.theme = theme;
        this.instruction = instruction;
        this.example = example;
        this.content = content;
        this.answer = answer;
    }

    public ItemTeilADetails(String number, String theme, String instruction, String example, String content, String answer) {
        this.number = number;
        this.theme = theme;
        this.instruction = instruction;
        this.example = example;
        this.content = content;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeilType() {
        return teilType;
    }

    public void setTeilType(String teilType) {
        this.teilType = teilType;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
