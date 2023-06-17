package com.marissa.wordcount;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class WordFrequencyAnalyzerImplTest {

    private final String inputText = "word,b,wordx,word;a";

    private WordFrequencyAnalyzer wordFrequencyAnalyzer = new WordFrequencyAnalyzerImpl();

    @Test
    public void test00_highestFrequency() {
        //Given

        //When
        int highestFrequency = wordFrequencyAnalyzer.calculateHighestFrequency(inputText);


        //Then
        assertThat(highestFrequency, is(2));
    }

    @Test
    public void test01_wordFrequency() {
        //Given

        //When
        int frequency = wordFrequencyAnalyzer.calculateFrequencyForWord(inputText, "x");


        //Then
        assertThat(frequency, is(1));
    }

    @Test
    public void test02_frequencyList() {
        //Given

        //When
        List<WordFrequency> frequency = wordFrequencyAnalyzer.calculateMostFrequentNWords(inputText, 2);


        //Then
        assertThat(frequency.size(), is(2));
        assertThat(frequency.get(0).getWord(), is("word"));
        assertThat(frequency.get(1).getWord(), is("a"));
    }

    @Test
    public void test03_frequencyList() {
        //Given
        String alfabetisch = "aa;a";

        //When
        List<WordFrequency> frequency = wordFrequencyAnalyzer.calculateMostFrequentNWords(alfabetisch, 2);


        //Then
        assertThat(frequency.size(), is(2));
        assertThat(frequency.get(0).getWord(), is("a"));
        assertThat(frequency.get(1).getWord(), is("aa"));
    }

    @Test
    public void test04_caseInsensitive() {
        //Given
        String text = "word;WORD;word";

        //When
        int frequency = wordFrequencyAnalyzer.calculateFrequencyForWord(text, "word");

        //Then
        assertThat(frequency, is(3));

        //When
        int f2 = wordFrequencyAnalyzer.calculateFrequencyForWord(text, "WORD");

        //Then
        assertThat(f2, is(3));
    }

    @Test
    public void test05_givenTest() {
        //Given
        String text = "The sun shines over the lake";

        //When
        List<WordFrequency> result = wordFrequencyAnalyzer.calculateMostFrequentNWords(text, 3);

        //Then
        assertThat(result.size(), is(3));
        assertThat(result.get(0), is(new WordFrequencyImpl("the", 2)));
        assertThat(result.get(1), is(new WordFrequencyImpl("lake", 1)));
        assertThat(result.get(2), is(new WordFrequencyImpl("over", 1)));
    }
}
