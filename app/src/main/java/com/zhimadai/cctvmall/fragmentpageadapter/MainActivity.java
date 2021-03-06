package com.zhimadai.cctvmall.fragmentpageadapter;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {
    private XViewPager myViewPager; // 要使用的ViewPager
    private TextView tv_tab0, tv_tab1, tv_tab2; // 3个选项卡
    private ImageView iv_tab0, iv_tab1, iv_tab2;
//    private ImageView line_tab; // tab选项卡的下划线
    private int moveOne = 0; // 下划线移动一个选项卡
    private boolean isScrolling = false; // 手指是否在滑动
    private boolean isBackScrolling = false; // 手指离开后的回弹
    private long startTime = 0;
    private long currentTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
//        initLineImage();
    }

    /**
     * 重新设定line的宽度
     */
//    private void initLineImage() {
//        /*
//         *
//         * 获取屏幕的宽度
//         */
//        DisplayMetrics dm = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(dm);
//        int screenW = dm.widthPixels;
//        /*
//         * 重新设置下划线的宽度
//         */
//        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) line_tab.getLayoutParams();
//        lp.width = screenW / 3;
//        line_tab.setLayoutParams(lp);
//        moveOne = lp.width;// 滑动一个页面的距离
//    }

    private void initView() {
        myViewPager = (XViewPager) findViewById(R.id.myViewPager); // ViewPager中包含的页面为普通页面
        myViewPager.setEnabled(false);
        MyFragment1 myFragment1 = new MyFragment1();
        MyFragment2 myFragment2 = new MyFragment2();
        MyFragment3 myFragment3 = new MyFragment3();
        List<Fragment> fragmentList = new ArrayList<Fragment>();
        fragmentList.add(myFragment1);
        fragmentList.add(myFragment2);
        fragmentList.add(myFragment3);
        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), fragmentList);
        myViewPager.setAdapter(myFragmentAdapter);
        tv_tab0 = (TextView) findViewById(R.id.tv_tab0);
        tv_tab1 = (TextView) findViewById(R.id.tv_tab1);
        tv_tab2 = (TextView) findViewById(R.id.tv_tab2);
        iv_tab0 = (ImageView) findViewById(R.id.iv_tab0);
        iv_tab1 = (ImageView) findViewById(R.id.iv_tab1);
        iv_tab2 = (ImageView) findViewById(R.id.iv_tab2);
        myViewPager.setCurrentItem(0);
        tv_tab0.setTextColor(Color.RED);
        tv_tab1.setTextColor(Color.BLACK);
        tv_tab2.setTextColor(Color.BLACK);
        tv_tab0.setOnClickListener(this);
        tv_tab1.setOnClickListener(this);
        tv_tab2.setOnClickListener(this);
        myViewPager.setOnPageChangeListener(this);
//        line_tab = (ImageView) findViewById(R.id.line_tab);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
//        switch (state) {
//            case 1:
//                isScrolling = true;
//                isBackScrolling = false;
//                break;
//            case 2:
//                isScrolling = false;
//                isBackScrolling = true;
//                break;
//            default:
//                isScrolling = false;
//                isBackScrolling = false;
//                break;
//        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//        currentTime = System.currentTimeMillis();
//        if (isScrolling && (currentTime - startTime > 200)) {
//            movePositionX(position, moveOne * positionOffset);
//            startTime = currentTime;
//        }
//        if (isBackScrolling) {
//            movePositionX(position);
//        }
    }


    @Override
    public void onPageSelected(int position) {
        //TODO Auto-generated method stub
        switch (position) {
            case 0:
                tv_tab0.setTextColor(Color.RED);
                tv_tab1.setTextColor(Color.BLACK);
                tv_tab2.setTextColor(Color.BLACK);

                iv_tab0.setVisibility(View.VISIBLE);
                iv_tab1.setVisibility(View.INVISIBLE);
                iv_tab2.setVisibility(View.INVISIBLE);
//                movePositionX(0);
                break;
            case 1:
                tv_tab0.setTextColor(Color.BLACK);
                tv_tab1.setTextColor(Color.BLUE);
                tv_tab2.setTextColor(Color.BLACK);

                iv_tab0.setVisibility(View.INVISIBLE);
                iv_tab1.setVisibility(View.VISIBLE);
                iv_tab2.setVisibility(View.INVISIBLE);
//                movePositionX(1);
                break;
            case 2:
                tv_tab0.setTextColor(Color.BLACK);
                tv_tab1.setTextColor(Color.BLACK);
                tv_tab2.setTextColor(Color.GREEN);

                iv_tab0.setVisibility(View.INVISIBLE);
                iv_tab1.setVisibility(View.INVISIBLE);
                iv_tab2.setVisibility(View.VISIBLE);
//                movePositionX(2);
                break;
            default:
                break;
        }
    }

    /**
     * 下划线跟随手指的滑动而移动
     *
     * @param toPosition
     * @param positionOffsetPixels
     */
//    private void movePositionX(int toPosition, float positionOffsetPixels) {
//        float curTranslationX = line_tab.getTranslationX();
//        float toPositionX = moveOne * toPosition + positionOffsetPixels;
//        ObjectAnimator animator = ObjectAnimator.ofFloat(line_tab, "translationX", curTranslationX, toPositionX);
//        animator.setDuration(500);
//        animator.start();
//    }

    /**
     * 下划线滑动到新的选项卡中
     *
     */
//    private void movePositionX(int toPosition) {
//        movePositionX(toPosition, 0);
//    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_tab0:
                myViewPager.setCurrentItem(0);
                break;
            case R.id.tv_tab1:
                myViewPager.setCurrentItem(1);
                break;
            case R.id.tv_tab2:
                myViewPager.setCurrentItem(2);
                break;
            default:
                break;
        }
    }
}