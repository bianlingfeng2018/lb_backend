package com.libiao.customer.util.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;



@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseVO <T>{

    private String code;

    private Boolean success;

    private String errorMessage;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String reqId;

    private T data;

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
