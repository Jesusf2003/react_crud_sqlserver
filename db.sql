DROP DATABASE IF EXISTS react_crudb;
CREATE DATABASE react_crudb;

use react_crudb;

create schema dev_projects;

create table dev_projects.books (
    id_books         int primary key identity(1,1),
    title           varchar(100),
    description     varchar(500),
    published       bit
);

select * from dev_projects.books;