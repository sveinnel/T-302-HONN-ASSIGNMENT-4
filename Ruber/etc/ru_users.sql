CREATE TABLE ru_users
(
  id int Identity (1, 1) primary key NOT NULL,
  username nvarchar(256) unique NOT NULL,
  firstname nvarchar(128),
  lastname nvarchar(128),
  password nvarchar(128),
  email nvarchar(256),
  registered datetime,
  driver bit default 0
)

create table ru_price
(
  id int Identity (1, 1) primary key NOT NULL,
  currencycode nvarchar(3),
  lowestimate float ,
  highestimate float,
  surgemultiplayer float ,
  finalpricce float
)

create table ru_product
(
  id int Identity (1, 1) primary key NOT NULL,
  description nvarchar(512),
  displayname nvarchar(128),
  capacity int ,
  imageurl nvarchar(512),
  driverid int references ru_users(id),
  priceid int references ru_price(id)
)

create table ru_ride
(
  id int Identity (1, 1) primary key NOT NULL,
  productid int references ru_product(id),
  requesttime datetime,
  starttime datetime,
  endtime datetime,
  startlongtitude float,
  endlongtitude float,
  startlatitude float,
  endlatitude float,
  distance float
)

create table ru_review
(
  id int Identity (1, 1) primary key NOT NULL,
  reviwerid int references ru_users(id),
  reviewedid int references ru_users(id),
  rideid int references ru_ride(id),
  comment nvarchar(512)
)