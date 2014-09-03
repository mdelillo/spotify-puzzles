package com.markdelillo;

import java.util.ArrayList;
import java.util.List;

public class Album {
    private final List<Track> tracks;

    public Album() {
        tracks = new ArrayList<Track>();
    }

    public Album(List<Track> tracks) {
        this.tracks = tracks;
    }

    public void addTrack(Track track) {
        tracks.add(track);
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public List<Track> getTopTracks(int numTracks) {
        return tracks.subList(0, numTracks);
    }

    public List<String> getTopTrackTitles(int numTrackTitles) {
        List<String> trackTitles = new ArrayList<String>();
        for (Track track : getTopTracks(numTrackTitles)) {
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