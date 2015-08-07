package uk.ostmodern.incoming.test.models;

import uk.ostmodern.incoming.test.api.gson_models.ItemsModel;

import java.io.Serializable;

/**
 * Created by sniper on 8/20/15.
 */
public class CardViewModel implements Serializable{

    private String title;
    private int cashedFilmCount;
    private boolean hasPrice;
    private boolean isActive;
    private String publishDate;
    private String summary;
    private String image;
    private String quote;
    private String body;
    private ItemsModel[] items;

    private static final String [] DEFAULT_IMAGES = new String [] {
            "http://feature-code-test.skylark-cms.qa.aws.ostmodern.co.uk:8000/static/images/dummy/dummy-film.jpg",
            "https://skylark-qa-fixtures.s3.amazonaws.com/media/images/stills/film/952/QCdjB5HwFOTaWQ8X4xMDoxOjAwMTt5zx.jpg?Signature=mZqA6FKDQOPMJPMC9%2BYGr1NZTqc%3D&Expires=1438447593&AWSAccessKeyId=AKIAIAGQAAEZJZUE4JIA",
            "https://skylark-qa-fixtures.s3.amazonaws.com/media/images/stills/film/96/QCdjB5HwFOTaWQ8X4xMDoxOjA4MTsiGN.jpg?Signature=%2FC%2FQ%2FnTCDa9fTtudKyJxu64xM3Q%3D&Expires=1438443101&AWSAccessKeyId=AKIAIAGQAAEZJZUE4JIA",
            "http://feature-code-test.skylark-cms.qa.aws.ostmodern.co.uk:8000/static/images/dummy/dummy-film.jpg",
            "https://skylark-qa-fixtures.s3.amazonaws.com/media/images/stills/film/992/promo206969562.jpg?Signature=f%2F%2FAv%2Fk4FpQP1fZ9fUsHAaZjBlM%3D&Expires=1438443154&AWSAccessKeyId=AKIAIAGQAAEZJZUE4JIA",
            "https://skylark-qa-fixtures.s3.amazonaws.com/media/images/stills/film/958/promo217595590.jpg?Signature=wkygYLa0LIwr%2B6sTNVN6cCKxRG0%3D&Expires=1438443187&AWSAccessKeyId=AKIAIAGQAAEZJZUE4JIA",
            "https://skylark-qa-fixtures.s3.amazonaws.com/media/images/stills/film/963/promo210349613.jpg?Signature=vvWZb%2FhCYTcrnjDm01pgEC7ezrk%3D&Expires=1438443215&AWSAccessKeyId=AKIAIAGQAAEZJZUE4JIA",
            "https://skylark-qa-fixtures.s3.amazonaws.com/media/images/stills/film/986/promo211222038.jpg?Signature=laODiQ4zsGYY%2FIgb17aKp%2B5OUQg%3D&Expires=1438443245&AWSAccessKeyId=AKIAIAGQAAEZJZUE4JIA",
            "https://skylark-qa-fixtures.s3.amazonaws.com/media/images/stills/film/950/3Gduepif0T1UGY8H4xMDoxOjAwMTt5zx-1920x1080.jpg?Signature=YB%2FF3K0V%2FsHV21GmZAJXlpKMFu8%3D&Expires=1438443266&AWSAccessKeyId=AKIAIAGQAAEZJZUE4JIA",
            "https://skylark-qa-fixtures.s3.amazonaws.com/media/images/stills/film/975/promo216994560-640x360.jpg?Signature=RRxsmjsFF8oKuXm1Wz246G%2BoaEk%3D&Expires=1438443293&AWSAccessKeyId=AKIAIAGQAAEZJZUE4JIA",
            "https://skylark-qa-fixtures.s3.amazonaws.com/media/images/stills/film/982/promo224190615.jpg?Signature=t29EWj%2B0Yx%2FYvnB%2FoNNB36Ij8dk%3D&Expires=1438443314&AWSAccessKeyId=AKIAIAGQAAEZJZUE4JIA",
            "https://skylark-qa-fixtures.s3.amazonaws.com/media/images/stills/film/99/promo210347606.jpg?Signature=O62OaBor66yf8MQMAYeUTMIfQe8%3D&Expires=1438443338&AWSAccessKeyId=AKIAIAGQAAEZJZUE4JIA",
            "http://feature-code-test.skylark-cms.qa.aws.ostmodern.co.uk:8000/static/images/dummy/dummy-film.jpg",
            "http://feature-code-test.skylark-cms.qa.aws.ostmodern.co.uk:8000/static/images/dummy/dummy-film.jpg",
            "https://skylark-qa-fixtures.s3.amazonaws.com/media/images/stills/film/966/promo210349445.jpg?Signature=A1Dm4hbY95chn5NQDl17%2BVqIr9A%3D&Expires=1438443396&AWSAccessKeyId=AKIAIAGQAAEZJZUE4JIA",
            "http://feature-code-test.skylark-cms.qa.aws.ostmodern.co.uk:8000/static/images/dummy/dummy-film.jpg",
            "https://skylark-qa-fixtures.s3.amazonaws.com/media/images/stills/film/97/promo222519196.jpg?Signature=N7weDLCx7c4Qpxs39ZGL0aRh3M4%3D&Expires=1438443434&AWSAccessKeyId=AKIAIAGQAAEZJZUE4JIA",
            "https://skylark-qa-fixtures.s3.amazonaws.com/media/images/stills/film/980/promo210350250.jpg?Signature=fd2m%2FDZb%2BML%2B7tbp0c7YLsevmrg%3D&Expires=1438443458&AWSAccessKeyId=AKIAIAGQAAEZJZUE4JIA",
            "https://skylark-qa-fixtures.s3.amazonaws.com/media/images/stills/film/954/promo216819374.jpg?Signature=kqrJWa6%2FfjE6dz4HF2OzxONfIzo%3D&Expires=1438443482&AWSAccessKeyId=AKIAIAGQAAEZJZUE4JIA",
            "http://feature-code-test.skylark-cms.qa.aws.ostmodern.co.uk:8000/static/images/dummy/dummy-film.jpg",
            };

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getCashedFilmCount() {
        return cashedFilmCount;
    }

    public void setCashedFilmCount(int cashedFilmCount) {
        this.cashedFilmCount = cashedFilmCount;
    }

    public boolean isHasPrice() {
        return hasPrice;
    }

    public void setHasPrice(boolean hasPrice) {
        this.hasPrice = hasPrice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDefaultImage(int position){
        return DEFAULT_IMAGES[position];
    }

    public ItemsModel[] getItems() {
        return items;
    }

    public void setItems(ItemsModel[] items) {
        this.items = items;
    }
}
