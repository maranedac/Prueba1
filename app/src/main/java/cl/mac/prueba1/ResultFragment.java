package cl.mac.prueba1;


import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.button;


/**
 * A simple {@link Fragment} subclass.
 */
public class ResultFragment extends Fragment {


    public ResultFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        final EditText height = (EditText) view.findViewById(R.id.heightEt);
        final EditText weight = (EditText) view.findViewById(R.id.weightEt);
        final TextView result = (TextView) view.findViewById(R.id.resultTv);
        final TextView imcTv = (TextView) view.findViewById(R.id.resultImc);

        Button button = (Button) view.findViewById(R.id.calculateBtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String genero = getActivity().getIntent().getStringExtra("Genero");

                double value1 = Double.parseDouble(height.getText().toString());
                int value2 = Integer.parseInt(weight.getText().toString());
                double mtrs = value1 / 100;
                double imc = value2 / (mtrs * mtrs);


                if (genero.equals("Hombre")) {
                    double wideal = 0.75 * value1 - 62.5;

                    result.setText(String.valueOf(wideal));
                    imcTv.setText(String.format("%.2f", imc));

                } else {
                    double wideal = 0.675 * value1 - 56;

                    result.setText(String.valueOf(wideal));
                    imcTv.setText(String.format("%.2f", imc));
                }
            }
        });
    }

}

