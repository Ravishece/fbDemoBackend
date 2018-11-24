create table friendsvote
(
   orderId varchar(255) not null,
   productId varchar(255) not null,
   friendId varchar(255) not null
);

create table orderdetails
(
   orderId varchar(255) not null,
   voteQualifyCount int not null,
   voteCount int default 0,
   checkoutstatus int default 0,
   primary key(orderId)
);