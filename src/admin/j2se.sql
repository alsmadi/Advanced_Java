DROP TABLE employee;

CREATE TABLE employee
(
  id              DECIMAL(8) PRIMARY KEY,
  firstname       VARCHAR(15),
  lastname        VARCHAR(25),
  title           VARCHAR(30),
  department_code CHAR(2),
  supervisor_id   DECIMAL(8),
  hire_date       DATE,
  salary          DECIMAL(9,2),
  mugshot         BLOB
);

DROP TABLE department;

CREATE TABLE department
(
  department_code CHAR(2) PRIMARY KEY,
  department_name VARCHAR(30),
  manager_id      DECIMAL(8),
  city            VARCHAR(25),
  state           CHAR(2)
);


INSERT INTO department (department_code, department_name, city, state)
            VALUES ('SM', 'Sales and Marketing', 'Denver', 'CO');

INSERT INTO department (department_code, department_name, city, state)
            VALUES ('RD', 'Research and Development', 'Houston', 'TX');

INSERT INTO department (department_code, department_name, city, state)
            VALUES ('CS', 'Customer Service and Support', 'Houston', 'TX');

INSERT INTO department (department_code, department_name, city, state)
            VALUES ('HR', 'Human Resources', 'Tucson', 'AZ');

INSERT INTO department (department_code, department_name, city, state)
            VALUES ('SH', 'Shipping', 'Commerce City', 'CO');

INSERT INTO department (department_code, department_name, city, state)
            VALUES ('AC', 'Accounting', 'Tucson', 'AZ');

INSERT INTO department (department_code, department_name, city, state)
            VALUES ('AD', 'Administration', 'Tucson', 'AZ');

INSERT INTO employee ( id, firstname, lastname, title,
                       department_code, supervisor_id, hire_date, salary)
            VALUES   ( 6567, 'Mike', 'Hodges', 'Department Manager',
                       'SM', NULL, '1990-02-04', 64000.00);

INSERT INTO employee ( id, firstname, lastname, title,
                       department_code, supervisor_id, hire_date, salary)
            VALUES   ( 6644, 'Geri', 'Singh', 'Account Manager',
                       'SM', 6567, '1991-03-12', 42000.00);

INSERT INTO employee ( id, firstname, lastname, title,
                       department_code, supervisor_id, hire_date, salary)
            VALUES   ( 6659, 'Sue', 'Hartman', 'Account Manager',
                       'SM', 6567, '1989-10-16', 50000.00);

INSERT INTO employee ( id, firstname, lastname, title,
                       department_code, supervisor_id, hire_date, salary)
            VALUES   ( 6668, 'John', 'Jean', 'Account Manager',
                       'SM', 6567, '1990-01-07', 40000.00);

INSERT INTO employee ( id, firstname, lastname, title,
                       department_code, supervisor_id, hire_date, salary)
            VALUES   ( 6863, 'Bob', 'Taylor', 'Account Manager',
                       'SM', 6567, '1997-07-05', 49000.00);

INSERT INTO employee ( id, firstname, lastname, title,
                       department_code, supervisor_id, hire_date, salary)
            VALUES   ( 6892, 'Robert', 'Zehr', 'Manager',
                       'SM', 6567, '1995-06-15', 41000.00);

INSERT INTO employee ( id, firstname, lastname, title,
                       department_code, supervisor_id, hire_date, salary)
            VALUES   ( 7218, 'Tom', 'Mundt', 'Sales Assistant',
                       'SM', 6892, '1993-01-13', 45000.00);

INSERT INTO employee ( id, firstname, lastname, title,
                       department_code, supervisor_id, hire_date, salary)
            VALUES   ( 7285, 'Michael', 'Ann', 'Account Manager',
                       'SM', 6892, '1988-01-18', 48000.00);

INSERT INTO employee ( id, firstname, lastname, title,
                       department_code, supervisor_id, hire_date, salary)
            VALUES   ( 7407, 'Allan', 'Schicker', 'Account Manager',
                       'SM', 6892, '1998-05-06', 42000.00);

INSERT INTO employee ( id, firstname, lastname, title,
                       department_code, supervisor_id, hire_date, salary)
            VALUES   ( 7366, 'John', 'Cummiskey', 'Account Manager',
                       'SM', 6892, '1997-04-26', 50000.00);

INSERT INTO employee ( id, firstname, lastname, title,
                       department_code, supervisor_id, hire_date, salary)
            VALUES   ( 8099, 'Mark', 'Sallee', 'Account Manager',
                       'SM', 6892, '1988-01-01', 41000.00);

INSERT INTO employee ( id, firstname, lastname, title,
                       department_code, supervisor_id, hire_date, salary)
            VALUES   ( 8084, 'Leigh', 'Scherer', 'Manager',
                       'SM', 6892, '1989-02-22', 50000.00);

