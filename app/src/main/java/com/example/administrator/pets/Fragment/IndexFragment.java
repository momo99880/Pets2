package com.example.administrator.pets.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.pets.R;
import com.example.administrator.pets.util.MyGridView;

public class IndexFragment extends Fragment {
    private ImageView toolbar_imageView_left, toolbar_imageView_right;
    private TextView toolbar_textView;
    private int num = 3;
    private ViewPager viewPager;
    private int[] imagesId;
    private MyPagerAdapter adapter;
    private View[] views;
    private LinearLayout point_line;
    private ImageView[] points;
    private MyHandler handler;
    private MyThread myThread;
    private Thread thread;
    private boolean flag;
    private float x_start = 0, x_end = 0, y_start = 0, y_end = 0;
    private MyGridView gridView;
    private String[] text;
    private MyGridViewAdapter myGridViewAdapter;
    private int[] images;
    private OnFragmentInteractionListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_index, container, false);
        init(view);
        text = new String[]{"话题", "精选", "文章", "公益"};
        images = new int[]{R.mipmap.tucao, R.mipmap.tucao, R.mipmap.tucao, R.mipmap.tucao };
        myGridViewAdapter = new MyGridViewAdapter();
        gridView.setAdapter(myGridViewAdapter);

        imagesId = new int[]{R.mipmap.wo, R.mipmap.wo, R.mipmap.wo};
        views = new View[num];
        for (int i = 0; i < imagesId.length; i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            imageView.setImageResource(imagesId[i]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            views[i] = imageView;
    }
        adapter = new MyPagerAdapter();
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(Integer.MAX_VALUE / 2);
        setPointData();
        handler = new MyHandler();
        myThread = new MyThread();
        myThread.setFlag(true);
        thread = new Thread(myThread);
        thread.start();

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setPointRed(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int state = motionEvent.getAction();
                switch (state) {
                    //第一次触碰viewpager
                    case 0:
                        //结束线程
                        myThread.setFlag(false);
                        x_start = motionEvent.getX();
                        y_start = motionEvent.getY();
                        break;
//                    抬起
                    case 1:
                        //线程继续
                        x_end = motionEvent.getX();
                        y_end = motionEvent.getY();
                        Log.e("bean1", "xxx=" + Math.abs(x_start - x_end) + ",yyy=" + Math.abs(y_start - y_end));

//                        if (Math.abs(x_start - x_end) < 50 && Math.abs(y_start - y_end) < 50) {
//                            //点击状态
//                         //   startActivity(new Intent(getContext(), StockInfoActivity.class));
//                        } else {
//                            //滑动状态
                        myThread = new MyThread();
                        myThread.setFlag(true);
                        new Thread(myThread).start();

//                        }
                        break;
                }
                return false;
            }
        });
        setToolbar();
        return view;
    }

    public void init(View view) {
       toolbar_imageView_left = (ImageView) view.findViewById(R.id.mytoolbar_imageview_left);
        toolbar_imageView_right = (ImageView) view.findViewById(R.id.mytoolbar_imageview_right);
        toolbar_textView = (TextView) view.findViewById(R.id.mytoolbar_textview);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        point_line = (LinearLayout) view.findViewById(R.id.point_line);
        gridView = (MyGridView) view.findViewById(R.id.index_gridview);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mListener.onGridViewButtonClicked(position);
            }
        });


    }

    public void setToolbar() {
        toolbar_textView.setText(getResources().getString(R.string.index));
    }

    public void setPointData() {
        points = new ImageView[num];
        for (int i = 0; i < imagesId.length; i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setLayoutParams(new LinearLayout.LayoutParams(20, 20));
            imageView.setImageResource(R.mipmap.point_gray);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setPadding(5, 5, 5, 5);
            points[i] = imageView;
            point_line.addView(imageView);
        }
    }

    public void setPointRed(int index) {
        for (int i = 0; i < imagesId.length; i++) {
            if (index % num == i) {
                points[i].setImageResource(R.mipmap.point_red);
            } else {
                points[i].setImageResource(R.mipmap.point_gray);
            }
        }
    }

    public class MyPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            if (container != null) {
                container.removeView(views[position % num]);
            }
            container.addView(views[position % num]);
            return views[position % num];
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {

        }
    }

    public class MyThread implements Runnable {
        boolean flag = true;

        public boolean isFlag() {
            return flag;
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }


        @Override
        public void run() {
            while (flag) {
                try {
                    Thread.sleep(2000);
                    if (flag) {
                        handler.sendEmptyMessage(1);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Log.e("bean1", "thread stop");
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        myThread.setFlag(false);

    }

    public class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
            }
        }
    }

    public class MyGridViewAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return text.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View myView = LayoutInflater.from(getActivity()).inflate(R.layout.gridview_item, null);
            ImageView imageView1 = (ImageView) myView.findViewById(R.id.gridview_imageview1);
            TextView textView = (TextView) myView.findViewById(R.id.gridview_textview);
            imageView1.setImageResource(images[i]);
            textView.setText(text[i]);
            return myView;
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (OnFragmentInteractionListener)context;
    }

    public interface OnFragmentInteractionListener{
        public void onGridViewButtonClicked(int position);
    }

}
