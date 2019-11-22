package com.xing.mp.controller;

import com.xing.mp.beans.msg.Response;
import com.xing.mp.model.TimeRecordDTO;
import com.xing.mp.service.TimeRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述
 *
 * @author weixing.yang
 * @version 1.1.0
 * @date 2019/11/20 19:28
 */
@RestController
@Slf4j
public class TimeRecordController {

    @Autowired
    TimeRecordService timeRecordService;

    @PostMapping("/recordingTime")
    public Response recordingTime(TimeRecordDTO timeRecordDTO){
        Response response = new Response();
        timeRecordService.recordingTime(timeRecordDTO);
        return response.success();
    }

}
