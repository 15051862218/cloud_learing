package com.mth.content.openfeign.fallback;


import com.mth.content.common.ResponseResult;
import com.mth.content.domain.entity.User;
import com.mth.content.openfeign.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author 沈永康
 * @Date 2022/9/8 9:12
 * @Version 1.0
 */

@Slf4j
@Component
public class UserServiceFallback implements UserService {
    @Override
    public ResponseResult getUser (int id) {
        log.info("fallback getUser");
        User user = User.builder().id(111).mobile("15000744185").nickname("降级方案返回用户").build();
        return ResponseResult.success(user);
    }
}
