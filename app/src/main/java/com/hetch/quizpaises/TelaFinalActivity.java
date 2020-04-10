package com.hetch.quizpaises;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class TelaFinalActivity extends Activity {
    private static final String TAG = "TelaFinalActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.telafinal);
        TelaPerguntasActivity.setPontos(0);

        Bundle extras = getIntent().getExtras();
        final Button BTN_AGAIN = this.findViewById(R.id.btnAgain);
        final Button BTN_MAIN_MENU = this.findViewById(R.id.btnQuit);
        final TextView TXT_NOME_USUARIO = this.findViewById(R.id.txtNomeUsuarioFinal);
        final TextView TXT_ACERTOS = this.findViewById(R.id.txtAcertos);
        String pontos = String.valueOf(extras.getInt("acertos"));
        String nomeUsuario = extras.getString("usuario");
        TXT_NOME_USUARIO.setText(nomeUsuario);
        TXT_ACERTOS.setText(pontos);
        Log.d(TAG, "onCreate: Mudado! " + pontos);

        BTN_AGAIN.setOnClickListener((view) -> {
            Intent it = new Intent(TelaFinalActivity.this, TelaPerguntasActivity.class);
            it.putExtra("usuario", nomeUsuario);
            startActivity(it);
        });

        BTN_MAIN_MENU.setOnClickListener((view) -> {
            Intent it = new Intent(TelaFinalActivity.this, TelaPrincipalActivity.class);
            startActivity(it);
        });

    }
}
