//MYSQL QUERY
CREATE TABLE `emp` (
  `empno` int DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `salary` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

  CREATE TABLE `employee` (
  `empno` int NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `salary` float DEFAULT NULL,
  PRIMARY KEY (`empno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

//Stored Procedures
//Insert Employee
	DELIMITER &&  
	
	create procedure InsertEmployee(IN empno INT,    
	IN name VARCHAR(100), IN salary FLOAT)        
	begin    
	insert into employee values(empno,name, salary);    
	end &&  
	DELIMITER ;    
//Select All Employees
DELIMITER &&  
	
	create procedure SelectAllEmployees()        
	begin    
	select * from employee;   
	end &&  
	DELIMITER ;    
	
//Delete Employee
DELIMITER &&  
	
	create procedure deleteEmployee(IN empno INT)        
	begin    
	delete from employee where empno=empno;
	commit;
	end &&  
	DELIMITER ;    
//Update Employee
DELIMITER &&  
	
	create procedure UpdateEmployee(IN empno INT,    
	IN name VARCHAR(100), IN salary FLOAT)        
	begin    
	update employee set name=name, salary=salary where empno=empno;     
	end &&  
	DELIMITER ;   