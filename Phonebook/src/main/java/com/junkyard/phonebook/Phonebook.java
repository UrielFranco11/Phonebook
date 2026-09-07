package com.junkyard.phonebook;

public class Phonebook {
    public String GetContact(String contact){


        return "buscando contacto de" + contact;

    }

    public String DeleteContact(String contact){


        return  "se elimino el contacto de " + contact;
    }

    public static void main {
        Phonebook phonebook = New.Phonebook();
        String resultado = phonebook.GetContact("Aldo Briones");
        System.out.println(resultado);
    }

}
