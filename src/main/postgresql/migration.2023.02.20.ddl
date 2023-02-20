CREATE TABLE tg_user
(
    id          BIGSERIAL PRIMARY KEY,
    ref_id      BIGINT UNIQUE NOT NULL,
    create_date TIMESTAMP     NOT NULL DEFAULT now()
);

CREATE TABLE tg_chat
(
    id          BIGSERIAL PRIMARY KEY,
    ref_id      BIGINT        NOT NULL UNIQUE,
    ref_name    TEXT          NOT NULL,
    tg_user_id  BIGINT UNIQUE NULL REFERENCES tg_user,
    create_date TIMESTAMP     NOT NULL DEFAULT now()
);

CREATE TYPE device_status AS ENUM ('online', 'offline');
CREATE TABLE device
(
    id               BIGSERIAL PRIMARY KEY,
    serial_number    TEXT UNIQUE   NOT NULL,
    firmware_version TEXT          NULL,
    status           device_status NOT NULL,
    create_date      TIMESTAMP     NOT NULL DEFAULT now()
);

CREATE TABLE tg_user_device
(
    id          BIGSERIAL PRIMARY KEY,
    tg_user_id  BIGINT UNIQUE NOT NULL REFERENCES tg_user,
    device_id   BIGINT UNIQUE NOT NULL REFERENCES device,
    name        TEXT          NULL,
    create_date TIMESTAMP     NOT NULL DEFAULT now(),
    UNIQUE (tg_user_id, device_id),
    UNIQUE (tg_user_id, name)
);

CREATE TABLE device_subscription
(
    id          BIGSERIAL PRIMARY KEY,
    device_id   BIGINT UNIQUE NOT NULL REFERENCES device,
    tg_chat_id  BIGINT UNIQUE NOT NULL REFERENCES tg_chat,
    create_date TIMESTAMP     NOT NULL DEFAULT now(),
    UNIQUE (device_id, tg_chat_id)
);
