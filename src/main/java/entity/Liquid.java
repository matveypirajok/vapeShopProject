package entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(of = {"id"})
@Data
@AllArgsConstructor
@NoArgsConstructor

@Builder
@Entity
@Table
public class Liquid implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "liquid_id")
    private Integer id;

    @Column
    private String name;

    @Column
    private String agVg;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "shop_id")
    private Shop shop;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "liquid",
            cascade = CascadeType.ALL)
    private Description description;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "liquid_provider",
            joinColumns = {@JoinColumn(name = "liquid_id")},
            inverseJoinColumns = {@JoinColumn(name = "provider_id")})
    private Set<Provider> providers = new HashSet<>();
}
