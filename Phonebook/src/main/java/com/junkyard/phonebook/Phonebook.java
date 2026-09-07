package com.junkyard.phonebook;

public class Phonebook {
    public String getContact(String contact){
String name = contact.name
        String telephone = contact.number

        return "buscando contacto de " + contact;

    }

    public String deleteContact(String contact){


        return  "se elimino el contacto de " + contact;
    }

    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        String resultado = phonebook.getContact(" Aldo Briones");
        System.out.println(resultado);
    }

}
