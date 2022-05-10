package ru.learnjava.spbtproject.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data //getter + setter в dao использовать нельзя
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
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


    public Client(String name, String segment, Double portfolio) {
        this.name = name;
        this.segment = segment;
        this.portfolio = portfolio;
    }

}
