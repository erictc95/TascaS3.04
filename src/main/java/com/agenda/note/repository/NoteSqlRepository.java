package com.agenda.note.repository;

import com.agenda.infrastructure.sql.ConnectionManager;
import com.agenda.note.model.Note;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NoteSqlRepository implements INoteRepository {

    private int nextId = 1;

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

        List<Note> notes = new ArrayList<>();

        String sql = """
                SELECT * FROM note
                """;
        try (
                Connection connection =
                        ConnectionManager.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql);

                ResultSet resultSet =
                        statement.executeQuery()
                ) {
            while (resultSet.next()) {
                Note note = new Note(

                        resultSet.getInt("note_id"),

                        resultSet.getString("note_title"),

                        resultSet.getNString("note_description"),

                        resultSet.getInt("note_task_id")
                );

                notes.add(note);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return notes;
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
