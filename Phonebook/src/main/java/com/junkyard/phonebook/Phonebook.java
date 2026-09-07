package com.junkyard.phonebook;

import com.junkyard.contact.Contact;

import java.util.HashSet;

public class Phonebook {
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
