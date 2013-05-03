-- this script must be run as root user
CREATE USER 'bfh'@'localhost' IDENTIFIED BY 'bfh';
CREATE DATABASE bfh;
GRANT ALL PRIVILEGES ON bfh.* TO 'bfh'@'localhost';