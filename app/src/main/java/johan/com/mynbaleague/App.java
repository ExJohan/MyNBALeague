package johan.com.mynbaleague;

import android.app.Application;
import android.databinding.DataBindingUtil;
import johan.com.mynbaleague.helpers.RecyclerViewDataBinding;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        DataBindingUtil.setDefaultComponent(new android.databinding.DataBindingComponent() {
                                                @Override
                                                public RecyclerViewDataBinding getRecyclerViewDataBinding() {
                                                    return new RecyclerViewDataBinding();
                                                }
                                            }
        );
    }
}
