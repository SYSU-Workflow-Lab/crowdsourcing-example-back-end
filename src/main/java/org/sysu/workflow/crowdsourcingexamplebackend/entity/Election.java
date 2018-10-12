package org.sysu.workflow.crowdsourcingexamplebackend.entity;

import javax.persistence.*;

/**
 * Created by Skye on 2018/10/8.
 */
@Entity
public class Election {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 提交者id
     */
    @Column(nullable = false)
    private String fromId;

    /**
     * 被投票用户id
     */
    @Column(nullable = false)
    private String targetId;

    /**
     * 投票子任务index
     */
    @Column(nullable = false)
    private String subTaskIndex;

    /**
     * 投票任务的阶段
     */
    @Column(nullable = false)
    private String stage;

    public Election() {
    }

    public Election(String fromId, String targetId, String subTaskIndex, String stage) {
        this.fromId = fromId;
        this.targetId = targetId;
        this.subTaskIndex = subTaskIndex;
        this.stage = stage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public String getSubTaskIndex() {
        return subTaskIndex;
    }

    public void setSubTaskIndex(String subTaskIndex) {
        this.subTaskIndex = subTaskIndex;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

}
