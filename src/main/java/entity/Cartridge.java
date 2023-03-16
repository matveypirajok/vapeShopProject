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
public class Cartridge implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cartridge_id")
    private Integer id;

    @Column
    private Double resistance;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "shop_id")
    private Shop shop;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "cartridge",
            cascade = CascadeType.ALL)
    private Description description;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "cartridge_provider",
            joinColumns = {@JoinColumn(name = "cartridge_id")},
            inverseJoinColumns = {@JoinColumn(name = "provider_id")})
    private Set<Provider> providers = new HashSet<Provider>();
}
