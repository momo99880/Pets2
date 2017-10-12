package com.example.administrator.pets;

import android.content.Intent;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res);
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
        Log.e("beli",username+","+userpwd+","+userpwd2);
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


}
