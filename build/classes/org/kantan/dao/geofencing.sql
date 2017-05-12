
drop database geoFenceDB;

create database IF NOT EXISTS geoFenceDB;
use geoFenceDB;

create table parent
(
	emailID varchar(26),
	mobileNum bigint,
	passwd varchar(16),
	verified bit(1),
	primary key(emailID)
);


create table verifyUser
(
	emailID varchar(26),
	otp int,
	otpCreatedAt DateTime,
	primary key(emailID),
	foreign key(emailID) references parent(emailID)
);

create table child
(
	childEmailID varchar(26),
	parentEmailID varchar(26),
	refCoordinates varchar(35),
	radius bigint,
	primary key(childEmailID),
	foreign key(parentEmailID) references parent(emailID)
);

create table locationLog
(
	childEmailID varchar(26),
	coordinates varchar(35),
	loggedAt DateTime,
	foreign key(childEmailID) references child(childEmailID)
);

insert into parent
values('neelakantachari@gmail.com',9964667656,'neel',0);

insert into parent
values('neelakanta.rvce@gmail.com',9964667656,'rvce',0);

insert into child
values('deepaksnandihal@gmail.com','neelakantachari@gmail.com','12345678987654321',2000); 

insert into locationLog
values('deepaksnandihal@gmail.com','98765431233456789','2017-04-24');


insert into locationLog
values('deepaksnandihal@gmail.com','98765431231212122','2017-04-24');