create database bankmanagementsystem;
show databases;
use bankmanagementsystem;
create table signup (formNo varchar(20),name varchar(20),fname varchar(20),dob varchar(20) , gender varchar(20), email varchar(20), marital varchar(20), address varchar(20), city varchar(20) , state varchar(20));
create table signuptwo (formNo varchar(20) , religion varchar(20) , category varchar(20) , income varchar(20) , education varchar(20) , occupation varchar(20) , pan varchar(20), aadhar varchar(20), seniorCitizen varchar(20), exitingAccount varchar(20));
create table signupThree(formNo varchar(20) , accounttype varchar(30), cardnumber varchar(20), pinnumber varchar(20), service varchar(100));
create table login(formNo varchar(20),cardnumber varchar(20) , pinnumber varchar(20));
create table bank(pinnumber varchar(20),date varchar(50),type varchar(20),amount varchar(20) );
show tables;


select * from signup;
select * from signuptwo;
select * from signupThree;
select * from login;
select * from bank;

truncate table signup;
truncate table signuptwo;
truncate table signupThree;
truncate table login;
truncate table bank;

