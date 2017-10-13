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

import com.example.administrator.pets.pojo.User;
import com.example.administrator.pets.service.MyUserService;
import com.example.administrator.pets.util.ToastUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @Bind(R.id.fanhui)
    ImageView fanhui;
    @Bind(R.id.btn_res)
    TextView btnRes;
    @Bind(R.id.et_name)
    EditText etName;
    @Bind(R.id.et_password)
    EditText etPassword;
    @Bind(R.id.btn_login)
    Button btnLogin;
    private MyBroadcastReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        if (receiver == null) {
            receiver = new MyBroadcastReceiver();
            IntentFilter filter = new IntentFilter();
            filter.addAction("com.action.login");
            registerReceiver(receiver, filter);
        }

    }

    @OnClick({R.id.fanhui, R.id.btn_res, R.id.btn_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fanhui:
                break;
            case R.id.btn_res:
                Intent intent = new Intent(LoginActivity.this,ResActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_login:
                login();
                break;
        }
    }

    private void login() {
        String username = etName.getText().toString().trim();
        String userpwd = etPassword.getText().toString().trim();
        Log.e("beli",username+","+userpwd);
        if (username.equals("")||userpwd.equals("")){
            ToastUtils.ToastText(this,"不能存在空的内容");
        }else{
            Intent in = new Intent(this, MyUserService.class);
            in.putExtra("action","1");
            in.putExtra("username",username);
            in.putExtra("userpwd",userpwd);
            startService(in);
        }
    }


    //数据库操作  登录
    public class MyBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String code_error = intent.getStringExtra("code_error");
            if (code_error.equals("0")){
//                登录成功
                ToastUtils.ToastText(LoginActivity.this,"登录成功");
                User user = (User) intent.getSerializableExtra("user");
                Log.e("beli","login_user="+user.toString());
            }else if(code_error.equals("-1")){
                ToastUtils.ToastText(LoginActivity.this,"用户不存在");
            }else if(code_error.equals("-2")){
                ToastUtils.ToastText(LoginActivity.this,"用户名或者密码错误");
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
        finish();
    }

}
