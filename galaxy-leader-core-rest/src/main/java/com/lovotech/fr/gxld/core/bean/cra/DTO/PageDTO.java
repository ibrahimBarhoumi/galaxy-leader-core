package com.lovotech.fr.gxld.core.bean.cra.DTO;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
public class PageDTO<T> {

    List<T> content;

    Long totalElements;

    int totalPages;

    int number;

    int size;

    public PageDTO(Page<T> page) {
        this.content = page.getContent();
        this.totalElements = page.getTotalElements();
        this.totalPages = page.getTotalPages();
        this.number = page.getNumber();
        this.size = page.getSize();
    }
}