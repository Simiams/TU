enum Pattern {
    PICKLANGUAGE("Choisit un langage", "Select a langage", "בחר שפה"), GOODMORNING("Bonjour", "Good Morning", "בוקר טוב"), GOODNIGHT("Bonne nuit", "Good evening", "לילה טוב"), GOODBYE("Au revoir", "Good Bye", "ביי"), INPUT("Tape un mot je te le retourne", "Type a word and I'll give it back to you", "הקלד מילה ואני אחזיר לך אותה"), CONGRATULATION("Félicitation", "Well Done", "מזל טוב"), DOMMAGE("Dommage", "Too bad", "נֵזֶק");
    String french;
    String english;
    String hebrew;

    Pattern(String french, String english, String hebrew) {
        this.french = french;
        this.english = english;
        this.hebrew = hebrew;
    }

    String getTranslation(Language language) {
        return switch (language) {
            case FRENCH -> french;
            case ENGLISH -> english;
            case HEBREW -> hebrew;
        };
    }
}

