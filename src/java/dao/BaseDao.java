/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.AppUser;
import model.Category;
import model.Logins;

/**
 *
 * @author DrazenDragovic
 */
public interface BaseDao {

    public AppUser login(String username, String password);
    public String register(AppUser user);
    public String updateUser(AppUser user);
    public List<Category> getCategories();
    public List<Logins> getRecords();
    public String addRecord(Logins record);
}
