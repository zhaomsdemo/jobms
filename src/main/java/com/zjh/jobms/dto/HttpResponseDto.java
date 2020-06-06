package com.zjh.jobms.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HttpResponseDto<T> {

    private int code;
    private String message;
    private int count;
    private T data;
}
