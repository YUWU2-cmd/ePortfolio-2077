create database eportfolio;

create table User
(
    UserId int   AUTO_INCREMENT PRIMARY KEY,
    UserName varchar(100)  NOT NULL,
    Email varchar(100)  NOT NULL,
    Password varchar(30)  NOT NULL
);

    create table Role
    (
        RoleId int  AUTO_INCREMENT PRIMARY KEY,
        Name varchar(100),
        Description varchar(100)
);

create table UserRole (
	UserRoleId int AUTO_INCREMENT PRIMARY KEY,
    UserId int,
    RoleId int
);

alter table UserRole 
add constraint fk_role
foreign key(RoleId) references Role(RoleId);

alter table UserRole 
add constraint fk_user 
foreign key(UserId)  references User(UserId);

create table Blog(
	BlogId int auto_increment primary key,
    Title varchar(200) not null,
    Content text,
    CreatedTime datetime,
    UserId int    
);

alter table Blog 
add constraint fk_blog_user
foreign key(UserId) references User(UserId);

alter table User
add column bio varchar(500);

create table Image(
	ImageId int auto_increment primary key,
    ImageName varchar(200),
    ImagePath varchar(200),
    UserId int
);

alter table Image
add constraint fk_image_user
foreign key(UserId) references User(UserId);
 
alter table Image
 add unique unique_name_path (ImageName,ImagePath);
 
 alter table User
 add  column AboutMe varchar(1000);


