package com.zjh.jobms.controller;

import com.zjh.jobms.dto.HttpResponseDto;
import com.zjh.jobms.dto.JobPositionDto;
import com.zjh.jobms.service.JobPositionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jobs")
@Slf4j
public class JobOpportunityController {

    @Autowired
    private JobPositionService jobPositionService;

    @GetMapping("/{jobId}")
    public HttpResponseDto<JobPositionDto> getJobById(@PathVariable String jobId){
        JobPositionDto jobPositionDto = jobPositionService.getJobById(jobId);
        return buildJobResponse(jobPositionDto);
    }

    @GetMapping("/")
    public HttpResponseDto<JobPositionDto> getAllJobs(@PageableDefault(size = 20, sort = "id") Pageable pageable){
        log.info("getAllJobs with parameter {}", pageable);
        List<JobPositionDto> jobPositions = jobPositionService.getAllJobPositions(pageable.getPageNumber(), pageable.getPageSize());
        return buildJobListResponse(jobPositions);
    }

    @GetMapping("/queryByParams")
    public HttpResponseDto<JobPositionDto> getJobPositions(JobPositionDto jobDto
            ,@PageableDefault(size = 20, sort = "id") Pageable pageable) {
        log.info("getJobPositions with parameter {}, {}", jobDto, pageable);
        List<JobPositionDto> jobPositions = jobPositionService.getJoPositionsByParams(jobDto, pageable);
        return buildJobListResponse(jobPositions);
    }

/*    @GetMapping("/findByTitle")
    public List<JobPositionDto> getJobPositions(@RequestParam String title, @RequestParam  int pageNum
            , @RequestParam int pageSize){

        List<JobPositionDto> jobPositions = jobPositionService.getJobPositionsByTitle(title, pageNum, pageSize);
        return jobPositions;
    }*/

    @PostMapping("/")
    public JobPositionDto postJobPosition(@RequestBody JobPositionDto job){
        log.info("postJobPosition with parameter {}", job);
        JobPositionDto newJob = jobPositionService.createNewJob(job);
        return newJob;
    }

    private HttpResponseDto buildJobListResponse(List<JobPositionDto> jobPositions) {
        HttpResponseDto httpResponseDto = new HttpResponseDto<List<JobPositionDto>>();
        httpResponseDto.setCode(0);
        httpResponseDto.setMessage("");
        httpResponseDto.setCount(jobPositions.size());
        httpResponseDto.setData(jobPositions);
        return httpResponseDto;
    }

    private HttpResponseDto buildJobResponse(JobPositionDto jobPositionDto) {
        HttpResponseDto httpResponseDto = new HttpResponseDto<JobPositionDto>();
        httpResponseDto.setData(jobPositionDto);
        httpResponseDto.setCount(1);
        httpResponseDto.setMessage("");
        httpResponseDto.setCode(0);
        return httpResponseDto;
    }
}
