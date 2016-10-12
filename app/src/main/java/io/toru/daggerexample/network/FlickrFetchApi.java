package io.toru.daggerexample.network;

import io.toru.daggerexample.pattern.model.PhotoThumbnailJsonItem;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by toru on 2016. 10. 11..
 */

public interface FlickrFetchApi {

    // example
//    https://api.flickr.com/services/rest/?method=flickr.photos.getRecent&api_key=4d31be9c8349b2240703d3c35504aa39&format=json&nojsoncallback=1
    @GET("?method=flickr.photos.getRecent&api_key=4d31be9c8349b2240703d3c35504aa39&format=json&nojsoncallback=1&extras=url_t")
    Call<PhotoThumbnailJsonItem> loadRecentImage();

    @GET("?method=flickr.photos.getRecent&api_key=4d31be9c8349b2240703d3c35504aa39&format=json&nojsoncallback=1&extras=url_s")
    Call<PhotoThumbnailJsonItem> loadSearchResultImage();
}


