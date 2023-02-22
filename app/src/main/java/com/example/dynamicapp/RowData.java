package com.example.dynamicapp;

import java.io.Serializable;

public class RowData implements Serializable {

    public String question;
    public String option;

    public RowData () {

    }

    public RowData(String question, String option) {
        this.question = question;
        this.option = option;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }
}
