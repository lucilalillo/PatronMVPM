package com.example.patronmvpm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private MainActivityViewModel vm;
    private Button btResultado;
    private EditText nro1, nro2, resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        inicializarVista();

        vm.getResultadoMutable().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                resultado.setText(s);
            }
        });
    }

    public void inicializarVista(){
        nro1 = findViewById(R.id.num1);
        nro2 = findViewById(R.id.num2);

        resultado = findViewById(R.id.resul);
        btResultado = findViewById(R.id.btResultado);

        btResultado.setOnClickListener(new View.OnClickListener(){
            public  void onClick(View v){
                vm.calcular(nro1.getText().toString(),nro2.getText().toString());
            }
        });
    }
}