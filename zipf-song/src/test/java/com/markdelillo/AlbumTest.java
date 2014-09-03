package com.markdelillo;

import junit.framework.TestCase;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class AlbumTest extends TestCase {

    public void testRetrieveFirstNSongsFromAlbum() {
        String[] songs = {"alpha", "bravo", "charlie", "delta", "echo"};
        String[] expectedSongs = {"alpha", "bravo", "charlie"};

        Album album = new Album(songs);
        String[] actualSongs = album.getTopSongs(3);

        assertThat(actualSongs, equalTo(expectedSongs));
    }

}