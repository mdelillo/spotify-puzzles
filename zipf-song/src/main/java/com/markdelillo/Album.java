package com.markdelillo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Album {
    private final List<Track> tracks;
    private int nextTrackNumber = 1;

    public Album() {
        tracks = new ArrayList<Track>();
    }

    public Album(List<Track> tracks) {
        this.tracks = tracks;
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

    public Track getTrack(int track) {
        return tracks.get(track - 1);
    }

    public int trackCount() {
        return tracks.size();
    }

    public List<String> getTopTrackTitles(int numTrackTitles) {
        List<Track> sortedTracks = new ArrayList<Track>(tracks);
        Collections.sort(sortedTracks, Collections.reverseOrder());

        List<String> trackTitles = new ArrayList<String>();
        for (Track track : sortedTracks.subList(0, numTrackTitles)) {
            trackTitles.add(track.getTitle());
        }
        return trackTitles;
    }
}