package com.example.dynamicapp;

import java.io.Serializable;

public class Option implements Serializable {
    String optionText;
    String optionStatus;

    public Option() {

    }

    public String getOptionText() {
        return optionText;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }

    public String getOptionStatus() {
        return optionStatus;
    }

    public void setOptionStatus(String optionStatus) {
        this.optionStatus = optionStatus;
    }

    public Option(String optionText, String optionStatus) {
        this.optionText = optionText;
        this.optionStatus = optionStatus;
    }
}

