package com.example.waldaufforstung_v2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextInputLayout textInputLayout;
    AutoCompleteTextView autoCompleteTextView;

    // Ist die Sprache auf Englisch
    public boolean lang_eng = false;

    EditText Anzahl;
    EditText Hectar;
    TextView text_Hectar;

    ArrayList<String> arrayList_trees;
    ArrayAdapter<String> arrayAdapter_trees;

    boolean baumart = false;
    double x = 0;

    Button btn_AboutUs;
    Button btn_Contact;

    Button btn_calcHectar;
    Button btn_calcAnzahl;

    Button btn_ger;
    Button btn_eng;

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Deaktivierung vom DunkelModus
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        text_Hectar = findViewById(R.id.text_hektar);

        // Auswahl der Baumart
        textInputLayout = findViewById(R.id.textInputLayout);
        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
        // Dropdown Baumart auswahl


        // Buttons zum Berechnen
        Anzahl = findViewById(R.id.anzahl_number);
        Hectar = findViewById(R.id.hectar_number);

        // Array List für Die Baumarten
        arrayList_trees = new ArrayList<>();
        arrayList_trees.add("Fichte");
        arrayList_trees.add("Buche");
        arrayList_trees.add("Kiefer");
        arrayList_trees.add("Eiche");

        arrayAdapter_trees = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, arrayList_trees);
        autoCompleteTextView.setAdapter(arrayAdapter_trees);

        // Dialog Button für Über Uns und Kontakte
        btn_AboutUs = findViewById(R.id.about_us);
        btn_Contact = findViewById(R.id.contact);
        btn_AboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialogAbout();
            }
        });
        btn_Contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialogContact();
            }
        });

        btn_ger = findViewById(R.id.lang_ger);
        btn_eng = findViewById(R.id.lang_eng);
        btn_ger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_AboutUs.setText("Über Uns");
                btn_Contact.setText("Kontakt");
                btn_calcAnzahl.setText("Anzahl Berrechnen");
                btn_calcHectar.setText("Hektar Berrechnen");
                Anzahl.setHint("Anzahl");
                Hectar.setHint("Hektar");
                text_Hectar.setText("Hektar :");
                textInputLayout.setHint("Baumart");

                arrayList_trees.set(0, "Fichte");
                arrayList_trees.set(1, "Buche");
                arrayList_trees.set(2, "Kiefer");
                arrayList_trees.set(3, "Eiche");
                lang_eng = false;
            }
        });
        btn_eng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_AboutUs.setText("About Us");
                btn_Contact.setText("Contact");
                btn_calcAnzahl.setText("Calculate Count");
                btn_calcHectar.setText("Calculate Hectar");
                textInputLayout.setHint("Tree");
                Anzahl.setHint("Count");
                Hectar.setHint("Hectar");
                text_Hectar.setText("Hectar :");

                arrayList_trees.set(0, "Spruce");
                arrayList_trees.set(1, "Beech");
                arrayList_trees.set(2, "Pine");
                arrayList_trees.set(3, "Oak");
                lang_eng = true;
            }
        });

        autoCompleteTextView.setThreshold(1);

        btn_calcHectar = findViewById(R.id.btn_hectar);
        btn_calcHectar.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {

                // Gib die Anzahl vor, wie viel in einem Hectar reinpassen
                if(autoCompleteTextView.getText().toString().equals("Fichte") || autoCompleteTextView.getText().toString().equals("Spruce")){
                    x = 400;
                    baumart = true;
                }
                if(autoCompleteTextView.getText().toString().equals("Kiefer") || autoCompleteTextView.getText().toString().equals("Pine")){
                    x = 250;
                    baumart = true;
                }
                if(autoCompleteTextView.getText().toString().equals("Eiche") || autoCompleteTextView.getText().toString().equals("Oak")){
                    x = 100;
                    baumart = true;
                }
                if(autoCompleteTextView.getText().toString().equals("Buche") || autoCompleteTextView.getText().toString().equals("Beech")){
                    x = 150;
                    baumart = true;
                }

                // Berechnet und gib das Ergebnis weiter zur Anzeige
                if(baumart)
                {
                    if ( Anzahl != null && Anzahl.length() > 0)
                    {
                        double y = Double.parseDouble(Anzahl.getText().toString());
                        double erg = y / x;
                        Hectar.setText(String.format("%.2f", erg));
                    }
                        baumart = false;
                }
            }
        });

        btn_calcAnzahl = findViewById(R.id.btn_anzahl);
        btn_calcAnzahl.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {

                // Gib die Anzahl vor, wie viel in einem Hectar reinpassen
                if(autoCompleteTextView.getText().toString().equals("Fichte") || autoCompleteTextView.getText().toString().equals("Spruce")){
                    x = 400;
                    baumart = true;
                }
                if(autoCompleteTextView.getText().toString().equals("Kiefer") || autoCompleteTextView.getText().toString().equals("Pine")){
                    x = 250;
                    baumart = true;
                }
                if(autoCompleteTextView.getText().toString().equals("Eiche") || autoCompleteTextView.getText().toString().equals("Oak")){
                    x = 100;
                    baumart = true;
                }
                if(autoCompleteTextView.getText().toString().equals("Buche") || autoCompleteTextView.getText().toString().equals("Beech")){
                    x = 150;
                    baumart = true;
                }

                // Berechnet und gib das Ergbnis weiter zur Anzeige
                if(baumart)
                {
                    if ( Hectar != null && Hectar.length() > 0){
                        double z = Double.parseDouble(Hectar.getText().toString());
                        double erg2 = z*x;
                        Anzahl.setText(String.format("%.2f", erg2));
                    }
                        baumart = false;
                }
            }
        });
    }

    public void openDialogAbout() {
        DialogAbout dialogAbout = new DialogAbout();
        dialogAbout.lang = lang_eng;
        dialogAbout.show(getSupportFragmentManager(),"About Us Dialog");
    }

    public void openDialogContact() {
        DialogContact dialogContact = new DialogContact();
        dialogContact.lang = lang_eng;
        dialogContact.show(getSupportFragmentManager(),"Contact Dialog");
    }
}