package com.example.administrator.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Administrator on 2018/3/29 0029.
 */

public class NewReciver extends BroadcastReceiver {
    private  int i =0;
    @Override
    public void onReceive(Context context, Intent intent) {
        String data = intent.getStringExtra("hxs");
        if (data != null)
        {
            Toast.makeText(context,"广播消息来了"+data+"  "+(++i),Toast.LENGTH_SHORT).show();
        }
    }
}
