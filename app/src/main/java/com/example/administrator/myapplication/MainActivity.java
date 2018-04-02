package com.example.administrator.myapplication;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
  private  NewReciver reciver =null;
  private IntentFilter intentFilter= null;
  private Button button = null;
  private EditText editText = null;
  private LinearLayoutCompat main = null;
  private TextInputLayout inputEditText=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main = findViewById(R.id.main_layout);
        inputEditText = findViewById(R.id.text_inputed);
        button = findViewById(R.id.test_reciver);
        editText = findViewById(R.id.ed);
        button.setOnClickListener(this);

        LayoutInflater layoutInflater  =LayoutInflater.from(this);
        View  new_layou = layoutInflater.inflate(R.layout.inflite,null);
        main.addView(new_layou);
    }

    @Override
    protected void onResume() {
        super.onResume();
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("com.example.administrator.myapplication.HXS");
        reciver = new NewReciver();
        registerReceiver(reciver,intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(reciver);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent("com.example.administrator.myapplication.HXS");
        intent.putExtra("hxs",editText.getText().toString());
        sendBroadcast(intent);
        inputEditText.setError("错误");
        Snackbar.make(inputEditText,"asdasd",Snackbar.LENGTH_LONG)
                .setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                }).show();
    }
}
