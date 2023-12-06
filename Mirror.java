import java.time.LocalTime;
import java.util.Scanner;
public class Mirror {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb;

        System.out.println("1- (Francais) " + Pattern.PICKLANGUAGE.french);
        System.out.println("2- (English) " + Pattern.PICKLANGUAGE.english);
        System.out.println("3- (עִברִית) " + Pattern.PICKLANGUAGE.hebrew);

        Language language = switch (scan.nextLine()) {
            case "1" -> Language.FRENCH;
            case "2" -> Language.ENGLISH;
            case "3" -> Language.HEBREW;
            default -> Language.FRENCH;
        };

        System.out.println(getCurrentTime().getTranslation(language));

        System.out.println(Pattern.INPUT.getTranslation(language));
        sb = new StringBuilder(scan.nextLine());
        StringBuilder input = new StringBuilder(sb);
        sb.reverse();
        System.out.println(sb);

        String endRes = (input.compareTo(sb) == 0) ? Pattern.CONGRATULATION.getTranslation(language) : Pattern.DOMMAGE.getTranslation(language);
        System.out.println(endRes);
        System.out.println(getCurrentTime().getTranslation(language));
        scan.close();

    }

    private static Pattern getCurrentTime() {
        return LocalTime.now().isAfter(LocalTime.of(12, 0)) ? Pattern.GOODNIGHT : Pattern.GOODMORNING;
    }

}
