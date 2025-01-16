  create sequence brands_seq start with 1 increment by 50;
  create sequence prices_seq start with 1 increment by 50;
  create sequence products_seq start with 1 increment by 50;

    create table  if not exists brands (
        created_at timestamp(6),
        id bigint not null,
        updated_at timestamp(6),
        name varchar(255) not null unique,
        primary key (id)
    );

    create table  if not exists prices (
            price numeric(38,2) not null,
            price_list tinyint not null check (price_list between 0 and 4),
            priority integer not null,
            brand_id bigint,
            created_at timestamp(6),
            end_date timestamp(6) not null,
            id bigint not null,
            product_id bigint,
            start_date timestamp(6) not null,
            updated_at timestamp(6),
            curr enum ('COP','EUR','USD') not null,
            primary key (id)
        );

            create table  if not exists products (
                unit_price numeric(38,2),
                code bigint not null unique,
                created_at timestamp(6),
                id bigint not null,
                updated_at timestamp(6),
                description varchar(255),
                image varchar(255),
                name varchar(255) not null unique,
                provider varchar(255),
                primary key (id)
            );

alter table if exists prices
       add constraint FKtfkvp7f37rned2mybilsmh5m5
       foreign key (brand_id)
       references brands;

 alter table if exists prices
        add constraint FKhpva2t51a39twh6gdkxdcllyf
        foreign key (product_id)
        references products;

insert into brands (id, created_at, name)
values (1, NOW(), 'ZARA');
insert into brands (id, created_at, name)
values (2, NOW(), 'Marca 2');

insert into products (id, code, created_at, description, image, name, provider, unit_price)
values (1, 35455, NOW(), 'Producto 1', '', 'Producto 1', 'Provider', 10);

insert into prices (id, created_at, curr, end_date, price_list, priority, start_date, price, brand_id, product_id)
values (1, NOW(), 'EUR', '2020-12-31T23:59:59', 1, 0, '2020-06-14T00:00:00', 35.50, 1, 1);

insert into prices (id, created_at, curr, end_date, price_list, priority, start_date, price, brand_id, product_id)
values (2, NOW(), 'EUR', '2020-06-14T18:30:00', 2, 1, '2020-06-14T15:00:00', 25.45, 1, 1);

insert into prices (id, created_at, curr, end_date, price_list, priority, start_date, price, brand_id, product_id)
values (3, NOW(), 'EUR', '2020-06-15T11:00:00', 3, 1, '2020-06-15T00:00:00', 30.50, 1, 1);

insert into prices (id, created_at, curr, end_date, price_list, priority, start_date, price, brand_id, product_id)
values (4, NOW(), 'EUR', '2020-12-31T23:59:59', 4, 1, '2020-06-15T16:00:00', 39.95, 1, 1);