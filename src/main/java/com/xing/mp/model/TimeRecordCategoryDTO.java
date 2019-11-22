package com.xing.mp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 描述
 *
 * @author weixing.yang
 * @version 1.1.0
 * @date 2019/11/22 18:14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TimeRecordCategoryDTO implements Serializable {

    private String name;

    private Long categoryId;
}
