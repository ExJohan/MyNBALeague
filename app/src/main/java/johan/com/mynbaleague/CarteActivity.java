package johan.com.mynbaleague;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CarteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carte);
    }

    public void goToItemList(View view){
        startActivity(new Intent(this, ItemListActivity.class));
    }

    public void goToMain(View view){
        startActivity(new Intent(this, MainActivity.class));
    }
}
