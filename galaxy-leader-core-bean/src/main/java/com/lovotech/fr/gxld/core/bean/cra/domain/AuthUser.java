package com.lovotech.fr.gxld.core.bean.cra.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lovotech.fr.gxld.core.bean.cra.common.ConventionEnum;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)

public class AuthUser extends Audit implements Serializable, GenericEntity<AuthUser> {

    private static final long serialVersionUID = -2072620633969408165L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PROTECTED)
    private Long id;

    private String userName;

    private String password;

    private String email;

    private boolean enabled = true;

    @Enumerated(EnumType.STRING)
    private ConventionEnum convention;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<AuthRole> roles = new ArrayList<>();

    @Override
    public void update(AuthUser source) {

        this.userName = source.userName;
        this.email = source.email;
        this.password = source.password;
        this.roles = source.roles;
        this.enabled = source.enabled;
        this.convention = source.convention;
    }

    @Override
    public AuthUser createNewInstance() {
        AuthUser newInstance = new AuthUser();
        newInstance.update(this);
        return newInstance;
    }
}
