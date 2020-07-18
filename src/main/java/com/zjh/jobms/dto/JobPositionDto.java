package com.zjh.jobms.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class JobPositionDto {
    private String jobId;
    @NotNull
    private String jobTitle;
    private String company;
    private String jobDescription;
    private String duration;
    private int openPositions;
}
