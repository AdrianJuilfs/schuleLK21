DROP DATABASE IF EXISTS jobvermittlung;
CREATE DATABASE jobvermittlung DEFAULT CHARACTER SET UTF8;
USE jobvermittlung;

CREATE TABLE  firma (
	firma_id INT AUTO_INCREMENT,
	name VARCHAR(40),
	anschrift VARCHAR(30),
	PRIMARY KEY (firma_id)
);

INSERT INTO firma VALUES
(1, 'Karl Hebemann AG',               'Winterstraße 13'),
(2, 'Schokoladenfabrikatur Herrmann', 'Buchenstraße 76-82'),
(3, 'Lochfabrikatur Kringel',         'Märchenweg 12'),
(4, 'Freckas Hundefutter AG',         'Kanarienweg 56'),
(5, 'Backwaren Kornelsen',            'Marienweg 34-36');

CREATE TABLE person (
	person_id INT AUTO_INCREMENT,
	vorname VARCHAR(20),
	nachname VARCHAR(20),
	telefonnr VARCHAR(20),
	PRIMARY KEY (person_id)
);

#INSERT INTO person VALUES
#(2,  'Karsten', 'Westerboer', '45 45 09'),
#(3,  'Sonja',   'Klein',      '12 23 23 8'),
#(4,  'Marion',  'Dünnwald',   '54 34 64'),
#(5,  'Kevin',   'Freud',      '76 23 45'),
#(6,  'Arno',    'Liebmann',   '78 77 77 8'),
#(10, 'Niklas',  'Potter',     '16 72 66'),
#(17, 'Daniela', 'Koch',       '91 14 36'),
#(18, 'Mark',    'Markward',   '93 63 48'),
#(20, 'Carol',   'Lourand',    '32 73 34'),
#(55, 'Hedwig',  'Müller',     '23 45 756');

CREATE TABLE  angestellt (
	angestellt_person_id INT,
 	angestellt_firma_id INT,
 	job VARCHAR(20),
 	PRIMARY KEY (angestellt_person_id, angestellt_firma_id),
 	FOREIGN KEY (angestellt_person_id) REFERENCES person (person_id),
 	FOREIGN KEY (angestellt_firma_id) REFERENCES firma (firma_id)
);

#INSERT INTO angestellt VALUES
#(2,  3, 'Lochstanzer'),
#(2,  5, 'Lieferwagenfahrer'),
#(3,  5, 'Bäcker'),
#(4,  5, 'Bäcker'),
#(4,  3, 'Lochstanzer'),
#(4,  4, 'Futtertester'),
#(5,  4, 'Lieferwagenfahrer'),
#(6,  3, 'Lieferwagenfahrer'),
#(6,  5, 'Lieferwagenfahrer'),
#(10, 5, 'Bäcker'),
#(10, 4, 'Futtertester'),
#(17, 2, 'Schreibarbeiten'),
#(18, 3, 'Lochstanzer'),
#(20, 1, 'Schreibarbeiten'),
#(20, 5, 'Bäcker'),
#(55, 1, 'Schreibarbeiten'),
#(55, 4, 'Futtertester');


SELECT mitPersonX.vorname, mitPersonX.nachname, angestellt.job 
FROM person mitPersonX, person PersonX, angestellt 
WHERE PersonX.person_id = angestellt_person_id 
AND mitPersonX.person_id = angestellt_person_id 
AND PersonX.person_id != mitPersonX.person_id




