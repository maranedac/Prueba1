package cl.mac.prueba1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {


    //private EditText height, weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        TextView nombre = (TextView) findViewById(R.id.nameTv);
        String name = getIntent().getStringExtra("Nombre");
        nombre.setText(name);

    }


}
