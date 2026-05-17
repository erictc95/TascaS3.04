USE agenda_db;

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
) VALUES
    (
        'Sprint Planning',
        'Sprint planning session with the development team.',
        '2026-05-18 09:00:00',
        '2026-05-18 10:30:00',
        'Agile Room',
        'NONE',
        NULL,
        30,
        'PLANNED'
    ),
    (
        'Medical Checkup',
        'Annual follow-up appointment.',
        '2026-05-20 17:00:00',
        '2026-05-20 17:45:00',
        'North Medical Center',
        'YEARLY',
        NULL,
        120,
        'PLANNED'
    ),
    (
        'English Class',
        'Recurring speaking practice session.',
        '2026-05-21 19:00:00',
        '2026-05-21 20:00:00',
        'Central Academy',
        'CUSTOM',
        '7',
        60,
        'PLANNED'
    );

INSERT INTO task (
    task_title,
    task_description,
    task_due_at,
    task_priority,
    task_status,
    task_event_id
) VALUES
    (
        'Prepare backlog',
        'Review stories and dependencies before sprint planning.',
        '2026-05-18 08:30:00',
        'HIGH',
        'PENDING',
        1
    ),
    (
        'Bring lab results',
        'Do not forget the latest test results for the medical checkup.',
        '2026-05-20 16:00:00',
        'MEDIUM',
        'PENDING',
        2
    ),
    (
        'Do listening exercises',
        'Review unit 4 before class.',
        '2026-05-21 18:00:00',
        'LOW',
        'COMPLETED',
        3
    );

INSERT INTO note (
    note_title,
    note_description,
    note_task_id
) VALUES
    (
        'Priority stories',
        'Validate blocked tasks before estimation.',
        1
    ),
    (
        'Medical documents',
        'Bring ID, health card, and printed lab results.',
        2
    ),
    (
        'Vocabulary',
        'Review work and meeting phrasal verbs.',
        3
    );
