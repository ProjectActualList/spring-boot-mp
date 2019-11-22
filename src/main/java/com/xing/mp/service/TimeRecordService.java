package com.xing.mp.service;

import com.xing.mp.mapper.TimeRecordMapper;
import com.xing.mp.model.TimeRecord;
import com.xing.mp.model.TimeRecordDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeRecordService {

    @Autowired
    TimeRecordMapper timeRecordMapper;

    public void recordingTime(TimeRecordDTO timeRecordDTO) {
        TimeRecord record = new TimeRecord();
        BeanUtils.copyProperties(timeRecordDTO, record);
        timeRecordMapper.insert(record);
    }
}
