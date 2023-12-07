package org.example;


import org.example.enums.Pattern;
import org.example.models.Language;

import java.time.LocalTime;
import java.util.Scanner;

public class Mirror {

    public static void main(String[] args) {
        Api api = new Api();
        Scanner scan = new Scanner(System.in);
        Language language = new Language(api);

        StringBuilder sb;

        System.out.println("1- (Francais) " + Pattern.PICKLANGUAGE.french);
        System.out.println("2- (English) " + Pattern.PICKLANGUAGE.english);
        System.out.println("3- (עִברִית) " + Pattern.PICKLANGUAGE.hebrew);
        System.out.println("4-  Pour voir la liste des langues disponibles (beta)");

        language.setUserLanguage(switch (scan.nextLine()) {
            case "2" -> "en";
            case "3" -> "he";
            case "4" -> chooseLanguage(language, scan);
            default -> "fr";
        });

        System.out.println(language.translateWord(getCurrentTime()));

        System.out.println(language.translateWord(Pattern.INPUT));
        sb = new StringBuilder(scan.nextLine());
        StringBuilder input = new StringBuilder(sb);
        sb.reverse();
        System.out.println(sb);

        System.out.println((input.compareTo(sb) == 0) ? language.translateWord(Pattern.CONGRATULATION) : language.translateWord(Pattern.DOMMAGE));
        System.out.println(language.translateWord(Pattern.GOODBYE));
        scan.close();
    }

    private static String chooseLanguage(Language language, Scanner scan) {
        System.out.println(String.join(" | " , language.getLanguages()));
        System.out.println("Entrée le language de votre choix (ex: fr, en, he, ...)");
        String userInput = scan.nextLine();
        return language.getLanguages().contains(userInput) ? userInput : chooseLanguage(language, scan);
    }

    private static Pattern getCurrentTime() {
        return LocalTime.now().isAfter(LocalTime.of(12, 0)) ? Pattern.GOODNIGHT : Pattern.GOODMORNING;
    }

}
