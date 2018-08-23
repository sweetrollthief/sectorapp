package ru.reksoft.isa.sectorapp.dao;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements Serializable {
    public User() {
        name = "";
        sessionId = "";
    }

    private static final long serialVersionUID = -3009157732242241606L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "session_id", unique = true)
    private String sessionId;

    @Column(name = "name")
    private String name;

    @Column(name = "is_agreed")
    private boolean isAgreed;

    @ManyToMany(fetch = FetchType.LAZY,
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

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
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
