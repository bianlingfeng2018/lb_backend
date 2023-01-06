package com.libiao.customer.model.test;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * created at 2023/1/6 10:17 by DZL
 *
 * @package com.libiao.customer.model.test
 */
@Data
@ApiModel
public class TestNameVO {
    @ApiModelProperty("检测交易名称")
    String testName;
    @ApiModelProperty("检测交易ID")
    String testId;
}
