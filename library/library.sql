CREATE TABLE `Library` (
  `libId` int(11) NOT NULL AUTO_INCREMENT,
  `city` varchar(255) DEFAULT NULL,
  `libraryName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`libId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `User` (
  `iduser` int(11) AUTO_INCREMENT NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `Member` (
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `iduser` int(11) NOT NULL,
  PRIMARY KEY (`iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `Works` (
  `worksId` int(11) NOT NULL AUTO_INCREMENT,
  `author` varchar(255) DEFAULT NULL,
  `bookDescription` varchar(255) DEFAULT NULL,
  `publicationYear` int(11) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `idlibrary` int(11) DEFAULT NULL,
  `copiesAvailable` int(11) DEFAULT NULL ,
  `imageUrl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`worksId`),
  KEY `fk_work1` (`idlibrary`),
  CONSTRAINT `fk_work1` FOREIGN KEY (`idlibrary`) REFERENCES `library` (`libid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `Book` (
  `bookId` varchar(255) NOT NULL,
  `isAvailable` tinyint(1) NOT NULL,
  `borrowing_idborrow` int(11) DEFAULT NULL,
  `works_worksId` int(11) DEFAULT NULL,
  PRIMARY KEY (`bookId`),
  KEY `fk_borrow1` (`borrowing_idborrow`),
  KEY `fk_work2` (`works_worksId`),
  CONSTRAINT `fk_work2` FOREIGN KEY (`works_worksId`) REFERENCES `works` (`worksid`),
  CONSTRAINT `fk_borrow1` FOREIGN KEY (`borrowing_idborrow`) REFERENCES `borrowing` (`idborrow`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `Borrowing` (
  `idborrow` int(11) NOT NULL AUTO_INCREMENT,
  `isExtended` tinyint(1) NOT NULL,
  `issueDate` datetime(6) DEFAULT NULL,
  `returnDate` datetime(6) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `book_bookId` varchar(255) DEFAULT NULL,
  `member_iduser` int(11) DEFAULT NULL,
  PRIMARY KEY (`idborrow`),
  KEY `fk_book1` (`book_bookId`),
  KEY `fk_memb1` (`member_iduser`),
  CONSTRAINT `fk_book1` FOREIGN KEY (`book_bookId`) REFERENCES `book` (`bookid`),
  CONSTRAINT `fk_memb1` FOREIGN KEY (`member_iduser`) REFERENCES `member` (`iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO `citylibrary`.`Library` (`city`,) VALUES ('Saint Herblain');
UPDATE `citylibrary`.`Library` SET `libraryName` = 'City' WHERE (`libId` = '1');


INSERT INTO `citylibrary`.`Works` (`author`, `bookDescription`, `publicationYear`, `title`, `idlibrary`) VALUES ('Rowling', 'Fantasy', '1997', 'Harry Potter and the Philosopher\'s Stone', '1');
INSERT INTO `citylibrary`.`Works` (`author`, `bookDescription`, `publicationYear`, `title`, `idlibrary`) VALUES ('Rowling', 'Fantasy', '1998', 'Harry Potter and the Chamber of Secret', '1');
INSERT INTO `citylibrary`.`Works` (`author`, `bookDescription`, `publicationYear`, `title`, `idlibrary`) VALUES ('Rowling', 'Fantasy', '1999', 'Harry Potter and the Prisoner of Azkaban', '1');
INSERT INTO `citylibrary`.`Works` (`author`, `bookDescription`, `publicationYear`, `title`, `idlibrary`) VALUES ('Rowling', 'Fantasy', '2000', 'Harry Potter and the Goblet of Fire', '1');
INSERT INTO `citylibrary`.`Works` (`author`, `bookDescription`, `publicationYear`, `title`, `idlibrary`) VALUES ('Rowling', 'Fantasy', '2003', 'Harry Potter and The Order of the Phoenix', '1');
INSERT INTO `citylibrary`.`Works` (`author`, `bookDescription`, `publicationYear`, `title`, `idlibrary`) VALUES ('Rowling', 'Fantasy', '2005', 'Harry Potter and the Half-Blood Prince', '1');
INSERT INTO `citylibrary`.`Works` (`author`, `bookDescription`, `publicationYear`, `title`, `idlibrary`) VALUES ('Rowling', 'Fantasy', '2007', 'Harry Potter and the Deathly Hallows','1');


INSERT INTO `citylibrary`.`Works` (`author`, `bookDescription`, `publicationYear`, `title`, `idlibrary`) VALUES ('Lewis', 'Fantasy', '1950', 'The Lion, the Witch and the Wardrobe', '1');
INSERT INTO `citylibrary`.`Works` (`author`, `bookDescription`, `publicationYear`, `title`, `idlibrary`) VALUES ('Lewis', 'Fantasy', '1951', 'Prince Caspian', '1');
INSERT INTO `citylibrary`.`Works` (`author`, `bookDescription`, `publicationYear`, `title`, `idlibrary`) VALUES ('Lewis', 'Fantasy', '1952', 'The Voyage of the Dawn Treader', '1');
INSERT INTO `citylibrary`.`Works` (`author`, `bookDescription`, `publicationYear`, `title`, `idlibrary`) VALUES ('Lewis', 'Fantasy', '1953', 'The Silver Chair', '1');
INSERT INTO `citylibrary`.`Works` (`author`, `bookDescription`, `publicationYear`, `title`, `idlibrary`) VALUES ('Lewis', 'Fantasy', '1954', 'The Horse and his Boy', '1');
INSERT INTO `citylibrary`.`Works` (`author`, `bookDescription`, `publicationYear`, `title`, `idlibrary`) VALUES ('Lewis', 'Fantasy', '1955', 'The Magician\'s Nephew', '1');
INSERT INTO `citylibrary`.`Works` (`author`, `bookDescription`, `publicationYear`, `title`, `idlibrary`) VALUES ('Lewis', 'Fantasy', '1956', 'The Last Battle', '1');


INSERT INTO `citylibrary`.`Works` (`author`, `bookDescription`, `publicationYear`, `title`, `idlibrary`) VALUES ('Snicket', 'Fantasy', '1999', 'The Bad Beginning', '1');
INSERT INTO `citylibrary`.`Works` (`author`, `bookDescription`, `publicationYear`, `title`, `idlibrary`) VALUES ('Snicket', 'Fantasy', '1999', 'The Reptile Room', '1');

UPDATE `citylibrary`.`Works` SET `copiesAvailable` = '4' WHERE (`worksId` = '1');
UPDATE `citylibrary`.`Works` SET `copiesAvailable` = '2' WHERE (`worksId` = '2');
UPDATE `citylibrary`.`Works` SET `copiesAvailable` = '1' WHERE (`worksId` = '16');
UPDATE `citylibrary`.`Works` SET `copiesAvailable` = '2' WHERE (`worksId` = '15');
UPDATE `citylibrary`.`Works` SET `copiesAvailable` = '2' WHERE (`worksId` = '14');
UPDATE `citylibrary`.`Works` SET `copiesAvailable` = '3' WHERE (`worksId` = '13');
UPDATE `citylibrary`.`Works` SET `copiesAvailable` = '4' WHERE (`worksId` = '12');
UPDATE `citylibrary`.`Works` SET `copiesAvailable` = '1' WHERE (`worksId` = '11');
UPDATE `citylibrary`.`Works` SET `copiesAvailable` = '3' WHERE (`worksId` = '10');
UPDATE `citylibrary`.`Works` SET `copiesAvailable` = '2' WHERE (`worksId` = '9');
UPDATE `citylibrary`.`Works` SET `copiesAvailable` = '2' WHERE (`worksId` = '8');
UPDATE `citylibrary`.`Works` SET `copiesAvailable` = '2' WHERE (`worksId` = '7');
UPDATE `citylibrary`.`Works` SET `copiesAvailable` = '3' WHERE (`worksId` = '3');
UPDATE `citylibrary`.`Works` SET `copiesAvailable` = '3' WHERE (`worksId` = '4');
UPDATE `citylibrary`.`Works` SET `copiesAvailable` = '3' WHERE (`worksId` = '5');
UPDATE `citylibrary`.`Works` SET `copiesAvailable` = '1' WHERE (`worksId` = '6');


INSERT INTO `citylibrary`.`User` ( `password`, `username`) VALUES ('1234lulu', 'georgelulu');
INSERT INTO `citylibrary`.`User` ( `password`, `username`) VALUES ('1234charlotte', 'charlottecam');
INSERT INTO `citylibrary`.`User` ( `password`, `username`) VALUES ('1234charles', 'charleswales');
INSERT INTO `citylibrary`.`User` ( `password`, `username`) VALUES ('1234louis', 'louiscam');
INSERT INTO `citylibrary`.`User` ( `password`, `username`) VALUES ('1234cat', 'cathcam');
INSERT INTO `citylibrary`.`User` ( `password`, `username`) VALUES ('1234will', 'willcam');


INSERT INTO `citylibrary`.`Member` (`address`, `email`, `firstName`, `lastName`, `iduser`) VALUES ('151 rue carnot Saint Herblain', 'georgelulu@yahoo.com', 'George', 'Lukas', '1');
INSERT INTO `citylibrary`.`Member` (`address`, `email`, `firstName`, `lastName`, `iduser`) VALUES ('152 rue mayenne Saint Herblain', 'charlottecam@yahoo.co.uk', 'Charlotte', 'Cambridge', '2');
INSERT INTO `citylibrary`.`Member` (`address`, `email`, `firstName`, `lastName`, `iduser`) VALUES ('2 rue cotherie Saint Herblain', 'charleswales@yahoo.fr', 'Charles', 'Wales', '3');
INSERT INTO `citylibrary`.`Member` (`address`, `email`, `firstName`, `lastName`, `iduser`) VALUES ('70 rue palaise Saint Herblain', 'louiscam@yahoo.fr', 'Louis', 'Cambridge', '4');
INSERT INTO `citylibrary`.`Member` (`address`, `email`, `firstName`, `lastName`, `iduser`) VALUES ('15 rue cremerie Saint Herblain', 'cathcam@gmail.com', 'Catherine', 'Cambridge', '5');
INSERT INTO `citylibrary`.`Member` (`address`, `email`, `firstName`, `lastName`, `iduser`) VALUES ('1 rue nazaire Saint Herblain', 'willcam@gmail.com', 'William', 'Cambridge', '6');




INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `works_worksId`) VALUES ('hp1a', '1', '1');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `works_worksId`) VALUES ('hp1', '1', '1');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `works_worksId`) VALUES ('hp1c', '1', '1');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `works_worksId`) VALUES ('hp1d', '1', '1');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `works_worksId`) VALUES ('hp2a', '1', '2');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `works_worksId`) VALUES ('hp2', '1', '2');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `works_worksId`) VALUES ('hp3a', '1', '3');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `works_worksId`) VALUES ('hp3', '1', '3');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `works_worksId`) VALUES ('hp3c', '1', '3');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `works_worksId`) VALUES ('hp4a', '1', '4');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `works_worksId`) VALUES ('hp4', '1', '4');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `works_worksId`) VALUES ('hp4c', '1', '4');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `works_worksId`) VALUES ('hp5a', '1', '5');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `works_worksId`) VALUES ('hp5', '1', '5');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `works_worksId`) VALUES ('hp5c', '1', '5');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `works_worksId`) VALUES ('hp6a', '1', '6');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `works_worksId`) VALUES ('hp7a', '1', '7');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `works_worksId`) VALUES ('hp7', '1', '7');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `works_worksId`) VALUES ('nar1a', '1', '8');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `works_worksId`) VALUES ('nar1', '1', '8');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `works_worksId`) VALUES ('nar2a', '1', '9');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `works_worksId`) VALUES ('nar2', '1', '9');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `works_worksId`) VALUES ('nar3a', '1', '10');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `works_worksId`) VALUES ('nar3', '1', '10');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `works_worksId`) VALUES ('nar3c', '1', '10');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `works_worksId`) VALUES ('nar4a', '1', '11');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `works_worksId`) VALUES ('nar5a', '1', '12');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `works_worksId`) VALUES ('nar5', '1', '12');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `works_worksId`) VALUES ('nar5c', '1', '12');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `works_worksId`) VALUES ('nar5d', '1', '12');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `works_worksId`) VALUES ('nar6a', '1', '13');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `works_worksId`) VALUES ('nar6', '1', '13');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `works_worksId`) VALUES ('nar6c', '1', '13');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `works_worksId`) VALUES ('nar7a', '1', '14');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `works_worksId`) VALUES ('nar7', '1', '14');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `works_worksId`) VALUES ('un1', '1', '15');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `works_worksId`) VALUES ('un1a', '1', '15');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `works_worksId`) VALUES ('un2', '1', '16');


