package com.centric.weather;

public class IncorrectZipException extends RuntimeException {
    IncorrectZipException(String zip) {
        super("Invalid zip code " + zip);
    }
}
