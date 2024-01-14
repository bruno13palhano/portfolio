package com.bruno13palhano.repository.impl;

import com.bruno13palhano.User;
import com.bruno13palhano.repository.UserRepository;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class DefaultUserRepository implements UserRepository {
    private final Connection connection;

    public DefaultUserRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(User model) {
        String INSERT = "INSERT INTO users (username,password,email,role,enabled) VALUES (?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, model.getUsername());
            preparedStatement.setString(2, model.getPassword());
            preparedStatement.setString(3, model.getPassword());
            preparedStatement.setString(4, model.getEmail());
            preparedStatement.setString(5, model.getRole());
            preparedStatement.setBoolean(6, model.getEnabled());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Integer id) {
        String DELETE = "DELETE FROM users WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User model) {
        String UPDATE = "UPDATE user SET username = ?, password = ?, email = ?, role = ?, enabled = ? WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, model.getUsername());
            preparedStatement.setString(2, model.getPassword());
            preparedStatement.setString(3, model.getEmail());
            preparedStatement.setString(4, model.getRole());
            preparedStatement.setBoolean(5, model.getEnabled());
            preparedStatement.setInt(6, model.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAll() {
        String QUERY_ALL = "SELECT * FROM users";
        List<User> result = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                result.add(
                        new User(
                                resultSet.getInt("id"),
                                resultSet.getString("username"),
                                resultSet.getString("password"),
                                resultSet.getString("email"),
                                resultSet.getString("role"),
                                resultSet.getBoolean("enabled")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public User getById(Integer id) {
        String QUERY = "SELECT * FROM users WHERE id = ?";
        User result = new User();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            result = new User(
                resultSet.getInt("id"),
                resultSet.getString("username"),
                resultSet.getString("password"),
                resultSet.getString("email"),
                resultSet.getString("role"),
                resultSet.getBoolean("enabled")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
