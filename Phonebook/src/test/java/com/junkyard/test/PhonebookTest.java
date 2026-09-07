package com.junkyard.test;

import com.junkyard.contact.Contact;
import com.junkyard.phonebook.Phonebook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

import com.junkyard.contact.Contact;
import com.junkyard.phonebook.Phonebook;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PhonebookTest {
    Phonebook testPhonebook;
    HashSet<Contact> testContacts;

    void fillPhonebook() {
        String[] names = {"A", "B", "C", "D", "F", "G", "H", "I", "J", "K"};

        for(int i = 0; i < 10; i++) {
            Contact contact = new Contact(names[i]);
            testContacts.add(contact);
        }

        testPhonebook.setContacts(testContacts);
    }


    @BeforeEach
    void createBaseEnvironment() {
        testPhonebook = new Phonebook(10);
        testContacts = new HashSet<>(10);
    }

    @Test
    void testFullPhonebook() {
        fillPhonebook();
        assertFalse(testPhonebook.canAdd());
    }

    @Test
    void canAddElements() {
        assertTrue(testPhonebook.canAdd());
    }

    @Test
    void testDuplicateContacts() {
        fail();
    }

    @Test
    void checkExistentContact() {
        Contact testContact = new Contact("Test");
        testContacts.add(testContact);
        testPhonebook.setContacts(testContacts);
        assertTrue(testPhonebook.checkContactExists(testContact));
    }
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
