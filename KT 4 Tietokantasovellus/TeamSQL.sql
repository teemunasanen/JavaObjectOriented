USE `sql7373042`;

DROP TABLE IF EXISTS TEAM; 

-- Table structure for table TEAM
CREATE TABLE TEAM (
  FName varchar(16) NOT NULL,
  LName varchar(32) NOT NULL,
  Classification varchar(32) NOT NULL,
  PRIMARY KEY (FName, LName)
);


-- Inserting new records for table
INSERT INTO TEAM VALUES
('Teemu', 'Nasanen', 'Unique'),
('Roberto', 'Carlos', 'Powerfull'),
('Zidedine', 'Zidane', 'Magnificent'),
('Christiano', 'Ronaldo', 'Pretty'),
('Jari' , 'Litmanen', 'Mr. Football');

