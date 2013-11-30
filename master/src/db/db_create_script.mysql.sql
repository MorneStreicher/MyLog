/*  TODO: Create a user and: GRANT ALL PRIVILEGES ON *.* TO 'user'@'%' WITH GRANT OPTION; */

USE test;
DROP DATABASE MyLog;

CREATE DATABASE MyLog;
USE MyLog;

CREATE TABLE AppUser
(
	UserId			VARCHAR (20)	NOT NULL PRIMARY KEY, /* The User Id has the format: yyyymmddhhmmssnnnnnn */
	LoginName		VARCHAR (50)	NOT NULL,
	PasswordHash	VARCHAR (64)	NOT NULL,			/* SHA-256 of clear password */
	Email			VARCHAR (100)	NOT NULL
);

INSERT INTO AppUser 
VALUES 
	('20131118140000000001', 'morne', 
	 'DF11C3C623C584217D8EA64E8C6FB8A73D7687D7CDBCEB38CDA6E62AECF67A76', 
	 'MorneStreicher@Hotmail.com');

SELECT * FROM AppUser;

CREATE TABLE LogEntry
(
	Id				VARCHAR (100)	NOT NULL PRIMARY KEY,
	UserId			VARCHAR (20)	NOT NULL,
	DateAdded		TIMESTAMP		NOT NULL DEFAULT CURRENT_TIMESTAMP,
	LogDataVersion	INT				NOT NULL,
    LogEntryType    VARCHAR (20)	NOT NULL,
	LogDataText		TEXT			NOT NULL
);

ALTER TABLE LogEntry ADD CONSTRAINT FK_LogEntry FOREIGN KEY (UserId) REFERENCES AppUser (UserId);

INSERT INTO LogEntry (Id, UserId, LogDataVersion, LogEntryType, LogDataText) VALUES ("0001", "20131118140000000001", 1, "Budget", "X");

SELECT * FROM LogEntry;
