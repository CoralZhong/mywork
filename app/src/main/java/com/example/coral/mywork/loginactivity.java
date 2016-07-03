//package com.example.coral.mywork;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.LinearLayout;
//
///**
// * Created by Administrator on 2016/6/22.
// */
//public class LoginActivity extends Activity {
//
//    private LinearLayout home_img_bn_Layout, search_img_bn_layout, cam_img_bn_layout, login_img_bn_layout, show_img_bn_layout;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.loginlayout);
//        home_img_bn_Layout = (LinearLayout) findViewById(R.id.bottom_home_layout_ly);
//        home_img_bn_Layout.setOnClickListener(clickListener_home);
//
//        search_img_bn_layout = (LinearLayout) findViewById(R.id.bottom_style_layout_ly);
//        search_img_bn_layout.setOnClickListener(clickListener_search);
//
//        login_img_bn_layout = (LinearLayout) findViewById(R.id.bottom_shopping_layout_ly);
//        //login_img_bn_layout.setOnClickListener(clickListener_mine);
//        login_img_bn_layout.setSelected(true);
//        login_img_bn_layout.setClickable(false);
//
//    }
//
//
//    private View.OnClickListener clickListener_home = new View.OnClickListener() {
//
//        @Override
//        public void onClick(View v) {
//            // TODO Auto-generated method stub
//            home_img_bn_Layout.setSelected(true);
//            search_img_bn_layout.setSelected(false);
//            login_img_bn_layout.setSelected(false);
//				Intent intent = new Intent();
//				intent.setClass(LoginActivity.this, TestUIActivity.class);
//				intent.putExtra("clickble", true);
//				startActivity(intent);
//        }
//    };
//
//    private View.OnClickListener clickListener_search = new View.OnClickListener() {
//
//        @Override
//        public void onClick(View v) {
//            home_img_bn_Layout.setSelected(false);
//            search_img_bn_layout.setSelected(true);
//            login_img_bn_layout.setSelected(false);
//            Intent intent = new Intent();
//            intent.setClass(LoginActivity.this, SearchActivity.class);
//            intent.putExtra("clickble", true);
//            startActivity(intent);
//
//        }
//    };
//
//
//}
