package dto;

import entity.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ShopDto {
    private Integer id;
    private String shopAddress;
    private Set<Accessory> accessories;
    private Set<Cartridge> cartridges;
    private Set<Device> devices;
    private Set<Evaporator> evaporators;
    private Set<Liquid> liquids;
}
