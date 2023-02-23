package com.example.dynamicapp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RowData implements Serializable {

    public String question;
    public String option;
    public ArrayList<Option> optionList;

    public RowData () {

    }

    public RowData(String question, String option, ArrayList<Option> optionList) {
        this.question = question;
        this.option = option;
        this.optionList = optionList;
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

    public ArrayList<Option> getOptionList() {
        return optionList;
    }

    public void setOptionList(ArrayList<Option> optionList) {
        this.optionList = optionList;
    }
}

