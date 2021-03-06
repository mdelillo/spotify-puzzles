package com.markdelillo;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class AlbumTest {

    public List<Track> tracks;
    public Album album;

    @Before
    public void setup() {
        tracks = Arrays.asList(
                new Track("alpha", 3),
                new Track("bravo", 20),
                new Track("charlie", 4),
                new Track("delta", 10),
                new Track("echo", 7)
        );
        album = new Album(tracks);
    }

    @Test
    public void testAddTracksToAlbum() {
        album = new Album();

        for (Track track : tracks) {
            album.addTrack(track);
        }

        assertThat(album.getTracks(), equalTo(tracks));
    }

    @Test
    public void testGetTracksByNumber() {
        for (int i = 0; i < tracks.size(); i++) {
            Track track = album.getTrack(i + 1);
            assertThat(track, equalTo(tracks.get(i)));
            assertThat(track.getTrackNumber(), equalTo(i + 1));
        }
    }

    @Test
    public void testGetTrackCount() {
        assertThat(album.trackCount(), equalTo(5));
    }

    @Test
    public void testRetrieveTopNTrackTitlesFromAlbum() {
        List<String> expectedTracks = Arrays.asList("bravo", "delta", "echo");

        List<String> actualTracks = album.getTopTrackTitles(3);

        assertThat(actualTracks, equalTo(expectedTracks));
    }
}