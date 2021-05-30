package com.strr.mall.common.redis.controller;

import com.strr.mall.common.CommonResult;
import com.strr.mall.common.redis.service.RedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@Api(tags = "RedisController", description = "验证码工具")
@RestController
@RequestMapping("/common/redis")
public class RedisController {
    @Autowired
    private RedisService redisService;

    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;

    @Value("${redis.key.expire.timeout}")
    private Long REDIS_KEY_EXPIRE_TIMEOUT;

    /**
     * 获取验证码
     * @param tel
     * @return
     */
    @ApiOperation("获取验证码")
    @GetMapping("/generateAuthCode")
    public CommonResult generateAuthCode(String tel) {
        CommonResult result = new CommonResult();
        try {
            StringBuilder builder = new StringBuilder();
            Random random = new Random();
            for (int i = 0; i < 6; i++) {
                builder.append(random.nextInt(10));
            }
            redisService.set(REDIS_KEY_PREFIX_AUTH_CODE + tel, builder.toString());
            redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE + tel, REDIS_KEY_EXPIRE_TIMEOUT);  // 设置过期时间
            result.setData(builder.toString());
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

    /**
     * 验证码校验
     * @param tel
     * @param code
     * @return
     */
    @ApiOperation("验证码校验")
    @PostMapping("/verifyAuthCode")
    public CommonResult verifyAuthCode(String tel, String code) {
        CommonResult result = new CommonResult();
        try {
            String authCode = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE + tel);
            if (StringUtils.isNotBlank(authCode) && authCode.equals(code)) {
                result.setSuccess(true);
            } else {
                result.setSuccess(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }
}
