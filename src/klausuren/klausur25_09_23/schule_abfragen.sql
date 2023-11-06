USE schule;

# 1)
# Liste alle Lehrer mit ihren vollständigen Attributen auf. Sortiere die Lehrer dabei 
# aufsteigend zunächst nach dem Vornamen und dann nach dem Nachnamen.
SELECT *
FROM lehrer 
ORDER BY vorname, nachname ASC;


# 2)
# Liste alle Kurse (mit Kurs-ID und Fach) auf, die der Lehrer Donald Dusel unterrichtet.
SELECT kurs_id, fach 
FROM kurs,lehrer 
WHERE kurs_lehrer_id = lehrer_id 
AND vorname = 'Donald' 
AND nachname = 'Dusel';


# 3)
# Erstelle eine Liste mit allen Lehrern (Vor- und Nachname) und den Fächern, die sie 
# unterrichten. Achte darauf, dass keine Zeilen mehrfach erscheinen.
SELECT DISTINCT vorname,nachname,fach 
FROM kurs,lehrer 
WHERE kurs_lehrer_id = lehrer_id;


# 4)
# Erstelle für den Schüler Daniel Weber eine Tabelle mit allen seinen Fächern und der 
# Note, die er jeweils in dem Fach hat. Sortiere die Liste absteigend nach dem Wert 
# der Note.

SELECT fach,note 
FROM note, schueler,kurs 
WHERE schueler_id = note_schueler_id 
AND kurs_id = note_kurs_id 
AND vorname = "Daniel" 
AND nachname = "Weber" 
ORDER BY note DESC;


# 5)
# Liste alle Schüler auf (Vor- und Nachname), die bei der Lehrerin Pia Bachmann
# Unterricht haben.
SELECT schueler.vorname,schueler.nachname 
FROM kurs,lehrer,schueler,note
WHERE schueler_id = note_schueler_id
AND kurs_id = note_kurs_id
AND kurs_lehrer_id = lehrer_id
AND lehrer.vorname = "Pia"
AND lehrer.nachname = "Bachmann";


# 6)
# Liste alle Schüler (Vorname, Nachname und Note) auf, die im Fach Mathematik einen
# Unterkurs haben.
SELECT vorname,nachname,note 
FROM note, schueler,kurs
WHERE schueler_id = note_schueler_id
AND kurs_id = note_kurs_id
AND fach = "Mathematik"
AND note <= "4"; 

# 7)
# Ermittle die Anzahl der weiblichen und die Anzahl der männlichen Lehrer.
SELECT geschlecht,count(*) 
FROM lehrer
GROUP BY geschlecht
HAVING geschlecht = "m"
OR geschlecht = "w";

// My: Warum einfach, wenns auch kompliziert geht? :-)
//     Die beiden letzten Zeilen hättest du dir sparen können.
// ==> 3 von 3 Punkten

# 8)
# Liste alle Schüler auf (Schüler-ID, Vorname und Nachname), für die noch keine
# Noten eingetragen wurden.
SELECT schueler_id, vorname,nachname FROM schueler
LEFT JOIN note
ON schueler_id = note_schueler_id
WHERE note IS NULL;


# 9)
# Liste alle Fächer auf, für die mehr als ein Kurs angeboten wird (Fach und 
# Kursanzahl).
SELECT fach, count(*) FROM kurs
GROUP BY fach 
HAVING count(*) >= 2; 



# 10)
# Liste alle Lehrer auf (Vor- und Nachname), die mit der Lehrerin Pia Bachmann ein
# Unterrichtsfach gemeinsam haben. Frau Bachmann selbst darf auch in der Liste
# erscheinen. Es soll jedoch kein Lehrer doppelt aufgelistet werden.
SELECT DISTINCT gleichlehrer.vorname,gleichlehrer.nachname 
FROM lehrer gleichlehrer, lehrer pialehrer,kurs pia, kurs gleichfach
WHERE gleichfach.fach = pia.fach
AND pialehrer.lehrer_id = pia.kurs_lehrer_id
AND gleichlehrer.lehrer_id = gleichfach.kurs_lehrer_id
AND pialehrer.vorname = "Pia"
AND pialehrer.nachname = "Bachmann";
	

