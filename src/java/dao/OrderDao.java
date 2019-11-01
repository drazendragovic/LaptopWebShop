/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.AppOrder;
import model.AppUser;
import model.OrderItem;

/**
 *
 * @author DrazenDragovic
 */
public interface OrderDao {
    public List<AppOrder> getOrders();
    public AppOrder getOrderById(int Id);
    public List<AppOrder> getOrdersByUserId(AppUser userId);
    public List<AppOrder> getOrdersByStatus(int statusId);
    public List<OrderItem> getItemsByOrderId(AppOrder order);
    
    public String addOrder(AppOrder order);
    public String addOrderItem(OrderItem orderItem);
}
