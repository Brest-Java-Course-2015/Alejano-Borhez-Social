INSERT INTO USER (
    userId,
    firstName,
    lastName,
    age,
    login,
    password,
    updatedDate)
VALUES (
    1,
    'Alexander',
    'Borohov',
    29,
    'alejano_borhez',
    '123456',
    TO_TIMESTAMP('24/10/2015 20:30:00', 'DD/MM/YYYY HH:MI:SS')
);

INSERT INTO USER (
    userId,
    firstName,
    lastName,
    age,
    login,
    password,
    updatedDate)
VALUES (
2,
'Julia',
'Borohova',
26,
'julia_borohova',
'123456',
TO_TIMESTAMP('24/10/2015 20:30:00', 'DD/MM/YYYY HH:MI:SS')
);

INSERT INTO USER (
userId,
firstName,
lastName,
age,
login,
password,
updatedDate)
VALUES (
3,
'Darya',
'Borohova',
2,
'darya_borohova',
'123456',
TO_TIMESTAMP('24/10/2015 20:30:00', 'DD/MM/YYYY HH:MI:SS')
);

INSERT INTO USER (
    userId,
    firstName,
    lastName,
    age,
    login,
    password,
    updatedDate)
VALUES (
    4,
    'Ivan',
    'Ivanov',
    25,
    'ivan',
    '123456',
    TO_TIMESTAMP('24/10/2015 20:30:00', 'DD/MM/YYYY HH:MI:SS')
);

INSERT INTO FRIENDS (
friend1Id,
friend2Id
)
VALUES(
1,
2
);

INSERT INTO FRIENDS (
friend1Id,
friend2Id
)
VALUES(
2,
1
);

INSERT INTO FRIENDS (
friend1Id,
friend2Id
)
VALUES(
1,
3
);

INSERT INTO FRIENDS (
friend1Id,
friend2Id
)
VALUES(
3,
1
);

INSERT INTO FRIENDS (
friend1Id,
friend2Id
)
VALUES(
2,
3
);

INSERT INTO FRIENDS (
friend1Id,
friend2Id
)
VALUES(
3,
2
);

INSERT INTO FRIENDS (
friend1Id,
friend2Id
)
VALUES(
1,
4
);

INSERT INTO FRIENDS (
friend1Id,
friend2Id
)
VALUES(
4,
1
);