INSERT INTO employee ( id, firstname, lastname, title,
                       department_code, supervisor_id, hire_date, salary)
            VALUES   ( 8080, 'Jon', 'Scholz', 'Sales Assistant',
                       'SM', 8084, '1993-01-07', 49000.00);

INSERT INTO employee ( id, firstname, lastname, title,
                       department_code, supervisor_id, hire_date, salary)
            VALUES   ( 8053, 'Valerie', 'Smith', 'Department Manager',
                       'HR', NULL, '1991-12-05', 63000.00);

INSERT INTO employee ( id, firstname, lastname, title,
                       department_code, supervisor_id, hire_date, salary)
            VALUES   ( 7966, 'Barbara', 'Walker', 'Recruiter',
                       'HR', 8053, '1995-12-20', 40000.00);

INSERT INTO employee ( id, firstname, lastname, title,
                       department_code, supervisor_id, hire_date, salary)
            VALUES   ( 7846, 'Anthony', 'Goffi', 'Recruiter',
                       'HR', 8053, '1991-06-15', 52000.00);

INSERT INTO employee ( id, firstname, lastname, title,
                       department_code, supervisor_id, hire_date, salary)
            VALUES   ( 7644, 'Cliff', 'Absher', 'Human Resource Specialist',
                       'HR', 8053, '1994-03-13', 47000.00);

INSERT INTO employee ( id, firstname, lastname, title,
                       department_code, supervisor_id, hire_date, salary)
            VALUES   ( 7502, 'Cris', 'Hunsaker', 'Department Manager',
                       'SH', NULL, '1997-06-16', 72000.00);

INSERT INTO employee ( id, firstname, lastname, title,
                       department_code, supervisor_id, hire_date, salary)
            VALUES   ( 8107, 'Bonnie', 'Roth', 'Clerk',
                       'SH', 7502, '2000-07-21', 52000.00);

INSERT INTO employee ( id, firstname, lastname, title,
                       department_code, supervisor_id, hire_date, salary)
            VALUES   ( 7445, 'Julie', 'Sussenbach', 'Clerk',
                       'SH', 7502, '2001-07-20', 40000.00);

INSERT INTO employee ( id, firstname, lastname, title,
                       department_code, supervisor_id, hire_date, salary)
            VALUES   ( 7223, 'Glen', 'Paul', 'Department Manager',
                       'AC', NULL, '1993-01-24', 70000.00);

INSERT INTO employee ( id, firstname, lastname, title,
                       department_code, supervisor_id, hire_date, salary)
            VALUES   ( 7088, 'Dave', 'McKillip', 'Bookkeeper',
                       'AC', 7223, '1999-04-19', 44000.00);

INSERT INTO employee ( id, firstname, lastname, title,
                       department_code, supervisor_id, hire_date, salary)
            VALUES   ( 6881, 'Susan', 'Langley', 'Department Manager',
                       'AD', NULL, '1996-03-06', 65000.00);

INSERT INTO employee ( id, firstname, lastname, title,
                       department_code, supervisor_id, hire_date, salary)
            VALUES   ( 6810, 'Michael', 'Farrelly', 'Office Manager',
                       'AD', 6881, '2003-03-17', 47000.00);

INSERT INTO employee ( id, firstname, lastname, title,
                       department_code, supervisor_id, hire_date, salary)
            VALUES   ( 6783, 'Chakradhar', 'Adair', 'Office Manager',
                       'AD', 6881, '1990-03-01', 53000.00);

INSERT INTO employee ( id, firstname, lastname, title,
                       department_code, supervisor_id, hire_date, salary)
            VALUES   ( 6650, 'Terry', 'Slickers', 'Receptionist',
                       'AD', 6881, '1993-03-16', 46000.00);

INSERT INTO employee ( id, firstname, lastname, title,
                       department_code, supervisor_id, hire_date, salary)
            VALUES   ( 8222, 'Robert', 'Moore', 'Assistant',
                       'AD', 6881, '2002-07-13', 45000.00);

INSERT INTO employee ( id, firstname, lastname, title,
                       department_code, supervisor_id, hire_date, salary)
            VALUES   ( 8269, 'Channing', 'Martin', 'Manager',
                       'AD', 6881, '1998-06-20', 40000.00);

INSERT INTO employee ( id, firstname, lastname, title,
                       department_code, supervisor_id, hire_date, salary)
            VALUES   ( 8339, 'Jack', 'Kent', 'Department Manager',
                       'CS', NULL, '1995-12-19', 76000.00);

INSERT INTO employee ( id, firstname, lastname, title,
                       department_code, supervisor_id, hire_date, salary)
            VALUES   ( 8373, 'Thomas', 'Jacoby', 'Customer Service Rep',
                       'CS', 8339, '1994-05-24', 48000.00);

INSERT INTO employee ( id, firstname, lastname, title,
                       department_code, supervisor_id, hire_date, salary)
            VALUES   ( 8511, 'Darcy', 'Drera', 'Customer Service Rep',
                       'CS', 8339, '1994-06-07', 49000.00);

