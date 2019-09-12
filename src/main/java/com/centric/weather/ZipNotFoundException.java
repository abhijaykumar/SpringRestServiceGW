package com.centric.weather;

public class ZipNotFoundException extends RuntimeException {
    ZipNotFoundException(String zip) {
        super("Could not load Weather data for zip code "
                + zip);
    }
}
