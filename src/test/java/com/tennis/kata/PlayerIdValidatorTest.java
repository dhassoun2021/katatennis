package com.tennis.kata;

import com.tennis.kata.exceptions.InvalidPlayerIdException;
import com.tennis.kata.exceptions.SamePlayerIdsException;
import com.tennis.kata.validator.PlayerIdValidator;
import org.assertj.core.api.Assertions;
import org.junit.Test;


public class PlayerIdValidatorTest {

    @Test
    public void validatePlayerIdNominal() {
        Assertions.assertThatCode(()-> {
            PlayerIdValidator.validatePlayerId("A");
        }).doesNotThrowAnyException();
    }

    @Test(expected = InvalidPlayerIdException.class)
    public void validatePlayerIdShouldThrowErrorWhenUnauthorizedValue() {
        PlayerIdValidator.validatePlayerId("C");

    }

    @Test
    public void validateSamePlayersNominal() {
        Assertions.assertThatCode(()-> {
            PlayerIdValidator.validateNotSameId("A","B");
        }).doesNotThrowAnyException();
    }

    @Test(expected = SamePlayerIdsException.class)
    public void validatePlayersShouldThrowErrorWhenSameValues() {
        PlayerIdValidator.validateNotSameId("A","A");
    }
}
