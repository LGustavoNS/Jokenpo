package com.example.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view){
        this.opcaoSelecionada("pedra");
    }

    public void selecionadoPapel(View view){
        this.opcaoSelecionada("papel");
    }

    public void selecionadoTesoura(View view){
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada (String escolhaUsuario) {

        ImageView img_padrao = findViewById(R.id.img_padrao);
        TextView txt_escolha_op = findViewById(R.id.txt_escolha_op);

        int numero = new Random().nextInt(3);
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String escolhaApp = opcoes [ numero ];

        switch ( escolhaApp ) {
            case "pedra":
                img_padrao.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                img_padrao.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                img_padrao.setImageResource(R.drawable.tesoura);
                break;
        }

        if(
                        (escolhaApp == "tesoura" && escolhaUsuario == "papel") ||
                        (escolhaApp == "papel" && escolhaUsuario == "pedra") ||
                        (escolhaApp == "pedra" && escolhaUsuario == "tesoura")
        ){ //App ganhador
            txt_escolha_op.setText("PERDEU. Tenta de novo hehe ");
        } else if (
                        (escolhaUsuario == "tesoura" && escolhaApp == "papel") ||
                        (escolhaUsuario == "papel" && escolhaApp == "pedra") ||
                        (escolhaUsuario == "pedra" && escolhaApp == "tesoura")
        ) { //Usuario ganhador
            txt_escolha_op.setText("Parabéns!!! VENCEDOR ");
        } else { //Empate
            txt_escolha_op.setText("Jogo Empatado");
        }

        System.out.println("item clicado: " + escolhaApp);

    }

}