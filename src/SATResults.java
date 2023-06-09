import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SATResults {
    static List<StudentData> satResults = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenu();
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    insertData(scanner);
                    break;
                case "2":
                    viewAllData();
                    break;
                case "3":
                    getRank(scanner);
                    break;
                case "4":
                    updateScore(scanner);
                    break;
                case "5":
                    deleteRecord(scanner);
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    static void insertData(Scanner scanner) {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter City: ");
        String city = scanner.nextLine();
        System.out.print("Enter Country: ");
        String country = scanner.nextLine();
        System.out.print("Enter Pincode: ");
        String pincode = scanner.nextLine();
        System.out.print("Enter SAT score: ");
        int satScore = Integer.parseInt(scanner.nextLine());

        boolean passed = satScore > 30;

        StudentData data = new StudentData(name, address, city, country, pincode, satScore, passed);

        satResults.add(data);
        System.out.println("Data inserted successfully.");
    }

    static void viewAllData() {
        for (StudentData data : satResults) {
            System.out.println(data.toString());
        }
    }

    static void getRank(Scanner scanner) {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        satResults.sort((s1, s2) -> Integer.compare(s2.getSatScore(), s1.getSatScore()));

        for (int i = 0; i < satResults.size(); i++) {
            if (satResults.get(i).getName().equals(name)) {
                System.out.println("Rank: " + (i + 1));
                return;
            }
        }

        System.out.println("Data not found.");
    }

    static void updateScore(Scanner scanner) {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        for (StudentData data : satResults) {
            if (data.getName().equals(name)) {
                System.out.print("Enter new SAT score: ");
                int satScore = Integer.parseInt(scanner.nextLine());
                data.setSatScore(satScore);
                data.setPassed(satScore > 30);
                System.out.println("Score updated successfully.");
                return;
            }
        }

        System.out.println("Data not found.");
    }

    static void deleteRecord(Scanner scanner) {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        for (int i = 0; i < satResults.size(); i++) {
            if (satResults.get(i).getName().equals(name)) {
                satResults.remove(i);
                System.out.println("Record deleted successfully.");
                return;
            }
        }

        System.out.println("Data not found.");
    }

    static void printMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Insert data");
        System.out.println("2. View all data");
        System.out.println("3. Get rank");
        System.out.println("4. Update score");
        System.out.println("5. Delete one record");
        System.out.println("0. Exit");
    }
}

class StudentData {
    private String name;
    private String address;
    private String city;
    private String country;
    private String pincode;
    private int satScore;
    private boolean passed;

    public StudentData(String name, String address, String city, String country, String pincode, int satScore, boolean passed) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.country = country;
        this.pincode = pincode;
        this.satScore = satScore;
        this.passed = passed;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getPincode() {
        return pincode;
    }

    public int getSatScore() {
        return satScore;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setSatScore(int satScore) {
        this.satScore = satScore;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                "\nAddress: " + address +
                "\nCity: " + city +
                "\nCountry: " + country +
                "\nPincode: " + pincode +
                "\nSAT score: " + satScore +
                "\nPassed: " + passed +
                "\n";
    }
}
