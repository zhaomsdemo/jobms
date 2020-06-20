package com.zjh.jobms.service;

import com.zjh.jobms.dto.JobPositionDto;
import com.zjh.jobms.entity.JobPosition;
import com.zjh.jobms.repository.JobOpportunityRepository;
import com.zjh.jobms.util.JobPositionConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service("JobPositionService")
@Slf4j
public class JobPositionServiceImpl implements JobPositionService {

    @Autowired
    private JobOpportunityRepository repository;

    @Override
    public List<JobPositionDto> getJobPositionsByTitle(String title, int pageNum, int pageSize) {
        String likeTitle = "%" + title + "%";
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.by(Sort.Direction.DESC, "id"));
        Page<JobPosition> page = repository.findByJobTitleLike(likeTitle, pageable);

        List<JobPosition> jobPositions = page != null ? page.getContent() : Collections.EMPTY_LIST;
        List<JobPositionDto> jobPositionDtos = jobPositions.stream().map(
                jobPosition -> JobPositionConverter.toJobPositionDto(jobPosition)).collect(Collectors.toList());

        return jobPositionDtos;
    }

    @Override
    public List<JobPositionDto> getJoPositionsByParams(JobPositionDto jobDto, Pageable pageable) {
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withMatcher("jobTitle", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("jobDescription", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("company", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withIgnorePaths("openPositions", "status")
                .withIgnoreNullValues();
        JobPosition jobEntity = JobPositionConverter.toJobEntity(jobDto);
        Example example = Example.of(jobEntity, exampleMatcher);

        Page<JobPosition> page = repository.findAll(example, pageable);

        List<JobPosition> jobPositions = page != null ? page.getContent() : Collections.EMPTY_LIST;
        List<JobPositionDto> jobPositionDtos = jobPositions.stream().map(
                jobPosition -> JobPositionConverter.toJobPositionDto(jobPosition)).collect(Collectors.toList());

        return jobPositionDtos;
    }

    @Override
    public List<JobPositionDto> getAllJobPositions(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.by(Sort.Direction.DESC, "id"));
        Page<JobPosition> page = repository.findAll(pageable);
        List<JobPosition> jobPositions = page != null ? page.getContent() : Collections.EMPTY_LIST;
        List<JobPositionDto> jobPositionDtos = jobPositions.stream().map(
                jobPosition -> JobPositionConverter.toJobPositionDto(jobPosition)).collect(Collectors.toList());

        return jobPositionDtos;
    }

    @Override
    public JobPositionDto createNewJob(JobPositionDto jobPositionDto) {
        JobPosition jobPosition = JobPositionConverter.toJobEntity(jobPositionDto);
        jobPosition = repository.save(jobPosition);
        JobPositionDto dto = JobPositionConverter.toJobPositionDto(jobPosition);
        return dto;
    }
}
