package com.mz_dev.agendadecontactos;

import static com.mz_dev.agendadecontactos.EditContactActivity.CONTACT_CODE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class ConfirmationActivity extends AppCompatActivity {

    private TextView tvConfirmationFullName, tvConfirmationBirthDate, tvConfirmationTelephone, tvConfirmationEmail, tvConfirmationDescription;
    private Button btnEditData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        initUI();
        initListener();
        Intent intent = getIntent();
        if (intent != null) {
            Contact receivedContact = (Contact) intent.getSerializableExtra(CONTACT_CODE);
            if (receivedContact != null) {
                fillData(receivedContact);
            }
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    private void initUI() {
        tvConfirmationFullName = findViewById(R.id.tvConfirmationFullName);
        tvConfirmationBirthDate = findViewById(R.id.tvConfirmationBirthDate);
        tvConfirmationTelephone = findViewById(R.id.tvConfirmationTelephone);
        tvConfirmationEmail = findViewById(R.id.tvConfirmationEmail);
        tvConfirmationDescription = findViewById(R.id.tvConfirmationDescription);
        btnEditData = findViewById(R.id.btnEditData);
    }

    private void initListener(){
        btnEditData.setOnClickListener(v -> finish());
    }

    private void fillData(Contact contact) {
        tvConfirmationFullName.setText(contact.getFullName());
        tvConfirmationBirthDate.setText(contact.getBirthDate());
        tvConfirmationTelephone.setText(contact.getTelephone());
        tvConfirmationEmail.setText(contact.getEmail());
        tvConfirmationDescription.setText(contact.getDescription());
    }
}