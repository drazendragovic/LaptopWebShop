package service;

import dao.OrderDao;
import dao.OrderDaoImpl;
import java.util.List;
import model.AppOrder;
import model.AppUser;
import model.OrderItem;


public class OrderServiceImpl implements OrderService {
    
    private OrderDao orderDao = new OrderDaoImpl();

    @Override
    public List<AppOrder> getOrders() {
        return orderDao.getOrders();
    }

    @Override
    public AppOrder getOrderById(int Id) {
        return orderDao.getOrderById(Id);
    }

    @Override
    public List<AppOrder> getOrdersByUserId(AppUser userId) {
        return orderDao.getOrdersByUserId(userId);
    }

    @Override
    public List<AppOrder> getOrdersByStatus(int statusId) {
        return orderDao.getOrdersByStatus(statusId);
    }

    @Override
    public List<OrderItem> getItemsByOrderId(AppOrder order) {
        return orderDao.getItemsByOrderId(order);
    }

    @Override
    public String addOrder(AppOrder order) {
        return orderDao.addOrder(order);
    }

    @Override
    public String addOrderItem(OrderItem orderItem) {
        return orderDao.addOrderItem(orderItem);
    }
    
}
