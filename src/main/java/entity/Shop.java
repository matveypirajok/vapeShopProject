package entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(of = {"id"})
@Data
@AllArgsConstructor
@NoArgsConstructor

@Builder
@Entity
@Table
public class Shop implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_id")
    private Integer id;

    @Column
    private String shopAddress;

    @OneToMany(mappedBy = "accessory")
    private Set<Accessory> accessories = new HashSet<Accessory>();

    @OneToMany(mappedBy = "cartridge")
    private Set<Cartridge> cartridges = new HashSet<Cartridge>();

    @OneToMany(mappedBy = "device")
    private Set<Device> devices = new HashSet<Device>();

    @OneToMany(mappedBy = "evaporator")
    private Set<Evaporator> evaporators = new HashSet<Evaporator>();

    @OneToMany(mappedBy = "liquid")
    private Set<Liquid> liquids = new HashSet<Liquid>();

}
