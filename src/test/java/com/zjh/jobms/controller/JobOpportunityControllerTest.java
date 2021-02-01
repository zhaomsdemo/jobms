package com.zjh.jobms.controller;

import com.zjh.jobms.dto.HttpResponseDto;
import com.zjh.jobms.dto.JobPositionDto;
import com.zjh.jobms.service.JobPositionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class JobOpportunityControllerTest {

    @Mock
    private JobPositionService jobPositionService;

    @InjectMocks
    private JobOpportunityController jobOpportunityController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getJobById() {
        when(jobPositionService.getJobById(anyString())).thenReturn(goodJobPositionDto());
        HttpResponseDto<JobPositionDto> responseDto = jobOpportunityController.getJobById("123");
        assertNotNull(responseDto);
    }

    @Test
    void getAllJobs() {
    }

    @Test
    void getJobPositions() {
    }

    @Test
    void postJobPosition() {
    }

    private JobPositionDto goodJobPositionDto() {
        JobPositionDto jobPositionDto = new JobPositionDto();
        jobPositionDto.setCompany("test company");
        jobPositionDto.setDuration("6 months");
        jobPositionDto.setOpenPositions(1);
        jobPositionDto.setJobDescription("This is a test job");
        jobPositionDto.setJobTitle("Software Engineer");
        return jobPositionDto;
    }
}