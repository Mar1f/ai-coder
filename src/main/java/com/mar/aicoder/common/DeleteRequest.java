package com.mar.aicoder.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @description；删除请求包装类
 * @author:mar1
 * @data:2025/08/05
 **/
@Data
public class DeleteRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    private static final long serialVersionUID = 1L;
}