package com.wordz.domain;

import org.junit.jupiter.api.Test;

import static com.wordz.domain.Letter.*;
import static org.assertj.core.api.Assertions.assertThat;

public class WordTest {
    @Test
    public void oneIncorrectLetter() {
        Word word = new Word("A");
        Score score =  word.guess("Z");
        Letter result = score.letter(0);
        assertThat(result).isEqualTo(Letter.INCORRECT);
    }


}
