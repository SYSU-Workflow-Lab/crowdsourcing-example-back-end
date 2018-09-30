package org.sysu.workflow.crowdsourcingexamplebackend.entity;

import javax.persistence.*;

/**
 * Created by Skye on 2018/9/29.
 */
@Entity
public class SubTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userId;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(nullable = false)
    private String subtask;

    public SubTask() {
    }

    public SubTask(String userId, String subtask) {
        this.userId = userId;
        this.subtask = subtask;
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

    public String getSubtask() {
        return subtask;
    }

    public void setSubtask(String subtask) {
        this.subtask = subtask;
    }
}
