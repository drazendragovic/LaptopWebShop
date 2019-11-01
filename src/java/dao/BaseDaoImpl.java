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
import model.AppUser;
import model.Category;
import model.Logins;

/**
 *
 * @author DrazenDragovic
 */
public class BaseDaoImpl implements BaseDao {

    private AppUser user;
    private List<Logins> logins;

    @Override
    public AppUser login(String username, String password) {
        EntityManager em = EntityManagerUtility.getEntityManager();

        if (em != null) {
            try {
                em.getTransaction().begin();
                user = (AppUser) em.createNamedQuery("AppUser.findByUsername").setParameter("username", username).getSingleResult();
                if (password.equals(user.getPassword())) {
                    System.out.println("User: " + user.toString());
                    em.getTransaction().commit();
                    return user;
                }
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
        return null;
    }

    @Override
    public String register(AppUser user) {
        EntityManager em = EntityManagerUtility.getEntityManager();

        String msg = "Registration unsuccessful, try again.....";

        if (em != null) {

            try {
                em.getTransaction().begin();
                if (user != null) {
                    em.persist(user);

                    msg = "User " + user.getName()
                            + " created successfully, please login...";
                    em.getTransaction().commit();
                }
            } catch (Exception e) {
                msg = "Exception occred while reading user data: "
                        + e.getMessage();
            } finally {
                em.close();
            }

        } else {
            System.out.println("DB server down.....");
        }
        System.out.println("msg:" + msg);
        return msg;
    }

    @Override
    public List<Category> getCategories() {

        EntityManager em = EntityManagerUtility.getEntityManager();
        List<Category> categories = new ArrayList<>();

        if (em != null) {
            try {
                em.getTransaction().begin();
                categories = em.createNamedQuery("Category.findAll", Category.class).getResultList();
                em.getTransaction().commit();
            } catch (Exception e) {
                e.getMessage();
            } finally {
                em.close();
            }
        } else {
            System.out.println("DB server down.....");
        }
        return categories;
    }

    @Override
    public List<Logins> getRecords() {
        EntityManager em = EntityManagerUtility.getEntityManager();

        logins = new ArrayList<>();
        if (em != null) {
            try {
                em.getTransaction().begin();
                logins = em.createNamedQuery("Logins.findAll", Logins.class).getResultList();
                em.getTransaction().commit();
            } catch (Exception e) {
                e.getMessage();
            } finally {
                em.close();
            }
        } else {
            System.out.println("DB server down.....");
        }
        return logins;
    }

    @Override
    public String addRecord(Logins record) {
        EntityManager em = EntityManagerUtility.getEntityManager();

        String msg = "Record insert unsuccessful, try again.....";

        if (em != null) {

            try {
                em.getTransaction().begin();
                if (record != null) {
                    em.persist(record);

                    msg = "Record " + record.getIDLogin()
                            + " inserted successfully";
                    em.getTransaction().commit();
                }
            } catch (Exception e) {
                msg = "Exception occred while reading order data: "
                        + e.getMessage();
            } finally {
                em.close();
            }

        } else {
            System.out.println("DB server down.....");
        }
        System.out.println("msg:" + msg);
        return msg;
    }

    @Override
    public String updateUser(AppUser user) {
        EntityManager em = EntityManagerUtility.getEntityManager();

        String msg = "Registration unsuccessful, try again.....";

        if (em != null) {
            try {
                em.getTransaction().begin();
                if (user != null) {
                    em.refresh(user);

                    msg = "User " + user.getName()
                            + " created successfully, please login...";
                    em.getTransaction().commit();
                }
            } catch (Exception e) {
                msg = "Exception occred while reading user data: "
                        + e.getMessage();
            } finally {
                em.close();
            }
        } else {
            System.out.println("DB server down.....");
        }
        System.out.println("msg:" + msg);
        return msg;
    }
}
