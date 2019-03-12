DROP  SCHEMA IF EXISTS ExpoSystem CASCADE;
CREATE SCHEMA ExpoSystem;
SET search_path TO ExpoSystem;

CREATE TABLE faculty(
	facultyId VARCHAR(5),
	facultyName VARCHAR(20),
	CONSTRAINT facultyPK PRIMARY KEY (facultyId)
);

CREATE TABLE stand(
    standId VARCHAR(20),
	standName VARCHAR(20),
	facultyId VARCHAR(5),
    CONSTRAINT standPK PRIMARY KEY (standId),
    CONSTRAINT facultyFK FOREIGN KEY (facultyId) REFERENCES faculty(facultyId)
);
CREATE TABLE vote(
    voteId SERIAL,
	voteValue int,
	standId varchar(20),
    CONSTRAINT votePK PRIMARY KEY (voteId),
    CONSTRAINT standFK FOREIGN KEY (standId) REFERENCES stand(standId)
);

CREATE TABLE admin(
	adminId SERIAL,
	username VARCHAR(20),
	hashedPassword VARCHAR(88)
);




CREATE TABLE expo(
	expoId SERIAL,
	expoYear INT,
	CONSTRAINT expoPK PRIMARY KEY (expoId)
);

CREATE TABLE visitor(
	visitorId VARCHAR(10),
	CONSTRAINT visitorPK PRIMARY KEY (visitorId)
);