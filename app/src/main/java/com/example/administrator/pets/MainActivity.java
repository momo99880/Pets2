package com.example.administrator.pets;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.pets.Fragment.BaikeFragment;
import com.example.administrator.pets.Fragment.IndexFragment;
import com.example.administrator.pets.Fragment.InfoFragment;
import com.example.administrator.pets.Fragment.MeFragment;

public class MainActivity extends AppCompatActivity implements IndexFragment.OnFragmentInteractionListener {
    private FragmentTabHost tabHost;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setTabHost();

    }
    public void init(){
        tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
    }

    public void setTabHost(){
        tabHost.setup(this,getSupportFragmentManager(),R.id.tablocation);
//        去掉分割线ds
        tabHost.getTabWidget().setDividerDrawable(null);
        tabHost.addTab(tabHost.newTabSpec("index").setIndicator(getTabhostItemView(R.drawable.indexselector,getResources().getString(R.string.index))), IndexFragment.class,null);
        tabHost.addTab(tabHost.newTabSpec("info").setIndicator(getTabhostItemView(R.drawable.infoselector,getResources().getString(R.string.info))), InfoFragment.class,null);
        tabHost.addTab(tabHost.newTabSpec("baike").setIndicator(getTabhostItemView(R.drawable.baikeselector,getResources().getString(R.string.baike))), BaikeFragment.class,null);
        tabHost.addTab(tabHost.newTabSpec("me").setIndicator(getTabhostItemView(R.drawable.meselector,getResources().getString(R.string.me))), MeFragment.class,null);
    }

    public View getTabhostItemView(int imageId, String title){
        View view = LayoutInflater.from(this).inflate(R.layout.tabhost_item,null);
        ImageView imageView = (ImageView)view.findViewById(R.id.tabhost_item_imageview);
        TextView textView = (TextView)view.findViewById(R.id.tabhost_item_textview);
        imageView.setImageResource(imageId);
        textView.setText(title);
        return view;
    }
  //  private long firstPressedTime;


    @Override
    public void onGridViewButtonClicked(int position) {
        Log.e("aa","buttonClickedposition="+position);
        switch (position){
            case 0:
                tabHost.setCurrentTab(2);
                break;
            case 1:
                tabHost.setCurrentTab(1);
                break;
            case 2:
                tabHost.setCurrentTab(3);
                break;
            case 3:
                break;
        }
    }


}
