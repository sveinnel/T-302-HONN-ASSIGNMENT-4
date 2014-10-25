CREATE TABLE hshemile12.hshemile12.ru_users (
  id int PRIMARY KEY NOT NULL identity (1,1),
  username nvarchar(256) NOT NULL,
  firstname nvarchar(128),
  lastname nvarchar(128),
  password nvarchar(128),
  email nvarchar(256),
  registered datetime,
  driver bit DEFAULT ((0))
);



CREATE TABLE hshemile12.hshemile12.ru_prices (
  id int PRIMARY KEY NOT NULL identity (1,1),
  currencycode nvarchar(3),
  lowestimate float(53),
  highestimate float(53),
  surgemultiplayer float(53),
  finalprice float(53)
);

CREATE TABLE hshemile12.hshemile12.ru_products (
  id int PRIMARY KEY NOT NULL identity (1,1),
  description nvarchar(512),
  displayname nvarchar(128),
  capacity int,
  imageurl nvarchar(512),
  driverid int,
  priceid int,
  FOREIGN KEY (driverid) REFERENCES ru_users (id),
  FOREIGN KEY (priceid) REFERENCES ru_prices (id)
);

CREATE TABLE hshemile12.hshemile12.ru_trips (
  id int PRIMARY KEY NOT NULL identity (1,1),
  productid int,
  requesttime datetime,
  starttime datetime,
  endtime datetime,
  startlongitude float(53),
  endlongitude float(53),
  startlatitude float(53),
  endlatitude float(53),
  distance float(53),
  completed bit DEFAULT ((0)),
  riderid int,
  FOREIGN KEY (productid) REFERENCES ru_products (id),
  FOREIGN KEY (riderid) REFERENCES ru_users (id)
);

CREATE TABLE hshemile12.hshemile12.ru_reviews (
  id int PRIMARY KEY NOT NULL identity (1,1),
  reviwerid int,
  reviewedid int,
  tripid int,
  comment nvarchar(512),
  FOREIGN KEY (reviwerid) REFERENCES ru_users (id),
  FOREIGN KEY (reviewedid) REFERENCES ru_users (id),
  FOREIGN KEY (tripid) REFERENCES ru_trips (id)
);