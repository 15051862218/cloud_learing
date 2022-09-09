package com.mth.content.controller;

import com.alibaba.fastjson.JSONObject;
import com.mth.content.common.ResponseResult;
import com.mth.content.domain.dto.ShareDto;
import com.mth.content.domain.entity.Share;
import com.mth.content.domain.entity.User;
import com.mth.content.openfeign.UserService;
import com.mth.content.service.ShareService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @author: mth
 * @date: 2022/9/6
 **/
@RestController
@Slf4j
@RequestMapping(value = "/shares")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ShareController {

    private final ShareService shareService;
    private final UserService userService;

    @GetMapping("{id}")
    public ResponseResult getShareById(@PathVariable Integer id) {
        Share share = shareService.findById(id);
        Integer userId = share.getUserId();
        ResponseResult res = userService.getUser(userId);
        String jsonString = JSONObject.toJSONString(res.getData());
        JSONObject obj = JSONObject.parseObject(jsonString);
        User user = JSONObject.toJavaObject(obj, User.class);
        System.out.println(user);
        ShareDto shareDto = ShareDto.builder().share(share).nickName(user.getNickname()).avatar(user.getAvatar()).build();
        return ResponseResult.success(shareDto);
    }

    @GetMapping(value = "/all")
    public ResponseResult getAllShares() {
        List<Share> all = shareService.findAll();
        System.out.println(all);
        return ResponseResult.success(all);
    }
}
