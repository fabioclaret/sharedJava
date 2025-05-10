package android.fabioclaret.modularcleitonpamisharedpreferences;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText email, senha;
    Button gravar;
    //criando uma constante
    public static final String NOME_ARQ = "cliente";
    SharedPreferences preferences;
    SharedPreferences.Editor dados;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //4° passo - ligando tela com código
        initComponents();

        //5° passo - criando evento de click
        gravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //6° passo - criando a lógica

                preferences = getSharedPreferences(NOME_ARQ,MODE_PRIVATE);
                dados = preferences.edit();

                String varEmail = email.getText().toString();
                String varSenha = senha.getText().toString();

                dados.putString("email", varEmail);
                dados.putString("senha", varSenha);

                dados.apply();

                boolean isOk = validarCampos();
                if (isOk){
                    Toast.makeText(MainActivity.this, "Campos Preenchidos", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validarCampos(){
        return ( !email.getText().toString().isEmpty()) && ( !senha.getText().toString().isEmpty() );
    }



    private void initComponents() {
        //inicializa os componentes
        email  = findViewById(R.id.edt_email);
        senha  = findViewById(R.id.edt_senha);
        gravar = findViewById(R.id.btn_gravar);
    }
}