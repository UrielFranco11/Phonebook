package com.junkyard.test;

import com.junkyard.contact.Contact;
import com.junkyard.phonebook.Phonebook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PhonebookTest {
    //Consultar si la agenda está llena
    @Test
    public void isFullTestWhenAgendaIsFull() {
        Phonebook phonebook = new Phonebook(2);
        phonebook.addContact(new Contact("Ana", "52-22221111"));
        phonebook.addContact(new Contact("Luis", "52-22221111"));

            assertTrue(phonebook.phonebookIsFull());
    }

    @Test
    public void isFullTestWhenAgendaIsNotFull() {
        Phonebook phonebook = new Phonebook(2);
        phonebook.addContact(new Contact("Ana", "52-22221111"));

        assertFalse(phonebook.phonebookIsFull());
    }
    //Consultar espacios disponibles
    @Test
    public void spaceAvailableTestWhenFullPhonebook() {
        Phonebook phonebook = new Phonebook(2);
        phonebook.addContact(new Contact("Ana", "52-22221111"));
        phonebook.addContact(new Contact("Luis", "52-22221111"));

        assertEquals(0, phonebook.spaceAvailable());
    }

    @Test
    public void spaceAvailableTestWithOneContact() {
        Phonebook phonebook = new Phonebook(2);
        phonebook.addContact(new Contact("Ana", "555-1111"));

        assertEquals(1, phonebook.spaceAvailable());
    }

    @Test
    public void spaceAvailableTestWithNoContacts() {
        Phonebook phonebook = new Phonebook(2);

        assertEquals(2, phonebook.spaceAvailable());
    }
}
