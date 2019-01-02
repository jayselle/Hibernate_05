package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="cl_id")
    private Long id;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "cliente",orphanRemoval = true)
    private Set<Factura> facturas = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="direccion")
    private Direccion direccion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(Set<Factura> facturas) {
        this.facturas = facturas;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
}
