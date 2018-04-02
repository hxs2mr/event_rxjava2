package com.example.administrator.myapplication;

import android.Manifest;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.tbruyelle.rxpermissions2.RxPermissions;

/**
 * Created by Administrator on 2018/3/29 0029.
 */

public class Main2 extends AppCompatActivity implements View.OnClickListener {

    FloatingActionButton  button = null;

    //动态权限
    RxPermissions rxPermissions = null;//动态权限
    ImageView iv_book_image = null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_con2);
        iv_book_image = findViewById(R.id.iv_book_image);
        rxPermissions = new RxPermissions(this);
      //  button = findViewById(R.id.fab_search);
      //  button.setOnClickListener(this);

        // 版本判断。当手机系统大于 23 时，才有必要去判断权限是否获取
  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) 
      {
          need_permissions();
      }
    }

    private void need_permissions() {//需要的权限
        rxPermissions
                .requestEach(Manifest.permission.CAMERA,
                        Manifest.permission.READ_PHONE_STATE)
                .subscribe(permission -> {
                    if (permission.granted) {

                        Snackbar.make(iv_book_image,"权限开启成功"+permission.name,Snackbar.LENGTH_SHORT)
                                .setAction("确定", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {

                                    }
                                }).show();
                        //权限获取成功
                        // All requested permissions are granted
                    } else {
                        Snackbar.make(iv_book_image,"权限打开失败"+permission.toString()+permission.name,Snackbar.LENGTH_SHORT)
                                .setAction("确定", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {

                                    }
                                }).show();
                        //权限获取失败
                        // At least one permission is denied
                    }
                });
    }

    @Override
    public void onClick(View view) {
      /*  Snackbar.make(button,"看看这个好看不",Snackbar.LENGTH_LONG)
                .setAction("好看", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                }).show();*/
    }
}
