import dao.DAO;
import dao.DaoImpl;
import entity.Accessory;
import entity.Description;
import entity.Provider;
import entity.Shop;

public class App {
    public static void main(String[] args) {
        DAO dao = new DaoImpl();

        Accessory accessory = new Accessory(null, "accessory1", 10.00, null, null, null);
        Accessory accessory1 = new Accessory(null, "accessory2", 12.00, null, null, null);

        Description description = new Description(null, "accessory1 description", null, null, null, null, null);
        Description description1 = new Description(null, "accessory2 description", null, null, null, null, null);

        Provider provider = new Provider(null, "pushkina 12", "China", "12342356", null, null, null, null);
        Provider provider1 = new Provider(null, "kukushkina 12", "Russia", "123423351256", null, null, null, null);

        Shop shop = new Shop(null, "qwf", null, null, null, null, null);
        Shop shop1 = new Shop(null, "qwfweqw", null, null, null, null, null);

        dao.save(accessory);
        dao.save(accessory1);
        dao.save(description);
        dao.save(description1);
        dao.save(provider);
        dao.save(provider1);
    }
}
