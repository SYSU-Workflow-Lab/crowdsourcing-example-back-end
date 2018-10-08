package org.sysu.workflow.crowdsourcingexamplebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.sysu.workflow.crowdsourcingexamplebackend.entity.TipsAndTasks;

/**
 * Created by Skye on 2018/9/30.
 */
public interface TipsAndTasksRepository extends JpaRepository<TipsAndTasks, Long> {

    TipsAndTasks findByStageAndType(String stage, int type);

}
