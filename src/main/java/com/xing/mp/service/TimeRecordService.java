package com.xing.mp.service;

import com.xing.mp.mapper.TimeRecordMapper;
import com.xing.mp.model.TimeRecord;
import com.xing.mp.model.TimeRecordDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TimeRecordService {

    @Autowired
    TimeRecordMapper timeRecordMapper;

    public void recordingTime(TimeRecordDTO timeRecordDTO) {
        TimeRecord record = timeRecordMapper.selectByUserIdAndCategoryAndNullEndTime(timeRecordDTO);
        if(record == null){
            if(timeRecordDTO.isStatus()) {
                record = new TimeRecord();
                record.setStartTime(new Date());
                BeanUtils.copyProperties(timeRecordDTO, record);
                timeRecordMapper.insert(record);
            }
        }else{
            record.setEndTime(new Date());
            timeRecordMapper.updateByPrimaryKey(record);
        }
    }
}
