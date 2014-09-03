package com.markdelillo;

import junit.framework.TestCase;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class AlbumTest extends TestCase {

    public static final List<Song> SONGS = Arrays.asList(
            new Song("alpha"),
            new Song("bravo"),
            new Song("charlie"),
            new Song("delta"),
            new Song("echo")
    );

    public void testRetrieveFirstNSongsFromAlbum() {
        List<Song> expectedSongs = Arrays.asList(
                new Song("alpha"),
                new Song("bravo"),
                new Song("charlie")
        );

        Album album = new Album(SONGS);
        List<Song> actualSongs = album.getTopSongs(3);

        assertThat(actualSongs, equalTo(expectedSongs));
    }

    public void testAddSongsToAlbum() {
        Album album = new Album();

        for (Song song : SONGS) {
            album.addSong(song);
        }

        assertThat(album.getSongs(), equalTo(SONGS));
    }

}