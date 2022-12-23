package com.libiao.customer.model;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class ListResponseVO<T> extends BaseResponseVO {

    @ApiModelProperty("总条目数")
    private long total;
    @JSONField(serialize = false)
    @ApiModelProperty("数据列表")
    private List<T> dataList;

}
