/*
package com.jia.jelly.smart;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.jia.jelly.smart.viewmodel.NameViewModel;

public class NameActivity extends AppCompatActivity {
    private NameViewModel mViewModel;
    private TextView nameTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication()).create(NameViewModel.class);
        nameTv = findViewById(R.id.name_tv);
        final Observer<String> nameObserver = new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                nameTv.setText(s);
            }
        };
        mViewModel.getmCurrentName().observe(this, nameObserver);
        nameTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.getmCurrentName().setValue("nnnnnnnnnnnnnnnnnnnnnnnnnn");
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
*/
