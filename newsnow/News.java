package com.example.nysil.newsnow;

/**
 * Created by nysil on 28-01-2018.
 */

class News {

    private String heading;
    private String stroy;
    private String imageUrl;
    News(String heading, String story, String imageUrl)
    {
        this.heading=heading;
        this.stroy=story;
        this.imageUrl=imageUrl;
    }

    public String getHeading()
    {
        return heading;
    }

    public String getStroy()
    {
        return stroy;
    }

    public String getImageUrl()
    {
        return imageUrl;
    }
}
