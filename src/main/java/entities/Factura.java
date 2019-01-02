package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="facturas")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="fac_id")
    private Long id;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "factura",orphanRemoval = true)
    private Set<Item> items = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="cl_id")
    private Cliente cliente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
