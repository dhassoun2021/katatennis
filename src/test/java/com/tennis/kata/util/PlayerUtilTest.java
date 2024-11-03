package com.tennis.kata.util;

import org.junit.Assert;
import org.junit.Test;

public class PlayerUtilTest {

    @Test
    public void shouldReturnBWhenCurrentPlayerIsA () {
       String result = PlayerUtil.opposite("A");
        Assert.assertEquals("B", result);
    }

    @Test
    public void shouldReturnAWhenCurrentPlayerIsB () {
        String result = PlayerUtil.opposite("B");
        Assert.assertEquals("A", result);
    }
}
