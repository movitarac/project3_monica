CREATE USER 'testuser'@'localhost' IDENTIFIED BY 'racine.root1234';
GRANT ALL PRIVILEGES ON * . * TO 'newuser'@'localhost'
FLUSH PRIVILEGES;

CREATE DATABASE IF NOT EXISTS `citylibrary` DEFAULT CHARACTER SET utf8;

USE `citylibrary`;
