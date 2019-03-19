DROP  SCHEMA IF EXISTS ExpoSystem;
CREATE SCHEMA ExpoSystem;
SET search_path TO ExpoSystem;

CREATE TABLE institute(
	instituteId VARCHAR(5),
	instituteName VARCHAR(50),
	CONSTRAINT institutePK PRIMARY KEY (instituteId)
);


CREATE TABLE study(
	studyId VARCHAR(5),
	studyName VARCHAR(50),
	instituteId VARCHAR(5),
	CONSTRAINT studyPK PRIMARY KEY (studyId),
	CONSTRAINT instituteFK FOREIGN KEY (instituteId) REFERENCES institute(instituteId)
);


CREATE TABLE stand(
    standId VARCHAR(20),
    standYear VARCHAR(4),
	standName VARCHAR(200),
	authors VARCHAR(200),
	studyId VARCHAR(5),
	
    CONSTRAINT standPK PRIMARY KEY (standId),
    CONSTRAINT studyFK FOREIGN KEY (studyId) REFERENCES study(studyId)
);

CREATE TABLE visitor(
	visitorId varchar(12),
	visitorToken varchar(5),
	CONSTRAINT visitorPK PRIMARY KEY (visitorId)
);

CREATE TABLE vote(
    voteId SERIAL,
	voteValue int,
	standId varchar(20),
	visitorId varchar,
    CONSTRAINT votePK PRIMARY KEY (voteId),
    CONSTRAINT standFK FOREIGN KEY (standId) REFERENCES stand(standId),
    CONSTRAINT visitorFK FOREIGN KEY (visitorId) REFERENCES visitor(visitorId)
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