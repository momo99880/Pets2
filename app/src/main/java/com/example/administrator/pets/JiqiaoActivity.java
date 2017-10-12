package com.example.administrator.pets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JiqiaoActivity extends AppCompatActivity {
    private TextView textView1, textView2, textView3, textView4, textView5, textView6, textView7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jiqiao);
        init();
        content();
    }

    public void init() {

        textView1 = (TextView) findViewById(R.id.text1_2_1);
        textView2 = (TextView) findViewById(R.id.text1_2_2);
        textView3 = (TextView) findViewById(R.id.text1_2_3);
        textView4 = (TextView) findViewById(R.id.text1_2_4);
        textView5 = (TextView) findViewById(R.id.text1_2_5);
        textView6 = (TextView) findViewById(R.id.text1_2_6);
        textView7 = (TextView) findViewById(R.id.text1_2_7);

    }

    public void content() {
        textView1.setText("\n\t\t\t\t\t\t小技巧\n");
        textView2.setText("\t\t\t\t\t\t关于帐号绑定\n");
        textView3.setText("\t\t\t\t\t\t注册有宠帐号时可以用手机号进行注册。\n");
        textView4.setText("\t\t\t\t\t\t如何查看宠物社区的活动？\n");
        textView5.setText("\t\t\t\t\t\t我们可以在宠物社区主页或者宠圈中的推荐板块中热看到热门活动，点击后，可以看到宠物社区的所有活动，查看宠友们的有趣分享。对于您感兴趣的活动，还可以进行订阅，保持对活动的关注；\n");
        textView6.setText("\t\t\t\t\t\t宠物资讯是什么？\n");
        textView7.setText("\t\t\t\t\t\t宠物资讯提供最新最全面的宠物信息，涵盖国内外第一手宠物资讯，解读宠物行业潮流走向，分享趣味宠物视频和高清宠物美图，为爱宠人士提供养护、健康、美容等养宠指南。\n");

    }
}