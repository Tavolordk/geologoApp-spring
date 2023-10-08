package org.nasa.spaceapp.geologoapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "profile_user")
@Data
public class ProfileUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "signup_id", unique = true, nullable = false)
    private Signup signup;

    @Column(name = "foto_perfil")
    private String fotoPerfil;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    // getters and setters
}
