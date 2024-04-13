USE
schule;

#
1)
# Liste alle Lehrer mit ihren vollständigen Attributen auf. Sortiere die Lehrer dabei 
# aufsteigend zunächst nach dem Vornamen und dann nach dem Nachnamen.
SELECT *

# 2)
# Liste alle Kurse (mit Kurs-ID und Fach) auf, die der Lehrer Donald Dusel unterrichtet.
SELECT kurs_id, fach


# 3)
# Erstelle eine Liste mit allen Lehrern (Vor- und Nachname) und den Fächern, die sie 
# unterrichten. Achte darauf, dass keine Zeilen mehrfach erscheinen.

# 4)
# Erstelle für den Schüler Daniel Weber eine Tabelle mit allen seinen Fächern und der 
# Note, die er jeweils in dem Fach hat. Sortiere die Liste absteigend nach dem Wert 
# der Note.

# 5)
# Liste alle Schüler auf (Vor- und Nachname), die bei der Lehrerin Pia Bachmann
# Unterricht haben.


# 6)
# Liste alle Schüler (Vorname, Nachname und Note) auf, die im Fach Mathematik einen
# Unterkurs haben.

# 7)
# Ermittle die Anzahl der weiblichen und die Anzahl der männlichen Lehrer.

// My: Warum einfach, wenns auch kompliziert geht? :-)
//     Die beiden letzten Zeilen hättest du dir sparen können.
// ==> 3 von 3 Punkten

# 8)
# Liste alle Schüler auf (Schüler-ID, Vorname und Nachname), für die noch keine
# Noten eingetragen wurden.

# 9)
# Liste alle Fächer auf, für die mehr als ein Kurs angeboten wird (Fach und 
# Kursanzahl).
SELECT fach, count(*) FROM kurs
GROUP BY fach 
HAVING count(*) >= 2; 



#
10)
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
	

