package com.example.administrator.pets;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.pets.util.MyApplication;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {
    @Bind(R.id.btn_res)
    TextView btnRes;
    @Bind(R.id.user_img)
    ImageView userImg;
    @Bind(R.id.et_name)
    EditText etName;
    @Bind(R.id.password_img)
    ImageView passwordImg;
    @Bind(R.id.et_password)
    EditText etPassword;
    @Bind(R.id.btn_login)
    Button btnLogin;
    @Bind(R.id.progress)
    ProgressBar progress;
    @Bind(R.id.activity_login)
    LinearLayout activityLogin;
    private EditText et_name, et_password;
    private Button btn_login;
    private TextView btn_res;
    private ImageView fanhui;
    private MyBroadcastReceiver receiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        if (receiver == null) {
            receiver = new MyBroadcastReceiver();
            IntentFilter filter = new IntentFilter();
            filter.addAction("com.beli.action.main");
            registerReceiver(receiver, filter);
        }

    }

    @OnClick({R.id.fanhui, R.id.btn_res,  R.id.et_name,R.id.et_password, R.id.btn_login,  R.id.activity_login})
    public void onViewClicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.fanhui:
                break;
            case R.id.btn_res:
                intent = new Intent(LoginActivity.this,ResActivity.class);
                startActivity(intent);
                break;

            case R.id.et_name:
                break;

            case R.id.et_password:
                break;
            case R.id.btn_login:

                break;
        }
    }

    //数据库操作  登录
    public class MyBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getStringExtra("action");
            int errorCode = intent.getIntExtra("errorCode", -1);
            switch (action) {
                case "login":
                    if (errorCode == 0) {
//                登录成功
                        String u_name = et_name.getText().toString().trim();
                        MyApplication application = (MyApplication) getApplication();
                        application.setU_name(u_name);
                        Toast.makeText(getApplication(), "登录成功", Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(getApplication(), MainActivity.class);
                        intent1.putExtra("username", u_name);
                        intent1.putExtra("url", intent.getStringExtra("url"));
                        startActivity(intent1);
                    } else {
                        Toast.makeText(getApplication(), "用户名或者密码错误", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case "register":
                    if (errorCode == 0) {
//                注册成功
                        Toast.makeText(getApplication(), "注册成功", Toast.LENGTH_SHORT).show();
                    } else if (errorCode == -2) {
//                用户已存在
                        Toast.makeText(getApplication(), "用户已存在", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplication(), "注册失败", Toast.LENGTH_SHORT).show();
                    }
                    break;
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
