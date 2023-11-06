DROP SCHEMA IF EXISTS schule;
CREATE SCHEMA schule DEFAULT CHARACTER SET utf8;
USE schule;

CREATE TABLE lehrer (
  lehrer_id INT AUTO_INCREMENT,
  vorname VARCHAR(20) NOT NULL DEFAULT '',
  nachname VARCHAR(20) NOT NULL DEFAULT '',
  geschlecht ENUM('m','w') NOT NULL DEFAULT 'm',
  PRIMARY KEY (lehrer_id)
);

CREATE TABLE kurs (
  kurs_id INT AUTO_INCREMENT,
  fach VARCHAR(20) NOT NULL DEFAULT '',
  kurs_lehrer_id INT NOT NULL DEFAULT 0,
  PRIMARY KEY (kurs_id),
  FOREIGN KEY (kurs_lehrer_id) REFERENCES lehrer (lehrer_id)
);

CREATE TABLE schueler (
  schueler_id INT AUTO_INCREMENT,
  vorname VARCHAR(20) NOT NULL DEFAULT '',
  nachname VARCHAR(20) NOT NULL DEFAULT '',
  geschlecht ENUM('m','w') NOT NULL DEFAULT 'm',
  geburtstag DATE NOT NULL DEFAULT '0000-00-00',
  PRIMARY KEY (schueler_id)
);

CREATE TABLE note (
  note_kurs_id INT NOT NULL DEFAULT 0,
  note_schueler_id INT NOT NULL DEFAULT 0,
  note INT NOT NULL DEFAULT 0,
  PRIMARY KEY  (note_schueler_id, note_kurs_id),
  FOREIGN KEY (note_schueler_id) REFERENCES schueler (schueler_id),
  FOREIGN KEY (note_kurs_id) REFERENCES kurs (kurs_id)
);

INSERT INTO lehrer VALUES
(1, "Pia",      "Bachmann", "w"),
(2, "Manfred",  "Streng",   "m"),
(3, "Donald",   "Dusel",    "m"),
(4, "Susi",     "Sonntag",  "w"),
(5, "Kai",      "Albrecht", "m"),
(6, "Ingeborg", "Schuster", "w");

INSERT INTO kurs VALUES
#id,  fach,      lehrer
(1,  "Mathematik", 1),
(2,  "Mathematik", 3),
(3,  "Biologie",   1),
(4,  "Englisch",   2),
(5,  "Sport",      6),
(6,  "Spanisch",   2),
(7,  "Deutsch",    4),
(8,  "Wirtschaft", 5),
(9,  "Geographie", 5),
(10, "Physik",     3),
(11, "Geschichte", 6),
(12, "Englisch",   2),
(13, "Deutsch",    6);

INSERT INTO schueler VALUES
(1, "Daniel",    "Weber",      "m", "2006-12-23"),
(2, "Andrea",    "Glückstein", "w", "2007-01-01"),
(3, "Isabell",   "Steiner",    "w", "2005-04-25"),
(4, "Michael",   "Plötzlich",  "m", "2007-09-03"),
(5, "Arne",      "Zeiger",     "m", "2006-06-13"),
(6, "Miriam",    "Mandelbrot", "w", "2006-11-28"),
(7, "Stephanie", "Übermut",    "m", "2007-10-05");

INSERT INTO note VALUES
#kurs, schüler, note
(1,  1,  8),
(12, 1, 13),
(9,  1,  9),
(5,  1,  6),
(6,  1,  7),
(11, 1, 11),
(12, 2,  3),
(5,  2,  8),
(8,  2,  9),
(6,  2,  1),
(11, 2,  4),
(2,  3,  6),
(12, 3, 12),
(8,  3,  9),
(5,  3, 10),
(6,  3,  7),
(11, 3,  8),
(4,  3, 10),
(2,  5, 14),
(12, 5,  6),
(9,  5,  7),
(5,  5, 10),
(11, 5,  9),
(4,  5,  7),
(1,  6,  4),
(12, 6,  7),
(8,  6,  3),
(5,  6, 12),
(4,  6,  6);