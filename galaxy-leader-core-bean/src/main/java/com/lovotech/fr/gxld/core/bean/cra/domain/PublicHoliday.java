package com.lovotech.fr.gxld.core.bean.cra.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="jours_ferier",uniqueConstraints={@UniqueConstraint(columnNames={"date"})})
@Builder(toBuilder = true)
public class PublicHoliday extends Audit implements Serializable, GenericEntity<PublicHoliday> {

    private static final long serialVersionUID = -7873453882453048868L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PROTECTED)
    private Long id;

    private String label;

    private LocalDate date;

    @Override
    public void update(PublicHoliday source) {
        this.label = source.label;
        this.date = source.date;
    }


    @Override
    public PublicHoliday createNewInstance() {
        PublicHoliday newInstance = new PublicHoliday();
        newInstance.update(this);
        return newInstance;
    }
}
