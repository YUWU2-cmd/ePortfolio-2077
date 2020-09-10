create database ePortfolio;

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
    RoleId int,
    CONSTRAINT 'fk_user' FOREIGN KEY
            (UserId) REFERENCES User
            (UserId),
    CONSTRAINT 'fk_role' FOREIGN KEY
            (RoleId) REFERENCES Role
            (RoleId)
);





