package com.guilherme.fibonaccidinamico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivityFiboDinam extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_fibo_dinam);

        final Button button = (Button) findViewById(R.id.button_fibo);

        final TextView txtresultado = (TextView) findViewById(R.id.text_fibo_result);

        final EditText editindice = (EditText) findViewById(R.id.edit_fibo_index);

        button.setOnClickListener(new View.OnClickListener() {

            long[] resultados = new long[90];

            @Override
            public void onClick(View v) {

                if(editindice.getText().length() == 0)
                {
                    Toast toast = Toast.makeText(getApplicationContext(), "Escolha um índice", Toast.LENGTH_SHORT);
                    toast.show();

                    return;
                }

                int max = Integer.parseInt(editindice.getText().toString());

                if(max <=0 || max >= 90)
                {
                    Toast toast = Toast.makeText(getApplicationContext(), "Escolha um índice entre 1 e 89", Toast.LENGTH_SHORT);
                    toast.show();

                    return;
                }
                else
                {
                    resultados[0] = 0;
                    resultados[1] = 1;
                    resultados[2] = 1;

                    for(int i = 3; i < 90; i++)
                        resultados[i] = -1;

                    txtresultado.setText("O " + max + "º elemento é " + fibonacci(max-1));
                }
            }

            private long fibonacci(int n)
            {
                if(resultados[n] >= 0)
                    return resultados[n];
                else
                {
                    resultados[n] = fibonacci(n - 2) + fibonacci(n - 1);
                    return resultados[n];
                }
            }
        });
    }
}
