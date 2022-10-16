package com.laioffer.my_rxjava.L2_Rx_Retrofit.use.api;


import com.laioffer.my_rxjava.L2_Rx_Retrofit.use.bean.ProjectBean;
import com.laioffer.my_rxjava.L2_Rx_Retrofit.use.bean.ProjectItem;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WangAndroidApi {

  // 总数据
  @GET("project/tree/json")
  Observable<ProjectBean> getProject();  // 异步线程 耗时操作

  // Item数据
  @GET("project/list/{pageIndex}/json")
  // ?cid=294
  Observable<ProjectItem> getProjectItem(
      @Path("pageIndex") int pageIndex,
      @Query("cid") int cid);  // 异步线程 耗时操作
}
