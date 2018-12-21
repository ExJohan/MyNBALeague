package johan.com.mynbaleague;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import java.util.Observable;

import johan.com.mynbaleague.databinding.ActivityMainBinding;




public class MainActivity extends AppCompatActivity {
    private FirebaseAuth.AuthStateListener authListener;
    private FirebaseAuth mAuth;

    EditText themail;
    EditText thepass;

    TextView etat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(new MainViewModel());

        mAuth = FirebaseAuth.getInstance();

    }
    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        etat = (TextView) findViewById(R.id.theEtat);
    }

    public void goToItemList(View view){
        startActivity(new Intent(this, ItemListActivity.class));
    }

    public void createpassword(View view) {
        themail = (EditText) findViewById(R.id.themail); //Je n'ai pas réussi a récupérer ces données dans MainActivity avec le MVVM
        thepass   = (EditText)findViewById(R.id.thepassword);
        //Log.e("Salut","mail : "+email);
       String email = themail.getText().toString();
       String password = thepass.getText().toString();
       if(email == ""){
           Toast.makeText(MainActivity.this, "Veuillez entrer votre adresse email",
                   Toast.LENGTH_LONG).show();
       }else if(password.length() < 6 ){
           Toast.makeText(MainActivity.this, "Veuillez entrer votre mot de passe de 6 caractères minimum",
               Toast.LENGTH_LONG).show();
        }else{
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d("Salut", "createUserWithEmail:success");
                            Toast.makeText(MainActivity.this, "Compte créé avec succès !",
                                    Toast.LENGTH_SHORT).show();
                            FirebaseUser user = mAuth.getCurrentUser();
                        } else {
                            Toast.makeText(MainActivity.this, "Impossible de créer ce compte, adresse mail déjà existante ou incorrecte",
                                Toast.LENGTH_LONG).show();
                        }

                        // ...
                    }
                });
       }
    }

    public void signIn(View view){
        themail = (EditText) findViewById(R.id.themail);
        thepass   = (EditText)findViewById(R.id.thepassword);
        //Log.e("Salut","mail : "+email);
        String email = themail.getText().toString();
        String password = thepass.getText().toString();
        if(email == ""){
            Toast.makeText(MainActivity.this, "Veuillez entrer votre adresse email",
                    Toast.LENGTH_LONG).show();
        }else if(password.length() < 6 ){
            Toast.makeText(MainActivity.this, "Veuillez entrer votre mot de passe de 6 caractères minimum",
                    Toast.LENGTH_LONG).show();
        }else {
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                FirebaseUser user = mAuth.getCurrentUser();
                                Toast.makeText(MainActivity.this, "Vous êtes connecté avec succès avec l'adresse "+ user.getEmail(),
                                        Toast.LENGTH_LONG).show();
                                etat.setText("Vous êtes connecté avec l'adresse " + user.getEmail());
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(MainActivity.this, "Email ou mot de passe incorrecte",
                                        Toast.LENGTH_LONG).show();
                            }

                            // ...
                        }
                    });
        }
    }



}
