package com.xing.mp.controller;

import com.xing.mp.beans.msg.Response;
import com.xing.mp.model.TimeRecordCategoryDTO;
import com.xing.mp.model.TimeRecordDTO;
import com.xing.mp.service.TimeRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述
 *
 * @author weixing.yang
 * @version 1.1.0
 * @date 2019/11/20 19:28
 */
@RestController
@Slf4j
@RequestMapping("/record")
public class TimeRecordController {

    @Autowired
    TimeRecordService timeRecordService;

    @PostMapping("/recordingTime")
    public Response recordingTime(@RequestBody TimeRecordDTO timeRecordDTO){
        Response response = new Response();
        timeRecordService.recordingTime(timeRecordDTO);
        return response.success();
    }

    @GetMapping("/list")
    public Response list(){
        List<TimeRecordCategoryDTO> list = new ArrayList<>();
        TimeRecordCategoryDTO dto0 = new TimeRecordCategoryDTO();
        TimeRecordCategoryDTO dto1 = new TimeRecordCategoryDTO();
        TimeRecordCategoryDTO dto2 = new TimeRecordCategoryDTO();
        TimeRecordCategoryDTO dto3 = new TimeRecordCategoryDTO();
        TimeRecordCategoryDTO dto4 = new TimeRecordCategoryDTO();
        dto0.setCategoryId(0L);
        dto0.setName("工作");
        dto1.setCategoryId(1L);
        dto1.setName("健身");
        dto2.setCategoryId(2L);
        dto2.setName("通勤");
        dto3.setCategoryId(3L);
        dto3.setName("阅读");
        dto4.setCategoryId(4L);
        dto4.setName("学习");
        list.add(dto0);
        list.add(dto1);
        list.add(dto2);
        list.add(dto3);
        list.add(dto4);
        Response response = new Response();
        response.success().setResult(list);
        return  response;

    }

}
