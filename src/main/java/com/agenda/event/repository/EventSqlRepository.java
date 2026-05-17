package com.agenda.event.repository;

import com.agenda.event.model.Event;
import com.agenda.infrastructure.sql.ConnectionManager;

import java.sql.*;

public class EventSqlRepository implements EventRepository{


    @Override
    public int saveEvent(Event event) {
        String sql = """
        INSERT INTO event (
            event_name,
            event_description,
            event_start,
            event_end,
            event_location,
            event_repeat_type,
            event_custom_repeat,
            event_notification_minutes,
            event_status
        ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
        """;

        try (
                Connection connection = ConnectionManager.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) {
            ps.setString(1, event.getName());
            ps.setString(2, event.getDescription());
            ps.setTimestamp(3, Timestamp.valueOf(event.getStartDate()));

            if (event.getEndDate() != null) {
                ps.setTimestamp(4, Timestamp.valueOf(event.getEndDate()));
            } else {
                ps.setNull(4, Types.TIMESTAMP);
            }

            ps.setString(5, event.getLocation());
            ps.setString(6, event.getRepeatType().name());
            ps.setInt(7, event.getEventCustomRepeat());

            ps.setInt(8, event.getEventNotificationMinutes());
            ps.setString(9, event.getStatus().name());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    event.setId(rs.getInt(1));
                }
            }

            return event.getId();

        } catch (SQLException e) {
            throw new RuntimeException("Error saving event", e);
        }
    }
}
