
import com.upb.agripos.dao.ProductDAO;
import com.upb.agripos.model.Product;
import java.util.*;

public class ProductDAOImpl implements ProductDAO {
    public ProductDAOImpl() {
        // Konstruktor kosong
    }

    @Override
    public void insert(Product product) throws Exception {
        // Biarkan kosong dulu atau isi dengan System.out.println
        System.out.println("Data tersimpan: " + product.getName());
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>();
    }
    
    @Override
    public void delete(String code) throws Exception {
        System.out.println("Data dengan kode " + code + " dihapus");
    }
    
    @Override
    public Product findByCode(String code) throws Exception {
        return null;
    }
    
    @Override
    public void update(Product product) throws Exception {
        System.out.println("Data diperbarui: " + product.getName());
    }
}