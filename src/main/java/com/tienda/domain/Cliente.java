package com.tienda.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id //Marca al siguiente atributo com la llame primaria (En este caso idCliente)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente;//id_Cliente en base de datos --> idCliente en java (Siempre se aplica éste tipo de cambios)
    private String nombre;
    private String apellidos;
    private String correo;
    private String telefono;

    @JoinColumn(name = "id_credito", referencedColumnName = "id_credito")
    @ManyToOne
    public Credito credito;

    public Cliente(String nombre, String apellidos, String correo, String telefono, Credito credito) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.credito = credito;
    }

    public Cliente() {
    }

}
