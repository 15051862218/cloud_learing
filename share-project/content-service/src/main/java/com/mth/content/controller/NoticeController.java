package com.mth.content.controller;

import com.google.j2objc.annotations.ReflectionSupport;
import com.mth.content.common.ResponseResult;
import com.mth.content.common.ResultCode;
import com.mth.content.domain.entity.Notice;
import com.mth.content.service.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: mth
 * @date: 2022/9/6
 **/
@RestController
@RequestMapping(value = "/notices")
@Slf4j
@RefreshScope
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class NoticeController {
    private final NoticeService noticeService;
    @Value("${disableNoticeRequest:false}")
     private  Boolean disableNoitice;
    @GetMapping("/latest")
    public ResponseResult getNotice() {
        Notice latestNotice = noticeService.getLatestNotice();
        if (disableNoitice) {
            log.info("暂停服务");
            return  ResponseResult.failure(ResultCode.INTERFACE_ADDRESS_INVALID);
        }else {
            return ResponseResult.success(latestNotice);
        }
//        Notice latestNotice = noticeService.getLatestNotice();
//        if (latestNotice != null) {
//            return ResponseResult.success(latestNotice);
//        } else {
//            return ResponseResult.failure(ResultCode.NOTICE_NO_LATEST);
//        }

    }
}
