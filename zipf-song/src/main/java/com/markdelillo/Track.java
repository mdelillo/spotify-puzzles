package com.markdelillo;

public class Track {
    private final String title;
    private final int playCount;

    public Track(String title) {
        this.title = title;
        this.playCount = 0;
    }

    public Track(String title, int playCount) {
        this.title = title;
        this.playCount = playCount;
    }

    public String getTitle() {
        return title;
    }

    public int getPlayCount() {
        return playCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Track track = (Track) o;

        return !(getTitle() != null ? !getTitle().equals(track.getTitle()) : track.getTitle() != null);

    }

    @Override
    public int hashCode() {
        return getTitle() != null ? getTitle().hashCode() : 0;
    }

}
