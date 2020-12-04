package com.example.connect;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /*Estados:
        0 para amarillo
        1 para rojo
        2 para vacío
     */

    /* Falta:
     *mejorar la interacción al tocar las piezas (IMPORTANTE) *HECHO
     *Agregar el about *HECHO
     *Investigar como agregar efectos de sonido *no necesario
     *Investigar como establecer el icono de la aplicacion
     *Exportar apk
    */

    int[] estadoDeJuego = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] posDeGane = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int jugador = 0;
    boolean juegoActivo = true;
    int tokens = 0;
    int info = 0; //1: info desplegada, 0: info escondida

    public void empezar(View view){
        ImageView imageViewLogo = (ImageView)findViewById(R.id.imageViewLogo);
        ImageView imageViewEmpezar = (ImageView)findViewById(R.id.imageViewEmpezar);
        TextView textViewVersion = (TextView)findViewById(R.id.textViewVersion);
        imageViewLogo.animate().alpha(0).setDuration(3000);
        textViewVersion.animate().alpha(0).setDuration(3000);
        imageViewEmpezar.animate().alpha(0).scaleY(0.1f).scaleX(0.1f).setDuration(500).setStartDelay(1000);

        ImageView imageViewGrid = (ImageView)findViewById(R.id.imageViewGrid);
        TextView textViewDetalles = (TextView)findViewById(R.id.textViewDetalles);
        ImageView imageViewAbout = (ImageView)findViewById(R.id.imageViewAbout);
        imageViewGrid.setVisibility(View.VISIBLE);
        textViewDetalles.setVisibility(View.VISIBLE);
        imageViewAbout.setVisibility(View.VISIBLE);
        imageViewGrid.animate().alpha(1).setDuration(3000).setStartDelay(3000);
        imageViewAbout.animate().alpha(1).setDuration(3000).setStartDelay(3000);
        textViewDetalles.animate().alpha(1).setDuration(3000).setStartDelay(3000);

        //ahora hacemos las piezas visibles
        ImageView pieza0 = (ImageView)findViewById(R.id.imageViewPieza0);

        pieza0.setVisibility(View.VISIBLE);
        ImageView pieza1 = (ImageView)findViewById(R.id.imageViewPieza1);
        pieza1.setVisibility(View.VISIBLE);
        ImageView pieza2 = (ImageView)findViewById(R.id.imageViewPieza2);
        pieza2.setVisibility(View.VISIBLE);
        ImageView pieza3 = (ImageView)findViewById(R.id.imageViewPieza3);
        pieza3.setVisibility(View.VISIBLE);
        ImageView pieza4 = (ImageView)findViewById(R.id.imageViewPieza4);
        pieza4.setVisibility(View.VISIBLE);
        ImageView pieza5 = (ImageView)findViewById(R.id.imageViewPieza5);
        pieza5.setVisibility(View.VISIBLE);
        ImageView pieza6 = (ImageView)findViewById(R.id.imageViewPieza6);
        pieza6.setVisibility(View.VISIBLE);
        ImageView pieza7 = (ImageView)findViewById(R.id.imageViewPieza7);
        pieza7.setVisibility(View.VISIBLE);
        ImageView pieza8 = (ImageView)findViewById(R.id.imageViewPieza8);
        pieza8.setVisibility(View.VISIBLE);
    }

    public void aparecer(View view){
        ImageView contador = (ImageView)view;
        int contadorPresionado = Integer.parseInt(contador.getTag().toString());

        if(estadoDeJuego[contadorPresionado] == 2 && juegoActivo){
            estadoDeJuego[contadorPresionado] = jugador;

            if(jugador == 0){
                contador.setImageResource(R.drawable.amarilla);
                jugador = 1;
            }else{
                contador.setImageResource(R.drawable.roja);
                jugador = 0;
            }
            contador.animate().scaleX(-1).scaleY(-1).setDuration(500);

            for(int[] posiciones : posDeGane){
                if(estadoDeJuego[posiciones[0]] == estadoDeJuego[posiciones[1]] && estadoDeJuego[posiciones[1]] == estadoDeJuego[posiciones[2]] && estadoDeJuego[posiciones[0]] != 2){
                    //Alguien gano
                    juegoActivo = false;
                    String ganador = "";
                    if(jugador == 1){
                        ganador = "Amarillo";
                    }else{
                        ganador = "rojo";
                    }

                    ImageView imageViewReinicio = (ImageView)findViewById(R.id.imageViewReinicio);
                    TextView textViewAnunciante = (TextView)findViewById(R.id.textViewAnunciante);
                    textViewAnunciante.setText(ganador += " ha ganado!");
                    textViewAnunciante.setVisibility(View.VISIBLE);
                    imageViewReinicio.setVisibility(View.VISIBLE);
                    imageViewReinicio.animate().scaleY(2).scaleX(2).setDuration(1000);
                    tokens = 0;

                }
            }
            tokens = tokens + 1;
            if(tokens==9){
                ImageView imageViewReinicio = (ImageView)findViewById(R.id.imageViewReinicio);
                TextView textViewAnunciante = (TextView)findViewById(R.id.textViewAnunciante);
                textViewAnunciante.setText("No hubo ganador");
                textViewAnunciante.setVisibility(View.VISIBLE);
                imageViewReinicio.setVisibility(View.VISIBLE);
                imageViewReinicio.animate().scaleY(2).scaleX(2).setDuration(1000);
            }
        }

    }

    public void reiniciar(View view){
        ImageView imageViewReiniciar = (ImageView)findViewById(R.id.imageViewReinicio);
        TextView textViewAnunciante = (TextView)findViewById(R.id.textViewAnunciante);
        textViewAnunciante.setVisibility(View.INVISIBLE);
        imageViewReiniciar.setVisibility(View.INVISIBLE);

        ImageView imageViewpieza0 = (ImageView)findViewById(R.id.imageViewPieza0);
        imageViewpieza0.setImageDrawable(null);
        ImageView imageViewpieza1 = (ImageView)findViewById(R.id.imageViewPieza1);
        imageViewpieza1.setImageDrawable(null);
        ImageView imageViewpieza2 = (ImageView)findViewById(R.id.imageViewPieza2);
        imageViewpieza2.setImageDrawable(null);
        ImageView imageViewpieza3 = (ImageView)findViewById(R.id.imageViewPieza3);
        imageViewpieza3.setImageDrawable(null);
        ImageView imageViewpieza4 = (ImageView)findViewById(R.id.imageViewPieza4);
        imageViewpieza4.setImageDrawable(null);
        ImageView imageViewpieza5 = (ImageView)findViewById(R.id.imageViewPieza5);
        imageViewpieza5.setImageDrawable(null);
        ImageView imageViewpieza6 = (ImageView)findViewById(R.id.imageViewPieza6);
        imageViewpieza6.setImageDrawable(null);
        ImageView imageViewpieza7 = (ImageView)findViewById(R.id.imageViewPieza7);
        imageViewpieza7.setImageDrawable(null);
        ImageView imageViewpieza8 = (ImageView)findViewById(R.id.imageViewPieza8);
        imageViewpieza8.setImageDrawable(null);

        for(int i=0; i<estadoDeJuego.length; i++){
            estadoDeJuego[i] = 2;
        }
        jugador = 0;
        juegoActivo = true;
        tokens = 0;

    }

    public void informacion(View view){
        ImageView imageViewnombres = (ImageView)findViewById(R.id.imageViewNombres);
        imageViewnombres.setVisibility(View.VISIBLE);
        if(info == 0){
            imageViewnombres.animate().translationXBy(50).setDuration(1000);
            //imageViewnombres.animate().scaleX(1f).scaleY(1f).setDuration(1000);
            info = 1;
        }else{
            imageViewnombres.animate().translationX(-50).setDuration(1000);
            imageViewnombres.setVisibility(View.INVISIBLE);
            info = 0;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageViewLogo = (ImageView)findViewById(R.id.imageViewLogo);
        ImageView imageViewEmpezar = (ImageView)findViewById(R.id.imageViewEmpezar);
        TextView textViewVersion = (TextView)findViewById(R.id.textViewVersion);
        imageViewLogo.setVisibility(View.VISIBLE);
        imageViewEmpezar.setVisibility(View.VISIBLE);
        textViewVersion.setVisibility(View.VISIBLE);
        imageViewLogo.animate().alpha(1).setDuration(3000).setStartDelay(1000);
        textViewVersion.animate().alpha(1).setDuration(3000).setStartDelay(1000);
        imageViewEmpezar.animate().alpha(1).scaleY(1.5f).scaleX(1.5f).setDuration(500).setStartDelay(3000);

    }
}
