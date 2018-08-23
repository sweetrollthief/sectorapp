package ru.reksoft.isa.sectorapp.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "sectors")
public class Sector implements Serializable {

    private static final long serialVersionUID = -3009157732242241606L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "label")
    private String label;

    @Column(name = "parent")
    private int parent;

    public Sector(final String label, final int parent) {
        this.label = label;
        this.parent = parent;
    }

    public Sector(final int id, final String label, final int parent) {
        this(label, parent);
        this.id = id;
    }

    public Sector() {}

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public int getParent() {
        return parent;
    }
}
