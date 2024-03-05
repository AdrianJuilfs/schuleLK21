USE firma;

# 2a
# Erstelle eine Liste aller Abteilungen (Abteilungsname und Abteilungsnummer) und der Namen der zugehörigen
# Abteilungsleiter (Vor- und Nachname). Sortiere die Liste absteigend nach dem Abteilungsnamen.
SELECT abteilungsname,abteilung_id,vorname,nachname 
FROM angestellter, abteilung
WHERE abteilungsleiter_id = angestellter_id
ORDER BY abteilungsname DESC;
# 2b
# Erstelle eine Liste aller Angestellten und ihrer Angehörigen. Es sollen der Vor- und Nachname der Angestellten
# sowie der Name, das Geschlecht und der Verwandtschaftsgrad der Angehörigen aufgelistet werden. Auch
# Angestellte, die keine Angehörigen besitzen, sollen in der Tabelle aufgelistet werden. Sortiere die Liste
# alphabetisch zuerst nach dem Nachnamen und anschließend nach dem Vornamen der Angestellten. Danach
# soll die Liste nach dem Namen der Angehörigen sortiert werden.
SELECT angestellter.vorname,angestellter.nachname,
	   angehöriger.vorname,angehöriger.nachname,
	   angehöriger.geschlecht,angehöriger.verwandtschaft
FROM angehöriger, angestellter
WHERE angehöriger_angestellter_id = angestellter_id;

# 2c
# Ermittle den Namen (Vor- und Nachname) des Vorgesetzten von Jennifer Wallace.
SELECT vorname,nachname 
FROM angestellter
WHERE (SELECT vorgesetzter_id 
		FROM angestellter 
		WHERE vorname= 'Jennifer' 
		AND nachname = 'Wallace') = angestellter_id;

# 2d
# Zähle die Anzahl der Projekte, die momentan in der Firma durchgeführt werden.
SELECT Count(*) FROM projekt;

# 2e
# Erstelle eine Liste mit allen Angestellten (Vor- und Nachname) und den Projekten (Projekt-Name und
# Projekt-Nummer), an denen sie arbeiten.
SELECT vorname,nachname,projektname,projekt_id 
FROM angestellter, projekt, arbeitet_an
WHERE arbeitet_an_angestellter_id = angestellter_id
AND arbeitet_an_projekt_id = projekt_id;

# 2f
# Erstelle eine Liste aller Mitarbeiter (Vorname, Nachname, Geburtstag, Geschlecht), die am Projekt 
# "Newbenefits" arbeiten.
SELECT vorname,nachname,geburtstag,geschlecht 
FROM angestellter, arbeitet_an
WHERE arbeitet_an_projekt_id = (SELECT projekt_id 
								FROM projekt 
								WHERE projektname = 'Newbenefits') 
AND arbeitet_an_angestellter_id = angestellter_id;

# 2g
# Ermittle den Abteilungsleiter (Vor- und Nachname), der für das Projekt "Reorganization" zuständig ist.
SELECT vorname,nachname 
FROM angestellter
LEFT JOIN arbeitet_an 
ON arbeitet_an_angestellter_id
LEFT JOIN abteilung 
ON abteilungsleiter_id
WHERE arbeitet_an_angestellter_id = angestellter_id
AND arbeitet_an_projekt_id = (SELECT projekt_id FROM projekt WHERE projektname = 'Reorganization')
AND abteilungsleiter_id = angestellter_id
AND vorgesetzter_id IS NULL;

SELECT vorname, nachname
FROM projekt, abteilung, angestellter 
WHERE projekt_abteilung_id = abteilung_id
AND abteilungsleiter_id = angestellter_id
AND projektname = 'Reorganization';

# 2h
# Zähle die Anzahl der Mitarbeiter im Projekt "Reorganization".
SELECT COUNT(*)
FROM arbeitet_an, projekt, angestellter
WHERE angestellter_id = arbeitet_an_angestellter_id
AND (SELECT projekt_id FROM projekt WHERE projektname = 'Reorganization') = arbeitet_an_projekt_id;

# 2i
# Liste alle Orte auf, in denen die Firma eine Niederlassung besitzt. Jeder Ort soll nur einmal aufgelistet
# werden.
SELECT DISTINCT ortsname FROM ort;

# 2j
# Zähle die Anzahl der Projekte, an denen jeder einzelne Mitarbeiter arbeitet. Die Mitarbeiter sollen mit Vor-
# und Nachnamen aufgelistet werden.
SELECT vorname,nachname, Count(arbeitet_an_projekt_id) 
FROM projekt, angestellter, arbeitet_an 
WHERE arbeitet_an_projekt_id = projekt_id
AND arbeitet_an_angestellter_id = angestellter_id;

# 2k
# Liste alle Projekte mit Namen auf, die am selben Ort wie das Projekt „Newbenefits“ stattfinden. Das Projekt
# "Newbenefits" selbst soll nicht in der Liste erscheinen.
SELECT projektname 
FROM projekt, ort 
WHERE ort_id = (SELECT projekt_ort_id FROM projekt WHERE projektname = 'Newbenefits')
AND projektname != 'Newbenefits';
# 2l
# Liste alle Mitarbeiter mit Vornamen, Nachnamen und Angestellten-Nummer auf, die mindestens drei
# Angehörige besitzen.

SELECT angestellter.vorname, angestellter.nachname, angestellter.angestellter_id, count(angehöriger_angestellter_id)
FROM angestellter, angehöriger
GROUP BY angestellter_id = angehöriger_angestellter_id
HAVING COUNT(angehöriger_angestellter_id) >= 3;

SELECT angestellter.vorname, angestellter.nachname, angestellter.angestellter_id, count(angehöriger_angestellter_id)
FROM angestellter
LEFT JOIN angehöriger
ON angestellter_id = angehöriger_angestellter_id
GROUP BY angehöriger_angestellter_id
HAVING angehöriger_angestellter_id = angestellter_id
AND COUNT(angehöriger_angestellter_id) >= 3; 
