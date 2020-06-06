package com.zjh.jobms.service;

import com.zjh.jobms.dto.JobPositionDto;
import com.zjh.jobms.entity.JobPosition;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface JobPositionService {

    List<JobPositionDto> getJobPositionsByTitle(String title, int pageNum, int pageSize);

    List<JobPositionDto> getJoPositionsByParams(JobPositionDto dto, Pageable pageable);

    List<JobPositionDto> getAllJobPositions(int pageNum, int pageSize);

    JobPositionDto createNewJob(JobPositionDto jobPositionDto);
}
