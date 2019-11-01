/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Utility.EntityManagerUtility;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import model.Item;
import model.PictureGalery;

/**
 *
 * @author DrazenDragovic
 */
public class ProductDaoImpl implements ProductDao {

    private List<Item> items;
    private Item product;

    @Override
    public List<Item> getProducts() {
        EntityManager em = EntityManagerUtility.getEntityManager();

        items = new ArrayList<>();
        if (em != null) {
            try {
                em.getTransaction().begin();
                items = em.createNamedQuery("Item.findAll", Item.class).getResultList();
                em.getTransaction().commit();
            } catch (Exception e) {
                e.getMessage();
            } finally {
                em.close();
            }
        } else {
            System.out.println("DB server down.....");
        }
        return items;
    }

    @Override
    public List<Item> getProductsByCategory(int catId) {

        EntityManager em = EntityManagerUtility.getEntityManager();

        items = new ArrayList<>();

        if (em != null) {
            try {
                em.getTransaction().begin();
                //items = em.createStoredProcedureQuery("Item.getItemByCategory").setParameter("idCategory", catId).getResultList();
                StoredProcedureQuery procedureQuery
                        = em.createNamedStoredProcedureQuery("Item.getItemByCategory");
                procedureQuery.setParameter("idCategory", catId);
                procedureQuery.execute();
                items = procedureQuery.getResultList();
                em.getTransaction().commit();
            } catch (Exception e) {
                e.getMessage();
            } finally {
                em.close();
            }
        } else {
            System.out.println("DB server down.....");
        }
        return items;
    }

    @Override
    public Item getProductById(int productId) {

        EntityManager em = EntityManagerUtility.getEntityManager();

        if (em != null) {
            try {
                em.getTransaction().begin();
                product = (Item) em.createNamedQuery("Item.findByIDItem").setParameter("iDItem", productId).getSingleResult();
                em.getTransaction().commit();
            } catch (Exception e) {
                System.out.println("Exception occred while reading user data: "
                        + e.getMessage());
                return null;
            } finally {
                em.close();
            }
        } else {
            System.out.println("DB server down.....");
        }
        return product;
    }

    @Override
    public Item getProductByCode(int code) {

        EntityManager em = EntityManagerUtility.getEntityManager();

        if (em != null) {
            try {
                em.getTransaction().begin();
                product = (Item) em.createNamedQuery("Item.findByCode").setParameter("code", code).getSingleResult();
                em.getTransaction().commit();
            } catch (Exception e) {
                System.out.println("Exception occred while reading user data: "
                        + e.getMessage());
                return null;
            } finally {
                em.close();
            }
        } else {
            System.out.println("DB server down.....");
        }
        return product;
    }

    @Override
    public List<PictureGalery> getPicturesforProduct(int prodId) {

        EntityManager em = EntityManagerUtility.getEntityManager();

        List<PictureGalery> pictures = new ArrayList<>();

        if (em != null) {
            try {
                em.getTransaction().begin();
                pictures = em.createNamedQuery("PictureGalery.findByProductID", PictureGalery.class).setParameter("pictureItemID", prodId).getResultList();
                em.getTransaction().commit();
            } catch (Exception e) {
                e.getMessage();
            } finally {
                em.close();
            }
        } else {
            System.out.println("DB server down.....");
        }
        return pictures;
    }

    @Override
    public List<Item> getProductsByStatus(int statusId) {

        EntityManager em = EntityManagerUtility.getEntityManager();

        items = new ArrayList<>();

        if (em != null) {
            try {
                em.getTransaction().begin();
                items = em.createNamedQuery("Item.findByItemStatus", Item.class).setParameter("itemStatusID", statusId).getResultList();
                em.getTransaction().commit();
            } catch (Exception e) {
                e.getMessage();
            } finally {
                em.close();
            }
        } else {
            System.out.println("DB server down.....");
        }
        return items;
    }

    @Override
    public List<PictureGalery> getPictures() {
        EntityManager em = EntityManagerUtility.getEntityManager();

        List<PictureGalery> pictures = new ArrayList<>();

        if (em != null) {
            try {
                em.getTransaction().begin();
                pictures = em.createNamedQuery("PictureGalery.findAll", PictureGalery.class).getResultList();
                em.getTransaction().commit();
            } catch (Exception e) {
                e.getMessage();
            } finally {
                em.close();
            }
        } else {
            System.out.println("DB server down.....");
        }
        return pictures;
    }

}
