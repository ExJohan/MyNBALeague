package johan.com.mynbaleague;

import android.databinding.ObservableField;
import android.widget.Toast;

import java.util.Random;

public class ItemViewModel {

    public ObservableField<String> title = new ObservableField<>();

    public ItemViewModel(String itemName){
        assign(itemName);
    }

    public void rename(String name) {
        assign(name);
    }

    private void assign(String itemName) {
        title.set(itemName);

    }

}