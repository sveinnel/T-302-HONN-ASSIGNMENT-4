insert into ru_products (description,
                        displayname,
                        capacity,
                        imageurl,
                        driverid,
                        priceid)
values(
    'Nice Yellow cab',
    'BicketMobile',
    3,
    'http://d1oi7t5trwfj5d.cloudfront.net/f7/c7/6d789759445f87ab6ccad153bc00/taxi-driver.jpg',
    1,
    1
)
insert into ru_products (description,
                        displayname,
                        capacity,
                        imageurl,
                        driverid,
                        priceid)
values(
    'Nice Blue cab',
    'Blue Taxi',
    3,
    'http://d1oi7t5trwfj5d.cloudfront.net/f7/c7/6d789759445f87ab6ccad153bc00/taxi-driver.jpg',
    1,
    1
)insert into ru_products (description,
                        displayname,
                        capacity,
                        imageurl,
                        driverid,
                        priceid)
values(
    'Nice Red cab',
    'Red taxi',
    3,
    'http://d1oi7t5trwfj5d.cloudfront.net/f7/c7/6d789759445f87ab6ccad153bc00/taxi-driver.jpg',
    1,
    1
)insert into ru_products (description,
                        displayname,
                        capacity,
                        imageurl,
                        driverid,
                        priceid)
values(
    'Nice Green cab',
    'Green taxi',
    3,
    'http://d1oi7t5trwfj5d.cloudfront.net/f7/c7/6d789759445f87ab6ccad153bc00/taxi-driver.jpg',
    1,
    1
)insert into ru_products (description,
                        displayname,
                        capacity,
                        imageurl,
                        driverid,
                        priceid)
values(
    'Nice Orange cab',
    'Orang Taxi',
    3,
    'http://d1oi7t5trwfj5d.cloudfront.net/f7/c7/6d789759445f87ab6ccad153bc00/taxi-driver.jpg',
    1,
    1
)insert into ru_products (description,
                        displayname,
                        capacity,
                        imageurl,
                        driverid,
                        priceid)
values(
    'Nice Black cab',
    'Black',
    3,
    'http://d1oi7t5trwfj5d.cloudfront.net/f7/c7/6d789759445f87ab6ccad153bc00/taxi-driver.jpg',
    1,
    1
)

insert into ru_trips(
  productid,
requesttime,
starttime,
endtime,
distance,
riderid)
values (
    1,
    '1976-10-10 10:10',
    '1976-10-10 10:15',
    '1976-10-10 11:00',
    66.0,
    2
  )

insert into ru_reviews(
    reviwerid,
    reviewedid,
    tripid,
    comment
)
values(
    2,
    1,
    1,
    'You talkin'' to me? You talkin'' to me? You talkin'' to me? Then who the hell else are you talking... you talking to me? Well I''m the only one here. Who the fuck do you think you''re talking to? Oh yeah? OK.'
  )





select * from ru_trips

select * from ru_products

select * from ru_prices

select * from ru_users

select * from ru_reviews

