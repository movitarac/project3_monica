INSERT INTO `citylibrary`.`Library` (`libId`,`city`,`libraryName`) VALUES (1,'Saint Herblain','City');


INSERT INTO `citylibrary`.`Work` (`worksId`,`author`, `bookDescription`, `publicationYear`, `title`, `idlibrary`, `copiesAvailable`, `imageUrl`) VALUES (1,'Rowling', 'Fantasy', 1997, 'Harry Potter and the Philosopher\'s Stone', 1,4,'http://localhost:80/resources/assets/1.jpeg');
INSERT INTO `citylibrary`.`Work` (`worksId`,`author`, `bookDescription`, `publicationYear`, `title`, `idlibrary`, `copiesAvailable`, `imageUrl`) VALUES (2,'Rowling', 'Fantasy', 1998, 'Harry Potter and the Chamber of Secret', 1,2,'http://localhost:80/resources/assets/2.jpeg');
INSERT INTO `citylibrary`.`Work` (`worksId`,`author`, `bookDescription`, `publicationYear`, `title`, `idlibrary`, `copiesAvailable`, `imageUrl`) VALUES (3,'Rowling', 'Fantasy', 1999, 'Harry Potter and the Prisoner of Azkaban', 1,3,'http://localhost:80/resources/assets/3.jpeg');
INSERT INTO `citylibrary`.`Work` (`worksId`,`author`, `bookDescription`, `publicationYear`, `title`, `idlibrary`, `copiesAvailable`, `imageUrl`) VALUES (4,'Rowling', 'Fantasy', 2000, 'Harry Potter and the Goblet of Fire', 1,3,'http://localhost:80/resources/assets/4.jpeg');
INSERT INTO `citylibrary`.`Work` (`worksId`,`author`, `bookDescription`, `publicationYear`, `title`, `idlibrary`, `copiesAvailable`, `imageUrl`) VALUES (5,'Rowling', 'Fantasy', 2003, 'Harry Potter and The Order of the Phoenix', 1,3,'http://localhost:80/resources/assets/5.jpeg');
INSERT INTO `citylibrary`.`Work` (`worksId`,`author`, `bookDescription`, `publicationYear`, `title`, `idlibrary`, `copiesAvailable`, `imageUrl`) VALUES (6,'Rowling', 'Fantasy', 2005, 'Harry Potter and the Half-Blood Prince', 1,1,'http://localhost:80/resources/assets/6.jpeg');
INSERT INTO `citylibrary`.`Work` (`worksId`,`author`, `bookDescription`, `publicationYear`, `title`, `idlibrary`, `copiesAvailable`, `imageUrl`) VALUES (7,'Rowling', 'Fantasy', 2007, 'Harry Potter and the Deathly Hallows',1,2,'http://localhost:80/resources/assets/7.jpeg');


