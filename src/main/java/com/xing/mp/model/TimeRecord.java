package com.xing.mp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TimeRecord {

    private Long id;

    private Long userId;

    private Long categoryId;

    private Date startTime;

    private Date endTime;

}