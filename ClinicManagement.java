import java.util.ArrayList;
import java.util.Scanner;

public class ClinicManagement {

    static ArrayList<Patient> patients = new ArrayList<>();
    static ArrayList<Visit> visits = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Clinic Management System ---");
            System.out.println("1. Add Patient");
            System.out.println("2. Record Visit");
            System.out.println("3. View All Patients");
            System.out.println("4. View Patient Visit History");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addPatient(sc);
                    break;

                case 2:
                    recordVisit(sc);
                    break;

                case 3:
                    viewPatients();
                    break;

                case 4:
                    viewVisitHistory(sc);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // Add Patient
    static void addPatient(Scanner sc) {

        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Gender: ");
        String gender = sc.nextLine();

        patients.add(new Patient(id, name, age, gender));

        System.out.println("Patient added successfully!");
    }

    // Record Visit
    static void recordVisit(Scanner sc) {

        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Visit Date: ");
        String date = sc.nextLine();

        System.out.print("Enter Symptoms: ");
        String symptoms = sc.nextLine();

        System.out.print("Enter Doctor Name: ");
        String doctor = sc.nextLine();

        System.out.print("Enter Prescription: ");
        String prescription = sc.nextLine();

        visits.add(new Visit(id, date, symptoms, doctor, prescription));

        System.out.println("Visit recorded successfully!");
    }

    // View All Patients
    static void viewPatients() {

        if (patients.isEmpty()) {
            System.out.println("No patients found.");
            return;
        }

        for (Patient p : patients) {
            p.displayPatient();
        }
    }

    // View Patient Visit History
    static void viewVisitHistory(Scanner sc) {

        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();

        boolean found = false;

        for (Visit v : visits) {

            if (v.patientId == id) {
                v.displayVisit();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No visit records found for this patient.");
        }
    }
}

// Patient Class
class Patient {

    int id;
    String name;
    int age;
    String gender;

    Patient(int id, String name, int age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    void displayPatient() {

        System.out.println("\n--- Patient Details ---");
        System.out.println("Patient ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
    }
}

// Visit Class
class Visit {

    int patientId;
    String date;
    String symptoms;
    String doctor;
    String prescription;

    Visit(int patientId, String date, String symptoms,
          String doctor, String prescription) {

        this.patientId = patientId;
        this.date = date;
        this.symptoms = symptoms;
        this.doctor = doctor;
        this.prescription = prescription;
    }

    void displayVisit() {

        System.out.println("\n--- Visit Details ---");
        System.out.println("Patient ID: " + patientId);
        System.out.println("Visit Date: " + date);
        System.out.println("Symptoms: " + symptoms);
        System.out.println("Doctor Name: " + doctor);
        System.out.println("Prescription: " + prescription);
    }
}