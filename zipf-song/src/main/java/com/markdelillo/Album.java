package com.markdelillo;

import java.util.ArrayList;
import java.util.List;

public class Album {
    private final List<String> songs;

    public Album() {
        songs = new ArrayList<String>();
    }

    public Album(List<String> songs) {
        this.songs = songs;
    }

    public void addSong(String song) {
        songs.add(song);
    }

    public List<String> getSongs() {
        return songs;
    }

    public List<String> getTopSongs(int numSongs) {
        return songs.subList(0, numSongs);
    }
}