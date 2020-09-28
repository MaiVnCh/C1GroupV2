package com.example.c1groupv2.model;

public class ItemPageEssayTips {
    private String number, theme, introduction, tips, conclusion;
    private String id;

    public ItemPageEssayTips() {
    }

    public ItemPageEssayTips(String number, String theme, String introduction, String tips, String conclusion) {
        this.number = number;
        this.theme = theme;
        this.introduction = introduction;
        this.tips = tips;
        this.conclusion = conclusion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }
}
