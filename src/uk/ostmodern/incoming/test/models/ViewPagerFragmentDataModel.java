package uk.ostmodern.incoming.test.models;

import java.io.Serializable;

/**
 * Created by sniper on 2015.
 */
public class ViewPagerFragmentDataModel implements Serializable{
    private String title;
    private String text;

    public ViewPagerFragmentDataModel(String title, String text){
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
