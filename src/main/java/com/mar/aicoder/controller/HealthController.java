package com.mar.aicoder.controller;

import com.mar.aicoder.common.BaseResponse;
import com.mar.aicoder.common.ResultUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description；
 * @author:mar1
 * @data:2025/08/05
 **/
@RestController
@RequestMapping("/health")
public class HealthController {

    @GetMapping("/")
    public BaseResponse<String> healthCheck() {
        return ResultUtils.success( "ok");
    }
}

