package barbosa.souza.eduardo.carlos.email;

import androidx.appcompat.app.AppCompatActivity;
// importando todas as funcionalidades necessárias
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//classe do MainActivity
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Retornando o botão btnEnviar pelo id
        Button btnEnviar = (Button) findViewById(R.id.btnEnviar);
        //Definição da ação do click do botão

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtendo dados digitados pelo usuário

                // Retornando o texto etEmail pelo id
                EditText etEmail = (EditText) findViewById(R.id.etEmail);
                String email = etEmail.getText().toString();
                // Retornando o texto etAssunto pelo id
                EditText etAssunto = (EditText) findViewById(R.id.etAssunto);
                String assunto = etAssunto.getText().toString();
                // Retornando o texto etTexto pelo id
                EditText etTexto = (EditText) findViewById(R.id.etTexto);
                String texto = etTexto.getText().toString();
                // Criando uma nova intente e atribuindo uma ação a ela
                Intent i = new Intent(Intent.ACTION_SENDTO);
                i.setData(Uri.parse("mailto:"));
                // Criando uma array de Emails
                String[] emails = new String[] {email};
                // Adicionar valores ao Bundle interno da Intente
                i.putExtra(Intent.EXTRA_EMAIL, emails);
                // Adicionar valores ao Bundle interno da Intente
                i.putExtra(Intent.EXTRA_SUBJECT,assunto);
                // Adicionar valores ao Bundle interno da Intente
                i.putExtra(Intent.EXTRA_TEXT,texto);
                // tentar caso haja exceção
                try {
                    startActivity(Intent.createChooser(i, "Escolha o app"));
               // marcando um bloco de declarações para testar
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MainActivity.this, "Não há nenhum app que possa realizar essa operação" , Toast.LENGTH_LONG).show();
                }
            }});
    }
    }
