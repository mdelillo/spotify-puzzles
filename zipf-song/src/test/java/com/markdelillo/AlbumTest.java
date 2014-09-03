package com.markdelillo;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class AlbumTest {

    public List<Song> songs;
    public Album album;

    @Before
    public void setup() {
        songs = Arrays.asList(
                new Song("alpha"),
                new Song("bravo"),
                new Song("charlie"),
                new Song("delta"),
                new Song("echo")
        );
        album = new Album(songs);
    }

    @Test
    public void testRetrieveFirstNSongsFromAlbum() {
        List<Song> expectedSongs = Arrays.asList(
                new Song("alpha"),
                new Song("bravo"),
                new Song("charlie")
        );

        List<Song> actualSongs = album.getTopSongs(3);

        assertThat(actualSongs, equalTo(expectedSongs));
    }

    @Test
    public void testRetrieveFirstNSongTitlesFromAlbum() {
        List<String> expectedSongs = Arrays.asList("alpha", "bravo", "charlie");

        List<String> actualSongs = album.getTopSongTitles(3);

        assertThat(actualSongs, equalTo(expectedSongs));
    }

    @Test
    public void testAddSongsToAlbum() {
        album = new Album();

        for (Song song : songs) {
            album.addSong(song);
        }

        assertThat(album.getSongs(), equalTo(songs));
    }

    @Test
    public void testGetSongsByTrack() {
        for (int i = 0; i < songs.size(); i++) {
            assertThat(album.getTrack(i + 1), equalTo(songs.get(i)));
        }
    }

}