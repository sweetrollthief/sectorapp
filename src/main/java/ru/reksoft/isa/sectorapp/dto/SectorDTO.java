package ru.reksoft.isa.sectorapp.dto;


import java.util.Set;

public class SectorDTO {
    private int id;
    private String label;
    private Set<SectorDTO> children;

    public void setId(final int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setLabel(final String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setChildren(final Set<SectorDTO> children) {
        this.children = children;
    }

    public Set<SectorDTO> getChildren() {
        return children;
    }
}
