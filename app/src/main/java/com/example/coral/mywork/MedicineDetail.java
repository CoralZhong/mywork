package com.example.coral.mywork;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/6/30.
 */
public class MedicineDetail extends Activity{
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicinedetail);
        tv= (TextView) findViewById(R.id.showdetail);
        tv.setMovementMethod(ScrollingMovementMethod.getInstance());
        String detail=getIntent().getStringExtra("medicinedetail");
        tv.setText(detail);
    }
}
