package com.xing.mp.mapper;

import com.xing.mp.model.TimeRecord;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeRecordMapper {


    int deleteByPrimaryKey(Long id);


    int insert(TimeRecord record);


    int insertSelective(TimeRecord record);


    TimeRecord selectByPrimaryKey(Long id);


    int updateByPrimaryKeySelective(TimeRecord record);


    int updateByPrimaryKey(TimeRecord record);
}