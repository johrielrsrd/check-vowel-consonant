import java.util.Scanner;

public class CheckVowCon {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Please enter a sequence of characters: ");
        String input = scan.nextLine();
        scan.close();

        boolean isInputValid = false;

        if (inputIsValid(input, isInputValid)) {
            printChar(input);
        } else {
            System.out.println("Your input is not valid.");
        }
    }

    public static void printChar(String input) {
        for (char letter : input.toCharArray()) {
            if (isVowel(letter)) {
                System.out.println(letter + " is a vowel.");
            } else if (Character.isWhitespace(letter)) {
                System.out.println();
            } else {
                System.out.println(letter + " is a consonant.");
            }
        }
    }

    public static boolean inputIsValid(String input, boolean isValid) {
        int numOfLetters = 0, numOfSpace = 0;

        for (char letter : input.toCharArray()) {
            if (Character.isLetter(letter)) {
                numOfLetters++;
                isValid = isOnlyWhiteSpace(numOfLetters, numOfSpace, isValid) ? true : false;
            } else if (Character.isWhitespace(letter)) {
                numOfSpace++;
                isValid = isOnlyWhiteSpace(numOfLetters, numOfSpace, isValid) ? true : false;
            } else {
                isValid = false;
                break;
            }
        }
        return isValid;
    }

    public static boolean isOnlyWhiteSpace(int letter, int space, boolean isWhite) {
        if (letter == 0 && space > 0) {
            isWhite = false;
        } else {
            isWhite = true;
        }
        return isWhite;
    }

    public static boolean isVowel(char letter) {
        letter = Character.toLowerCase(letter);
        return letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u';
    }
}
