package PruebasEstructurales;

public class CountWords {
    public int count(String str) {
        int words = 0;
        char last = ' ';
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isLetter(str.charAt(i)) &&
                    (last == 's' || last == 'r')) {
                words++;
            }
        }
        if (last == 'r' || last == 's') {
            words++;
        }
        return words;
    }
}
