DROP  SCHEMA IF EXISTS ExpoSystem CASCADE;
CREATE SCHEMA ExpoSystem;
SET search_path TO ExpoSystem;

CREATE TABLE institute(
	instituteId VARCHAR(5),
	instituteName VARCHAR(20),
	CONSTRAINT institutePK PRIMARY KEY (instituteId)
);

--CREATE TABLE faculty(
--	facultyId VARCHAR(5),
--	facultyName VARCHAR(20),
--	CONSTRAINT facultyPK PRIMARY KEY (facultyId)
--);

CREATE TABLE study(
	studyId VARCHAR(5),
	studyName VARCHAR(20),
	instituteId CARCHAR(5),
	CONSTRAINT studyPK PRIMARY KEY (studyId),
	CONSTRAINT instituteFK FOREIGN KEY (instituteId) REFERENCES institute(instituteId) 
);


CREATE TABLE stand(
    standId VARCHAR(20),
	standName VARCHAR(20),
	authors VARCHAR(100),
	studyId VARCHAR(5),
	
    CONSTRAINT standPK PRIMARY KEY (standId),
    CONSTRAINT studyFK FOREIGN KEY (studyId) REFERENCES study(studyId)
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