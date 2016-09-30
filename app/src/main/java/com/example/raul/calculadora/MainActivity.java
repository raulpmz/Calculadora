package com.example.raul.calculadora;

import android.media.MediaCodec;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.regex.Pattern;

import static com.example.raul.calculadora.R.id.bComa;

public class MainActivity extends AppCompatActivity {

    //Declaro variables.

    public TextView tv;
    String n, pantalla, op;
    double d1, mc, m;
    Button b;
    ImageButton ib;
    boolean opp, rest, ope, coma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView)findViewById(R.id.tv);
        tv.setText("");
        n = "";
        pantalla = "";
        op = "";
        d1 = 0;
        mc = 0;
        m = 0;
        opp = false;
        rest = false;
        ope = false;
    }

    public void pulsarNumero(View v) {

        b = (Button) findViewById(v.getId());

        if (tv.getText() == "0"){
            tv.setText("");
            System.out.println("Borra el primer cero");
        }

        pantalla = "" + tv.getText();

        if (!opp && !rest){

            pantalla += b.getText().toString();
            tv.setText(pantalla);
            System.out.println("Entra solo if");

        } else{

            tv.setText(b.getText());
            opp = false;
            rest = false;
            System.out.println("Entra else");
        }
    }

    public void pulsarOperador(View v){

        n = op;
        b = (Button) findViewById(v.getId());
        op = "" + b.getText();
        System.out.println(op);


            if(!ope){

                d1 = Double.parseDouble("" + tv.getText());
                ope = true;

            }else {

                d1 = calcular(d1,Double.parseDouble(""+ tv.getText()), n);
                tv.setText("" + d1);

            }

        opp = true;
    }

    public void pulsarComa(View v){

        b = (Button) findViewById(v.getId());
        String tf;
        tf = "" + tv.getText();

        if(!tf.contains(".")) {

            tf += "" + b.getText();
            tv.setText(tf);

        }

    }

    public void pulsarMC(View v){

        b = (Button) findViewById(v.getId());
        mc = Double.parseDouble( ""+ tv.getText());

    }

    public void pulsarMR(View v){

        b = (Button) findViewById(v.getId());
        d1 = calcular(d1, mc, op);
        tv.setText("" + d1);
        ope = false;
        rest = true;

    }

    public void pulsarIgual(View v){

        double resultado = calcular(d1, Double.parseDouble(tv.getText().toString()), op);
        tv.setText("" + resultado);
        ope = false;
        rest = true;

    }

    public void pulsarEliminar(View v){

        ib = (ImageButton) findViewById(v.getId());
        String tf;
        tf = "" + tv.getText();
        if(!tf.isEmpty()) {

            tf = tf.substring(0, tf.length() - 1);
            tv.setText(tf);
            opp = false;
            rest = false;
        }

    }

    public double calcular(double n1, double n2, String op){

        double c = 0.0;

        switch(op){
            case "+" : c = n1 + n2;
                break;
            case "-" : c = n1 - n2;
                break;
            case "*" : c = n1 * n2;
                break;
            case "/" : c = n1 / n2;
                break;
        }
        return c;
    }

    public void pulsarC(View v){

        tv.setText("0");
        pantalla = "";
        op = "";
        d1 = 0.0;
        n = "";
        ope = false;
        opp = false;
    }
}
