package com.example.model;

public class Email {
    private String language;
    private int page;
    private boolean spam;
    private String signature;

    public Email() {
    }

    public Email(String language, int page, boolean spam, String signature) {
        this.language = language;
        this.page = page;
        this.spam = spam;
        this.signature = signature;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public boolean getSpam() {
        return spam;
    }

    public void setSpam(boolean spam) {
        this.spam = spam;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
