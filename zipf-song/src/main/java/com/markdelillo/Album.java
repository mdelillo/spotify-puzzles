package com.markdelillo;

import java.util.ArrayList;
import java.util.List;

public class Album {
    private final List<Song> songs;

    public Album() {
        songs = new ArrayList<Song>();
    }

    public Album(List<Song> songs) {
        this.songs = songs;
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public List<Song> getSongs() {
        return songs;
    }

    public List<Song> getTopSongs(int numSongs) {
        return songs.subList(0, numSongs);
    }

    public List<String> getTopSongTitles(int numSongTitles) {
        List<String> songTitles = new ArrayList<String>();
        for (Song song : getTopSongs(numSongTitles)) {
            songTitles.add(song.getTitle());
        }
        return songTitles;
    }

    public Song getTrack(int track) {
        return songs.get(track - 1);
    }
}