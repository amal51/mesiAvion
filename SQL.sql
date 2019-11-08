SELECT avion
FROM DetailsVol
WHERE id = (
 	SELECT MAX(nombre)
    FROM (
        SELECT COUNT(avion) AS nombre
        FROM DetailsVol
        WHERE
            dateHeureDepart >= DATE_FORMAT(dateMin, '%r')
        AND
            dateHeureDepart >= DATE_FORMAT(dateMax, '%r')
    ) AS nombre_count

SELECT COUNT(passager) as NombreAnnulation
FROM reservation
WHERE estActif = 0
AND dateReservation >= dateMin
AND dateReservation <= dateMax

SELECT COUNT(email) AS NombrePassagers
FROM Passager

SELECT COUNT(DISTINCT passager) as NombrePassagers
FROM reservation
WHERE estActif = 1
AND dateReservation >= dateMin
AND dateReservation <= dateMax

SELECT COUNT(*) AS NombreReservations
FROM Reservation
WHERE
	dateReservation >= dateMin
AND
	dateReservation <= dateMax