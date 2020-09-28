package com.example.c1groupv2.model;

public class ItemNewEssay {

    private String id,  teilType, name, theme, mindmap, introduction, body, conclusion, lessonId;
    public ItemNewEssay() {
    }



    public String getId() {
        return id;
    }

    public ItemNewEssay(String teilType, String name, String theme, String mindmap, String introduction, String body, String conclusion, String lessonId) {
        this.teilType = teilType;
        this.name = name;
        this.theme = theme;
        this.mindmap = mindmap;
        this.introduction = introduction;
        this.body = body;
        this.conclusion = conclusion;
        this.lessonId = lessonId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeilType() {
        return teilType;
    }

    public void setTeilType(String teilType) {
        this.teilType = teilType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getMindmap() {
        return mindmap;
    }

    public void setMindmap(String mindmap) {
        this.mindmap = mindmap;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public String getLessonId() {
        return lessonId;
    }

    public void setLessonId(String lessonId) {
        this.lessonId = lessonId;
    }
}
