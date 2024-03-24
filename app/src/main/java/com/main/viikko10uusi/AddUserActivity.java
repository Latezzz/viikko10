package com.main.viikko10uusi;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddUserActivity extends AppCompatActivity {

    private EditText firstName;
    private EditText lastName;
    private EditText email;
    private RadioGroup studyProgram;
    private Context context;

    private CheckBox bcCheckBox;
    private CheckBox msCheckBox;
    private CheckBox lciCheckBox;
    private CheckBox phdCheckBox;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_user);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        firstName = findViewById(R.id.editFirstName);
        lastName = findViewById(R.id.editLastName);
        email = findViewById(R.id.editEmail);
        studyProgram = findViewById(R.id.radioDegreeProgram);
        bcCheckBox = findViewById(R.id.bcCheckBox);
        msCheckBox = findViewById(R.id.msCheckBox);
        lciCheckBox = findViewById(R.id.lciCheckBox);
        phdCheckBox = findViewById(R.id.phdCheckBox);

        context = this;

    }

    public void addUser(View view) {
        String program;
        String first_Name = firstName.getText().toString();
        String last_Name = lastName.getText().toString();
        String e_mail= email.getText().toString();

        int id = studyProgram.getCheckedRadioButtonId();
        if (id == R.id.seRadioButton) {
            program = "Software Engineering";
        }
        else if (id == R.id.imRadioButton) {
            program = "Industrial Engineering";
        }
        else if (id == R.id.ceRadioButton) {
            program = "Computational Engineering";
        }
        else if (id == R.id.eeRadioButton) {
            program = "Electrical Engineering";
        }
        else {
            program = "";
        }

        Boolean bachelor = bcCheckBox.isChecked();
        Boolean master = msCheckBox.isChecked();
        Boolean licentiate = lciCheckBox.isChecked();
        Boolean doctor = phdCheckBox.isChecked();

        UserStorage.getInstance().addUser(new User(first_Name,last_Name,e_mail,program, bachelor, master, licentiate, doctor));
        //UserStorage.getInstance().saveUsers(context);

    }
}