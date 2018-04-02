package com.example.administrator.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.administrator.myapplication.util.MessageEvent;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Administrator on 2018/3/29 0029.
 */

public class SecondActivity extends AppCompatActivity {
    Button button;
    EditText edittext;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        edittext = findViewById(R.id.edittext);
        button = findViewById(R.id.second_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //发送事件
                EventBus.getDefault().post(new MessageEvent(edittext.getText().toString()));
            }
        });
    }
}
