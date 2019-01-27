package com.amadeus.birds;

public class Currency {
    private String code;
    private String title;

    public String getCode() {
        return code;
    }

    public Currency setCode(String code) {
        this.code = code;

        return this;
    }

    public String getTitle() {
        return title;
    }

    public Currency setTitle(String title) {
        this.title = title;

        return this;
    }

    @Override
    public String toString() {
        return this.getCode();
    }
}
