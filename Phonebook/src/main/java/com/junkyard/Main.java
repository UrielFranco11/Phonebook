package com.junkyard;

import com.junkyard.contact.Contact;
import com.junkyard.phonebook.Phonebook;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Phonebook phonebook = createPhonebook(scanner);

        boolean running = true;
        while (running) {
            printMenu();
            String option = scanner.nextLine().trim();

            switch (option) {
                case "1":
                    addContact(scanner, phonebook);
                    break;
                case "2":
                    checkExists(scanner, phonebook);
                    break;
                case "3":
                    phonebook.listContacts();
                    break;
                case "4":
                    searchContact(scanner, phonebook);
                    break;
                case "5":
                    removeContact(scanner, phonebook);
                    break;
                case "6":
                    checkIfFull(phonebook);
                    break;
                case "7":
                    checkFreeSpace(phonebook);
                    break;
                case "0":
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }

    private static Phonebook createPhonebook(Scanner scanner) {
        System.out.println("Enter a custom size for your phonebook, or press Enter for the default (10):");
        String input = scanner.nextLine().trim();

        if (input.isEmpty()) {
            return new Phonebook();
        }

        try {
            int size = Integer.parseInt(input);
            return new Phonebook(size);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number. Using default size (10).");
            return new Phonebook();
        }
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("=== Phonebook Menu ===");
        System.out.println("1. Add contact");
        System.out.println("2. Check if a contact exists");
        System.out.println("3. List all contacts");
        System.out.println("4. Search contact by name");
        System.out.println("5. Remove contact");
        System.out.println("6. Check if phonebook is full");
        System.out.println("7. Check free space");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }

    private static void addContact(Scanner scanner, Phonebook phonebook) {
        System.out.print("Name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Phone: ");
        String phone = scanner.nextLine().trim();

        phonebook.addContact(new Contact(name, phone));
    }

    private static void checkExists(Scanner scanner, Phonebook phonebook) {
        System.out.print("Name to check: ");
        String name = scanner.nextLine().trim();

        boolean exists = phonebook.contactExists(name);
        System.out.println(exists ? "That contact exists." : "That contact does not exist.");
    }

    private static void searchContact(Scanner scanner, Phonebook phonebook) {
        System.out.print("Name to search: ");
        String name = scanner.nextLine().trim();

        Contact found = phonebook.searchContact(name);
        if (found != null) {
            System.out.println("Phone: " + found.getPhone());
        } else {
            System.out.println("No contact found with that name.");
        }
    }

    private static void removeContact(Scanner scanner, Phonebook phonebook) {
        System.out.print("Name to remove: ");
        String name = scanner.nextLine().trim();

        boolean removed = phonebook.deleteContact(name);
        System.out.println(removed ? "Contact removed." : "Contact not found.");
    }

    private static void checkIfFull(Phonebook phonebook) {
        System.out.println(phonebook.phonebookIsFull() ? "The phonebook is full." : "There is still room.");
    }

    private static void checkFreeSpace(Phonebook phonebook) {
        System.out.println("Free spaces: " + phonebook.spaceAvailable());
    }
}