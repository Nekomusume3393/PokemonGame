/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemon.pokedex.dao.impl;

import java.util.List;
import pokemon.pokedex.dao.UserDAO;
import pokemon.pokedex.entity.User;
import pokemon.pokedex.util.XJdbc;
import pokemon.pokedex.util.XQuery;

/**
 *
 * @author May5th
 */
public class UserDAOImpl implements UserDAO {

    String createSql = "INSERT INTO Users (Username, Password, DisplayName, Image, Manager) VALUES (?, ?, ?, ?, ?)";
    String updateSql = "UPDATE Users SET Password = ?, DisplayName = ?, Image = ?, Manager = ? WHERE Username = ?";
    String deleteSql = "DELETE FROM Users WHERE Username = ?";
    String findAllSql = "SELECT * FROM Users";
    String findByIdSql = "SELECT * FROM Users WHERE Username = ?";

    @Override
    public User create(User entity) {
        Object[] values = {
            entity.getUsername(),
            entity.getPassword(),
            entity.getDisplayName(),
            entity.getImage(),
            entity.isManager()
        };
        XJdbc.executeUpdate(createSql, values);
        return entity;
    }

    @Override
    public void update(User entity) {
        Object[] values = {
            entity.getPassword(),
            entity.getDisplayName(),
            entity.getImage(),
            entity.isManager(),
            entity.getUsername()
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(String id) {
        XJdbc.executeUpdate(deleteSql, id);
    }

    @Override
    public List<User> findAll() {
        return XQuery.getBeanList(User.class, findAllSql);
    }

    @Override
    public User findById(String id) {
        return XQuery.getSingleBean(User.class, findByIdSql, id);
    }
}
