package com.lovotech.fr.gxld.core.bean.cra.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ConfigurationValue extends Audit implements Serializable, GenericEntity<ConfigurationValue> {

    private static final long serialVersionUID = 854798511974416519L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PROTECTED)
    private Long id;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String label;

    @ManyToOne
    private Configuration configuration;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void update(ConfigurationValue source) {
        this.code = source.getCode();
        this.label = source.getLabel();
        this.configuration = source.getConfiguration();
    }

    @Override
    public ConfigurationValue createNewInstance() {
        ConfigurationValue newInstance = new ConfigurationValue();
        newInstance.update(this);
        return newInstance;
    }
}
