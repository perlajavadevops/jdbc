--create db schema
CREATE SCHEMA batch03;

-- image table for storing image in the db
CREATE TABLE 'imgtable' (
  'name' varchar(100) DEFAULT NULL,
  'photo' blob
)

-- Emp table with Primary Key
CREATE TABLE `emp` (
  `id` int NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `salary` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) 

-- Stored Procedures
--SelectAllEmployees Stored Procedure
DELIMITER $$
CREATE PROCEDURE `SelectAllEmployees`()
begin    
	select * from employee;   
end
$$ DELIMITER ;

-- InsertEmployee Stored Procedure
DELIMITER $$
CREATE PROCEDURE InsertEmployee (IN id INT,    
IN name VARCHAR(100), IN salary FLOAT)
begin    
insert into employee values(id,name, salary);    
end
$$ DELIMITER ;

-- UpdateEmployee Stored Procedure
DELIMITER $$
CREATE PROCEDURE `UpdateEmployee`(IN id INT,    
	IN name VARCHAR(100), IN salary FLOAT)
begin    
	update employee set name=name, salary=salary where id=id;  
	end$$
DELIMITER ;

-- Delete Stored Procedure
DELIMITER $$
CREATE  PROCEDURE `DeleteEmployee`(IN id INT)
begin    
	delete from employee where id=id;
	commit;
	end$$
DELIMITER ;
