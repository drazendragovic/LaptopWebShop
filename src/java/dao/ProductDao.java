package dao;

import java.util.List;
import model.Item;
import model.PictureGalery;

public interface ProductDao {
    
    public List<Item> getProducts();
    public List<Item> getProductsByCategory(int catId);
    public List<Item> getProductsByStatus(int statusId);
    public Item getProductById(int Id);
    public Item getProductByCode(int code);
    public List<PictureGalery> getPictures();
    public List<PictureGalery> getPicturesforProduct(int prodId);
}
