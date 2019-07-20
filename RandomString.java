import java.util.*;

/**
 * Random String
 *
 * A tool for creating random names or other strings.
 * Input a string with some replacement characters
 * ('.' and '-') that will then get swapped to a
 * vowel or a consonant, respectively. You can also
 * input '?' to mark a letter that can be anything.
 *
 * @author Lauri Kosonen
 * @version 2019-07-20
 */
public class RandomString {
    private static final String letters = "abcdefghijklmnopqrstuvwxyz";
    private static final String vowels = "aeiouy";
    private static final String consonants = "bcdfghjklmnpqrstvwxyz";
    private static char vowelMark = '.';
    private static char consonantMark = '-';
    private static char anyMark = '?';
    private static char midChar = ' ';

   /**
    * Runs the program.
    */
    public static void main(String[] args) {
        if (args.length > 0) {

            // Concatenates all of the args into one string
            String wholeString = "";
            for (int i = 0; i < args.length; i++) {
                if (i > 0) {
                    wholeString += midChar;
                }

                wholeString += args[i];
            }

            StringBuilder result = new StringBuilder(wholeString.length());

            // Creates the new string
            boolean capitalizeNext = true;
            for (int i = 0; i < wholeString.length(); i++) {
                char charToAppend = wholeString.charAt(i);
                if (charToAppend == midChar) {
                    capitalizeNext = true;
                }
                else {
                    charToAppend = getReplacementRandomLetter(charToAppend);
                    if (capitalizeNext) {
                        charToAppend = Character.toUpperCase(charToAppend);
                        capitalizeNext = false;
                    }
                }

                result.append(charToAppend);
            }

            System.out.print(result + "\n");
        }
        else {
            System.out.println("Please input a string");
        }
    }

   /**
    * Gets a replacement letter depending on what will be replaced.
    *
    * @param charToReplace a character to be replaced
    * @return a replacement letter or the original character
    */
    private static char getReplacementRandomLetter(char charToReplace) {
        if (charToReplace == vowelMark) {
            return getRandomChar(vowels);
        }
        else if (charToReplace == consonantMark) {
            return getRandomChar(consonants);
        }
        else if (charToReplace == anyMark) {
            return getRandomChar(letters);
        }
        else {
            return charToReplace;
        }
    }

   /**
    * Gets a random character from the given string.
    *
    * @param str a string
    * @return a random character from the string
    */
    private static char getRandomChar(String str) {
        if (str.length() > 0) {
            double rand = Math.random();
            int index = (int)(rand * str.length());

            return str.charAt(index);
        }
        else {
            return '?';
        }
    }
}
