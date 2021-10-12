package com.lovotech.fr.gxld.core.bean.cra.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Contract extends Audit implements Serializable , GenericEntity<Contract> {
    private static final long serialVersionUID = 3437625561370651058L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PROTECTED)
    private Long id;

    private String number ;

    private String amendment ;

    private double tjm ;

    private int nbExpirationDay ;

    private LocalDate startDate ;

    private LocalDate endDate ;

    private String invoiceFirstEmail ;

    private String invoiceSecondEmail ;

    private Boolean active ;


    @ManyToOne
    private Activity activity ;

    @ManyToOne
    private UserProfile userProfile ;

    @Override
    public Long getId() {
        return this.id ;
    }

    @Override
    public void update(Contract source) {
        this.number = source.number ;
        this.amendment = source.amendment ;
        this.tjm = source.tjm ;
        this.nbExpirationDay = source.nbExpirationDay ;
        this.startDate = source.startDate ;
        this.endDate = source.endDate ;
        this.invoiceFirstEmail = source.invoiceFirstEmail ;
        this.invoiceSecondEmail = source.invoiceSecondEmail ;
        this.active = source.active ;
        this.activity = source.activity;
        this.userProfile = source.userProfile;
    }



    @Override
    public Contract createNewInstance() {
        Contract newInstance = new Contract();
        newInstance.update(this);
        return newInstance;
    }
}
