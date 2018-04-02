package com.example.administrator.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.myapplication.util.MessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by Administrator on 2018/3/29 0029.
 */

public class FristAcitivity extends AppCompatActivity {
    TextView textView ;
    Button button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frist);

        //注册成为订阅者
        EventBus.getDefault().register(this);

        textView = findViewById(R.id.frist_text);
        button = findViewById(R.id.first_bun);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FristAcitivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    //声明订阅方法 用@SubScribe注解  当接受到事件的时候回调用该方法

    //threadMode表示订阅方法所运行的线程  有四个参数如下
    /*BACKGROUND表示事件方法在后台运行
     MAIN:表示运行在UI线程  不能耗时间过长
    */

    @Subscribe
    public void Event(MessageEvent messageEvent)
    {
        System.out.println("事件来了11111111111");
    }
    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onEvent(MessageEvent messageEvent)
    {
        System.out.println("事件来了");
        textView.setText(messageEvent.getMessage());
        Snackbar.make(textView,messageEvent.getMessage(),Snackbar.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解除注册释放资源
        EventBus.getDefault().unregister(this);
    }
}
