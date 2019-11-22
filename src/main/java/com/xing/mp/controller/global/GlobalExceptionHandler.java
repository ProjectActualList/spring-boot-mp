package com.xing.mp.controller.global;


import com.xing.mp.beans.msg.Response;
import com.xing.mp.constants.ErrCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Response defaultExceptionHandler(HttpServletResponse response, Exception exception) {
        response.setStatus(500);
        log.error("exception 异常");
        Response res = new Response();
        return res.msg(ErrCodeEnum.SYS_ERROR.code, ErrCodeEnum.SYS_ERROR.msg);
    }

}
