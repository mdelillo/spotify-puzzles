package com.markdelillo;

import java.util.Arrays;

public class Album {
    private final String[] songs;

    public Album(String[] songs) {
        this.songs = songs;
    }

    public String[] getTopSongs(int numSongs) {
        return Arrays.copyOfRange(songs, 0, numSongs);
    }
}