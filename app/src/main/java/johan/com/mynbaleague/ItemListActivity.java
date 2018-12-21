package johan.com.mynbaleague;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import johan.com.mynbaleague.databinding.ActivityItemListBinding;
import johan.com.mynbaleague.databinding.ActivityMainBinding;

import static android.support.v7.widget.LinearLayoutManager.VERTICAL;

public class ItemListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityItemListBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_item_list);
        binding.setViewModel( new ItemListViewModel(this));
        RecyclerView recyclerView = binding.getRoot().findViewById(R.id.data_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), VERTICAL));
    }
    public void goToCarte(View view){
        startActivity(new Intent(this, CarteActivity.class));
    }
}