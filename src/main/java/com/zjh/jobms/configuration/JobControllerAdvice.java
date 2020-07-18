package com.zjh.jobms.configuration;

import com.zjh.jobms.dto.HttpResponseDto;
import com.zjh.jobms.dto.JobPositionDto;
import com.zjh.jobms.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
@Slf4j
public class JobControllerAdvice {

    @ExceptionHandler(value = {NotFoundException.class, EntityNotFoundException.class})
    @ResponseBody
    public HttpResponseDto<JobPositionDto> handleNotFoundException(Exception e){
        log.error(e.getMessage());

        HttpResponseDto httpResponseDto = new HttpResponseDto();
        httpResponseDto.setCount(0);
        httpResponseDto.setCode(400);
        httpResponseDto.setMessage("没有相关数据");

        return httpResponseDto;
    }
}
