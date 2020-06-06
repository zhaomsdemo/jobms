package com.zjh.jobms.repository;

import com.zjh.jobms.entity.JobPosition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobOpportunityRepository extends JpaRepository<JobPosition, String> {

    Page<JobPosition> findByJobTitleLike(String title, Pageable pageable);

    Page<JobPosition> findAll(Pageable pageable);

}
