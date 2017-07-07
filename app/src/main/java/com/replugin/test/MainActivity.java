package com.replugin.test;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.widget.Toast;

import com.jakewharton.rxbinding.view.RxView;
import com.replugin.test.databinding.ActivityMainBinding;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

public class MainActivity extends RxAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        RxView.clicks(dataBinding.textview)
                .compose(bindToLifecycle())
                .subscribe(__ -> test());

    }
    private void test(){
        Toast.makeText(MainActivity.this,"测试",Toast.LENGTH_LONG).show();
    }
}
