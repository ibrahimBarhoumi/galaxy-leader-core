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
public class Client extends Audit implements Serializable, GenericEntity<Client> {

    private static final long serialVersionUID = 4700065359186835594L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PROTECTED)
    private Long id;

    //raisonSociale
    @Column(nullable = false)
    private String companyName;

    //adresse
    @Column(nullable = false)
    private String address;

    //codePostal
    @Column(nullable = false)
    private String postcode;

    //ville
    @Column(nullable = false)
    private String city;

    //formeJuridique
    @Column(nullable = false)
    private String legalForm;

    @Column(nullable = false)
    private Double capital;

    //rcs - Registre du commerce et des sociétés - Register of Commerce and Companies
    @Column(nullable = false)
    private String rcc;

    @Column(nullable = false, unique = true)
    private String siren;

    //numeroTva
    private String vatNumber;

    //etranger
    // column name need to be set because foreign is a reserved keyword
    @Column(nullable = false, name = "\"foreign\"")
    private boolean foreign = false;

    //devise
    private String currency;

    @JsonIgnore
    @OneToMany(targetEntity = Activity.class, mappedBy = "client", fetch = FetchType.LAZY)
    private List<Activity> activities;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void update(Client source) {
        this.companyName = source.companyName;
        this.address = source.address;
        this.postcode = source.postcode;
        this.city = source.city;
        this.legalForm = source.legalForm;
        this.capital = source.capital;
        this.rcc = source.rcc;
        this.siren = source.siren;
        this.vatNumber = source.vatNumber;
        this.foreign = source.foreign;
        this.currency = source.currency;
        this.activities = source.activities;
    }

    @Override
    public Client createNewInstance() {
        Client newInstance = new Client();
        newInstance.update(this);
        return newInstance;
    }

}
