CREATE TABLE USERS (
                       USERNAME VARCHAR(512) NOT NULL,
                       PASSWORD VARCHAR(1024) NOT NULL,
                       ENABLED SMALLINT,
                       PRIMARY KEY (USERNAME)
);
----------------------------------------------------------------------
CREATE TABLE AUTHORITIES (
                             USERNAME VARCHAR(512) NOT NULL,
                             AUTHORITY VARCHAR(128) NOT NULL,
                             FOREIGN KEY (USERNAME) REFERENCES USERS
);