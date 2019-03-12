DROP SCHEMA IF EXISTS ExpoSystem;
CREATE SCHEMA ExpoSystem;
SET search_path TO ExpoSystem;

CREATE TABLE vote(
    voteId SERIAL,
	voteValue int,
	standId varchar(20),
    CONSTRAINT votePK PRIMARY KEY (voteId),
    CONSTRAINT standFK FOREIGN KEY (standId)
);

CREATE TABLE stand(
    standId VARCHAR(20),
	standName VARCHAR(20),
	fakultetId VARCHAR(5),
    CONSTRAINT standPK PRIMARY KEY (standId),
    CONSTRAINT fakultetFK FOREIGN KEY (fakultetId)
);

CREATE TABLE admin(
	adminId SERIAL,
	username VARCHAR(20),
	hashedPassword(88)
);
