package javaassignment;
import java.util.*;

 class SecondAnswer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Choose an operation:");
            System.out.println("1. Concatenate Strings");
            System.out.println("2. Find Length of a String");
            System.out.println("3. Convert to Uppercase and Lowercase");
            System.out.println("4. Extract Substring");
            System.out.println("5. Split a Sentence");
            System.out.println("6. Reverse a String");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
            }
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    concatenateStrings(scanner);
                    break;
                case 2:
                    findStringLength(scanner);
                    break;
                case 3:
                    convertToUpperCaseAndLowerCase(scanner);
                    break;
                case 4:
                    extractSubstring(scanner);
                    break;
                case 5:
                    splitSentence(scanner);
                    break;
                case 6:
                    reverseString(scanner);
                    break;
                case 0:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please choose a valid operation.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void concatenateStrings(Scanner scanner) {
        System.out.println("Enter the first string:");
        String str1 = scanner.next();
        System.out.println("Enter the second string:");
        String str2 = scanner.next();
        String result = str1.concat(str2);
        System.out.println("Concatenated string: " + result);
    }

    private static void findStringLength(Scanner scanner) {
        System.out.println("Enter a string:");
        String str = scanner.next();
        int length = str.length();
        System.out.println("Length of the string: " + length);
    }

    private static void convertToUpperCaseAndLowerCase(Scanner scanner) {
        System.out.println("Enter a string:");
        String str = scanner.next();
        String upperCase = str.toUpperCase();
        String lowerCase = str.toLowerCase();
        System.out.println("Uppercase: " + upperCase);
        System.out.println("Lowercase: " + lowerCase);
    }

    private static void extractSubstring(Scanner scanner) {
        System.out.println("Enter a string:");
        String str = scanner.next();
        System.out.println("Enter the starting index:");
        int start = scanner.nextInt();
        System.out.println("Enter the ending index:");
        int end = scanner.nextInt();
        String subStr = str.substring(start, end);
        System.out.println("Extracted substring: " + subStr);
    }

    private static void splitSentence(Scanner scanner) {
        System.out.println("Enter a sentence:");
        scanner.nextLine(); // consume newline
        String sentence = scanner.nextLine();
        String[] words = sentence.split("\\s+");
        System.out.println("Words in the sentence:");
        for (String word : words) {
            System.out.println(word);
        }
    }

    private static void reverseString(Scanner scanner) {
        System.out.println("Enter a string:");
        String str = scanner.next();
        StringBuilder reversed = new StringBuilder(str).reverse();
        System.out.println("Reversed string: " + reversed);
    }
}
