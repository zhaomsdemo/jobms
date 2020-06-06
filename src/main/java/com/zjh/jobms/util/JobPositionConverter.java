package com.zjh.jobms.util;

import com.zjh.jobms.dto.JobPositionDto;
import com.zjh.jobms.entity.JobPosition;
import com.zjh.jobms.enums.JobStatus;
import org.springframework.util.StringUtils;

public class JobPositionConverter {

    public static JobPosition toJobEntity(JobPositionDto dto){
        JobPosition jobPosition = new JobPosition();
        if(!StringUtils.isEmpty(dto.getJobId())){
            jobPosition.setId(dto.getJobId());
        }
        jobPosition.setJobTitle(dto.getJobTitle());
        jobPosition.setCompany(dto.getCompany());
        jobPosition.setDuration(dto.getDuration());
        jobPosition.setOpenPositions(dto.getOpenPositions());
        jobPosition.setJobDescription(dto.getJobDescription());
        jobPosition.setStatus(JobStatus.DRAFT);

        return jobPosition;
    }

    public static JobPositionDto toJobPositionDto(JobPosition jobPosition) {
        JobPositionDto jobPositionDto = new JobPositionDto();
        jobPositionDto.setJobId(jobPosition.getId());
        jobPositionDto.setCompany(jobPosition.getCompany());
        jobPositionDto.setDuration(jobPosition.getDuration());
        jobPositionDto.setJobTitle(jobPosition.getJobTitle());
        jobPositionDto.setOpenPositions(jobPosition.getOpenPositions());
        jobPositionDto.setJobDescription(jobPosition.getJobDescription());

        return jobPositionDto;
    }
}
