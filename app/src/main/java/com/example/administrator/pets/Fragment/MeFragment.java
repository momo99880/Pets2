package com.example.administrator.pets.Fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.administrator.pets.CalendActivity;
import com.example.administrator.pets.DeclareActivity;
import com.example.administrator.pets.JiqiaoActivity;
import com.example.administrator.pets.LoginActivity;
import com.example.administrator.pets.R;

public class MeFragment extends Fragment {
    private int index = 0;
    private Button login_text1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_me, container, false);

        initView(view);
        settingBtn(view);
        login_text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

    public void settingBtn(View view){
        LinearLayout line4 = (LinearLayout)view.findViewById(R.id.line4);
        LinearLayout line5 = (LinearLayout)view.findViewById(R.id.line5);
        LinearLayout line6 = (LinearLayout)view.findViewById(R.id.line6);
        LinearLayout line7 = (LinearLayout)view.findViewById(R.id.line7);
        LinearLayout line8 = (LinearLayout)view.findViewById(R.id.line8);
        //宠物日历
        line4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),CalendActivity.class);
                startActivity(intent);
            }
        });
        //小技巧

        line5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),JiqiaoActivity.class);
                startActivity(intent);

            }
        });

//关于
        line6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
                builder.setTitle("微笑宠物社区");
                builder.setMessage("宠物社区交流");
                builder.setPositiveButton("关闭",null);
                builder.create().show();
            }
        });
        //吐槽

        line7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backInformation();
            }
        });

        //免责声明
        line8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),DeclareActivity.class);
                startActivity(intent);
            }
        });
    }
    public void backInformation(){
        AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
        builder.setTitle("欢迎吐槽");
        final String[] tu = {"界面不美观","功能不齐全","资讯不够多"};
        builder.setSingleChoiceItems(tu,0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                index = i;
            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getContext(),"您的吐槽已发送", Toast.LENGTH_SHORT).show();

            }
        });
        builder.create().show();
    }

    private void initView(View view) {

       // user_logo = (ImageView) view.findViewById(user_logo);
        login_text1 = (Button) view.findViewById(R.id.login_text1);
      //  button2 = (Button) view.findViewById(R.id.exit_login);
       //me_toolbar_tv = (TextView)view.findViewById(me_toolbar_tv);
     //   line2 = (LinearLayout)view.findViewById(line2);
    }



    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


}
