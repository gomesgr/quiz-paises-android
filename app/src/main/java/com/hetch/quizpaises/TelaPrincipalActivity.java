package com.hetch.quizpaises;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class TelaPrincipalActivity extends Activity {
    private static final String TAG = "TelaPrincipalActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.telaprincipal);

        final Button BTN_START = this.findViewById(R.id.btnStart);
        final Button BTN_EXIT = this.findViewById(R.id.btnQuitFromInitialPage);
        final EditText EDT_NOME_USUARIO = this.findViewById(R.id.edtNomeUsuario);

        BTN_START.setOnClickListener((view) -> {
            String nome = EDT_NOME_USUARIO.getText().toString();
            Intent it = new Intent(this, TelaPerguntasActivity.class);
            if(nome.equals("")) {
                runOnUiThread(() -> new AlertDialog.Builder(this)
                        .setTitle("Erro de continuidade")
                        .setMessage("Digite um nome para continuar")
                        .setNeutralButton("Ok", (dialog, which) -> dialog.dismiss())
                        .create().show());
            } else {
                it.putExtra("usuario", nome);
                startActivity(it);
            }
        });

        BTN_EXIT.setOnClickListener((view) -> {
            finishAffinity();
        });

    }


}
