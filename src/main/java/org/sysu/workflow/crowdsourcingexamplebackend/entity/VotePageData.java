package org.sysu.workflow.crowdsourcingexamplebackend.entity;

import java.util.List;

/**
 * Created by Skye on 2018/10/3.
 */
public class VotePageData {

    private String userId;

    private List<String> data;

    public VotePageData() {
    }

    public VotePageData(String userId, List<String> data) {
        this.userId = userId;
        this.data = data;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
