package ru.learnjava.spbtproject.model;

import javax.persistence.*;
//comment
@Entity
@Table (name = "client")
public class Client {
    @Id
    @SequenceGenerator(name = "sequence_name", sequenceName = "sequence_name", allocationSize = 1)
    @GeneratedValue(generator = "client_sequence", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "segment")
    private String segment;

    @Column(name = "portfolio")
    private Double portfolio;


    public Client() {
    }

    public Client(String name, String segment, Double portfolio) {
        this.name = name;
        this.segment = segment;
        this.portfolio = portfolio;
    }

    public Client(Long id, String name, String segment, Double portfolio) {
        this.id = id;
        this.name = name;
        this.segment = segment;
        this.portfolio = portfolio;
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    public Double getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Double portfolio) {
        this.portfolio = portfolio;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", segment='" + segment + '\'' +
                ", portfolio=" + portfolio +
                '}';
    }
}
