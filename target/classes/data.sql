-- Sample Users
INSERT INTO users (email, password, nom, prenom, role, active) VALUES
('admin@sge.com', '$2a$10$e.ExV.x1dJ9C6/s1s2k3j4o5p6q7r8s9t0u1v2w3x4y5z6A7B8C9D', 'Admin', 'User', 'ADMIN', true),
('prof@sge.com', '$2a$10$e.ExV.x1dJ9C6/s1s2k3j4o5p6q7r8s9t0u1v2w3x4y5z6A7B8C9D', 'Einstein', 'Albert', 'PROFESSEUR', true),
('student@sge.com', '$2a$10$e.ExV.x1dJ9C6/s1s2k3j4o5p6q7r8s9t0u1v2w3x4y5z6A7B8C9D', 'Curie', 'Marie', 'ETUDIANT', true);

-- Sample Professors
INSERT INTO professeur (nom, prenom, email, specialite) VALUES
('Einstein', 'Albert', 'prof@sge.com', 'Physics');

-- Sample Subjects
INSERT INTO matiere (nom, code, coefficient, professeur_id) VALUES
('Relativity', 'PHY101', 3, 1);

-- Sample Students
INSERT INTO etudiant (nom, prenom, email, cne, filiere) VALUES
('Curie', 'Marie', 'student@sge.com', 'C123456', 'Science');

-- Sample Enrollments
INSERT INTO inscription (etudiant_id, matiere_id, date_inscription) VALUES
(1, 1, '2023-01-15');

-- Sample Exams
INSERT INTO examen (nom, matiere_id, date_examen, duree, type_examen, statut) VALUES
('Mid-Term Relativity', 1, '2023-03-10 10:00:00', 120, 'CC', 'Scheduled');

-- Sample Grades
INSERT INTO note (examen_id, etudiant_id, note, date_saisie, observations) VALUES
(1, 1, 18.5, '2023-03-20 14:00:00', 'Excellent work');
