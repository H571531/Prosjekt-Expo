DROP SCHEMA IF EXISTS ExpoSystem;
CREATE SCHEMA ExpoSystem;
SET search_path TO ExpoSystem;

CREATE TABLE vote(
    voteId SERIAL,
	voteValue int,
	standId int,
    CONSTRAINT votePK PRIMARY KEY (voteId)
);

CREATE TABLE stand(
    standId int,
	standName VARCHAR(20),
    CONSTRAINT standPK PRIMARY KEY (standId)
);