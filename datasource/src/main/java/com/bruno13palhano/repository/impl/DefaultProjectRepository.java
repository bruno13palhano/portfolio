package com.bruno13palhano.repository.impl;

import com.bruno13palhano.Project;
import com.bruno13palhano.Utils;
import com.bruno13palhano.repository.ProjectRepository;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class DefaultProjectRepository implements ProjectRepository {
    private final Connection connection;

    DefaultProjectRepository(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void insert(Project model) {
        String INSERT = "INSERT INTO projects (name, type, description, images_urls) VALUES (?,?,?,?)";

        try {
            String type = String.join(", ", model.getType());
            String imagesUrls = String.join(", ", model.getImagesUrls());

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, model.getName());
            preparedStatement.setString(2, type);
            preparedStatement.setString(3, model.getDescription());
            preparedStatement.setString(4, imagesUrls);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Integer id) {
        String DELETE = "DELETE FROM projects WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Project model) {
        String UPDATE = "UPDATE projects SET name = ?, type = ?, description = ?, images_urls = ? WHERE id = ?";

        try {
            String type = String.join(", ", model.getType());
            String imagesUrls = String.join(", ", model.getImagesUrls());

            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, model.getName());
            preparedStatement.setString(2, type);
            preparedStatement.setString(3, model.getDescription());
            preparedStatement.setString(4, imagesUrls);
            preparedStatement.setInt(5, model.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Project> getAll() {
        String QUERY_ALL = "SELECT * FROM projects";
        List<Project> result = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                result.add(
                    new Project(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            Utils.stringToList(resultSet.getString("type")),
                            resultSet.getString("description"),
                            Utils.stringToList(resultSet.getString("images_url"))
                    )
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public Project getById(Integer id) {
        String QUERY = "SELECT * FROM users WHERE id = ?";
        Project result = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            result = new Project(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    Utils.stringToList(resultSet.getString("type")),
                    resultSet.getString("description"),
                    Utils.stringToList(resultSet.getString("images_urls"))
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
