
CREATE TABLE IF NOT EXISTS  books (
  id  SERIAL PRIMARY KEY,
  name VARCHAR(45) NULL,
  publishYear INT NULL,
  description VARCHAR(100) NULL,
  price FLOAT NULL,
  author VARCHAR(45) NULL
  );


CREATE TABLE IF NOT EXISTS users (
  id  SERIAL PRIMARY KEY,
  name VARCHAR(100) NULL,
  birthDate DATE NULL,
  login VARCHAR(100) NOT NULL,
  password VARCHAR(100) NULL,
  role VARCHAR(45) NULL DEFAULT 'USER'
);


CREATE TABLE IF NOT EXISTS userCart (
  Id SERIAL PRIMARY KEY ,
  userId INT NOT NULL REFERENCES users(id),
  bookId INT NOT NULL REFERENCES books(id)
);
select * from users;

