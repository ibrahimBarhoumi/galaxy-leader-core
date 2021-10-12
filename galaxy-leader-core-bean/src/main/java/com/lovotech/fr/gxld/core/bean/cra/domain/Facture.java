package com.lovotech.fr.gxld.core.bean.cra.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Facture extends Audit implements Serializable, GenericEntity<Facture> {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PROTECTED)
    private Long id;

    @Column(nullable = false)
    private Long numero ;

    private LocalDate invoiceDate ;

    private int nbUnites ;

    private long numero_Remplace ;

    private long montant_Ht ;

    private long montant_Ttc ;

    private boolean annulee ;

    private boolean envoyee ;

    private String url_Cra ;


    @Override
    public void update(Facture source) {
        this.numero = source.numero;
        this.invoiceDate = source.invoiceDate;
        this.nbUnites = source.nbUnites ;
        this.numero_Remplace = source.numero_Remplace ;
        this.montant_Ht = source.montant_Ht ;
        this.montant_Ttc = source.montant_Ttc ;
        this.annulee = source.annulee ;
        this.envoyee = source.envoyee ;
        this.url_Cra = source.url_Cra ;
    }

    @Override
    public Facture createNewInstance() {
        Facture newInstance = new Facture();
        newInstance.update(this);
        return newInstance;
    }
}
