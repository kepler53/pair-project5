create schema project_db;

use project_db;

drop table if exists preference_tb;
drop table if exists housedeal_tb;
drop table if exists member_tb;
drop table if exists houseinfo_tb;

create table member_tb(
	membernum int primary key auto_increment,
	userid varchar(20) not null,
    pwd	varchar(20) not null,
    user_name varchar(20) not null,
    email_id varchar(20) not null,
    email_domain varchar(20) not null,
	join_date timestamp default NOW(),
    admin_type int
);

create table houseinfo_tb(
	houseinfonum int primary key auto_increment,
    city varchar(20),
    aptname varchar(50),
    dongcode int,
    gugun varchar(200),
    dong varchar(200),
    lat float,
    lang float
);

create table housedeal_tb(
    dealdate TIMESTAMP not null ,
	hmembernum int,
    hhouseinfonum int,
    housedeal_city varchar(20),
    housedeal_aptname varchar(50),
    housedeal_dong varchar(200),
    housedeal_type varchar(20),
    housedeal_price int,
    housedeal_charterprice int,
    housedeal_deposit int,
    housedeal_rentmoney int,
    primary key (hmembernum, hhouseinfonum),
	FOREIGN KEY (hmembernum) REFERENCES member_tb(membernum),
    FOREIGN KEY (hhouseinfonum) REFERENCES houseinfo_tb (houseinfonum)
    on delete cascade
);

create table preference_tb(
	pmembernum int ,
    phouseinfonum int ,
	preference_city varchar(20),
    preference_aptname varchar(50),
    preference_dong varchar(200),
    enroll_date timestamp,
    primary key (pmembernum, phouseinfonum),
	FOREIGN KEY (pmembernum) REFERENCES member_tb(membernum),
    FOREIGN KEY (phouseinfonum) REFERENCES houseinfo_tb(houseinfonum)
    on delete cascade
);