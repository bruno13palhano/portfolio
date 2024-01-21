package com.bruno13palhano.repository.impl;

import com.bruno13palhano.Profile;
import com.bruno13palhano.Utils;
import com.bruno13palhano.repository.ProfileRepository;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class DefaultProfileRepository implements ProfileRepository {
    private final Connection connection;

    public DefaultProfileRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Profile model) {
        String INSERT = "INSERT INTO profile (name,image_url,description,email,cellphone_number,social_media) " +
                "VALUES (?,?,?,?,?,?)";

        try {
            String socialMedia = String.join(", ", model.getSocialMedia());

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, model.getName());
            preparedStatement.setString(2, model.getImageUrl());
            preparedStatement.setString(3, model.getDescription());
            preparedStatement.setString(4, model.getEmail());
            preparedStatement.setString(5, model.getCellphoneNumber());
            preparedStatement.setString(6, socialMedia);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Integer id) {
        String DELETE = "DELETE FROM profile WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Profile model) {
        String UPDATE = "UPDATE profile SET name = ?, image_url = ?, description = ?, email = ?, cellphone_number, " +
                "social_media = ? WHERE id = ?";

        try {
            String socialMedia = String.join(", ", model.getSocialMedia());

            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, model.getName());
            preparedStatement.setString(2, model.getImageUrl());
            preparedStatement.setString(3, model.getDescription());
            preparedStatement.setString(4, model.getEmail());
            preparedStatement.setString(5, model.getCellphoneNumber());
            preparedStatement.setString(6, socialMedia);
            preparedStatement.setInt(7, model.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Profile> getAll() {
        String QUERY_ALL = "SELECT * FROM profile";
        List<Profile> result = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                result.add(
                        new Profile(
                                resultSet.getInt("id"),
                                resultSet.getString("name"),
                                resultSet.getString("image_url"),
                                resultSet.getString("description"),
                                resultSet.getString("email"),
                                resultSet.getString("cellphone_number"),
                                Utils.stringToList(resultSet.getString("social_media"))
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public Profile getById(Integer id) {
        String QUERY = "SELECT * FROM profile WHERE id = ?";
        Profile result = new Profile();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            result = new Profile(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("image_url"),
                    resultSet.getString("description"),
                    resultSet.getString("email"),
                    resultSet.getString("cellphone_number"),
                    Utils.stringToList(resultSet.getString("social_media"))
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
