create database PoliceSystem
go 
use PoliceSystem

create table PoliceOfficer
(
	[Name] nvarchar(50),
	ID nvarchar(15) primary key,
	[Password] nvarchar(10),
	[Rank] nvarchar(10)
)

insert into dbo.[PoliceOfficer] values ('Muhammed Ali','34677-1234654-4','SPO12345' , 'Senior')
insert into dbo.[PoliceOfficer] values ('Muhammed Ahmed','34689-1234654-5','SPO67891' , 'Senior')
insert into dbo.[PoliceOfficer] values ('Muhammed Sufian','34654-1234654-9','SPO09007', 'Senior')
insert into dbo.[PoliceOfficer] values ('Fatima Ali','34454-1234654-7','JPO78601', 'Junior')
insert into dbo.[PoliceOfficer] values ('Rameen Amir','34454-1274654-7','JPO123', 'Junior')

create table Complaint 
(
	ID nvarchar(15) not null primary key,
	[status] nvarchar(30),
	ComplainerName nvarchar(50),
	ComplainerID nvarchar(15),
	[Description] nvarchar(200)
)

create table FIR
(
	ID nvarchar(15) not null primary key,
	ReportedByName nvarchar(50),
	ReportedByID nvarchar(15),
	ReportedAgainstName nvarchar(50),
	ReportedAgainstID nvarchar(15),
	[Description] nvarchar(200),
	[status] nvarchar(30),
	FileDate date
	)
	alter table FIR add ResourceID nvarchar(15) foreign key references Resources(ID) 
	alter table FIR add AppointedOfficerID nvarchar(15) foreign key references PoliceOfficer(ID) 
	alter table PoliceOfficer add [Rank] nvarchar(10)

create table Appointment
(
	ID nvarchar(15) not null primary key,
	AppTime time,
	AppDate date,
	HolderName nvarchar(50),
	HolderID nvarchar(15),
	ApointmentWithName nvarchar(50)
)

create table Resources
(
	[Name] nvarchar(50),
	ID nvarchar(15) primary key,
	[status] nvarchar(30)
)

create table Patrol
(
	ID nvarchar(15) primary key,
	[Date] date,
	StartTime time,
	EndTime time,
	AppointeeName nvarchar(50),
	AppointeeID nvarchar(15)
)

create table Prisoner
(
	[Name] nvarchar(50),
	CNIC nvarchar(15) primary key,
	DateOfEntry date,
	DateofRelease date,
	Crime nvarchar(50),
	CellID int,
	[Status] nvarchar(30)
)

create table DashBoard
(
	TotalCrimes float,
	NewPrisoners float,
	NewCrimes float
)

create table Token
(
	TokenDate date,
	TokenNO int
)

update Token set TokenNO ='2' where tokenNO='1'

select top 1 ID from FIR order by ID desc

select * from FIR
select top 1 ID from Appointment order by ID desc
update dbo.[FIR] set [status]='completed' where [status] is null

select top 1 ID from Complaint order by ID desc

select * from Prisoner
select * from Complaint 
select * from PoliceOfficer
select * from Appointment
update Prisoner set DateofRelease = null
update Prisoner set CellID = 12 

update Prisoner set [Status] ='InPrison' 

select count(*) total from FIR

SELECT Count(*) total
FROM FIR
WHERE  FileDate >= DATEADD(day,-7, GETDATE())


SELECT Count(*) total FROM Prisoner WHERE  DateOfEntry >= DATEADD(day,-7, GETDATE())