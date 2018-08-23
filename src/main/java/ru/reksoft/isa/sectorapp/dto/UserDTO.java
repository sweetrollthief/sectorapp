package ru.reksoft.isa.sectorapp.dto;

import java.util.HashSet;
import java.util.Set;

public class UserDTO {
    private String name;
    private Set<Integer> sectors;
    private boolean isAgreed;

    public UserDTO() {
        name = "";
        sectors = new HashSet<>();
        isAgreed = false;
    }

    public void setName(final String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setIsAgreed(final boolean isAgreed) {
        this.isAgreed = isAgreed;
    }

    public boolean getIsAgreed() {
        return isAgreed;
    }

    public void setSectors(final Set<Integer> sectors) {
        this.sectors = sectors;
    }

    public Set<Integer> getSectors() {
        return sectors;
    }

    @Override
    public boolean equals(final Object object) {
        if (!(object instanceof UserDTO)) {
            return false;
        }

        final UserDTO anotherDTO = (UserDTO) object;

        return anotherDTO.getName().equals(name) &&
                anotherDTO.getIsAgreed() == isAgreed &&
                anotherDTO.getSectors().size() == sectors.size() &&
                anotherDTO.getSectors()
                        .stream()
                        .allMatch(x -> sectors.contains(x));
    }
}
