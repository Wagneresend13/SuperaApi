CREATE TABLE product (
  id bigint primary key not null  AUTO_INCREMENT,
  name varchar(255) NOT NULL,
  price double(13,2) NOT NULL,
  score double DEFAULT NULL,
  image varchar(255) NOT NULL
  
);




insert into product values (312,'@Super Mario Odyssey',197.88,100,'super-mario-odyssey.png')
insert into product values (201,'Call Of Duty Infinite Warfare',49.99,80,'call-of-duty-infinite-warfare.png')
insert into product values (102,'The Witcher III Wild Hunt',119.5,250,'the-witcher-iii-wild-hunt.png')
insert into product values (99,'Call Of Duty WWII',249.99,205,'call-of-duty-wwii.png')
insert into product values (12,'Mortal Kombat XL',69.99,150,'mortal-kombat-xl.png')
insert into product values (74,'Shards of Darkness',71.94,400,'shards-of-darkness.png')
insert into product values (31,'Terra Média: Sombras de Mordor',79.99,50,'terra-media-sombras-de-mordor.png')
insert into product values (420,'FIFA 18',195.39,325,'fifa-18.png')
insert into product values (501,'Horizon Zero Dawn',115.8,290,'horizon-zero-dawn.png