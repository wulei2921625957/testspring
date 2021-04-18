package com.wu.dao.impl;

import com.wu.dao.OpRecordDao;
import com.wu.pojo.OpRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;

/**
 * @author: 吴磊
 * @program: testspring
 * @create: 2021-04-14 21:19
 */

@Repository
public class OpRecordDaoImpl implements OpRecordDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer saveOpRecord(OpRecord opRecord) {
        String sql = "insert into oprecord (accountid, opmoney, optime, optype, transferid) VALUES (?,?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});//第二个参数的意思是返回这个字段生成的键
            ps.setInt(1, opRecord.getAccountid());
            ps.setDouble(2, opRecord.getOpmoney());
            ps.setDate(3, new Date(opRecord.getOptime().getTime()));
            ps.setString(4, opRecord.getOptype());
            ps.setString(5, opRecord.getTransferid());
            return ps;
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

    @Override
    public List<OpRecord> findAll() {

        String sql = "select * from oprecord";
        List<OpRecord> query = jdbcTemplate.query(sql, (rs, row) -> {
            OpRecord opRecord = new OpRecord();
            opRecord.setId(rs.getInt("ID"));
            opRecord.setAccountid(rs.getInt("ACCOUNTID"));
            opRecord.setOpmoney(rs.getDouble("OPMONEY"));
            opRecord.setOptime(rs.getTimestamp("OPTIME"));
            opRecord.setTransferid(rs.getString("TRANSFERID"));
            opRecord.setOptype(rs.getString("OPTYPE"));
            return opRecord;
        });
        return query;
    }

    @Override
    public List<OpRecord> findByOpRecord(int opRecordid) {

        String sql = "select * from oprecord where id = ?";
        List<OpRecord> query = jdbcTemplate.query(sql, (rs, row) -> {
            OpRecord opRecord = new OpRecord();
            opRecord.setId(rs.getInt("ID"));
            opRecord.setAccountid(rs.getInt("ACCOUNTID"));
            opRecord.setOpmoney(rs.getDouble("OPMONEY"));
            opRecord.setOptime(rs.getTimestamp("OPTIME"));
            opRecord.setTransferid(rs.getString("TRANSFERID"));
            opRecord.setOptype(rs.getString("OPTYPE"));
            return opRecord;
        }, opRecordid);

        return query;
    }
}
