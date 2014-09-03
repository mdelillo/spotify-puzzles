package com.markdelillo;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static final int MAX_TRACKS_ON_ALBUM = 50000;
    public static final double MAX_PLAY_COUNT = Math.pow(10, 12);
    public static final String TITLE_PATTERN = "[a-z0-9_]{1,30}";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tracksOnAlbum = scanner.nextInt();
        int topTracksToDisplay = scanner.nextInt();

        validateTracksOnAlbum(tracksOnAlbum);
        validateTopTracksToDisplay(tracksOnAlbum, topTracksToDisplay);

        Album album = new Album();
        for (int i = 0 ; i < tracksOnAlbum; i++) {
            double playCount = scanner.nextInt();
            String title = scanner.nextLine().trim();
            validatePlayCount(playCount);
            validateTitle(title);
            album.addTrack(new Track(title, playCount));
        }

        for (String title : album.getTopTrackTitles(topTracksToDisplay)) {
            System.out.println(title);
        }
    }

    private static void validateTitle(String title) {
        if (!Pattern.matches(TITLE_PATTERN, title)) {
            System.err.println("Title must be between 1 and 30 characters and only consist of lowercase letters, digits, and underscores.");
            System.exit(1);
        }
    }

    private static void validatePlayCount(double playCount) {
        if (playCount > MAX_PLAY_COUNT) {
            System.err.println("Play count must be between 0 and " + MAX_PLAY_COUNT);
            System.exit(1);

        }
    }

    private static void validateTopTracksToDisplay(int tracksOnAlbum, int topTracksToDisplay) {
        if (topTracksToDisplay < 1 || topTracksToDisplay > tracksOnAlbum) {
            System.err.println("Number of top tracks to display must be between 1 and number of tracks on album");
            System.exit(1);
        }
    }

    private static void validateTracksOnAlbum(int tracksOnAlbum) {
        if (tracksOnAlbum < 1 || tracksOnAlbum > MAX_TRACKS_ON_ALBUM) {
            System.err.println("Number of tracks on album must be between 1 and " + MAX_TRACKS_ON_ALBUM);
            System.exit(1);
        }
    }
}