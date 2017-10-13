package com.example.administrator.pets;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.pets.service.MyUserService;

public class ResActivity extends AppCompatActivity {
    private EditText et_name,et_password,et_password2;
    private Button btn_res;
    private TextView toolbar_text,btn_login;
    private ImageView imageview,fanhui;
    private ResBroadcast receiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res);
        if (receiver == null){
            receiver = new ResBroadcast();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.action.res");
            registerReceiver(receiver,intentFilter);
        }
        init();
        initView();

        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        btn_res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regUser();
            }
        });
    }
    private void init() {
        fanhui = (ImageView)findViewById(R.id.fanhui);
    }

    private void initView() {
        et_name = (EditText) findViewById(R.id.et_name);
        et_password = (EditText) findViewById(R.id.et_password);
        et_password2 = (EditText)findViewById(R.id.agintet_password);
        btn_login = (TextView) findViewById(R.id.btn_login);
        btn_res = (Button) findViewById(R.id.btn_res);
    }

    public void regUser(){
        String username = et_name.getText().toString().trim();
        String userpwd = et_password.getText().toString().trim();
        String userpwd2 = et_password2.getText().toString().trim();

        if (username.equals("")||userpwd.equals("")||userpwd2.equals("")){
            Toast.makeText(ResActivity.this,"不能存在空的内容",Toast.LENGTH_SHORT).show();
        }else {
            if (!userpwd.equals(userpwd2)){
              Toast.makeText(ResActivity.this,"两次密码不相同",Toast.LENGTH_SHORT).show();
            }else {
                Intent intent = new Intent(ResActivity.this, MyUserService.class);
                intent.putExtra("action","0");
                intent.putExtra("username",username);
                intent.putExtra("userpwd",userpwd);
                startService(intent);
            }
        }
//        if (!username.equals("")||!userpwd.equals("")){
//            Intent intent = new Intent(ResActivity.this, MyUserService.class);
//            intent.putExtra("action",0);
//            intent.putExtra("username",username);
//            intent.putExtra("userpwd",userpwd);
//            startService(intent);
//        }
//        两个密码不相同的时候
//        else if (userpwd.equals("")!=userpwd2.equals("")){
//            Toast.makeText(ResActivity.this,"两次密码不相同",Toast.LENGTH_SHORT).show();
//        }

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
    private class ResBroadcast extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            String code_error = intent.getStringExtra("code_error");
            if (code_error.equals("-1")){
//                            用户已存在
                Toast.makeText(ResActivity.this,"用户已存在",Toast.LENGTH_SHORT).show();
            }else if (code_error.equals("0")){
//                            注册成功
                Toast.makeText(ResActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

}
