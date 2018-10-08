package org.sysu.workflow.crowdsourcingexamplebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.sysu.workflow.crowdsourcingexamplebackend.entity.Election;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Skye on 2018/10/8.
 */
public interface ElectionRepository extends JpaRepository<Election, Long> {

    @Transactional
    void deleteElectionByFromId(String fromId);

    @Transactional
    @Modifying
    @Query(value = "delete from election where true", nativeQuery = true)
    void deleteAll();

    @Query(value = "select target_id, count(*) as count from election group by target_id order by count desc", nativeQuery = true)
    List<Object[]> findTheBestUserId();

}
