package com.wu.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: 吴磊
 * @program: testspring
 * @create: 2021-04-24 20:38
 */
@Data
public class AccountVO implements Serializable {
    private static final long serialVersionUID = 4253824737249230542L;
    private Integer AccountId;
    private Double money;
    private Integer inAccountId;
}
