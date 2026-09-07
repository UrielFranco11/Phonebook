package com.junkyard.phonebook;

import com.junkyard.contact.Contact;

import java.util.HashSet;

import com.junkyard.contact.Contact;
import java.util.HashSet;
import java.util.Set;

public class Phonebook {
    private static final int DEFAULT_SIZE = 10;

    // Set - Set mathematically cannot contain duplicates
    // Duplicate means "same name" --> Contact.equals()
    private Set<Contact> contacts;
    private int maxSize;

    // Constructor Method: Phonebook() --- No arguments ---
    // Calls Phonebook(int size) using this(DEFAULT_SIZE)
    // C O N S T U C T O R - C H A I N I N G
    public Phonebook() {
        this(DEFAULT_SIZE);
    }

    // Constructor Method: Phonebook(int size)
    public Phonebook(int size) {
        this.maxSize = size;
        this.contacts = new HashSet<>();
    }

    public boolean addContact(Contact contact) {
        if (contacts.size() >= maxSize) {
            System.out.println("The phonebook is full. Cannot add more contacts.");
            return false;
        }
        if (contacts.contains(contact)) {
            System.out.println("A contact with this name already exists.");
            return false;
        }
        return contacts.add(contact);
    }

    public boolean contactExists(){
        return false;
    }

    public void listContacts(){}

    //public Contact searchContact(){}

    public boolean deleteContact(){
        return false;
    }

    public boolean phonebookIsFull(){
        return false;
    }

    public int spaceAvailable(){
        return 0;
    }

    public int size() {
        return contacts.size();
    }

    public int getMaxSize() {
        return maxSize;
    }

    HashSet<Contact> contacts;
    int size;

    public Phonebook() {
        contacts = new HashSet<>(10);
        this.size = 10;
    }

    public Phonebook(int size) {
        this.size = size;
        contacts = new HashSet<>(size);
    }

    /*
    * HU-04: Validar espacio disponible al añadir
    * Como usuario, quiero que el sistema me informe por pantalla si la agenda está llena al intentar añadir un
    * contacto, para saber por qué no se pudo agregar.
    * HU-05: Verificar existencia de un contacto
    * Como usuario, quiero consultar si un contacto ya existe en la agenda, para saber si necesito agregarlo o ya está registrado.
    * */

    public HashSet<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(HashSet<Contact> contacts) {
        this.contacts = contacts;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean canAdd() {
        return this.contacts.size() < this.size;
    }

    public boolean checkContactExists(Contact contact) {
        return contacts.contains(contact);
    }

}
