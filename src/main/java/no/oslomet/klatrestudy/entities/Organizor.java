package no.oslomet.klatrestudy.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity
public class Organizor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(name = "org_num", nullable = false)
    private int orgNum;

    // Default constructor
    public Organizor() {}
    
    public Organizor(String name, int orgNum) {
        this.name = name;
        this.orgNum = orgNum;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public int getOrgNum() { return orgNum; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setOrgNum(int orgNum) { this.orgNum = orgNum; }
}