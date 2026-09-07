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
}
