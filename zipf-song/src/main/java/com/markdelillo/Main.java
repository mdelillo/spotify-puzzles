package com.markdelillo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tracksOnAlbum = scanner.nextInt();
        int topTracksToDisplay = scanner.nextInt();

        Album album = new Album();
        for (int i = 0 ; i < tracksOnAlbum; i++) {
            int playCount = scanner.nextInt();
            String title = scanner.nextLine().trim();
            album.addTrack(new Track(title, playCount));
        }

        for (String title : album.getTopTrackTitles(topTracksToDisplay)) {
            System.out.println(title);
        }
    }
}