USE doc_management;

CREATE TABLE users (
  username varchar(15),
  password varchar(100),
  enabled tinyint(1),
  PRIMARY KEY (username)
) ;

CREATE TABLE authorities (
  username varchar(15),
  authority varchar(25),
  FOREIGN KEY (username) references users(username)
) ;

INSERT INTO doc_management.users (username, password, enabled)
VALUES
	('yury', '{noop}yury', 1),
	('user', '{noop}user', 1),
	('admin', '{noop}admin', 1);
    
INSERT INTO doc_management.authorities (username, authority)
VALUES
	('yury', 'ROLE_MANAGER'),
	('user', 'ROLE_VIEWER'),
    ('admin', 'ROLE_ADMIN');
    
    