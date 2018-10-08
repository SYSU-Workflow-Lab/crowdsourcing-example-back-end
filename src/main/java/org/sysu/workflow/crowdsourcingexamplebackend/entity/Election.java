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

    @Column(nullable = false)
    private String fromId;

    @Column(nullable = false)
    private String targetId;

    public Election() {
    }

    public Election(String fromId, String targetId) {
        this.fromId = fromId;
        this.targetId = targetId;
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
}