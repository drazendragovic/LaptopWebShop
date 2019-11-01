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
import model.AppOrder;
import model.AppUser;
import model.OrderItem;

/**
 *
 * @author DrazenDragovic
 */
public class OrderDaoImpl implements OrderDao {
    
    private List<AppOrder> orders;
    private List<OrderItem> orderItems;
    private AppOrder order;

    @Override
    public List<AppOrder> getOrders() {
        EntityManager em = EntityManagerUtility.getEntityManager();

        orders = new ArrayList<>();
        if (em != null) {
            try {
                em.getTransaction().begin();
                orders = em.createNamedQuery("AppOrder.findAll", AppOrder.class).getResultList();
                em.getTransaction().commit();
            } catch (Exception e) {
                e.getMessage();
            } finally {
                em.close();
            }
        } else {
            System.out.println("DB server down.....");
        }
        return orders;
    }

    @Override
    public AppOrder getOrderById(int orderId) {
        EntityManager em = EntityManagerUtility.getEntityManager();

        if (em != null) {
            try {
                em.getTransaction().begin();
                order = (AppOrder) em.createNamedQuery("AppOrder.findByIDOrder").setParameter("iDOrder", orderId).getSingleResult();
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
        return order;
    }

    @Override
    public List<AppOrder> getOrdersByUserId(AppUser userId) {
        EntityManager em = EntityManagerUtility.getEntityManager();

        orders = new ArrayList<>();

        if (em != null) {
            try {
                em.getTransaction().begin();
                orders = em.createNamedQuery("AppOrder.findByUserID", AppOrder.class).setParameter("userID", userId).getResultList();
                em.getTransaction().commit();
            } catch (Exception e) {
                e.getMessage();
            } finally {
                em.close();
            }
        } else {
            System.out.println("DB server down.....");
        }
        return orders;
    }

    @Override
    public List<AppOrder> getOrdersByStatus(int statusId) {
        EntityManager em = EntityManagerUtility.getEntityManager();

        orders = new ArrayList<>();

        if (em != null) {
            try {
                em.getTransaction().begin();
                orders = em.createNamedQuery("AppOrder.findByStatusID", AppOrder.class).setParameter("statusID", statusId).getResultList();
                em.getTransaction().commit();
            } catch (Exception e) {
                e.getMessage();
            } finally {
                em.close();
            }
        } else {
            System.out.println("DB server down.....");
        }
        return orders;    
    }

    @Override
    public List<OrderItem> getItemsByOrderId(AppOrder order) {
        EntityManager em = EntityManagerUtility.getEntityManager();

        orderItems = new ArrayList<>();

        if (em != null) {
            try {
                em.getTransaction().begin();
                orderItems = em.createNamedQuery("OrderItem.findByOrderID", OrderItem.class).setParameter("orderID", order).getResultList();
                em.getTransaction().commit();
            } catch (Exception e) {
                e.getMessage();
            } finally {
                em.close();
            }
        } else {
            System.out.println("DB server down.....");
        }
        return orderItems;  
    }

    @Override
    public String addOrder(AppOrder order) {
        EntityManager em = EntityManagerUtility.getEntityManager();

        String msg = "Order insert unsuccessful, try again.....";

        if (em != null) {

            try {
                em.getTransaction().begin();
                if (order != null) {
                    em.persist(order);

                    msg = "Order " + order.getIDOrder()
                            + " created successfully";
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
    public String addOrderItem(OrderItem orderItem) {
        EntityManager em = EntityManagerUtility.getEntityManager();

        String msg = "Order insert unsuccessful, try again.....";

        if (em != null) {

            try {
                em.getTransaction().begin();
                if (orderItem != null) {
                    em.persist(orderItem);

                    msg = "Order Item " + orderItem.getIDOrderItem()
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
    
}
