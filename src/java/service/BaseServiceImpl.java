/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.BaseDao;
import dao.BaseDaoImpl;
import java.util.List;
import model.AppUser;
import model.Category;
import model.Logins;

/**
 *
 * @author DrazenDragovic
 */
public class BaseServiceImpl implements BaseService {
    
    private BaseDao baseDao = new BaseDaoImpl();

    @Override
    public AppUser login(String username, String password) {
        return baseDao.login(username, password);
    }

    @Override
    public String registration(AppUser user) {
        return baseDao.register(user);
    }

    @Override
    public List<Category> getCategories() {
        return baseDao.getCategories();
    }

    @Override
    public List<Logins> getRecords() {
        return baseDao.getRecords();
    }

    @Override
    public String addRecord(Logins record) {
        return baseDao.addRecord(record);
    }

    @Override
    public String updateUser(AppUser user) {
        return baseDao.updateUser(user);
    }
}
