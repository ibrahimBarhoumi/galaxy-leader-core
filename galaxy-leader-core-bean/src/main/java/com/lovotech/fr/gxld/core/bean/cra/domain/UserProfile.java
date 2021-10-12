package com.lovotech.fr.gxld.core.bean.cra.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance
public class UserProfile extends Audit implements Serializable , GenericEntity<UserProfile>  {

    private static final long serialVersionUID = -2072620633969408165L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PROTECTED)
    private Long id;

    private String name;

    private String lastname;

    private String mobile;

    private double salary ;

    private LocalDate entryDate;

    private LocalDate leavingDate ;

    private LocalDate lastJobInterviewDate ;

    private LocalDate lastMedicalTestDate ;

    private LocalDate lastStayDate ;

    private double holidayBalance ;

    private double rttBalance ;

    private double cetBalance ;

    private String restaurantTitle;

    private Boolean mutuelle ;

    private Boolean malakoff ;

    private Boolean titreSejourValideOfi;

    private String numSecurity ;

    private String placeOfBirth ;

    private int restaurantBalance  ;

    private String address ;

    private String codePostal ;

    private String city ;

    @OneToOne()
    private AuthUser authUser ;

    @JsonIgnore
    @OneToMany(targetEntity = Timesheet.class, mappedBy = "userProfile", fetch = FetchType.LAZY)
    private List<Timesheet> timesheets;

    @JsonIgnore
    @OneToMany(targetEntity = Contract.class, mappedBy = "userProfile",fetch = FetchType.LAZY)
    private List<Contract> contractList;

    @Override
    public void update(UserProfile source) {
        this.name = source.name ;
        this.lastname = source.lastname;
        this.mobile = source.mobile ;
        this.salary = source.salary ;
        this.entryDate = source.entryDate ;
        this.leavingDate = source.leavingDate ;
        this.lastJobInterviewDate = source.lastJobInterviewDate ;
        this.lastMedicalTestDate = source.lastMedicalTestDate ;
        this.lastStayDate = source.lastStayDate ;
        this.holidayBalance = source.holidayBalance ;
        this.rttBalance = source.rttBalance ;
        this.cetBalance = source.cetBalance ;
        this.restaurantTitle = source.restaurantTitle ;
        this.mutuelle = source.mutuelle ;
        this.malakoff = source.malakoff ;
        this.titreSejourValideOfi = source.titreSejourValideOfi ;
        this.numSecurity = source.numSecurity ;
        this.placeOfBirth = source.placeOfBirth ;
        this.restaurantBalance = source.restaurantBalance ;
        this.address = source.address ;
        this.codePostal = source.codePostal ;
        this.city = source.city;
        this.authUser = source.authUser ;
        this.contractList = source.contractList ;
    }
    @Override
    public UserProfile createNewInstance() {
        UserProfile newInstance = new UserProfile();
        newInstance.update(this);
        return newInstance;
    }
}
