package com.cs.live.http;

import com.cs.live.bean.LiveCategory;
import com.cs.live.bean.LiveListResult;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * 直播网络API
 */

public interface APIService {

    /**
     * 获取App启动页信息
     * @return
     */
    @GET("json/page/app-data/info.json?v=3.0.1&os=1&ver=4")
    Observable<ResponseBody> getAppStartInfo();

    /**
     * 获取分类列表
     */
    @GET("json/app/index/category/info-android.json?v=3.0.1&os=1&ver=4")
    Observable<List<LiveCategory>> getAllCategories();

    /**
     * 获取推荐列表
     *
     * @return
     */
    @GET("json/app/index/recommend/list-android.json?v=3.0.1&os=1&ver=4")
    Observable<ResponseBody> getRecommend();


    /**
     * 获取直播列表
     */
    @GET("json/play/list.json?v=3.0.1&os=1&ver=4")
    Observable<LiveListResult> getLiveList();


    /**
     * 根据分类slug获取该类直播列表
     */
    @GET("json/categories/{slug}/list.json?v=3.0.1&os=1&ver=4")
    Observable<LiveListResult> getLiveListByCategories(@Path("slug") String slug);

    /**
     * 进入房间
     *
     * @param uid
     * @return
     */
    @GET("json/rooms/{uid}/info.json?v=3.0.1&os=1&ver=4")
    Observable<ResponseBody> enterRoom(@Path("uid") String uid);

    /**
     * 搜索
     * @param searchRequestBody
     * @return
     */
//    @POST("site/search")
//    Observable<SearchResult> search(@Body SearchRequestBody searchRequestBody);

}
