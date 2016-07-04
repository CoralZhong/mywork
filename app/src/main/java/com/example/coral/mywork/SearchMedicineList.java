package com.example.coral.mywork;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2016/6/30.
 */
public interface SearchMedicineList {
    @GET("/medlive/drugs/drugapi")
    Call<MedicineListBean> searchlist(@Header("apikey") String apikey, @Query("type") String type, @Query("key") String key,@Query("page") int page,@Query("pagesize") String pagesize);
}
