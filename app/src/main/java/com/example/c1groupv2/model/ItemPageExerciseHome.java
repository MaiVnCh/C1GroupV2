package com.example.c1groupv2.model;

public class ItemPageExerciseHome {
    private String date, number, instruction, content, key;



    public ItemPageExerciseHome(String date, String number, String instruction, String content, String key) {
        this.date = date;
        this.number = number;
        this.instruction = instruction;
        this.content = content;
        this.key = key;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
