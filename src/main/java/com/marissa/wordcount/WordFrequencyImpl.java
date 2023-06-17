package com.marissa.wordcount;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordFrequencyImpl that = (WordFrequencyImpl) o;
        return frequency == that.frequency && Objects.equals(word, that.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, frequency);
    }
}
