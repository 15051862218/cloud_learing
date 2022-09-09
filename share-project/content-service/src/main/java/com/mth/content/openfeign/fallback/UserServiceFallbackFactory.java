package com.mth.content.openfeign.fallback;


import com.mth.content.common.ResponseResult;
import com.mth.content.domain.entity.User;
import com.mth.content.openfeign.UserService;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Author 沈永康
 * @Date 2022/9/9 11:25
 * @Version 1.0
 */

@Slf4j
@Component
public class UserServiceFallbackFactory implements FallbackFactory<UserService> {

    @Override
    public UserService create(Throwable cause) {
        return id -> {
            log.info("fallback factory method test" +cause);
             User user = User.builder().nickname("降级方案返回用户").avatar("defaut.jpg").build();
            return ResponseResult.success(user);
        };
    }
}
