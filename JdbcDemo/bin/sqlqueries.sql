//MYSQL QUERY
CREATE TABLE `emp` (
  `empno` int DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `salary` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
<<<<<<< HEAD

  CREATE TABLE `employee_sp` (
=======
//ORacle
	CREATE TABLE emp (
   empno number DEFAULT NULL,
      name varchar2(45) DEFAULT NULL,
     salary number DEFAULT NULL
   );
========================
  CREATE TABLE `employee` (
>>>>>>> d94c75d58ff31b7d088bbd2642f122ea940cf012
  `empno` int NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `salary` float DEFAULT NULL,
  PRIMARY KEY (`empno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

//Stored Procedures
//Insert Employee
	DELIMITER &&  
	
	create procedure InsertEmployee_employee_sp(IN empno INT,    
	IN name VARCHAR(100), IN salary FLOAT)        
	begin    
	insert into employee_sp values(empno,name, salary);    
	end &&  
	DELIMITER ;    
//Select All Employees
DELIMITER &&  
	
	create procedure SelectAllEmployees_employee_sp()        
	begin    
	select * from employee_sp;   
	end &&  
	DELIMITER ;    
	
//Delete Employee
DELIMITER &&  
	
	create procedure deleteEmployee_employee_sp(IN empno INT)        
	begin    
	delete from employee_sp where empno=empno;
	commit;
	end &&  
	DELIMITER ;    
//Update Employee
DELIMITER &&  
	
	create procedure UpdateEmployee_employee_sp(IN empno INT,    
	IN name VARCHAR(100), IN salary FLOAT)        
	begin    
	update employee_sp set name=name, salary=salary where empno=empno;     
	end &&  
	DELIMITER ;   
