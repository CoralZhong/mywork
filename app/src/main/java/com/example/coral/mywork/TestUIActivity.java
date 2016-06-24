package com.example.coral.mywork;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestUIActivity extends Activity implements OnGestureListener, OnTouchListener {

    private TextView date_TextView;
    private ImageButton set_ImageButton, regist_ImageButton, login_ImageButton;
    private ViewFlipper viewFlipper;
    private boolean showNext = true;
    private boolean isRun = true;
    private int currentPage = 0;
    private final int SHOW_NEXT = 0011;
    private static final int FLING_MIN_DISTANCE = 50;
    private static final int FLING_MIN_VELOCITY = 0;
    private GestureDetector mGestureDetector;
    private LinearLayout home_img_bn_Layout, search_img_bn_layout, cam_img_bn_layout, shopping_img_bn_layout, show_img_bn_layout;
private ListView lv;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
        date_TextView = (TextView) findViewById(R.id.home_date_tv);
        date_TextView.setText(getDate());
        lv= (ListView) findViewById(R.id.mainlistview);

        // set_ImageButton = (ImageButton) findViewById(R.id.title_set_bn);
//        set_ImageButton.setOnClickListener(new OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				toastInfo("��������");
//			}
//		});



        home_img_bn_Layout = (LinearLayout) findViewById(R.id.bottom_home_layout_ly);
        home_img_bn_Layout.setOnClickListener(clickListener_home);

        search_img_bn_layout = (LinearLayout) findViewById(R.id.bottom_style_layout_ly);
        search_img_bn_layout.setOnClickListener(clickListener_search);

        //cam_img_bn_layout = (LinearLayout) findViewById(R.id.bottom_cam_layout_ly);
        //cam_img_bn_layout.setOnClickListener(clickListener_cam);

        shopping_img_bn_layout = (LinearLayout) findViewById(R.id.bottom_shopping_layout_ly);
        shopping_img_bn_layout.setOnClickListener(clickListener_mine);

        //show_img_bn_layout = (LinearLayout) findViewById(R.id.bottom_show_layout_ly);
        //show_img_bn_layout.setOnClickListener(clickListener_show);


        viewFlipper = (ViewFlipper) findViewById(R.id.mViewFliper_vf);
        mGestureDetector = new GestureDetector(this);
        viewFlipper.setOnTouchListener(this);
        viewFlipper.setLongClickable(true);
        viewFlipper.setOnClickListener(clickListener);
        displayRatio_selelct(currentPage);


        MyScrollView myScrollView = (MyScrollView) findViewById(R.id.viewflipper_scrollview);
        myScrollView.setOnTouchListener(onTouchListener);
        myScrollView.setGestureDetector(mGestureDetector);

        thread.start();
        showhealthymsg();

    }

    private OnClickListener clickListener = new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            toastInfo("����¼�");
        }
    };
    private OnTouchListener onTouchListener = new OnTouchListener() {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            // TODO Auto-generated method stub
            return mGestureDetector.onTouchEvent(event);
        }
    };
//控制filiper
    Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            switch (msg.what) {
                case SHOW_NEXT:
                    if (showNext) {
                        showNextView();
                    } else {
                        showPreviousView();
                    }
                    break;

                default:
                    break;
            }
        }

    };

    //接收api数据
    List<Map<String,String>> list=new ArrayList<Map<String,String>>();
    Handler h=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle b=msg.getData();
            String str= (String) b.get("str");
            Gson g=new Gson();
            HealthyNewsBean hn=g.fromJson(str,HealthyNewsBean.class);
            List<HealthyNewsBean.NewslistBean> l=hn.getNewslist();
            int i=0;
            for(HealthyNewsBean.NewslistBean news:l){
                Map<String,String> map=new HashMap<String,String>();
                String title=news.getTitle();
                map.put("title",title);
                String url=news.getUrl();
                map.put("url",url);
                list.add(map);
                i++;
                if(i>10){
                    break;
                }
            }
            toastInfo("长度"+list.size());
            SimpleAdapter sa=new SimpleAdapter(TestUIActivity.this,list,R.layout.newslistdetial,new String[]{"title"},new int[]{R.id.newstitle});
            lv.setAdapter(sa);



        }
    };
    private String getDate() {
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        int w = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) {
            w = 0;
        }
        String mDate = c.get(Calendar.YEAR) + "年" + (c.get(Calendar.MONTH)+1) + "月" + c.get(Calendar.DATE) + "日  " + weekDays[w];
        return mDate;
    }

    private OnClickListener clickListener_home = new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            home_img_bn_Layout.setSelected(true);
            search_img_bn_layout.setSelected(false);
//				cam_img_bn_layout.setSelected(false);
            shopping_img_bn_layout.setSelected(false);
//				show_img_bn_layout.setSelected(false);
//				Intent intent = new Intent();
//				intent.setClass(TestUIActivity.this, MyActivity.class);
//				intent.putExtra("clickble", true);
//				startActivity(intent);
            home_img_bn_Layout.setSelected(false);
        }
    };
    private OnClickListener clickListener_search = new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            home_img_bn_Layout.setSelected(false);
            search_img_bn_layout.setSelected(true);
            //cam_img_bn_layout.setSelected(false);
            shopping_img_bn_layout.setSelected(false);
//			show_img_bn_layout.setSelected(false);
            //toastInfo("����ҵļ�����ת");
