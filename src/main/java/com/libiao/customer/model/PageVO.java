package com.libiao.customer.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

@Getter
@Setter
public class PageVO<T> {

    private int pageSize;
    private int pageNo;
    private int totalPage;
    private long totalCount;
    private List<T> data;

    public PageVO() {
    }

    public PageVO(Page<T> page) {
        this.pageNo = page.getNumber() + 1;
        this.pageSize = page.getNumberOfElements();
        this.totalPage = page.getTotalPages();
        this.totalCount = page.getTotalElements();
        this.data = page.getContent();
    }
}
