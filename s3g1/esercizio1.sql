CREATE TABLE Clienti (
	numero_cliente SERIAL PRIMARY KEY,
	nome VARCHAR NOT NULL,
	cognome VARCHAR NOT NULL,
	data_nascita DATE NOT NULL,
	regione VARCHAR NOT NULL
);

CREATE TABLE Prodotti (
    id_prodotto SERIAL PRIMARY KEY,
    descrizione VARCHAR,
    in_produzione BOOLEAN NOT NULL,
    in_commercio BOOLEAN NOT NULL,
    data_attivazione DATE,
    data_disattivazione DATE
);

CREATE TABLE Fornitori (
    numero_fornitore SERIAL PRIMARY KEY,
    denominazione VARCHAR NOT NULL,
    regione_residenza VARCHAR NOT NULL
);

CREATE TABLE Fatture (
	numero_fattura SERIAL PRIMARY KEY,
	tipologia CHAR NOT NULL,
	importo DECIMAL NOT NULL,
	iva DECIMAL NOT NULL,
	id_cliente INTEGER NOT NULL,
	data_fattura DATE NOT NULL,
	numero_fornitore INT NOT NULL,
	FOREIGN KEY (id_cliente) REFERENCES Clienti (numero_cliente),
	FOREIGN KEY (numero_fornitore) REFERENCES Fornitori(numero_fornitore)
);


INSERT INTO Clienti (nome, cognome, data_nascita, regione) VALUES ('Mario', 'Rossi', '1980-05-10', 'Lombardia');
INSERT INTO Clienti (nome, cognome, data_nascita, regione) VALUES ('Laura', 'Bianchi', '1992-12-15', 'Lazio');
INSERT INTO Clienti (nome, cognome, data_nascita, regione) VALUES ('Luigi', 'Verdi', '1975-07-22', 'Piemonte');
INSERT INTO Clienti (nome, cognome, data_nascita, regione) VALUES ('Maria', 'Russo', '1988-03-28', 'Campania');
INSERT INTO Clienti (nome, cognome, data_nascita, regione) VALUES ('Giovanni', 'Esposito', '1990-09-05', 'Sicilia');


INSERT INTO Prodotti (descrizione, in_produzione, in_commercio, data_attivazione, data_disattivazione) VALUES('Prodotto A', true, true, '2022-01-01', null);
INSERT INTO Prodotti (descrizione, in_produzione, in_commercio, data_attivazione, data_disattivazione) VALUES('Prodotto B', true, true, '2021-05-15', null);
INSERT INTO Prodotti (descrizione, in_produzione, in_commercio, data_attivazione, data_disattivazione) VALUES('Prodotto C', true, false, '2023-03-10', '2023-06-30');
INSERT INTO Prodotti (descrizione, in_produzione, in_commercio, data_attivazione, data_disattivazione) VALUES('Prodotto D', false, false, '2022-07-01', '2022-12-31');
INSERT INTO Prodotti (descrizione, in_produzione, in_commercio, data_attivazione, data_disattivazione) VALUES('Prodotto E', true, true, '2023-01-01', null);


INSERT INTO Fornitori (denominazione, regione_residenza) VALUES ('Fornitore A', 'Lombardia');
INSERT INTO Fornitori (denominazione, regione_residenza) VALUES ('Fornitore B', 'Puglia');
INSERT INTO Fornitori (denominazione, regione_residenza) VALUES ('Fornitore C', 'Veneto');
INSERT INTO Fornitori (denominazione, regione_residenza) VALUES ('Fornitore D', 'Campania');
INSERT INTO Fornitori (denominazione, regione_residenza) VALUES ('Fornitore E', 'Toscana');

INSERT INTO Fatture (tipologia, importo, iva, id_cliente, data_fattura, numero_fornitore) VALUES ('A', 100.50, 22.50, 11, '2023-01-15', 6);
INSERT INTO Fatture (tipologia, importo, iva, id_cliente, data_fattura, numero_fornitore) VALUES ('B', 75.20, 15.80, 12, '2023-02-05', 7);
INSERT INTO Fatture (tipologia, importo, iva, id_cliente, data_fattura, numero_fornitore) VALUES ('C', 200.00, 40.00, 13, '2023-03-10', 8);
INSERT INTO Fatture (tipologia, importo, iva, id_cliente, data_fattura, numero_fornitore) VALUES ('A', 50.80, 11.30, 14, '2023-04-20', 9);
INSERT INTO Fatture (tipologia, importo, iva, id_cliente, data_fattura, numero_fornitore) VALUES ('B', 120.75, 25.25, 15, '2023-05-07', 10);

UPDATE Clienti SET data_nascita = '1982-05-10' WHERE numero_cliente = 11;
ALTER TABLE Fatture ALTER COLUMN iva TYPE INTEGER;
SELECT * FROM Clienti WHERE EXTRACT(YEAR FROM data_nascita) = 1982;

SELECT * FROM Fatture;

SELECT iva, COUNT(*) AS numero_fatture_iva_20 FROM Fatture GROUP BY iva HAVING iva = 20;

SELECT * FROM Prodotti WHERE EXTRACT(YEAR FROM data_attivazione) = 2022 AND (in_commercio = true OR in_produzione = true);

SELECT Fatture.numero_fattura, Fatture.tipologia, Fatture.importo, Fatture.iva, Clienti.Nome, Clienti.Cognome, Fatture.data_fattura, Fornitori.Denominazione FROM Fatture INNER JOIN Fornitori ON Fatture.numero_fornitore = Fornitori.numero_fornitore INNER JOIN Clienti ON Fatture.id_cliente = Clienti.numero_cliente;

SELECT Clienti.regione, SUM(Fatture.importo) AS totale_importi FROM Clienti JOIN Fatture ON Clienti.numero_cliente = Fatture.id_cliente GROUP BY Clienti.regione;

