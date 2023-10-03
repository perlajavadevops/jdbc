SQL> create table emp2(id NUMBER, name VARCHAR2, salary FLOAT);
create table emp2(id NUMBER, name VARCHAR2, salary FLOAT)
                                          *
ERROR at line 1:
ORA-00906: missing left parenthesis


SQL> create table emp2(id NUMBER, name VARCHAR2(100), salary FLOAT);

Table created.

SQL> describe emp2;
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 ID                                                 NUMBER
 NAME                                               VARCHAR2(100)
 SALARY                                             FLOAT(126)

SQL> select * from emp2;

no rows selected

SQL> insert into emp2 values(1, 'Perla Reddy', 1000)
  2  ;

1 row created.

SQL> select * from emp2;

ID     NAME           SALARY
----------------------------
1     Perla Reddy    1000


SQL> commit;

Commit complete.

SQL> insert into emp2 values(2, 'Dhatrika', 2000);

1 row created.

SQL> select * from emp2;

ID                 NAME             SALARY
--------------------------------------------------------------------------------
1                  Perla Reddy      1000

2                  Dhatrika         2000


SQL> select * from emp2 where id=2;

ID                 NAME             SALARY
--------------------------------------------------------------------------------
2                  Dhatrika         2000


SQL> update emp2 set salary=3000, name='Dhatrika Sai Perla'; -- not recomended

2 rows updated.

SQL> commit;

Commit complete.

SQL> select * from emp2;

ID                 NAME                        SALARY
--------------------------------------------------------------------------------
1                  Dhatrika Sai Perla         3000

2                  Dhatrika Sai Perla         3000

SQL> update emp2 set salary=4000, name='Dhruvika Shree Perla' where id=1 ;

1 row updated.

SQL> select * from emp2;
ID                 NAME                        SALARY
--------------------------------------------------------------------------------
1                  Dhruvika Shree Perla         3000

2                  Dhatrika Sai Perla           3000


SQL> commit;

Commit complete.

SQL> select * from emp2 where id in(1,2);

ID                 NAME                        SALARY
--------------------------------------------------------------------------------
1                  Dhruvika Shree Perla         3000

2                  Dhatrika Sai Perla           3000



SQL> delete from emp2 where id in(1,2);

2 rows deleted.

SQL> rollback;

Rollback complete.

SQL> select * from emp2 where id in(1,2);
ID                 NAME                        SALARY
--------------------------------------------------------------------------------
1                  Dhruvika Shree Perla         3000

2                  Dhatrika Sai Perla           3000


SQL> delete from emp2 where id in(1,2);

2 rows deleted.

SQL> select * from emp2 where id in(1,2);

no rows selected

SQL> rollback;

Rollback complete.

SQL> select * from emp2 where id in(1,2);

ID                 NAME                        SALARY
--------------------------------------------------------------------------------
1                  Dhruvika Shree Perla         3000

2                  Dhatrika Sai Perla           3000

SQL> delete from emp2 where id=2;

1 row deleted.

SQL> select * from emp2 where id in(1,2);

ID                 NAME                        SALARY
--------------------------------------------------------------------------------
1                  Dhruvika Shree Perla         3000


SQL> rollback;

Rollback complete.

SQL> select * from emp2 where id in(1,2);
ID                 NAME                        SALARY
--------------------------------------------------------------------------------
1                  Dhruvika Shree Perla         3000

2                  Dhatrika Sai Perla           3000

SQL>