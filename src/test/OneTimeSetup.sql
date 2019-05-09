-- There is a schema named "useradmin" with one table: "Users"
-- The test schema is named "useradminTest"
-- make a copy of the table
CREATE TABLE fog_byggemarked_test.roof_material LIKE fog_byggemarked.roof_material;
-- make an other copy, this time naming it UsersTest
CREATE TABLE fog_byggemarked_test.roof_material_test LIKE fog_byggemarked.roof_material;
LOCK TABLES `roof_material` WRITE;
/*!40000 ALTER TABLE `roof_material` DISABLE KEYS */;
USE fog_byggemarked_test;
INSERT INTO `roof_material_test`
VALUES (1,'Betontagsten B & C dobbelt','Rød',420,330,300,300,'stk',0,1,1),
(2,'Betontagsten B & C dobbelt','Teglrød',420,330,300,300,'stk',0,1,1),
(3,'Betontagsten B & C dobbelt','Brun',420,330,300,300,'stk',0,1,1),
(4,'Betontagsten B & C dobbelt','Sort',420,330,300,300,'stk',0,1,1),
(5,'Ernittag B6','Grå',0,0,0,0,'stk',0,1,1),
(6,'Ernittag B6','Sort',0,0,0,0,'stk',0,1,1),
(7,'Ernittag B6','Mokka (brun)',0,0,0,0,'stk',0,1,1),
(8,'Ernittag B6','Rødbrun',0,0,0,0,'stk',0,1,1),
(9,'Ernittag B6','Teglrød',0,0,0,0,'stk',0,1,1),
(10,'Ernittag B7','Grå',0,0,0,0,'stk',0,1,1),
(11,'Ernittag B7','Sort',0,0,0,0,'stk',0,1,1),
(12,'Ernittag B7','Mokka (brun)',0,0,0,0,'stk',0,1,1),
(13,'Ernittag B7','Rødbrun',0,0,0,0,'stk',0,1,1),
(14,'Ernittag B7','Teglrød',0,0,0,0,'stk',0,1,1),
(15,'Ernittag B7','Rødflammet',0,0,0,0,'stk',0,1,1),
(16,'Plastmo Ecolite','Blåtonet',0,0,0,0,'stk',0,0,0);
/*!40000 ALTER TABLE `roof_material` ENABLE KEYS */;
UNLOCK TABLES;

-- make a new user for the test database
CREATE USER 'testinguser' IDENTIFIED BY 'try1try2tryAgain';
GRANT ALL PRIVILEGES ON fog_byggemarked_test.* TO 'testinguser';