package com.example.waldaufforstung_v2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class DialogAbout extends AppCompatDialogFragment {

    public boolean lang;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        if (lang == false)
        {
            builder.setTitle("Willkommen bei MTAB IT GmbH");

            builder.setMessage("\n" + "Wir sind ein kleines aber hochmotiviertes Unternehmen mit einem Sitz in Leverkusen (Deutschland), das sich auf das Designen und Programmieren von Apps spezialisiert hat.\n" + "\n" +
                    "Mit einem motivierten und jungen Team mit insgesamt 11 Mitarbeitern streben wir danach, die kreativen Köpfe zu sein, die ein Lächeln auf Ihr Gesicht zaubern.\n" + "\n" +
                    "Wenn Sie „DIE IDEE“ haben und jemanden suchen der es vertrauensvoll umsetzt, sind Sie bei uns genau richtig.\n" + "\n" +
                    "Mit reichlicher Energie und Innovationsgeist möchten wir unseren Kunden etwas ganz Besonderes bieten. Dabei stehen ihre Wünsche ganz oben auf unserer Prioritätenliste.\n");
        } else {
            builder.setTitle("Welcome to MTAB IT GmbH");

            builder.setMessage("\n" + "We are a small but highly motivated company based in Leverkusen (Germany) that specializes in designing and programming apps.\n" + "\n" +
                    "With a motivated and young team with a total of 11 employees, we strive to be the creative minds that put a smile on your face.\n" + "\n" +
                    "If you have \"THE IDEA\" and are looking for someone who implements it with confidence, YOU are exactly right with us.\n" +  "\n" +
                    "With plenty of energy and a spirit of innovation, we want to offer our customers something very special. Your wishes are at the top of our priority list.");
        }


        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        return builder.create();
    }
}
