package com.libiao.customer.model.report;

import com.libiao.customer.model.BaseSessionReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("报告单批量审核传参")
public class ReportApproveBatchReq extends BaseSessionReq {
    List<ReportApproveReq> reqList;
}
