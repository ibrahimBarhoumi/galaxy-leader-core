package com.lovotech.fr.gxld.core.bean.cra.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class AuthRole extends Audit implements Serializable, GenericEntity<AuthRole> {

    private static final long serialVersionUID = 3784582371001739320L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PROTECTED)
    private Long id;

    private String name;

    private String description;

    @Override
    public void update(AuthRole source) {
        this.description = source.description;
        this.name = source.name;
    }

    @Override
    public AuthRole createNewInstance() {
        AuthRole newInstance = new AuthRole();
        newInstance.update(this);
        return newInstance;
    }
}
