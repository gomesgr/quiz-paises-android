package com.hetch.quizpaises;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.List;

public class TelaPerguntasActivity extends Activity {
    private static final String TAG = "TelaPerguntasActivity";
    private Integer i = 0;
    private static Integer pontos = 0;

    public static void setPontos(Integer pontos) {
        TelaPerguntasActivity.pontos = pontos;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.telaperguntas);

        final ImageView IMG = this.findViewById(R.id.img);
        final TextView TXT_NOME_USUARIO = this.findViewById(R.id.txtNomeUsuarioPerguntas);
        final Button BTN_RESPONDER = this.findViewById(R.id.btnResponder);
        final RadioGroup RD_GROUP = this.findViewById(R.id.rdGroup);
        final RadioButton[] BUTTONS = {
                this.findViewById(R.id.rdFirst),
                this.findViewById(R.id.rdSecond),
                this.findViewById(R.id.rdThird),
                this.findViewById(R.id.rdFourth)
        };

        Bundle extras = getIntent().getExtras();
        String nomeUsuario = extras.getString("usuario");
        TXT_NOME_USUARIO.setText("Bem vindo " + nomeUsuario);

        HandlePaises handlePaises = new HandlePaises();
        List<Questao> questoesProntas = handlePaises.getQuestoes();

        BUTTONS[0].setText(questoesProntas.get(0)
                .getPrimeiraAlternativa());
        BUTTONS[1].setText(questoesProntas.get(0)
                .getSegundaAlternativa());
        BUTTONS[2].setText(questoesProntas.get(0)
                .getTerceiraAlternativa());
        BUTTONS[3].setText(questoesProntas.get(0)
                .getQuartaAlternativa());

        IMG.setImageResource(questoesProntas.get(0).getBandeira());

        Log.i(TAG, "onClick: questao correta " + questoesProntas.get(i).getCorreta());

        BTN_RESPONDER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            boolean go = false;

                for (int j = 0; j < 4; j++) {
                    if (BUTTONS[j].isChecked()) {
                        if (j == questoesProntas.get(i).getCorreta()) {
                            pontos++;
                        }
                        go = true;
                    }
                }
                if (!go) {
                    runOnUiThread(() -> new AlertDialog.Builder(TelaPerguntasActivity.this)
                            .setTitle("Erro de continuidade")
                            .setMessage("Escolha pelo menos uma alternativa")
                            .setNeutralButton("Ok", ((dialog, which) -> dialog.dismiss()))
                            .create().show()
                    );
                } else {
                    RD_GROUP.clearCheck();
                    i++;
                    if (i < 10) {
                        Log.i(TAG, "onClick: questao correta " + questoesProntas.get(i).getCorreta());
                        BUTTONS[0].setText(questoesProntas.get(i)
                                .getPrimeiraAlternativa());
                        BUTTONS[1].setText(questoesProntas.get(i)
                                .getSegundaAlternativa());
                        BUTTONS[2].setText(questoesProntas.get(i)
                                .getTerceiraAlternativa());
                        BUTTONS[3].setText(questoesProntas.get(i)
                                .getQuartaAlternativa());
                        IMG.setImageResource(questoesProntas.get(i).getBandeira());
                        Log.i(TAG, "onClick: questao pontos " + pontos);
                    } else {
                        Intent it = new Intent(TelaPerguntasActivity.this,
                                TelaFinalActivity.class);
                        it.putExtra("acertos", pontos);
                        it.putExtra("usuario", nomeUsuario);
                        startActivity(it);
                    }
                }
            }
        });

    }
}
