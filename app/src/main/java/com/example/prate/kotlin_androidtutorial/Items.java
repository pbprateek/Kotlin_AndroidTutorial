package com.example.prate.kotlin_androidtutorial;

/**
 * Created by prate on 02-09-2017.
 */

public class Items {
    private String title;
    private int imageid;
    private String html;
    public Items(String a,int b,String c){
        title=a;
        imageid=b;
        html=c;
    }
    public String getTitle(){return title;}
    public int getImageid(){return imageid;}
    public String getHtml(){return html;}
}
