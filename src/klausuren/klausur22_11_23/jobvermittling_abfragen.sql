USE jobvermittlung;

# 1. Gib eine alphabetisch sortierte Liste aller Jobs aus. Jeder Job soll dabei nur 
#    einmal angezeigt werden.
select distinct job from angestellt
order by job asc;




# 2. Erzeuge eine Liste (Vorname, Nachname) aller Personen, die als Bäcker arbeiten. 
#    Die Liste soll dabei alphabetisch zunächst nach Vorname und dann nach Nachname 
#    sortiert sein. Jede Person soll dabei nur einmal aufgelistet werden.
select vorname, nachname from angestellt, person
where person_id = angestellt_person_id 
and job = 'Bäcker';

# My: Richtig soweit, aber es fehlt die Sortierung und außerdem auch das DISTINCT um
#     sicherzustellen, dass Personen nicht doppelt aufgeführt werden. Auch wenn es mit 
#     den wenigen Beispieldatenbank nicht vorkommt, so ist es doch ohne Weiteres möglich,
#     dass eine Person bei zwei verschiedenen Arbeitgebern als Bäcker jobt!
# ==> 2 von 4 Punkten



# 3. Gib die Anzahl der Arbeitgeber (Firmen) aus. Sonst nichts.
select count(*) from firma;


# 4. Erzeuge eine alphabetisch sortierte Liste aller möglichen Jobs bei der 
#    Lochfabrikatur Kringel. Jeder Job soll dabei nur einmal aufgeführt werden.
select distinct job from firma, angestellt
where firma_id = angestellt_firma_id
and name = 'Lochfabrikatur Kringel';

# My: Auch hier fehlt wieder die Sortierung!
# ==> 3 von 4 Punkten

# eigene Abfragen zur Überpfrüfung

SELECT * FROM person;
SELECT * FROM person, angestellt, firma WHERE person_id = 55 AND person_id = angestellt_person_id AND firma_id = angestellt_firma_id;

SELECT * FROM person pAngezeigt, person pVertretung, angestellt aAngezeigt, angestellt aVertretung 
WHERE pAngezeigt.person_id = aAngezeigt.angestellt_person_id 
AND pvertretung.person_id = aVertretung.angestellt_person_id 
AND aangezeigt.job = avertretung.job
AND pangezeigt.person_id = 55
AND pVertretung.vorname != pangezeigt.vorname 
AND pVertretung.nachname !=  pangezeigt.nachname;

SELECT * FROM person, angestellt, firma WHERE person_id = 2 AND person_id = angestellt_person_id AND firma_id = angestellt_firma_id;

SELECT * FROM person pAngezeigt, person pVertretung, angestellt aAngezeigt, angestellt aVertretung 
WHERE pAngezeigt.person_id = aAngezeigt.angestellt_person_id 
AND pvertretung.person_id = aVertretung.angestellt_person_id 
AND aangezeigt.job = avertretung.job AND pangezeigt.person_id = 2 
AND pAngezeigt.vorname != pVertretung.vorname AND pAngezeigt.nachname != pVertretung.nachname





