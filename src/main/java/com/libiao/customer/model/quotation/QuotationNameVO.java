package com.libiao.customer.model.quotation;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * created at 2023/1/6 10:09 by DZL
 *
 * @package com.libiao.customer.model.quotation
 */
@Data
@ApiModel
public class QuotationNameVO {

    @ApiModelProperty("交易名称")
    String tradeName;
    @ApiModelProperty("交易ID")
    String tradeId;

}
