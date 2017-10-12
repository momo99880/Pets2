package com.example.administrator.pets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DeclareActivity extends AppCompatActivity {
    private TextView textView1,textView2,textView3,textView4,textView5,textView6,textView7,textView8,textView9,textView10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_declare);
        init();
        content();
    }
    public void init(){

        textView1 =(TextView)findViewById(R.id.text1_1_1);
        textView2=(TextView)findViewById(R.id.text1_1_2);
        textView3=(TextView)findViewById(R.id.text1_1_3);
        textView4=(TextView)findViewById(R.id.text1_1_4);
        textView5 =(TextView)findViewById(R.id.text1_1_5);
        textView6=(TextView)findViewById(R.id.text1_1_6);
        textView7=(TextView)findViewById(R.id.text1_1_7);
        textView8=(TextView)findViewById(R.id.text1_1_8);
        textView9 =(TextView)findViewById(R.id.text1_1_9);
        textView10=(TextView)findViewById(R.id.text1_1_10);
    }
    public void content(){
        textView1.setText("\n\t\t\t\t\t\t1、一切移动客户端用户在下载并浏览微笑宠物社区APP软件时均被视为已经仔细阅读本条款并完全同意。凡以任何方式登陆本APP ，或直接、间接使用本APP 资料者，均被视为自愿接受本网站相关声明和用户服务协议的约束。\n");
        textView2.setText("\t\t\t\t\t\t2、微笑宠物社区转载的内容并不代表微笑宠物社区之意见及观点，也不意味着本网赞同其观点或证实其内容的真实性。\n");
        textView3.setText("\t\t\t\t\t\t3、微笑宠物社区转载的文字、图片、音视频等资料均由本APP用户提供，其真实性、准确性和合法性由信息发布人负责。微笑宠物社区不提供任何保证，并不承担任何法律责任。\n");
        textView4.setText("\t\t\t\t\t\t4、微笑宠物社区所转载的文字、图片、音视频等资料，如果侵犯了第三方的知识产权或其他权利，责任由作者或转载者本人承担，本APP 对此不承担责任。\n");
        textView5.setText("\t\t\t\t\t\t5、微笑宠物社区不保证为向用户提供便利而设置的外部链接的准确性和完整性，同时，对于该外部链接指向的不由APP 手机APP 实际控制的任何网页上的内容，APP 手机APP 不承担任何责任。\n");
        textView6.setText("\t\t\t\t\t\t6、用户明确并同意其使用APP微笑宠物社区网络服务所存在的风险将完全由其本人承担；因其使用APP网络服务而产生的一切后果也由其本人承担，微笑宠物社区对此不承担任何责任。\n");
        textView7.setText("\t\t\t\t\t\t7、除微笑宠物社区注明之服务条款外，其它因不当使用本APP 而导致的任何意外、疏忽、合约毁坏、诽谤、版权或其他知识产权侵犯及其所造成的任何损失，APP 手机APP 概不负责，亦不承担任何法律责任。\n");
        textView8.setText("\t\t\t\t\t\t8、对于因不可抗力或因黑客攻击、通讯线路中断等微笑宠物社区不能控制的原因造成的网络服务中断或其他缺陷，导致用户不能正常使用微笑宠物社区，微笑宠物社区不承担任何责任，但将尽力减少因此给用户造成的损失或影响。\n");
        textView9.setText("\t\t\t\t\t\t9、本声明未涉及的问题请参见国家有关法律法规，当本声明与国家有关法律法规冲突时，以国家法律法规为准。\n");
        textView10.setText("\t\t\t\t\t\t10、本网站相关声明版权及其修改权、更新权和最终解释权均属APP微笑宠物社区所有。\n");
    }
}
