package com.tennis.kata.display;

import com.tennis.kata.Players;

public interface  GameFormater {

    /**
     * Convert a players object to a String format. This format could be (simple text, json, XML, etc ...)
     * @param players Players to convert
     * @return String format
     */
    String format(Players players);
}
