package com.lovotech.fr.gxld.core.bean.cra.common;

public enum SearchOperationEnum {
    EQUALITY, NEGATION, GREATER_THAN, LESS_THAN, LIKE, STARTS_WITH, ENDS_WITH, CONTAINS, JOIN;

    public static final String[] SIMPLE_OPERATION_SET = { ":", "!", ">", "<", "~" };

    public static SearchOperationEnum getSimpleOperation(char input) {
        switch (input) {
            case ':':
                return EQUALITY;
            case '!':
                return NEGATION;
            case '>':
                return GREATER_THAN;
            case '<':
                return LESS_THAN;
            case '~':
                return LIKE;
            default:
                return null;
        }
    }
}
