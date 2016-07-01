package com.example.coral.mywork;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2016/6/30.
 */
public interface SearchMedicineDetail {
    @GET("/medlive/drugs/drugapi")
    Call<MedicineBean> searchdetail(@Header("apikey") String apikey,@Query("type") String type,@Query("drugid") String drugid);

}
