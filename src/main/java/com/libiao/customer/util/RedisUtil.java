package com.libiao.customer.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    /**
     * 生成报价单编号
     * @param date
     * @return
     */
    public String getNo(String city,String date){
        String key = "TODAY_QUOTA_NO"+":"+date;
        Long increment = redisTemplate.opsForValue().increment(key, 1);
        if (increment > 26000){
            throw new ServiceException(HttpStatus.BAD_GATEWAY,"序列生成失败");
        }
        //获取后三位编号
        long no = increment % 1000;
        String noStr = String.format("%03d",no);
        //获取前一位字母
        long alpha = (increment / 1000) + 65;
        char aChar = (char) alpha;
        return "LIT" + city + "T" + date + aChar + noStr;
    }

    /**
     * 生成申请单编号
     * @param date
     * @return
     */
    public String getAppNo(String date){
        //生成申请单号 LTI+T+年份后两位+月份+日+ （A-Z）
        String key = "TODAY_APPLY_NO"+":"+date;
        Long increment = redisTemplate.opsForValue().increment(key, 1);
        if (increment > 26000){
            throw new ServiceException(HttpStatus.BAD_GATEWAY,"序列生成失败");
        }
        //获取后三位编号
        long no = increment % 1000;
        String noStr = String.format("%03d",no);
        //获取前一位字母
        long alpha = (increment / 1000) + 65;
        char aChar = (char) alpha;
        return "LTI" + "T" + date + aChar + noStr;
    }

    /**
     * 生成工作单编号
     * @param date
     * @return
     */
    public String getWorkNo(String date){
        String key = "TODAY_WORK_NO"+":"+date;
        Long increment = redisTemplate.opsForValue().increment(key, 1);
        if (increment > 26000){
            throw new ServiceException(HttpStatus.BAD_GATEWAY,"序列生成失败");
        }
        //获取后三位编号
        long no = increment % 1000;
        String noStr = String.format("%03d",no);
        //获取前一位字母
        long alpha = (increment / 1000) + 65;
        char aChar = (char) alpha;
        return "LTITW" + date + aChar + noStr;
    }

    /**
     * 生成原始记录单编号
     * LTI+T/I/C+R+年份后两位+月份+日+ （A-Z）+ 三位
     * @param date
     * @return
     */
    public String getOriRecordNo(String date){
        String key = "TODAY_RECORD_NO"+":"+date;
        Long increment = redisTemplate.opsForValue().increment(key, 1);
        if (increment > 26000){
            throw new ServiceException(HttpStatus.BAD_GATEWAY,"序列生成失败");
        }
        //获取后三位编号
        long no = increment % 1000;
        String noStr = String.format("%03d",no);
        //获取前一位字母
        long alpha = (increment / 1000) + 65;
        char aChar = (char) alpha;
        return "LTITR" + date + aChar + noStr;
    }


    /**
     * 生成报告单编号
     * 报告单编号：LTI+T+年份后两位+月份+日+ （A-Z）+ 三位数
     * @param date
     * @return
     */
    public String getReportNo(String date){
        String key = "TODAY_REPORT_NO"+":"+date;
        Long increment = redisTemplate.opsForValue().increment(key, 1);
        if (increment > 26000){
            throw new ServiceException(HttpStatus.BAD_GATEWAY,"序列生成失败");
        }
        //获取后三位编号
        long no = increment % 1000;
        String noStr = String.format("%03d",no);
        //获取前一位字母
        long alpha = (increment / 1000) + 65;
        char aChar = (char) alpha;
        return "LTIT" + date + aChar + noStr;
    }
}
