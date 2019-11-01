/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ProductDao;
import dao.ProductDaoImpl;
import java.util.List;
import model.Item;
import model.PictureGalery;

/**
 *
 * @author DrazenDragovic
 */
public class ProductServiceImpl implements ProductService {
    
    private ProductDao productDao = new ProductDaoImpl();

    @Override
    public List<Item> getProducts() {
        return productDao.getProducts();
    }

    @Override
    public List<Item> getProductsByCategory(int catId) {
        return productDao.getProductsByCategory(catId);
    }

    @Override
    public Item getProductById(int Id) {
        return productDao.getProductById(Id);
    }

    @Override
    public Item getProductByCode(int code) {
        return productDao.getProductByCode(code);
    }

    @Override
    public List<PictureGalery> getPicturesforProduct(int prodId) {
        return productDao.getPicturesforProduct(prodId);
    }

    @Override
    public List<Item> getProductsByStatus(int statusId) {
        return productDao.getProductsByStatus(statusId);
    }

    @Override
    public List<PictureGalery> getPictures() {
        return productDao.getPictures();
    }
    
}
