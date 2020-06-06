package com.zjh.jobms.entity;

import com.zjh.jobms.enums.JobStatus;
import com.zjh.jobms.enums.JobType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table
@Data
@NoArgsConstructor
public class JobPosition extends BaseEntity {
    @Column(nullable = false)
    private String jobTitle;
    @Column(nullable = false)
    private String company;
    @Column(nullable = false)
    private String jobDescription;
    @Column(columnDefinition = "tinyint(2)")
    private JobStatus status;
    @Column
    private String duration;
    @Column
    private Integer openPositions;
    @Column(columnDefinition = "tinyint(2)")
    private JobType jobType;
    @Column
    private BigDecimal minWage;
    @Column
    private BigDecimal maxWage;
    @Column
    private String locations;
}