INSERT INTO `citylibrary`.`Work` (`worksId`,`author`, `bookDescription`, `publicationYear`, `title`, `idlibrary`, `copiesAvailable`, `imageUrl`) VALUES (8,'C.S Lewis', 'Fantasy', 1950, 'The Lion, the Witch and the Wardrobe', 1,2,'http://localhost:80/resources/assets/8.jpeg');
INSERT INTO `citylibrary`.`Work` (`worksId`,`author`, `bookDescription`, `publicationYear`, `title`, `idlibrary`, `copiesAvailable`, `imageUrl`) VALUES (9,'C.S Lewis', 'Fantasy', 1951, 'Prince Caspian', 1,2,'http://localhost:80/resources/assets/9.jpeg');
INSERT INTO `citylibrary`.`Work` (`worksId`,`author`, `bookDescription`, `publicationYear`, `title`, `idlibrary`, `copiesAvailable`, `imageUrl`) VALUES (10,'C.S Lewis', 'Fantasy', 1952, 'The Voyage of the Dawn Treader', 1,3,'http://localhost:80/resources/assets/10.jpeg');
INSERT INTO `citylibrary`.`Work` (`worksId`,`author`, `bookDescription`, `publicationYear`, `title`, `idlibrary`, `copiesAvailable`, `imageUrl`) VALUES (11,'C.S Lewis', 'Fantasy', 1953, 'The Silver Chair', 1,1,'http://localhost:80/resources/assets/11.jpeg');
INSERT INTO `citylibrary`.`Work` (`worksId`,`author`, `bookDescription`, `publicationYear`, `title`, `idlibrary`, `copiesAvailable`, `imageUrl`) VALUES (12,'C.S Lewis', 'Fantasy', 1954, 'The Horse and his Boy', 1,4,'http://localhost:80/resources/assets/12.jpeg');
INSERT INTO `citylibrary`.`Work` (`worksId`,`author`, `bookDescription`, `publicationYear`, `title`, `idlibrary`, `copiesAvailable`, `imageUrl`) VALUES (13,'C.S Lewis', 'Fantasy', 1955, 'The Magician\'s Nephew', 1,3,'http://localhost:80/resources/assets/13.jpeg');
INSERT INTO `citylibrary`.`Work` (`worksId`,`author`, `bookDescription`, `publicationYear`, `title`, `idlibrary`, `copiesAvailable`, `imageUrl`) VALUES (14,'C.S Lewis', 'Fantasy', 1956, 'The Last Battle', 1,2,'http://localhost:80/resources/assets/14.jpeg');
INSERT INTO `citylibrary`.`Work` (`worksId`,`author`, `bookDescription`, `publicationYear`, `title`, `idlibrary`, `copiesAvailable`, `imageUrl`) VALUES (15,'Lemony Snicket', 'Fantasy', 1999, 'The Bad Beginning', 1,2,'http://localhost:80/resources/assets/15.jpeg');
INSERT INTO `citylibrary`.`Work` (`worksId`,`author`, `bookDescription`, `publicationYear`, `title`, `idlibrary`, `copiesAvailable`, `imageUrl`) VALUES (16,'Lemony Snicket', 'Fantasy', 1999, 'The Reptile Room', 1,1,'http://localhost:80/resources/assets/16.jpeg');
INSERT INTO `citylibrary`.`Work` (`worksId`,`author`, `bookDescription`, `publicationYear`, `title`, `idlibrary`, `copiesAvailable`, `imageUrl`) VALUES (17,'Lemony Snicket', 'Fantasy', 2000, 'The Wide Window', 1, 5, 'http://localhost:80/resources/assets/17.jpeg');
INSERT INTO `citylibrary`.`Work` (`worksId`,`author`, `bookDescription`, `publicationYear`, `title`, `idlibrary`, `copiesAvailable`, `imageUrl`) VALUES (18,'Lemony Snicket', 'Fantasy', 2000, 'The Miserable Mill', 1, 2, 'http://localhost:80/resources/assets/18.jpeg');
INSERT INTO `citylibrary`.`Work` (`worksId`,`author`, `bookDescription`, `publicationYear`, `title`, `idlibrary`, `copiesAvailable`, `imageUrl`) VALUES (19,'Sir Arthur Conan Doyle', 'Detective', 1887, 'A Study in Scarlet',1, 3, 'http://localhost:80/resources/assets/19.jpeg');
INSERT INTO `citylibrary`.`Work` (`worksId`,`author`, `bookDescription`, `publicationYear`, `title`, `idlibrary`, `copiesAvailable`, `imageUrl`) VALUES (20,'Sir Arthur Conan Doyle', 'Detective', 1890, 'The Sign of Four', 1, 3, 'http://localhost:80/resources/assets/20.jpeg');



UPDATE `citylibrary`.`Work` SET `copiesAvailable` = 4 WHERE (`worksId` = 1);
UPDATE `citylibrary`.`Work` SET `copiesAvailable` = 2 WHERE (`worksId` = 2);
UPDATE `citylibrary`.`Work` SET `copiesAvailable` = 1 WHERE (`worksId` = 16);
UPDATE `citylibrary`.`Work` SET `copiesAvailable` = 2 WHERE (`worksId` = 15);
UPDATE `citylibrary`.`Work` SET `copiesAvailable` = 2 WHERE (`worksId` = 14);
UPDATE `citylibrary`.`Work` SET `copiesAvailable` = 3 WHERE (`worksId` = 13);
UPDATE `citylibrary`.`Work` SET `copiesAvailable` = 4 WHERE (`worksId` = 12);
UPDATE `citylibrary`.`Work` SET `copiesAvailable` = 1 WHERE (`worksId` = 11);
UPDATE `citylibrary`.`Work` SET `copiesAvailable` = 3 WHERE (`worksId` = 10);
UPDATE `citylibrary`.`Work` SET `copiesAvailable` = 2 WHERE (`worksId` = 9);
UPDATE `citylibrary`.`Work` SET `copiesAvailable` = 2 WHERE (`worksId` = 8);
UPDATE `citylibrary`.`Work` SET `copiesAvailable` = 2 WHERE (`worksId` = 7);
UPDATE `citylibrary`.`Work` SET `copiesAvailable` = 3 WHERE (`worksId` = 3);
UPDATE `citylibrary`.`Work` SET `copiesAvailable` = 3 WHERE (`worksId` = 4);
UPDATE `citylibrary`.`Work` SET `copiesAvailable` = 3 WHERE (`worksId` = 5);
UPDATE `citylibrary`.`Work` SET `copiesAvailable` = 1 WHERE (`worksId` = 6);


