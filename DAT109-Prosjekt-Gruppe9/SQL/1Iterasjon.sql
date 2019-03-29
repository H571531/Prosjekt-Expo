--DROP  SCHEMA IF EXISTS ExpoSystem CASCADE;
--CREATE SCHEMA ExpoSystem;
SET search_path TO ExpoSystem;

CREATE TABLE expo(
	expoId varchar(4),
	voteregistrationopen boolean,
	statisticsopentopublic boolean,
	CONSTRAINT expoPK PRIMARY KEY (expoId)
);

CREATE TABLE institute(
	instituteId VARCHAR(5),
	instituteName VARCHAR(50),
	CONSTRAINT institutePK PRIMARY KEY (instituteId)
);

--
CREATE TABLE study(
	studyId VARCHAR(5),
	studyName VARCHAR(50),
	instituteId VARCHAR(5),
	CONSTRAINT studyPK PRIMARY KEY (studyId),
	CONSTRAINT instituteFK FOREIGN KEY (instituteId) REFERENCES institute(instituteId)
);

CREATE TABLE stand(
    standId VARCHAR(20),
    expoId VARCHAR(4),
	standName VARCHAR(200),
	authors VARCHAR(200),
	studyId VARCHAR(5),
	token varchar(14),
	
    CONSTRAINT standPK PRIMARY KEY (standId),
    CONSTRAINT studyFK FOREIGN KEY (studyId) REFERENCES study(studyId),
    CONSTRAINT expoFK FOREIGN KEY (expoId) REFERENCES expo(expoId)
);


CREATE TABLE visitor(
	visitorId varchar(12),
	visitorToken varchar(14),
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
	username VARCHAR(20),
	hashedPassword VARCHAR(88),
	CONSTRAIN adminPK PRIMARY KEY (username)
);


