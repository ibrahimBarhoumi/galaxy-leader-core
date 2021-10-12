package com.lovotech.fr.gxld.core.bean.cra.common;

public enum ConventionEnum {
    SYNTEC("SYNTEC", 7L);

    public final String label;
    public final Long value;

    ConventionEnum(String label, Long value) {
        this.label = label;
        this.value = value;
    }
}
