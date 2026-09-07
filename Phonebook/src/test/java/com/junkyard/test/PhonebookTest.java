package com.junkyard.test;

import com.junkyard.contact.Contact;
import com.junkyard.phonebook.Phonebook;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PhonebookTest {
    @Test
    void shouldCreatePhonebookWithDefaultSize() {
        Phonebook phonebook = new Phonebook();
        assertEquals(10, phonebook.getMaxSize());
    }

    @Test
    void shouldCreatePhonebookWithCustomSize() {
        Phonebook phonebook = new Phonebook(5);
        assertEquals(5, phonebook.getMaxSize());
    }

    @Test
    void newPhonebookShouldBeEmpty() {
        Phonebook phonebook = new Phonebook();
        assertEquals(0, phonebook.size());
    }

    @Test
    void shouldAddContactSuccessfully() {
        Phonebook phonebook = new Phonebook();
        Contact contact = new Contact("Uri", "5545455689");
        assertTrue(phonebook.addContact(contact));
        assertEquals(1, phonebook.size());
    }

    // HU-05: contactExists(String name)
    @Test
    void contactExists_shouldReturnTrue_whenContactExists() {
        Phonebook phonebook = new Phonebook();
        phonebook.addContact(new Contact("Uri", "5545455689"));
        assertTrue(phonebook.contactExists("Uri"));
    }

    @Test
    void contactExists_shouldReturnFalse_whenContactDoesNotExist() {
        Phonebook phonebook = new Phonebook();
        assertFalse(phonebook.contactExists("Luis"));
    }

    // HU-06: listContacts() -- imprime por consola, no retorna nada
    @Test
    void listContacts_shouldNotThrow_whenPhonebookIsEmpty() {
        Phonebook phonebook = new Phonebook();
        assertDoesNotThrow(phonebook::listContacts);
    }

    @Test
    void listContacts_shouldNotThrow_whenPhonebookHasContacts() {
        Phonebook phonebook = new Phonebook();
        phonebook.addContact(new Contact("Uri", "5545455689"));
        assertDoesNotThrow(phonebook::listContacts);
    }

}
