package com.libiao.customer.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * created at 2023/1/6 10:24 by DZL
 *
 * @package com.libiao.customer.model.quotation
 */
@Data
@ApiModel("用于名称模糊查询")
public class BaseNameReq extends BaseSessionReq {

    String name;
}
