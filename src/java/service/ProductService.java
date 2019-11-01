/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.Item;
import model.PictureGalery;

/**
 *
 * @author DrazenDragovic
 */
public interface ProductService {
    
    public List<Item> getProducts();
    public List<Item> getProductsByCategory(int catId);
    public List<Item> getProductsByStatus(int statusId);
    public Item getProductById(int Id);
    public Item getProductByCode(int code);
    public List<PictureGalery> getPictures();
    public List<PictureGalery> getPicturesforProduct(int prodId);
    
}
