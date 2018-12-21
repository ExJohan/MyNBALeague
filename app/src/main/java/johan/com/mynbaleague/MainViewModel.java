package johan.com.mynbaleague;

import android.content.Intent;
import android.databinding.ObservableField;

public class MainViewModel {
    public ObservableField<String> helloTextField = new ObservableField<>();
    public ObservableField<String> buttonText = new ObservableField<>();
    public ObservableField<String> mailExample = new ObservableField<>();
    public ObservableField<String> mdpExample = new ObservableField<>();
    public ObservableField<String> title = new ObservableField<>();

    public MainViewModel(){
        mailExample.set("exemple@exemple.com");
        mdpExample.set("");
        title.set("Ma NBA Ligue");
        helloTextField.set("Hello World");
        buttonText.set("Poursuivre vers l'application");
    }

    public String getMail(){
        return mailExample.get();
    }
    public String getMdp(){
        return mdpExample.get();
    }


}