UPDATE `citylibrary`.`Works` SET `imageUrl` = 'http://localhost:80/resources/assets/1.jpeg' WHERE (`worksId` = '1');
UPDATE `citylibrary`.`Works` SET `imageUrl` = 'http://localhost:80/resources/assets/2.jpeg' WHERE (`worksId` = '2');
UPDATE `citylibrary`.`Works` SET `imageUrl` = 'http://localhost:80/resources/assets/3.jpeg' WHERE (`worksId` = '3');
UPDATE `citylibrary`.`Works` SET `imageUrl` = 'http://localhost:80/resources/assets/4.jpeg' WHERE (`worksId` = '4');
UPDATE `citylibrary`.`Works` SET `imageUrl` = 'http://localhost:80/resources/assets/5.jpeg' WHERE (`worksId` = '5');
UPDATE `citylibrary`.`Works` SET `imageUrl` = 'http://localhost:80/resources/assets/6.jpeg' WHERE (`worksId` = '6');
UPDATE `citylibrary`.`Works` SET `imageUrl` = 'http://localhost:80/resources/assets/7.jpeg' WHERE (`worksId` = '7');
UPDATE `citylibrary`.`Works` SET `imageUrl` = 'http://localhost:80/resources/assets/8.jpeg' WHERE (`worksId` = '8');
UPDATE `citylibrary`.`Works` SET `imageUrl` = 'http://localhost:80/resources/assets/16.jpeg' WHERE (`worksId` = '16');
UPDATE `citylibrary`.`Works` SET `imageUrl` = 'http://localhost:80/resources/assets/15.jpeg' WHERE (`worksId` = '15');
UPDATE `citylibrary`.`Works` SET `imageUrl` = 'http:/localhost:80/resources/assets/14.jpeg' WHERE (`worksId` = '14');
UPDATE `citylibrary`.`Works` SET `imageUrl` = 'http://localhost:80/resources/assets/13.jpeg' WHERE (`worksId` = '13');
UPDATE `citylibrary`.`Works` SET `imageUrl` = 'http://localhost:80/resources/assets/12.jpeg' WHERE (`worksId` = '12');
UPDATE `citylibrary`.`Works` SET `imageUrl` = 'http://localhost:80/resources/assets/11.jpeg' WHERE (`worksId` = '11');
UPDATE `citylibrary`.`Works` SET `imageUrl` = 'http://localhost:80/resources/assets/10.jpeg' WHERE (`worksId` = '10');
UPDATE `citylibrary`.`Works` SET `imageUrl` = 'http://localhost:80/resources/assets/9.jpeg' WHERE (`worksId` = '9');
