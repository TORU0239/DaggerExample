package io.toru.daggerexample.pattern.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by toru on 2016. 10. 12..
 */

public class SearchedPhotoList {
    public String page;
    public String pates;
    public String perpage;
    public String total;
    public List<SearchedPhotoItem> searchedPhotoItemList = new ArrayList<>();
}
