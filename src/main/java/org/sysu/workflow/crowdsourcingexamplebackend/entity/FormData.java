package org.sysu.workflow.crowdsourcingexamplebackend.entity;

/**
 * Created by Skye on 2018/9/29.
 */
public class FormData {

    private String userId;
    private Object data;

    public FormData() {
    }

    public FormData(String userId, String data) {
        this.userId = userId;
        this.data = data;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
