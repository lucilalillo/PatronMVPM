package com.example.patronmvpm;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<String> resultadoMutable;

    public MutableLiveData<String> getResultadoMutable() {
        if(resultadoMutable == null){
            resultadoMutable = new MutableLiveData<>();
        }
        return resultadoMutable;
    }

    public void calcular(String n1, String n2){
        int num1 = 0;
        int num2 = 0;
        try {
             num1 = Integer.parseInt(n1);
             num2 = Integer.parseInt(n2);
             int res = num1+num2;
             resultadoMutable.setValue(res+" ");
        }
        catch (Exception ex){
            resultadoMutable.setValue("No son numeros");
        }

    }
}
