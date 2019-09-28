package com.turan.dao;

import com.turan.po.CommonAlarm;
import com.turan.po.CommonAlarmExample;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * CommonAlarmDAO继承基类
 */
@Repository
public interface CommonAlarmDAO extends MyBatisBaseDao<CommonAlarm, Long, CommonAlarmExample>
{
    int insertList(List<CommonAlarm> records);
}