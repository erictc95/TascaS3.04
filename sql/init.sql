CREATE SCHEMA IF NOT EXISTS agenda_db;

USE agenda_db;

CREATE TABLE IF NOT EXISTS event (
    event_id INT NOT NULL AUTO_INCREMENT,
    event_name VARCHAR(100) NOT NULL,
    event_description LONGTEXT NULL,
    event_start DATETIME NOT NULL,
    event_end DATETIME NULL,
    event_location VARCHAR(100) NULL,

    event_repeat_type ENUM(
        'NONE',
        'YEARLY',
        'CUSTOM'
    ) DEFAULT 'NONE',

    event_custom_repeat VARCHAR(100) NULL,

    event_notification_minutes INT DEFAULT 30,

    event_status ENUM(
        'PLANNED',
        'COMPLETED',
        'CANCELLED'
    ) DEFAULT 'PLANNED',

    event_created_at DATETIME
        DEFAULT CURRENT_TIMESTAMP,

    PRIMARY KEY (event_id)
);

CREATE TABLE IF NOT EXISTS task (

    task_id INT NOT NULL AUTO_INCREMENT,

    task_title VARCHAR(100) NOT NULL,

    task_description LONGTEXT NULL,

    task_due_at DATETIME NULL,

    task_priority ENUM(
        'LOW',
        'MEDIUM',
        'HIGH'
    ) DEFAULT 'MEDIUM',

    task_status ENUM(
        'PENDING',
        'COMPLETED'
    ) DEFAULT 'PENDING',

    task_created_at DATETIME
        DEFAULT CURRENT_TIMESTAMP,

    task_event_id INT NULL,

    PRIMARY KEY (task_id),

    CONSTRAINT fk_task_event
        FOREIGN KEY (task_event_id)
        REFERENCES event(event_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS note (

    note_id INT NOT NULL AUTO_INCREMENT,

    note_title VARCHAR(100) NOT NULL,

    note_description LONGTEXT NULL,

    note_created_at DATETIME
        DEFAULT CURRENT_TIMESTAMP,

    note_task_id INT NOT NULL,

    PRIMARY KEY (note_id),

    CONSTRAINT fk_note_task
        FOREIGN KEY (note_task_id)
        REFERENCES task(task_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);