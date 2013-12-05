# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table paste (
  id                        bigint not null,
  guid                      varchar(255),
  content                   TEXT,
  date_created              timestamp,
  constraint pk_paste primary key (id))
;

create sequence paste_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists paste;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists paste_seq;

