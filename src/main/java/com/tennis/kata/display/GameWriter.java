package com.tennis.kata.display;

import com.tennis.kata.Players;

public interface GameWriter {

    /**
     * Display players information to a specific output (standard output, file, etc ...)
     * @param players Players to display
     */
    void write (Players players);
}
