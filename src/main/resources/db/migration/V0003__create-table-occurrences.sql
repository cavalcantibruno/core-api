CREATE TABLE occurrences (
     id bigint not null auto_increment,
     delivery_id bigint not null,
     description text not null,
     date_registration datetime not null,

     primary key (id)
);

alter table occurrences add constraint fk_occurrences_delivery
    foreign key (delivery_id) references delivery (id);