INSERT INTO `citylibrary`.`User` ( `iduser`,`password`, `username`) VALUES (1,'1234lulu', 'georgelulu');
INSERT INTO `citylibrary`.`User` ( `iduser`,`password`, `username`) VALUES (2,'1234charlotte', 'charlottecam');
INSERT INTO `citylibrary`.`User` ( `iduser`,`password`, `username`) VALUES (3,'1234charles', 'charleswales');
INSERT INTO `citylibrary`.`User` ( `iduser`,`password`, `username`) VALUES (4,'1234louis', 'louiscam');
INSERT INTO `citylibrary`.`User` ( `iduser`,`password`, `username`) VALUES (5,'1234cat', 'cathcam');
INSERT INTO `citylibrary`.`User` ( `iduser`,`password`, `username`) VALUES (6,'1234will', 'willcam');


INSERT INTO `citylibrary`.`Member` (`address`, `email`, `firstName`, `lastName`, `iduser`) VALUES ('151 rue carnot Saint Herblain', 'georgelulu.georgelulu@gmail.com', 'George', 'Lukas', 1);
INSERT INTO `citylibrary`.`Member` (`address`, `email`, `firstName`, `lastName`, `iduser`) VALUES ('152 rue mayenne Saint Herblain', 'charlottecamcam@gmail.com', 'Charlotte', 'Cambridge', 2);
INSERT INTO `citylibrary`.`Member` (`address`, `email`, `firstName`, `lastName`, `iduser`) VALUES ('2 rue cotherie Saint Herblain', 'charleswaleswales@gmail.com', 'Charles', 'Wales', 3);
INSERT INTO `citylibrary`.`Member` (`address`, `email`, `firstName`, `lastName`, `iduser`) VALUES ('70 rue palaise Saint Herblain', 'louiscam.louiscam@yahoo.com', 'Louis', 'Cambridge', 4);
INSERT INTO `citylibrary`.`Member` (`address`, `email`, `firstName`, `lastName`, `iduser`) VALUES ('15 rue cremerie Saint Herblain', 'cathcam.cathcam@yahoo.com', 'Catherine', 'Cambridge', 5);
INSERT INTO `citylibrary`.`Member` (`address`, `email`, `firstName`, `lastName`, `iduser`) VALUES ('1 rue nazaire Saint Herblain', 'willcam.willcam@yahoo.com', 'William', 'Cambridge', 6);




INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `work_worksId`) VALUES ('hp1a', '1', '1');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `work_worksId`) VALUES ('hp1', '1', '1');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `work_worksId`) VALUES ('hp1c', '1', '1');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `work_worksId`) VALUES ('hp1d', '1', '1');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `work_worksId`) VALUES ('hp2a', '1', '2');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `work_worksId`) VALUES ('hp2', '1', '2');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `work_worksId`) VALUES ('hp3a', '1', '3');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `work_worksId`) VALUES ('hp3', '1', '3');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `work_worksId`) VALUES ('hp3c', '1', '3');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `work_worksId`) VALUES ('hp4a', '1', '4');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `work_worksId`) VALUES ('hp4', '1', '4');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `work_worksId`) VALUES ('hp4c', '1', '4');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `work_worksId`) VALUES ('hp5a', '1', '5');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `work_worksId`) VALUES ('hp5', '1', '5');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `work_worksId`) VALUES ('hp5c', '1', '5');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `work_worksId`) VALUES ('hp6a', '1', '6');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `work_worksId`) VALUES ('hp7a', '1', '7');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `work_worksId`) VALUES ('hp7', '1', '7');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `work_worksId`) VALUES ('nar1a', '1', '8');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `work_worksId`) VALUES ('nar1', '1', '8');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `work_worksId`) VALUES ('nar2a', '1', '9');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `work_worksId`) VALUES ('nar2', '1', '9');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `work_worksId`) VALUES ('nar3a', '1', '10');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `work_worksId`) VALUES ('nar3', '1', '10');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `work_worksId`) VALUES ('nar3c', '1', '10');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `work_worksId`) VALUES ('nar4a', '1', '11');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `work_worksId`) VALUES ('nar5a', '1', '12');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `work_worksId`) VALUES ('nar5', '1', '12');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `work_worksId`) VALUES ('nar5c', '1', '12');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `work_worksId`) VALUES ('nar5d', '1', '12');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `work_worksId`) VALUES ('nar6a', '1', '13');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `work_worksId`) VALUES ('nar6', '1', '13');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `work_worksId`) VALUES ('nar6c', '1', '13');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `work_worksId`) VALUES ('nar7a', '1', '14');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `work_worksId`) VALUES ('nar7', '1', '14');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `work_worksId`) VALUES ('un1', '1', '15');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `work_worksId`) VALUES ('un1a', '1', '15');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `work_worksId`) VALUES ('un2', '1', '16');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`) VALUES ('un3a', '1');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`) VALUES ('un3b', '1');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`) VALUES ('un3c', '1');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`) VALUES ('un3d', '1');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`) VALUES ('un3e', '1');
UPDATE `citylibrary`.`Book` SET `work_worksId` = '17' WHERE (`bookId` = 'un3a');
UPDATE `citylibrary`.`Book` SET `work_worksId` = '17' WHERE (`bookId` = 'un3b');
UPDATE `citylibrary`.`Book` SET `work_worksId` = '17' WHERE (`bookId` = 'un3c');
UPDATE `citylibrary`.`Book` SET `work_worksId` = '17' WHERE (`bookId` = 'un3d');
UPDATE `citylibrary`.`Book` SET `work_worksId` = '17' WHERE (`bookId` = 'un3e');

INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `work_worksId`) VALUES ('un4a', '1', '18');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `work_worksId`) VALUES ('un4b', '1', '18');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `work_worksId`) VALUES ('sh1a', '1', '19');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `work_worksId`) VALUES ('sh1b', '1', '19');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `work_worksId`) VALUES ('sh1c', '1', '19');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `work_worksId`) VALUES ('sh2a', '1', '20');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `work_worksId`) VALUES ('sh2b', '1', '20');
INSERT INTO `citylibrary`.`Book` (`bookId`, `isAvailable`, `work_worksId`) VALUES ('sh2c', '1', '20');



INSERT INTO `citylibrary`.`borrowing` (`idborrow`, `isExtended`, `issueDate`, `returnDate`, `status`, `book_bookId`, `member_iduser`) VALUES
(1, '0', '2018-12-08 09:54:26.382000', '2019-01-05 09:54:26.382000', 'ongoing', 'hp2a', 1),
(2, '0', '2018-12-18 09:54:29.618000', '2019-01-15 09:54:29.618000', 'ongoing', 'sh2c', 1),
(3, '0', '2018-12-12 09:54:32.396000', '2019-01-09 09:54:32.396000', 'ongoing', 'nar1a', 1),
(4, '0', '2019-01-08 09:54:36.455000', '2019-02-05 09:54:36.455000', 'ongoing', 'un3e', 1),
(5, '0', '2018-12-13 09:54:46.027000', '2019-01-10 09:54:46.027000', 'ongoing', 'nar3c', 3),
(6, '0', '2019-01-08 09:54:48.713000', '2019-02-05 09:54:48.713000', 'returned', 'hp1d', 3),
(7, b'1', '2018-12-22 09:54:51.529000', '2019-02-16 09:54:51.529000', 'extended', 'sh2b', 3),
(8, '0', '2018-12-15 09:54:56.797000', '2019-01-12 09:54:56.797000', 'ongoing', 'nar1', 3),
(9, '0', '2019-01-08 09:55:21.672000', '2019-02-05 09:55:21.672000', 'ongoing', 'hp3c', 5),
(10, '0', '2019-01-08 09:55:29.465000', '2019-02-05 09:55:29.465000', 'ongoing', 'nar2a', 5),
(11, '0', '2018-12-13 09:55:32.774000', '2019-01-10 09:55:32.774000', 'ongoing', 'un3d', 5),
(12, '0', '2019-01-08 09:56:34.054000', '2019-02-05 09:56:34.054000', 'ongoing', 'nar2', 6),
(13, '0', '2018-12-11 09:56:37.130000', '2019-01-08 09:56:37.130000', 'ongoing', 'sh2a', 6),
(14, '0', '2018-12-08 09:56:39.504000', '2019-01-05 09:56:39.504000', 'ongoing', 'nar3a', 6);

UPDATE `seq_borrow` SET `next_val`=15 WHERE 1;
UPDATE `seq_works` SET `next_val`=21 WHERE 1;
UPDATE `seq_user` SET `next_val`=7 WHERE 1;
