package io.toru.daggerexample.pattern.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by toru on 2016. 10. 11..
 */

public class PhotoThumbnailList {
    public String page;
    public String pages;
    public String total;
    public List<PhotoThumbnailItem> photo = new ArrayList<>();
}
