package com.lovotech.fr.gxld.core.bean.cra.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lovotech.fr.gxld.core.bean.cra.common.ConventionEnum;
import com.lovotech.fr.gxld.core.bean.cra.common.TimesheetStatusEnum;
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
public class Timesheet extends Audit implements Serializable {

    private static final long serialVersionUID = -3291627338741076410L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PROTECTED)
    private Long id;

    @ManyToOne
    private UserProfile userProfile;

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private TimesheetStatusEnum status;

    @Enumerated(EnumType.STRING)
    private ConventionEnum convention;

    @OneToMany(targetEntity = WorkingDay.class, mappedBy = "timesheet", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @OrderBy(value = "date")
    private List<WorkingDay> workingDays;


}
