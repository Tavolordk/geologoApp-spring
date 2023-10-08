package org.nasa.spaceapp.geologoapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "posts_user")
@Data
public class PostsUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "profile_user_id", nullable = false)
    private ProfileUser profileUser;

    @Column(name = "tema")
    private String tema;

    @Column(name = "subtema")
    private String subtema;

    @ManyToOne
    @JoinColumn(name = "prioridad_id")
    private Prioridad prioridad;

    @Column(name = "imagen")
    private String imagen;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    // getters and setters
}
