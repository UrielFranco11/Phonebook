package com.junkyard.contact;

import java.util.Objects;

public class Contact {
    private String name;
    private String phone;

    // Constructor Method
    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    // Getter
    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    // Override
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Contact)) return false;
        Contact other = (Contact) obj;
        return Objects.equals(this.name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
