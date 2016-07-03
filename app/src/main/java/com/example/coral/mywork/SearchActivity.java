package com.example.coral.mywork;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/6/27.
 */
public class SearchActivity extends Activity {
    private LinearLayout home_img_bn_Layout, search_img_bn_layout, cam_img_bn_layout, login_img_bn_layout, show_img_bn_layout;
    private Button button;
    EditText et;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchlayout);
        home_img_bn_Layout = (LinearLayout) findViewById(R.id.bottom_home_layout_ly);
        home_img_bn_Layout.setOnClickListener(clickListener_home);
        home_img_bn_Layout.setSelected(false);

        search_img_bn_layout = (LinearLayout) findViewById(R.id.bottom_style_layout_ly);
        search_img_bn_layout.setSelected(true);
        search_img_bn_layout.setClickable(false);

        login_img_bn_layout = (LinearLayout) findViewById(R.id.bottom_shopping_layout_ly);
        login_img_bn_layout.setOnClickListener(clickListener_mine);
        login_img_bn_layout.setSelected(false);

        //searchactivity = (RelativeLayout) findViewById(R.id.searchlayout);
        et = (EditText) findViewById(R.id.nameofmedicine);

        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(search);

        lv = (ListView) findViewById(R.id.medicine);
        lv.setOnScrollListener(scrollListener);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                searchdetail(list.get(position).get("drugid"));
            }
        });


    }

    List<Map<String, String>> list = new ArrayList<Map<String, String>>();

    private View.OnClickListener clickListener_home = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            home_img_bn_Layout.setSelected(true);
            search_img_bn_layout.setSelected(false);
            login_img_bn_layout.setSelected(false);
            Intent intent = new Intent();
            intent.setClass(SearchActivity.this, TestUIActivity.class);
            intent.putExtra("clickble", true);
            startActivity(intent);
        }
    };

    private View.OnClickListener clickListener_mine = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            home_img_bn_Layout.setSelected(false);
            search_img_bn_layout.setSelected(false);
            login_img_bn_layout.setSelected(true);
//            Intent intent = new Intent();
//            intent.setClass(SearchActivity.this, LoginActivity.class);
//            intent.putExtra("clickble", true);
//            startActivity(intent);

            Intent intent = new Intent();
            intent.setClass(SearchActivity.this, NearbyMap.class);
            //intent.putExtra("clickble", true);
            startActivity(intent);

        }
    };

    int page = 1;


    private View.OnClickListener search = new View.OnClickListener() {

        //String httpUrl = "http://apis.baidu.com/medlive/drugs/drugapi";

        //String httpArg = "type=list&key="+medicineinfo+"&page=" + page + "&pagesize=10";
        @Override
        public void onClick(View v) {
            String medicineinfo = et.getText().toString();
            searchlist(medicineinfo);
            list.clear();


        }
    };

    private AbsListView.OnScrollListener scrollListener = new AbsListView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(AbsListView view, int scrollState) {

        }

        @Override
        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            if (firstVisibleItem + visibleItemCount >= totalItemCount) {
                // list.clear();
                page++;
                //searchlist("阿莫西林");
            }
        }
    };

    public void searchdetail(String drugid) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://apis.baidu.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        SearchMedicineDetail smd = retrofit.create(SearchMedicineDetail.class);
        Call<MedicineBean> call = smd.searchdetail("2971243f61b450c3d5e00fda852939b1", "show", drugid);
        call.enqueue(new Callback<MedicineBean>() {
            @Override
            public void onResponse(Call<MedicineBean> call, Response<MedicineBean> response) {
                MedicineBean mb2 = response.body();
                List<MedicineBean.RetDataBean.DetailBean> ll2 = mb2.getRetData().getDetail();
                StringBuffer detail = new StringBuffer();
                for (MedicineBean.RetDataBean.DetailBean medicine2 : ll2) {
                    Map<String, String> map = new HashMap<String, String>();
                    medicine2.getDdf_name();
                    medicine2.getDd_value();
                    detail.append("\r\n[" + medicine2.getDdf_name() + "]" + Html.fromHtml(medicine2.getDd_value()) + "\r\n");

                }

                Intent i2 = new Intent(SearchActivity.this, MedicineDetail.class);
                i2.putExtra("medicinedetail", detail.toString());
                startActivity(i2);
            }

            @Override
            public void onFailure(Call<MedicineBean> call, Throwable t) {

            }
        });
    }

    public void searchlist(String name) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://apis.baidu.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        SearchMedicineList sml = retrofit.create(SearchMedicineList.class);
        Call<MedicineListBean> call = sml.searchlist("2971243f61b450c3d5e00fda852939b1", "list", name, page, "20");
        call.enqueue(new Callback<MedicineListBean>() {
            @Override
            public void onResponse(Call<MedicineListBean> call, Response<MedicineListBean> response) {
                MedicineListBean mlb = response.body();
                try{
                    List<MedicineListBean.RetDataBean.DataBean> ll = mlb.getRetData().getData();
                    for (MedicineListBean.RetDataBean.DataBean medicine : ll) {
                        Map<String, String> map = new HashMap<String, String>();
                        String drugId = medicine.getDrugId();
                        map.put("drugid", drugId);
                        String value = medicine.getDsName();
                        map.put("drugname", value);
                        list.add(map);

                    }
                    SimpleAdapter sa = new SimpleAdapter(SearchActivity.this, list, R.layout.medicinelist, new String[]{"drugname"}, new int[]{R.id.medicinedisc});
                    lv.setAdapter(sa);

                }catch(Exception e) {
                    Toast.makeText(SearchActivity.this, "百度接口异常！请稍后再试！", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }




            }

            @Override
            public void onFailure(Call<MedicineListBean> call, Throwable t) {

            }
        });
    }

}
