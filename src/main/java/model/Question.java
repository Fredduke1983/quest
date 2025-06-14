package model;

import java.util.Map;

public class Question {
    private final String text;
    private final Map<String, Integer> options;

    public Question(String text, Map<String, Integer> options) {
        this.text = text;
        this.options = options;
    }

    public String getText() {
        return text;
    }

    public Map<String, Integer> getOptions() {
        return options;
    }
}