//            Intent intent = new Intent();
//            intent.setClass(TestUIActivity.this, vvv.class);
//            intent.putExtra("clickble", true);
//            startActivity(intent);

        }
    };
    private OnClickListener clickListener_cam = new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            home_img_bn_Layout.setSelected(false);
            search_img_bn_layout.setSelected(false);
            //cam_img_bn_layout.setSelected(true);
            shopping_img_bn_layout.setSelected(false);
            //show_img_bn_layout.setSelected(false);
            toastInfo("����ҵļ�����ת");
        }
    };
    private OnClickListener clickListener_mine = new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            home_img_bn_Layout.setSelected(false);
            search_img_bn_layout.setSelected(false);
//			cam_img_bn_layout.setSelected(false);
            shopping_img_bn_layout.setSelected(true);
//			show_img_bn_layout.setSelected(false);
            //toastInfo("����ҵļ�����ת");
            Intent intent = new Intent();
            intent.setClass(TestUIActivity.this, loginactivity.class);
            intent.putExtra("clickble", true);
            startActivity(intent);
        }
    };
    private OnClickListener clickListener_show = new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            home_img_bn_Layout.setSelected(false);
            search_img_bn_layout.setSelected(false);
//			cam_img_bn_layout.setSelected(false);
            shopping_img_bn_layout.setSelected(false);
//			show_img_bn_layout.setSelected(true);
            toastInfo("����ҵļ�����ת");
        }
    };

    @Override
    public boolean onDown(MotionEvent e) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                           float velocityY) {
        // TODO Auto-generated method stub
        Log.e("view", "onFling");
        if (e1.getX() - e2.getX() > FLING_MIN_DISTANCE
                && Math.abs(velocityX) > FLING_MIN_VELOCITY) {
            Log.e("fling", "left");
            showNextView();
            showNext = true;
//			return true;
        } else if (e2.getX() - e1.getX() > FLING_MIN_DISTANCE
                && Math.abs(velocityX) > FLING_MIN_VELOCITY) {
            Log.e("fling", "right");
            showPreviousView();
            showNext = false;
//			return true;
        }
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
                            float distanceY) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        // TODO Auto-generated method stub
        return mGestureDetector.onTouchEvent(event);
    }

    Thread thread = new Thread() {

        @Override
        public void run() {
            // TODO Auto-generated method stub
            while (isRun) {
                try {
                    Thread.sleep(1000 * 8);
                    Message msg = new Message();
                    msg.what = SHOW_NEXT;
                    mHandler.sendMessage(msg);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

    };

    private void showNextView() {

        viewFlipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.push_left_in));
        viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.push_left_out));
        viewFlipper.showNext();
        currentPage++;
        if (currentPage == viewFlipper.getChildCount()) {
            displayRatio_normal(currentPage - 1);
            currentPage = 0;
            displayRatio_selelct(currentPage);
        } else {
            displayRatio_selelct(currentPage);
            displayRatio_normal(currentPage - 1);
        }
        Log.e("currentPage", currentPage + "");

    }

    private void showPreviousView() {
        displayRatio_selelct(currentPage);
        viewFlipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.push_right_in));
        viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.push_right_out));
        viewFlipper.showPrevious();
        currentPage--;
        if (currentPage == -1) {
            displayRatio_normal(currentPage + 1);
            currentPage = viewFlipper.getChildCount() - 1;
            displayRatio_selelct(currentPage);
        } else {
            displayRatio_selelct(currentPage);
            displayRatio_normal(currentPage + 1);
        }
        Log.e("currentPage", currentPage + "");
    }

    private void displayRatio_selelct(int id) {
        int[] ratioId = {R.id.home_ratio_img_04, R.id.home_ratio_img_03, R.id.home_ratio_img_02, R.id.home_ratio_img_01};
        ImageView img = (ImageView) findViewById(ratioId[id]);
        img.setSelected(true);
    }

    private void displayRatio_normal(int id) {
        int[] ratioId = {R.id.home_ratio_img_04, R.id.home_ratio_img_03, R.id.home_ratio_img_02, R.id.home_ratio_img_01};
        ImageView img = (ImageView) findViewById(ratioId[id]);
        img.setSelected(false);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            isRun = false;
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        finish();
        super.onDestroy();
    }

    private void toastInfo(String string) {
        Toast.makeText(TestUIActivity.this, string, Toast.LENGTH_SHORT).show();
    }

    String httpUrl = "http://apis.baidu.com/txapi/health/health";
    String httpArg = "num=10&page=1";
    String jsonResult ;
    //System.out.println(jsonResult);

    public void showhealthymsg(){

        (new Thread(){
            @Override
            public void run() {
                super.run();
                BufferedReader reader = null;
                String result = null;
                StringBuffer sbf = new StringBuffer();
                httpUrl = httpUrl + "?" + httpArg;

                try {
                    URL url = new URL(httpUrl);
                    HttpURLConnection connection = (HttpURLConnection) url
                            .openConnection();
                    connection.setRequestMethod("GET");
                    // 填入apikey到HTTP header
                    connection.setRequestProperty("apikey",  "2971243f61b450c3d5e00fda852939b1");
                    connection.connect();
                    InputStream is = connection.getInputStream();
                    reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                    String strRead = null;
                    while ((strRead = reader.readLine()) != null) {
                        sbf.append(strRead);
                        sbf.append("\r\n");
                    }
                    reader.close();
                    result = sbf.toString();

                    Message m=new Message();
                    Bundle b=new Bundle();
                    b.putSerializable("str",result);
                    m.setData(b);
                    h.sendMessage(m);

                } catch (Exception e) {
                    Log.e("error",e.toString());
                    e.printStackTrace();
                }

            }
        }).start();


    }



}