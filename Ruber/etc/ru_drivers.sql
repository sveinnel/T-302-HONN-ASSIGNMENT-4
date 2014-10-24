CREATE TABLE ru_driver
(
  id int Identity (1, 1) primary key NOT NULL,
  userid nvarchar(100),
  username nvarchar(256) unique NOT NULL,
  firstname nvarchar(128),
  lastname nvarchar(128),
  password nvarchar(128),
  email nvarchar(256),
  registered datetime
)



