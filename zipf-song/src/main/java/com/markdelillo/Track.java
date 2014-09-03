package com.markdelillo;

public class Track implements Comparable {
    private String title;
    private int playCount;
    private int trackNumber;

    public Track(String title, int playCount) {
        this.title = title;
        this.playCount = playCount;
        this.trackNumber = 1;
    }

    public Track(String title, int playCount, int trackNumber) {
        this.title = title;
        this.playCount = playCount;
        this.trackNumber = trackNumber;
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
    public int compareTo(Object o) {
        Track otherTrack = (Track)o;
        int quality = getTrackNumber() * getPlayCount();
        int otherQuality = otherTrack.getTrackNumber() * otherTrack.getPlayCount();

        if (quality != otherQuality) {
            return quality - otherQuality;
        }
        else {
            return otherTrack.getTrackNumber() - getTrackNumber();
        }
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
