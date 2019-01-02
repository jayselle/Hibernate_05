package entities;

import javax.persistence.*;

@Entity
@Table(name="direcciones")
public class Direccion {

    @Id
    @Column(name="direc")
    private String direccion;

    @OneToOne(mappedBy = "direccion")
    private Cliente cliente;

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
