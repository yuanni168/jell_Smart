package com.jia.jelly.smart.liveData;

import android.app.Activity;
import android.app.Fragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.jia.jelly.smart.R;
import com.jia.jelly.smart.model.Resource;

import java.util.List;

public class LiveDataActivity extends AppCompatActivity {
    private TextView nameTv;
    private NameViewModel nameViewModel;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        nameTv = findViewById(R.id.name_tv);
        nameViewModel = ViewModelProviders.of(this).get(NameViewModel.class);
        nameViewModel.getCurrentName().observe(this, new Observer<Resource<String>>() {
            @Override
            public void onChanged(@Nullable Resource<String> resource) {
                nameTv.setText(resource.data);
            }
        });
        nameViewModel.getmNameListData().observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(@Nullable List<String> strings) {
                for (String item : strings) {
                    Log.d("TAG", "name: " + item);

                }
            }
        });
    }
}
