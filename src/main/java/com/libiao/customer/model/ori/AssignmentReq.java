package com.libiao.customer.model.ori;

import com.libiao.customer.model.BaseSessionReq;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class AssignmentReq extends BaseSessionReq {

    @ApiModelProperty("原始记录单的ID")
    private Long oriRecordId;
    @ApiModelProperty("测试人列表")
    private List<UserVO> userList;

}
