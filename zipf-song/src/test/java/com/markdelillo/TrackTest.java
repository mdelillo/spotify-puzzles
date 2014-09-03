package com.markdelillo;

import org.junit.Test;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class TrackTest {
    @Test
    public void testCompareTracks() {
        Track track1 = new Track("alpha", 3, 1);
        Track track2 = new Track("bravo", 1, 2);
        Track track3 = new Track("charlie", 1, 3);
        Track track4 = new Track("delta", 1, 4);

        assertThat(track1, greaterThan(track2)); // Track 1 is higher quality
        assertThat(track1, greaterThan(track3)); // Same quality, track 1 has lower track number
        assertThat(track1, lessThan(track4));    // Track 1 has lower quality
    }
}
