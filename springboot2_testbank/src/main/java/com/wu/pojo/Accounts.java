package com.wu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: 吴磊
 * @program: testspring
 * @create: 2021-04-14 20:21
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Accounts {
    private Integer accountId;
    private double balance;
}
