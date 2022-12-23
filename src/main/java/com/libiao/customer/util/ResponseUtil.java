package com.libiao.customer.util;

import com.libiao.customer.model.BaseResponseVO;
import com.libiao.customer.model.ErrorMessage;
import com.libiao.customer.model.ListResponseVO;
import com.libiao.customer.util.exception.ErrorCodeEnum;
import com.libiao.customer.util.model.ResponseVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ResponseUtil {

    private static final String HTTP_SUCCESS_CODE = "200";

    public static ResponseVO success(){
        return success(null);
    }

    public static ResponseVO success(Object data){
        ResponseVO response = new ResponseVO();
        response.setCode(HTTP_SUCCESS_CODE);
        response.setErrorMessage(StringUtils.EMPTY);
        response.setSuccess(true);
        response.setData(data);
        return response;
    }

    public static ResponseVO success(List data){
        ResponseVO response = new ResponseVO();
        response.setCode(HTTP_SUCCESS_CODE);
        response.setErrorMessage(StringUtils.EMPTY);
        response.setSuccess(true);
        response.setData(data);
        return response;
    }

    private static String getDefaultReqid(){
        return String.valueOf(System.currentTimeMillis());
    }

    public static ResponseVO error(String code, String msg, Object data){
        ResponseVO response = new ResponseVO();
        response.setCode(code);
        response.setErrorMessage(msg);
        response.setSuccess(false);
        response.setData(data);
        return response;
    }

    public static ResponseVO error(int code, String msg){
        return error(String.valueOf(code), msg, null);
    }


    public static ResponseVO error(String code, String msg){
        return error(code, msg, null);
    }

    public static ResponseVO error(ErrorCodeEnum errorCodeEnum){
        return error(errorCodeEnum.getCode(), errorCodeEnum.getDescription(), null);
    }

    public static ResponseEntity<BaseResponseVO> convert(ErrorMessage errorMessage){
        return ResponseEntity.status(errorMessage.getStatus()).body(new BaseResponseVO(errorMessage.getErrMsg()));
    }

    public static ResponseEntity<BaseResponseVO> convert(HttpStatus httpStatus, String message){
        return ResponseEntity.status(httpStatus).body(new BaseResponseVO(message));
    }

    public static ResponseEntity<BaseResponseVO> getDefaultResp() {
        return ResponseEntity.status(HttpStatus.OK).body(new BaseResponseVO("success"));
    }

    public static <T> ResponseEntity<T> getResponseVO(T data) {
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }

    public static <T> ResponseEntity<ListResponseVO<T>> getListResponseVO(List<T> data, long total) {
        ListResponseVO<T> ResponseVO = new ListResponseVO<>();
        ResponseVO.setDataList(data);
        ResponseVO.setTotal(total);
        return ResponseEntity.status(HttpStatus.OK).body(ResponseVO);
    }
}
