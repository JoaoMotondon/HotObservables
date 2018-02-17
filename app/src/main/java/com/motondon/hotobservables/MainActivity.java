package com.motondon.hotobservables;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.category_list) RecyclerView exampleCategoriesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.app_name);
        }

        exampleCategoriesList.setHasFixedSize(true);
        exampleCategoriesList.setLayoutManager(new LinearLayoutManager(this));
        exampleCategoriesList.setAdapter(new CategoryItemsAdapter(this, getHotObservablesCategoryExamples()));
    }

    private List<CategoryItem> getHotObservablesCategoryExamples() {
        List<CategoryItem> hotObservablesExample = new ArrayList<>();

        hotObservablesExample.add(new CategoryItem(
                HotObservableConnectExampleActivity.class,
                "Hot Observables - Connect",
                "Show how to use connect() operator"));

        hotObservablesExample.add(new CategoryItem(
                HotObservableRefCountExampleActivity.class,
                "Hot Observables - RefCount",
                "Show how to use refCount() operator"));

        hotObservablesExample.add(new CategoryItem(
                HotObservableReplayExampleActivity.class,
                "Hot Observables - Replay",
                "Show how to use some replay() operator variants"));

        hotObservablesExample.add(new CategoryItem(
                HotObservableCacheExampleActivity.class,
                "Hot Observables - Cache",
                "Show how to use cache() operator"));

        return hotObservablesExample;
    }
}
