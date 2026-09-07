package com.junkyard.test;

import com.junkyard.contact.Contact;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @Test
    void shouldCreateContactWithNameAndPhone() {
        Contact contact = new Contact("Uri", "5545455689");
        assertEquals("Uri", contact.getName());
        assertEquals("5545455689", contact.getPhone());
    }

    @Test
    void twoContactsWithTheSameNameShouldBeEqual() {
        Contact c1 = new Contact("Uri", "5545455689");
        Contact c2 = new Contact("Uri", "5545455679");
        assertEquals(c1, c2); // required by "a contact equals another when names match"
    }
}
