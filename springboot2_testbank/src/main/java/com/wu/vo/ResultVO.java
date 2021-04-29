package com.wu.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: 吴磊
 * @program: testspring
 * @create: 2021-04-24 20:40
 */
@Data
public class ResultVO<T> implements Serializable {
    private static final long serialVersionUID = 487830793375998294L;
    private Integer code;
    private T data;
    private String msg;
}
