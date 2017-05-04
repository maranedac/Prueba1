package cl.mac.prueba1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Log.d("Sex", sex);

        Button access = (Button) findViewById(R.id.accessBtn);

        access.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                final EditText nameEt = (EditText) findViewById(R.id.nameEt);
                final String name = nameEt.getText().toString();

                final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.genderRg);
                final int id = radioGroup.getCheckedRadioButtonId();


                if (name.trim().length() < 1) {
                    Toast.makeText(LoginActivity.this, "Debes ingresar tu nombre", Toast.LENGTH_SHORT).show();
                } else if (id == -1) {
                    Toast.makeText(LoginActivity.this, "Debes seleccionar tu sexo", Toast.LENGTH_SHORT).show();
                } else {
                    RadioButton radioButton = (RadioButton) radioGroup.findViewById(id);
                    String gender = radioButton.getText().toString();

                    Intent intent = new Intent(LoginActivity.this, CalculatorActivity.class);
                    intent.putExtra("Nombre", name);
                    intent.putExtra("Genero", gender);
                    startActivity(intent);

                }
            }
        });

    }


}
