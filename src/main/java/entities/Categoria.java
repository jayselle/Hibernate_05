package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="cat_id")
    private Long id;

    @Column(name="cat_descripcion")
    private String descripcion;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="categorias_items",
    joinColumns = {@JoinColumn(name = "cat_id")},
    inverseJoinColumns = {@JoinColumn(name="it_id")})
    private Set<Item> items = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
}
