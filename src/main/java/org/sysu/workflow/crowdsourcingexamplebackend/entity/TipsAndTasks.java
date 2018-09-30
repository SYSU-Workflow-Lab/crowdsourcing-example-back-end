package org.sysu.workflow.crowdsourcingexamplebackend.entity;

import javax.persistence.*;

/**
 * Created by Skye on 2018/9/30.
 */
@Entity
public class TipsAndTasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String stage;

    /**
     * 0 for tips
     * 1 for task
     */
    @Column
    private int type;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(nullable = false)
    private String content;

    public TipsAndTasks() {
    }

    public TipsAndTasks(String stage, int type, String content) {
        this.stage = stage;
        this.type = type;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
