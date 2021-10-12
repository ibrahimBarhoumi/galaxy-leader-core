package com.lovotech.fr.gxld.core.bean.cra.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class WorkingDay extends Audit implements Serializable, GenericEntity<WorkingDay> {

    private static final long serialVersionUID = 7620558535489124781L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PROTECTED)
    private Long id;

    @JsonIgnore
    @ManyToOne
    private Timesheet timesheet;

    private LocalDate date;

    private int dayOfWeek;

    @OneToOne
    private PublicHoliday publicHoliday;

    @OneToOne
    private Activity morningActivity;

    @OneToOne
    private Activity afternoonActivity;

    private Long workedHoursNumber;

    @Override
    public void update(WorkingDay source) {

        this.timesheet=source.timesheet;
        this.date=source.date;
        this.morningActivity=source.morningActivity;
        this.afternoonActivity=source.afternoonActivity;
        this.publicHoliday = source.publicHoliday;
        this.dayOfWeek = source.dayOfWeek;

    }

    @Override
    public WorkingDay createNewInstance() {
        WorkingDay newInstance = new WorkingDay();
        newInstance.update(this);
        return newInstance;
    }
}
