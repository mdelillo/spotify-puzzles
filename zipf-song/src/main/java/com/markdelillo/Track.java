package com.markdelillo;

public class Track {
    private String title;
    private int playCount;

    private int trackNumber;

    public Track(String title) {
        this.title = title;
        this.playCount = 0;
        this.trackNumber = 1;
    }

    public Track(String title, int playCount) {
        this.title = title;
        this.playCount = playCount;
        this.trackNumber = 1;
    }

    public String getTitle() {
        return title;
    }

    public int getPlayCount() {
        return playCount;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Track track = (Track) o;

        return getTrackNumber() == track.getTrackNumber() && !(getTitle() != null ? !getTitle().equals(track.getTitle()) : track.getTitle() != null);
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + trackNumber;
        return result;
    }
}
