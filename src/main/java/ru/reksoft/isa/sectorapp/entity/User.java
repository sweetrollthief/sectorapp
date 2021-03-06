package ru.reksoft.isa.sectorapp.entity;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements Serializable {
    public User() {
        name = "";
    }

    private static final long serialVersionUID = -3009157732242241606L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "is_agreed")
    private boolean isAgreed;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "user_to_sector",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "sector_id") })
    private Set<Sector> sectors = new HashSet<>();


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setIsAgreed(boolean agreed) {
        isAgreed = agreed;
    }

    public boolean getIsAgreed() {
        return isAgreed;
    }

    public void setSectors(Set<Sector> sectors) {
        this.sectors = sectors;
    }

    public Set<Sector> getSectors() {
        return sectors;
    }
}
