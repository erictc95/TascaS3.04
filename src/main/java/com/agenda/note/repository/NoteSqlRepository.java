package com.agenda.note.repository;

import com.agenda.infrastructure.sql.ConnectionManager;
import com.agenda.note.model.Note;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class NoteSqlRepository implements INoteRepository {


    @Override
    public void save(Note note) {
        String sql = """
                INSERT INTO note
                (note_title, note_description, note_task_id)
                VALUES (?, ?, ?)
                """;

        try (
                Connection connection =
                        ConnectionManager.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
                ) {
            statement.setString(1, note.getTitle());
            statement.setString(2, note.getDescription());
            statement.setInt(3, note.getTaskId());

            statement.executeUpdate();

            System.out.println("Note saved in database!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Note> findAll() {
        return List.of();
    }

    @Override
    public void update(Note note) {

    }

    @Override
    public void delete(int noteId) {

    }

    @Override
    public Note findById(int noteId) {
        return null;
    }

    @Override
    public List<Note> findByTitle(String title) {
        return List.of();
    }

    @Override
    public List<Note> findByWord(String word) {
        return List.of();
    }
}
