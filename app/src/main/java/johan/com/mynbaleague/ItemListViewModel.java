package johan.com.mynbaleague;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ItemListViewModel {

    public ObservableField<String> screenTitle = new ObservableField<>();
    public ObservableField<String> textMakeTeam = new ObservableField<>();
    public ObservableField<String> textNewTeam = new ObservableField<>();
    public ObservableArrayList<ItemViewModel> items = new ObservableArrayList<>();
    Context cont;
    private String m_Text = "";
    private String isChanged;

    public ItemListViewModel(Context context) {
        cont = context;

        screenTitle.set("Votre Liste NBA ! Vous pouvez renommer ou supprimer une équipe en cliquant dessus.");
        textMakeTeam.set("Nom de l'équipe a créer : ");
        textNewTeam.set("Esiarques d'Ivry sur Seine");

        generateItem("Nuggets de Denver");
        generateItem("Timberwolves du Minnesota");
        generateItem("Thunder d'Oklahoma City");
        generateItem("Trail Blazers de Portland");
        generateItem("Jazz de l'Utah");
        generateItem("Warriors de Golden State");
        generateItem("Clippers de Los Angeles");
        generateItem("Lakers de Los Angeles");
        generateItem("Suns de Phoenix");
        generateItem("Kings de Sacramento");
        generateItem("Mavericks de Dallas");
        generateItem("Rockets de Houston");
        generateItem("Grizzlies de Memphis");
        generateItem("Pelicans de La Nouvelle-Orléans");
        generateItem("Spurs de San Antonio");
        generateItem("Celtics de Boston");
        generateItem("Nets de Brooklyn");
        generateItem("Knicks de New York");
        generateItem("76ers de Philadelphie");
        generateItem("Raptors de Toronto");
        generateItem("Bulls de Chicago");
        generateItem("Cavaliers de Cleveland");
        generateItem("Pistons de Détroit");
        generateItem("Pacers de l'Indiana");
        generateItem("Bucks de Milwaukee");
        generateItem("Hawks d'Atlanta");
        generateItem("Hornets de Charlotte");
        generateItem("Heat de Miami");
        generateItem("Magic d'Orlando");
        generateItem("Wizards de Washington");
    }

    public void clear() { items.clear(); }

    public void generateItem(String itemName) {
        if(exist(itemName) == 0) {
            items.add(0, new ItemViewModel(itemName));
        }
    }
    public void onItemTapped(Object item) { //((ItemViewModel)item).squareTwo();
        isChanged = ((ItemViewModel)item).title.get();
        AlertDialog.Builder builder = new AlertDialog.Builder(cont);
        builder.setTitle("Renommer l'équipe");
        final EditText input = new EditText(cont);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                theRename(input.getText().toString());
            }
        });
        builder.setNeutralButton("Supprimer", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                theSupp();
            }
        });
        builder.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();

    }

    public void theRename(String newName){
        if(exist(newName) == 1){

        }else {
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).title.get() == isChanged) {
                    Toast.makeText(cont,"Vous avez renommé "+isChanged+" en "+newName, Toast.LENGTH_LONG).show();
                    items.get(i).rename(newName);
                }
            }
        }
    }

    public void theSupp(){
    for (int i = 0; i < items.size(); i++) {
        if (items.get(i).title.get() == isChanged) {
            Toast.makeText(cont,"Vous avez supprimé "+isChanged, Toast.LENGTH_LONG).show();
            items.remove(i);
            }
        }
    }

    public void onClickGenerate(){
        generateItem(textNewTeam.get());
    }

    public int exist(String itemName){
        int isExist = 0;
        for(int i = 0; i<items.size(); i++){
            if (items.get(i).title.get().equals(itemName)) {
                Toast.makeText(cont,""+itemName+" existe déjà.", Toast.LENGTH_LONG).show();
                isExist = 1;
            }
        }
        return isExist;
    }

}