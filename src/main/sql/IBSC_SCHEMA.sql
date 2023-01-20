CREATE TABLE IBSC_USER (
Emp_Id NUMERIC(10,0) NOT NULL PRIMARY KEY ([Emp_Id]),
Password VARCHAR(20) NOT NULL,
FirstName VARCHAR(255) NOT NULL,
LastName VARCHAR(255) NOT NULL,
Email_Id VARCHAR(255) NOT NULL,
QNO VARCHAR(255) NOT NULL,
Ans Varchar(50) NOT NULL,
Ob_Status VARCHAR(50), 
Pending_Trainings int, 
Total_Trainings int,
Location VARCHAR(255));


CREATE TABLE IBSC_Training(
Tr_ID VARCHAR (50) NOT null,
Name VARCHAR(50),
Type VARCHAR(50),
Duration VARCHAR(50),
Reference VARCHAR(500)
Primary Key (Tr_ID));


CREATE TABLE IBSC_User_Training(
User_Tr_ID VARCHAR(60) NOT null,
Emp_ID Numeric (10) NOT null,
Status VARCHAR(50),
Actual_Date DATE,
Due_Date DATE,
Primary Key (User_Tr_ID),
Training_ID VARCHAR(50) references IBSC_Training(Tr_ID));


Create Table IBSC_Documents(
Document_ID varchar(10) NOT null,
Topic_Name varchar(50),
Link varchar(500),
Type varchar(50)
Primary Key (Document_ID));

CREATE TABLE IBSC_OB_MASTER (
Step_Id NUMERIC(5,0) NOT NULL PRIMARY KEY ([Step_Id]),
Step_Desc VARCHAR(255) NOT NULL,
Refereces VARCHAR(1024) NOT NULL,
Applicable_Location VARCHAR(255) NOT NULL,
Applicable_Roles VARCHAR(255) NOT NULL);

CREATE TABLE IBSC_OB_USER(
Emp_Id NUMERIC REFERENCES IBSC_USER(emp_id),
Step_Id numeric(5,0) not null,
OB_Status varchar(55) not null,
Assigned_To NUMERIC REFERENCES IBSC_USER(emp_id),
Remarks varchar(255) not null,
reference varchar(55)
primary key(Emp_Id, Step_Id));