INSERT INTO employee ( id, firstname, lastname, title,
                       department_code, supervisor_id, hire_date, salary)
            VALUES   ( 8578, 'Jim', 'Cheffy', 'Customer Service Rep',
                       'CS', 8339, '1991-01-07', 48000.00);

INSERT INTO employee ( id, firstname, lastname, title,
                       department_code, supervisor_id, hire_date, salary)
            VALUES   ( 8741, 'Ashraf', 'Kindvall', 'Customer Service Rep',
                       'CS', 8339, '2002-06-23', 51000.00);

INSERT INTO employee ( id, firstname, lastname, title,
                       department_code, supervisor_id, hire_date, salary)
            VALUES   ( 8795, 'Lisa', 'Stewart', 'Manager',
                       'CS', 8339, '2003-02-01', 49000.00);

INSERT INTO employee ( id, firstname, lastname, title,
                       department_code, supervisor_id, hire_date, salary)
            VALUES   ( 8804, 'James', 'Gaughan', 'Customer Service Rep',
                       'CS', 8795, '1999-06-01', 47000.00);

INSERT INTO employee ( id, firstname, lastname, title,
                       department_code, supervisor_id, hire_date, salary)
            VALUES   ( 8798, 'Philip', 'Osen', 'Customer Service Rep',
                       'CS', 8795, '1990-04-01', 43000.00);

INSERT INTO employee ( id, firstname, lastname, title,
                       department_code, supervisor_id, hire_date, salary)
            VALUES   ( 9318, 'Kelly', 'Tatman', 'Customer Service Rep',
                       'CS', 8795, '1990-01-20', 50000.00);

INSERT INTO employee ( id, firstname, lastname, title,
                       department_code, supervisor_id, hire_date, salary)
            VALUES   ( 9188, 'Gail', 'Ortlieb', 'Department Manager',
                       'RD', NULL, '1989-05-15', 66000.00);

INSERT INTO employee ( id, firstname, lastname, title,
                       department_code, supervisor_id, hire_date, salary)
            VALUES   ( 9018, 'Dick', 'Lillrose', 'QA',
                       'RD', 9188, '2000-01-19', 44000.00);

INSERT INTO employee ( id, firstname, lastname, title,
                       department_code, supervisor_id, hire_date, salary)
            VALUES   ( 8981, 'Joseph', 'Paris', 'Engineer',
                       'RD', 9188, '1996-07-12', 47000.00);

INSERT INTO employee ( id, firstname, lastname, title,
                       department_code, supervisor_id, hire_date, salary)
            VALUES   ( 8785, 'Lauretta', 'Abedzadeh', 'QA',
                       'RD', 9188, '1988-03-28', 54000.00);

INSERT INTO employee ( id, firstname, lastname, title,
                       department_code, supervisor_id, hire_date, salary)
            VALUES   ( 8674, 'Sue', 'Ahl', 'Engineer',
                       'RD', 9188, '1997-07-24', 42000.00);

INSERT INTO employee ( id, firstname, lastname, title,
                       department_code, supervisor_id, hire_date, salary)
            VALUES   ( 8571, 'Howie', 'Ciurej', 'Manager',
                       'RD', 9188, '1996-12-11', 51000.00);

INSERT INTO employee ( id, firstname, lastname, title,
                       department_code, supervisor_id, hire_date, salary)
            VALUES   ( 8478, 'Tony', 'Filipowicz', 'Developer',
                       'RD', 8571, '1994-02-23', 53000.00);

INSERT INTO employee ( id, firstname, lastname, title,
                       department_code, supervisor_id, hire_date, salary)
            VALUES   ( 9894, 'Gloria', 'Harbert', 'Engineer',
                       'RD', 8571, '1989-11-23', 50000.00);

INSERT INTO employee ( id, firstname, lastname, title,
                       department_code, supervisor_id, hire_date, salary)
            VALUES   ( 9883, 'Warren', 'Carson', 'Developer',
                       'RD', 8571, '1993-01-08', 49000.00);

INSERT INTO employee ( id, firstname, lastname, title,
                       department_code, supervisor_id, hire_date, salary)
            VALUES   ( 9779, 'Eleanor', 'Hill', 'QA',
                       'RD', 8571, '1993-01-15', 44000.00);

INSERT INTO employee ( id, firstname, lastname, title,
                       department_code, supervisor_id, hire_date, salary)
            VALUES   ( 9765, 'Dave', 'Marsh', 'Developer',
                       'RD', 8571, '1999-11-25', 51000.00);

INSERT INTO employee ( id, firstname, lastname, title,
                       department_code, supervisor_id, hire_date, salary)
            VALUES   ( 9683, 'Robert', 'Miller', 'Manager',
                       'RD', 8571, '1995-11-27', 40000.00);

