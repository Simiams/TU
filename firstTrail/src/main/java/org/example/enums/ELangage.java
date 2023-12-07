package org.example.enums;

public enum ELangage {
    FRENCH("Francais"), ENGLISH("English") , HEBREW("Hebrew");
    String name;

    ELangage(String name) {
        this.name = name;
    }

    public static ELangage getELanguage(String language) {
        return switch (language) {
            case "fr" -> ELangage.FRENCH;
            case "en" -> ELangage.ENGLISH;
            case "he" -> ELangage.HEBREW;
            default -> null;
        };
    }
}