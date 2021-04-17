package com.wu.tx.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: 吴磊
 * @program: testspring
 * @create: 2021-04-14 21:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpRecord {
    private Integer id;
    private Integer accountid;
    private Double opmoney;
    private Date optime;
    private String optype;
    private String transferid;
}
