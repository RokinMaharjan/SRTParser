/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rokin.srtindexing.entity;

/**
 *
 * @author rokin
 */
public class Element {
    private int id;
    private String word, startTime, endTime, video, comments;

    public Element() {
    }

    public Element(int id, String word, String startTime, String endTIme, String video, String comments) {
        this.id = id;
        this.word = word;
        this.startTime = startTime;
        this.endTime = endTIme;
        this.video = video;
        this.comments = comments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTIme) {
        this.endTime = endTIme;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
    
}
