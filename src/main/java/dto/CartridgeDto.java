package dto;

import entity.Description;
import entity.Provider;
import entity.Shop;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CartridgeDto {
    private Integer id;
    private Double resistance;
    private Shop shop;
    private Description description;
    private Set<Provider> providers;
}
