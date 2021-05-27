CREATE DOMAIN uint64 AS bigint CHECK(VALUE >= 0 AND VALUE <= 9223372036854775807);
CREATE DOMAIN uint32 AS integer CHECK(VALUE >= 0 AND VALUE <= 2147483647);
CREATE DOMAIN uint16 AS smallint CHECK(VALUE >= 0 AND VALUE <= 32767);


CREATE TABLE User_data (
	user_id uint64 PRIMARY KEY,
	user_first_name char(50),
	user_last_name char (50),
	username char(50) NOT NULL UNIQUE
);

CREATE TABLE Messages (
	user_id uint64 REFERENCES User_data (user_id) ON DELETE CASCADE,
	message_unix_time uint32 NOT NULL,
	message_text char(1024)
);

CREATE TABLE User_notifications (
	user_id uint64 REFERENCES User_data (user_id) ON DELETE CASCADE,
	user_unix_time uint32 NOT NULL
);

CREATE TABLE Weather (
	weather_id uint64 PRIMARY KEY,
	weather_city char(50),
	weather_unix_time uint32 NOT NULL
);
