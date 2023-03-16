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
public class Provider implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "provider_id")
    private Integer id;

    @Column
    private String address;

    @Column
    private String country;

    @Column
    private String phoneNumber;

    @ManyToMany(mappedBy = "providers")
    private Set<Accessory> accessories = new HashSet<Accessory>();

    @ManyToMany(mappedBy = "providers")
    private Set<Cartridge> cartridges = new HashSet<Cartridge>();

    @ManyToMany(mappedBy = "providers")
    private Set<Device> devices = new HashSet<Device>();

    @ManyToMany(mappedBy = "providers")
    private Set<Liquid> liquids = new HashSet<Liquid>();

}
