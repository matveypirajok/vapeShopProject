package dto;

import entity.Accessory;
import entity.Cartridge;
import entity.Device;
import entity.Liquid;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ProviderDto {
    private Integer id;
    private String address;
    private String country;
    private String phoneNumber;
    private Set<Accessory> accessories;
    private Set<Cartridge> cartridges;
    private Set<Device> devices;
    private Set<Liquid> liquids;
}
