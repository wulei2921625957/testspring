package com.wu.tx.dao;

import com.wu.tx.Bean.OpRecord;

import java.util.List;

/**
 * @author: 吴磊
 * @program: testspring
 * @create: 2021-04-14 21:10
 */
public interface OpRecordDao {
    Integer saveOpRecord(OpRecord opRecord);

    List<OpRecord> findAll();

    List<OpRecord> findByOpRecord(int opRecordid);
}
