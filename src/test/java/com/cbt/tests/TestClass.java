package com.cbt.tests;

public class TestClass {
    public static void main(String[] args) throws InterruptedException {
        AmazonTitle.verifyAmazonTitle();
        WikipediaURL.verifyWikipediaURL();
        VyTrackTitleTest.verifyTitle();
        GoogleResultTitle.verifyGoogleTitle();
        EbaySearchResult.verifyEtsySearchFunctionality();
        VyTrackShortcutFunctionality.verifyVyTrachShortcut();
    }
}
