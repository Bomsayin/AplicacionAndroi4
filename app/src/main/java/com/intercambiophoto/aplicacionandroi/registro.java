package com.intercambiophoto.aplicacionandroi;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class registro extends AppCompatActivity {
    private RadioButton selecionarRBT;
  // RadioButton op1,op2,op3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro2);
        //op1=(RadioButton) findViewById(R.id.rbFemenino);
        //op2=(RadioButton) findViewById(R.id.rbMasculino);
        //op3=(RadioButton) findViewById(R.id.rbOtro);

    }
    public void btnRBT(View v){
        if(selecionarRBT.isChecked()==true){
           String mensaje ="Seleccionado";
            Toast toast = Toast.makeText(this,"Seleccionado!",Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.START,90,0);
            toast.show();
        }
        else{
            String mensaje = "No Seleccionado";
            Toast.makeText(this,mensaje,Toast.LENGTH_LONG).show();
        }
    }
    //public void onclick(View view){
      //  if (view.getId()==R.id.btnCrearUsu){
            //validar();
        //}
    //}
    //private void validar(){
        //String cad ="Seleccionado;\n";

        //if (op1.isChecked()==true){
          //cad+="Opcion1\n";
        //}
        //if (op2.isChecked()){
           //cad+="Opcion2";
        //}
        //if (op3.isChecked()){
            //cad+="Opcion3";
        //}

    //}
}