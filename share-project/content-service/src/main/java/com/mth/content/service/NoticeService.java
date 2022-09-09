package com.mth.content.service;

import com.mth.content.domain.entity.Notice;

/**
 * @description:
 * @author: mth
 * @date: 2022/9/6
 **/
public interface NoticeService {
    /**
     * 获取最新公告
     *
     * @return 最新公告
     */
    Notice getLatestNotice();
}
