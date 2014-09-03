package com.markdelillo;

import java.util.ArrayList;
import java.util.List;

public class Album {
    private final List<Track> tracks;
    private int nextTrackNumber;

    public Album() {
        tracks = new ArrayList<Track>();
        nextTrackNumber = 1;
    }

    public Album(List<Track> tracks) {
        this.tracks = tracks;
        nextTrackNumber = 1;
        for (Track track : this.tracks) {
            track.setTrackNumber(nextTrackNumber++);
        }
    }

    public void addTrack(Track track) {
        tracks.add(track);
        track.setTrackNumber(nextTrackNumber++);
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public List<String> getTopTrackTitles(int numTrackTitles) {
        List<String> trackTitles = new ArrayList<String>();
        for (Track track : tracks.subList(0, numTrackTitles)) {
            trackTitles.add(track.getTitle());
        }
        return trackTitles;
    }

    public Track getTrack(int track) {
        return tracks.get(track - 1);
    }

    public int trackCount() {
        return tracks.size();
    }
}