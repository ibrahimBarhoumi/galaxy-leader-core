package com.lovotech.fr.gxld.core.bean.cra.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Configuration extends Audit implements Serializable, GenericEntity<Configuration> {

    private static final long serialVersionUID = 3437625561370651058L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PROTECTED)
    private Long id;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String label;

    @JsonIgnore
    @OneToMany(targetEntity = ConfigurationValue.class, mappedBy = "configuration", fetch = FetchType.LAZY)
    private List<ConfigurationValue> configurationValues;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void update(Configuration source) {
        this.code = source.getCode();
        this.label = source.getLabel();
        this.configurationValues = source.getConfigurationValues() ;
    }

    @Override
    public Configuration createNewInstance() {
        Configuration newInstance = new Configuration();
        newInstance.update(this);
        return newInstance;
    }
}
