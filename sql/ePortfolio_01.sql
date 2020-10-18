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

 
create table Site(
	SiteId int auto_increment primary key,
    UserId int
);

alter table Site
add constraint fk_site_user
foreign key(UserId) references User(UserId);

alter table Site 
add column Bio varchar(1000), 
add column AboutMe varchar(1000);

alter table Image
drop constraint fk_image_user;

alter table Image
drop column UserId;

alter table Image 
add column SiteId int;

alter table Image
add constraint fk_image_site
foreign key(SiteId) references Site(SiteId);

alter table Role 
add constraint ak_RoleName
unique(Name);

alter table User
add constraint ak_Email
unique(Email);

alter table User add column Enable bool;
alter table User add column VerifyCode varchar(10);
alter table User add column ProfilePicture varchar(500);

create table Skill(
	SkillId int auto_increment primary key,
    SkillName varchar(200) unique
);

create table UserSkill(
	UserSkillId int auto_increment primary key,
    SkillType varchar(200) unique,
    SiteId int,
    SkillId int
);

alter table UserSkill
add constraint fk_userskill_site
foreign key(SiteId) references Site(SiteId);

alter table UserSkill
add constraint fk_userskill_skill
foreign key(SkillId) references Skill(SkillId);

create table Education(
	EducationId int auto_increment primary key,
    StartTime date,
    EndTime date,
    SchoolName varchar(250),
    Degree varchar(200),
    Major varchar(100),
    Minor varchar(100),
    SchoolLocation varchar(500),
    `Description` varchar(1000),
    SiteId int
);

alter table Education
add constraint fk_education_user
foreign key(SiteId) references Site(SiteId);

create table Experience(
	ExperienceId int auto_increment primary key,
    StartTime datetime,
    EndTime datetime,
    Position varchar(200),
    CompanyName varchar(250),
    CompanyLocation varchar(500),
    `Description` varchar(1000),
    SiteId int
);

alter table Experience
add constraint fk_experience_user
foreign key(SiteId) references Site(SiteId);


create table ProjectSeries(
	ProjectSeriesId int auto_increment primary key,
	SeriesName varchar(200),
    Summary varchar(1000),
    SiteId int
);

alter table ProjectSeries
add constraint fk_projectseries_site
foreign key(SiteId) references Site(SiteId);

create table Project(
	ProjectId int auto_increment primary key,
	ProjectName varchar(200),
    `Description` varchar(1000),
    Position varchar(200),
    ProjectSeriesId int
);

alter table Project
add constraint fk_project_projectseries
foreign key(ProjectSeriesId) references ProjectSeries(ProjectSeriesId);

create table ProjectImage(
	ProjectImageId int auto_increment primary key,
	ImageName varchar(200) unique,
    ImagePath varchar(1000),
    ProjectId int
);

alter table ProjectImage
add constraint fk_projectImage_project
foreign key(ProjectId) references Project(ProjectId);

alter table Site 
add column SiteName varchar(1000);

alter table Education
drop column StartTime;

alter table Education
drop column EndTime;

alter table Education 
add column Duration varchar(100);

alter table Experience
drop column StartTime;

alter table Experience
drop column EndTime;

alter table Experience
add column Duration varchar(100);

alter table User
add column PhoneNumber int;
