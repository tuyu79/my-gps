package com.turan.dao;

import com.turan.po.GpsInfo;
import com.turan.po.GpsInfoExample;
import org.springframework.stereotype.Repository;

/**
 * GpsInfoDAO继承基类
 */
@Repository
public interface GpsInfoDAO extends MyBatisBaseDao<GpsInfo, Long, GpsInfoExample> {
}