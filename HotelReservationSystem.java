import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HotelReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Hotel Reservation System");

        while (true) {
            System.out.println("1: Create an account");
            System.out.println("2: Start your reservation");
            System.out.println("3: Cancel your reservation");
            System.out.println("4: Display all my reservations");
            System.out.println("5: Print total bill");
            System.out.println("Enter your choice (1-5) or any other key to exit:");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    createAccount(scanner);
                    break;
                default:
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
            }
        }
    }

    private static void createAccount(Scanner scanner) {
        System.out.println("Enter user email:");
        String userEmail = scanner.nextLine();

        System.out.println("Enter user phone number:");
        String userPhoneNumber = scanner.nextLine();

        System.out.println("Enter user location:");
        String userLocation = scanner.nextLine();

        String accountNumber = generateAccountNumber();


        String folderPath = "./HotelReservations/" + accountNumber;
        File accountFolder = new File(folderPath);

        if (!accountFolder.exists()) {
            accountFolder.mkdirs(); 
        }

        String filePath = folderPath + File.separator + "acc_" + accountNumber + ".txt";
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("User Email: " + userEmail + "\n");
            writer.write("User Phone Number: " + userPhoneNumber + "\n");
            writer.write("User Location: " + userLocation + "\n");

            System.out.println("Account created successfully. Folder and file created.");
        } catch (IOException e) {
            System.err.println("Error creating account. Please try again.");
            e.printStackTrace();
        }
    }

    private static String generateAccountNumber() {
        return String.valueOf(System.currentTimeMillis());
    }
}
