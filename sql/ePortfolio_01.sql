create database eportfolio;

create table User
(
    UserId int
    AUTO_INCREMENT PRIMARY KEY,
    UserName varchar
    (100) NOT NULL,
    Email varchar
    (100) NOT NULL,
    Password varchar
    (30) NOT NULL
);

    create table Role
    (
        RoleId int
        AUTO_INCREMENT PRIMARY KEY,
    Name varchar
        (100),
    Description varchar
        (100)
);

        create table UserRole
        (
            UserRoleId int
            AUTO_INCREMENT PRIMARY KEY,
    UserId int,
    RoleId int
);

alter table UserRole 
add constraint fk_role
foreign key(RoleId) 
references Role(RoleId);

alter table UserRole 
add constraint fk_user 
foreign key(UserId) 
references User(UserId);




