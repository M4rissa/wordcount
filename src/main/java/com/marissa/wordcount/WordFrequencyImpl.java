package com.marissa.wordcount;

public class WordFrequencyImpl implements WordFrequency {

    private final String word;
    private int frequency;

    public WordFrequencyImpl(String word) {
        this(word, 0);
    }

    public WordFrequencyImpl(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
    }

    public void count() {
        this.frequency+=1;
    }

    @Override
    public String getWord() {
        return word;
    }

    @Override
    public int getFrequency() {
        return frequency;
    }
}
