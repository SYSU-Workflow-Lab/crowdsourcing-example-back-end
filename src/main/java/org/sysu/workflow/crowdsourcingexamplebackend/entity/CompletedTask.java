package org.sysu.workflow.crowdsourcingexamplebackend.entity;

import javax.persistence.*;

/**
 * Created by Skye on 2018/10/9.
 */
@Entity
public class CompletedTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 提交者id
     */
    @Column(nullable = false)
    private String userId;

    /**
     * 提交内容
     */
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(nullable = false)
    private String content;

    /**
     * 提交子任务index
     */
    @Column(nullable = false)
    private String subTaskIndex;

    public CompletedTask() {
    }

    public CompletedTask(String userId, String content, String subTaskIndex) {
        this.userId = userId;
        this.content = content;
        this.subTaskIndex = subTaskIndex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSubTaskIndex() {
        return subTaskIndex;
    }

    public void setSubTaskIndex(String subTaskIndex) {
        this.subTaskIndex = subTaskIndex;
    }
}
