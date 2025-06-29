import java.util.Scanner;
import java.util.Random;

public class PasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Prompt user for password length
        System.out.print("Enter desired password length: ");
        int length = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (length <= 0) {
            System.out.println("Password length must be greater than 0.");
            return;
        }

        // Prompt user for character types to include
        System.out.print("Include lowercase letters? (yes/no): ");
        boolean includeLowercase = scanner.nextLine().equalsIgnoreCase("yes");

        System.out.print("Include uppercase letters? (yes/no): ");
        boolean includeUppercase = scanner.nextLine().equalsIgnoreCase("yes");

        System.out.print("Include numbers? (yes/no): ");
        boolean includeNumbers = scanner.nextLine().equalsIgnoreCase("yes");

        System.out.print("Include special characters? (yes/no): ");
        boolean includeSpecial = scanner.nextLine().equalsIgnoreCase("yes");

        // Character pools
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        String special = "!@#$%^&*()-_=+[]{}|;:,.<>?/";

        // Build the character set based on user choice
        String charSet = "";
        if (includeLowercase) charSet += lowercase;
        if (includeUppercase) charSet += uppercase;
        if (includeNumbers) charSet += numbers;
        if (includeSpecial) charSet += special;

        if (charSet.isEmpty()) {
            System.out.println("You must select at least one character type.");
            return;
        }

        // Generate password
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(charSet.length());
            password.append(charSet.charAt(index));
        }

        // Display result
        System.out.println("Generated password: " + password.toString());

        scanner.close();
    }
}

