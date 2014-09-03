package com.markdelillo;

import junit.framework.TestCase;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class AlbumTest extends TestCase {

    public static final List<String> SONGS = Arrays.asList("alpha", "bravo", "charlie", "delta", "echo");

    public void testRetrieveFirstNSongsFromAlbum() {
        List<String> expectedSongs = Arrays.asList("alpha", "bravo", "charlie");

        Album album = new Album(SONGS);
        List<String> actualSongs = album.getTopSongs(3);

        assertThat(actualSongs, equalTo(expectedSongs));
    }

    public void testAddSongsToAlbum() {
        Album album = new Album();

        for (String song : SONGS) {
            album.addSong(song);
        }

        assertThat(album.getSongs(), equalTo(SONGS));
    }

}