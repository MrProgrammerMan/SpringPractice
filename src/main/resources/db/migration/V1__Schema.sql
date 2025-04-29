CREATE TABLE Organizor (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  org_num INT NOT NULL
);

CREATE TABLE Venue (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  adress TEXT NOT NULL,
  capacity INT NOT NULL
);

CREATE TABLE Artist (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100),
  genre VARCHAR(100)
);

CREATE TABLE Concert (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  organizor_id INT NOT NULL REFERENCES Organizor(id),
  venue_id INT NOT NULL REFERENCES Venue(id),
  artist_id INT NOT NULL REFERENCES Artist(id)
);