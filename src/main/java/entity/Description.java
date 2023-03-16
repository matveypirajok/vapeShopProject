package entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@EqualsAndHashCode(of = {"id"})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class Description implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "description_id")
    private Integer id;

    @Column
    private String description;

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Accessory accessory;

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Cartridge cartridge;

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Device device;

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Liquid liquid;

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Evaporator evaporator;
}
