USE `base_db`;

DROP TABLE if exists `base_db`.`user`;
CREATE TABLE `base_db`.`user`
(
    `id`     INT          NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(100) NOT NULL,
    `created_at` DATETIME,
    `updated_at` DATETIME,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC)
);
