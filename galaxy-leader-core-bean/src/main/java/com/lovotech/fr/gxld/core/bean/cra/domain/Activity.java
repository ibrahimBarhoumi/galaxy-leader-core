package com.lovotech.fr.gxld.core.bean.cra.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Activity extends Audit implements Serializable, GenericEntity<Activity> {

    private static final long serialVersionUID = -7515305195025954868L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PROTECTED)
    private Long id;

    private String nature;

    private String label;

    private LocalDate startDate;

    private LocalDate endDate;

    private boolean isCommon;

    @JsonIgnore
    @OneToMany(targetEntity = Contract.class, mappedBy = "activity",fetch = FetchType.LAZY)
    private List<Contract> contractList;

    @ManyToOne
    private Client client;


    @Override
    public void update(Activity source) {
        this.nature = source.nature;
        this.label = source.label;
        this.startDate = source.startDate;
        this.endDate = source.endDate;
        this.isCommon = source.isCommon;
        this.client = source.client;
        this.contractList = source.contractList;
    }

    @Override
    public Activity createNewInstance() {
        Activity newInstance = new Activity();
        newInstance.update(this);
        return newInstance;
    }
}
