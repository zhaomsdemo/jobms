package com.zjh.jobms.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JobPositionDto {
    private String jobId;
    private String jobTitle;
    private String company;
    private String jobDescription;
    private String duration;
    private int openPositions;
}
