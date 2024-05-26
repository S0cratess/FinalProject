package org.example;

public class Util {

    /**
     *
     * @param strIn the input string to be converted to title case
     * @return a new string each word is in title case
     */
    public static String toTitleCase(String strIn) {
        if (strIn == null || strIn.isEmpty()) {
            return strIn;
        }

        StringBuilder titleCase = new StringBuilder();
        boolean nextTitleCase = true;

        for (char c : strIn.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                nextTitleCase = true;
            } else if (nextTitleCase) {
                c = Character.toTitleCase(c);
                nextTitleCase = false;
            } else {
                c = Character.toLowerCase(c);
            }
            titleCase.append(c);
        }

        return titleCase.toString();
    }
}
