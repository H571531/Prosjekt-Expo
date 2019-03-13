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
CREATE TABLE course(
	courseId VARCHAR(5),
	courseName VARCHAR(20),
	CONSTRAINT coursePK PRIMARY KEY (courseId)
);


CREATE TABLE stand(
    standId VARCHAR(20),
	standName VARCHAR(20),
	instituteId VARCHAR(5),
	courseId VARCHAR(5),
	
    CONSTRAINT standPK PRIMARY KEY (standId),
    CONSTRAINT instituteFK FOREIGN KEY (instituteId) REFERENCES institute(instituteId),
    CONSTRAINT courseFK FOREIGN KEY (courseId) REFERENCES course(courseId)
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