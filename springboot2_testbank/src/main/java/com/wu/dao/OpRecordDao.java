package com.wu.dao;


import com.wu.pojo.OpRecord;

import java.util.List;

/**
 * @author: 吴磊
 * @program: testspring
 * @create: 2021-04-14 21:10
 */
public interface OpRecordDao {
    /**
     * 保存流水
     *
     * @param opRecord
     * @return
     */
    Integer saveOpRecord(OpRecord opRecord);

    /**
     * 查找所有流水
     *
     * @return
     */
    List<OpRecord> findAll();

    /**
     * 根据流水ID查询流水
     *
     * @param opRecordid
     * @return
     */
    List<OpRecord> findByOpRecord(int opRecordid);
}
