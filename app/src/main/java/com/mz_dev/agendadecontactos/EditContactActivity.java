package com.mz_dev.agendadecontactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Objects;

public class EditContactActivity extends AppCompatActivity {

    private EditText etMainFullName, etMainTelephone, etMainEmail, etMainDescription;
    private Button btnDateCancel, btnDateOk, btnMainNext;
    private DatePicker calendarBirthDate;
    public static final String CONTACT_CODE = "ContactObject";
    private Contact contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        initUI();
        initListener();
    }

    private void initUI(){
        etMainFullName = findViewById(R.id.etMainFullName);
        etMainTelephone = findViewById(R.id.etMainTelephone);
        etMainEmail = findViewById(R.id.etMainEmail);
        etMainDescription = findViewById(R.id.etMainDescription);
        btnDateCancel = findViewById(R.id.btnDateCancel);
        btnDateOk = findViewById(R.id.btnDateOk);
        btnMainNext = findViewById(R.id.btnMainNext);
        calendarBirthDate = findViewById(R.id.calendarDateOfBrith);
    }

    private void initListener(){
        btnDateCancel.setOnClickListener(item ->{
            //TODO: implement this method
        });
        btnDateOk.setOnClickListener(item ->{
            //TODO: implement this method
        });
        btnMainNext.setOnClickListener(item ->{
            //if (!dataVerify()) return;
            saveContact();
            confirmationData();
        });
    }

    private void saveContact(){
        String fullName = etMainFullName.getText().toString();
        String telephone = etMainTelephone.getText().toString();
        String email = etMainEmail.getText().toString();
        String description = etMainDescription.getText().toString();
        String birthDate = calendarBirthDate.getDayOfMonth()
                + "/" + calendarBirthDate.getMonth()
                + "/" + calendarBirthDate.getYear();
        contact = new Contact(
                fullName,
                birthDate,
                telephone,
                email,
                description
        );
    }

    private void confirmationData(){
        Intent intent = new Intent(this, ConfirmationActivity.class);
        intent.putExtra(CONTACT_CODE, contact);
        startActivity(intent);
    }

    private Boolean dataVerify(){
        if (etMainFullName.getText().toString().isEmpty()) return false;
        return true;
    }
}