package com.lovotech.fr.gxld.core.bean.cra.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SearchCriteria {
    private String key;
    private SearchOperationEnum operation;
    private Object value;

}
