package com.example.waldaufforstung_v2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class DialogContact extends AppCompatDialogFragment {

    public boolean lang;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        if(lang == false)
        {
            builder.setTitle("Kontakt / Support");

            builder.setMessage("Adresse : \n" + "Musterstraße 12 \n" +
                    "12345 Leverkusen \n" + "Deutschland \n" +
                    "\n" + "Erreichbarkeit : \n" + "Montag - Freitag : 08 - 16 Uhr \n" +
                    "Samstag : 08 - 13 Uhr \n" + "Telefonnummer : 0800/12345667 " +
                    "(Gebührenfrei innnerhalb Deutschland) \n" + "E-Mail : mtba@it-tech.de" +
                    "\n" + "\n" + "Folge uns in den Sozialen Medien \n" +
                    "Facebook : MTBA IT GmbH \n" + "Twitter : MITBA IT GmbH \n" +
                    "Instagram : MITBA IT GmbH");
        } else {
            builder.setTitle("Contact / Support");

            builder.setMessage("Adress : \n" + "Musterstraße 12 \n" +
                    "12345 Leverkusen \n" + "Germany \n" + "\n" + "Reachability : \n" +
                    "Monday - Friday : 8 a.m - 4 p.m \n" + "Saturday : 8 a.m - 1 a.m \n" +
                    "phone number : 0800/12345667 \n" + "(Free of charge within Germany) \n" +
                    "E-Mail : mtba@it-tech.de" + "\n" + "\n" + "Follow us on Social Media" +
                    "\n" + "Facebook : MTBA IT GmbH \n" + "Twitter : MITBA IT GmbH \n" +
                    "Instagram : MITBA IT GmbH");
        }

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        return builder.create();
    }
}
