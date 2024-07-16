create table answers(
    id bigint not null auto_increment,
    message varchar(2000) not null,
    topic_id bigint not null,
    created datetime not null,
    user_id bigint not null,
    solved boolean,
    score int,

    primary key(id),

    constraint fk_answers_topic_id foreign key(topic_id) references topics(id),
    constraint fk_answers_user_id foreign key(user_id) references users(id)
)