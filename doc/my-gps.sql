CREATE SCHEMA IF NOT EXISTS `gps` DEFAULT CHARACTER SET utf8mb4;

-- 车辆信息

CREATE TABLE IF NOT EXISTS `gps`.`gps_info`
(
    `id`         BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
    `gps_no`     BIGINT(20)          NOT NULL COMMENT '记录唯一编号',
    `vehicle_no` BIGINT(20) UNSIGNED NOT NULL COMMENT '车辆id',
    `alarm_mark` INT(11) UNSIGNED    NOT NULL COMMENT '报警标志',
    `status_bit` INT(11) UNSIGNED    NOT NULL COMMENT '状态位',
    `latitude`   INT(11) UNSIGNED    NOT NULL COMMENT '纬度',
    `longitude`  INT(11) UNSIGNED    NOT NULL COMMENT '经度',
    `height`     INT(11) UNSIGNED    NOT NULL COMMENT '高程',
    `speed`      INT(11) UNSIGNED    NOT NULL COMMENT '速度',
    `direction`  INT(11) UNSIGNED    NOT NULL COMMENT '方向',
    `time`       DATETIME(3)         NOT NULL COMMENT '时间',
    PRIMARY KEY (`id`),
    INDEX `idx_vehicle_no` (`vehicle_no` ASC)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COMMENT = 'GPS信息表';


CREATE TABLE IF NOT EXISTS `gps`.`common_alarm`
(
    `id`         BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
    `alarm_no`   BIGINT(20)          NOT NULL COMMENT '记录唯一编号',
    `vehicle_no` BIGINT(20) UNSIGNED NOT NULL COMMENT '车辆id',
    `alarm_type` INT(11) UNSIGNED    NOT NULL COMMENT '报警类型',
    `status_bit` INT(11) UNSIGNED    NOT NULL COMMENT '状态位',
    `time`       DATETIME(3)         NOT NULL COMMENT '时间',
    PRIMARY KEY (`id`),
    INDEX `idx_vehicle_no` (`vehicle_no` ASC)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COMMENT = '报警信息表';

CREATE TABLE IF NOT EXISTS `gps`.`active_alarm_0x64`
(
    `id`             BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
    `alarm_no`       BIGINT(20)          NOT NULL COMMENT '记录唯一编号(平台)',
    `vehicle_no`     BIGINT(20) UNSIGNED NOT NULL COMMENT '车辆id',
    `alarm_id`       INT(11) UNSIGNED    NOT NULL COMMENT '报警id',
    `mark_status`    INT(11) UNSIGNED    NOT NULL COMMENT '标志状态(0-不可用,1-开始标志,2-结束标志)',
    `alarm_type`     INT(11) UNSIGNED    NOT NULL COMMENT '报警类型',
    `alarm_level`    INT(11) UNSIGNED    NOT NULL COMMENT '报警级别(1-一级报警,2-二级报警)',
    `deviation_type` INT(11) UNSIGNED    NOT NULL COMMENT '偏离类型',
    `road_mark_type` INT(11) UNSIGNED    NOT NULL COMMENT '道路标志识别类型',
    `road_mark_data` INT(11) UNSIGNED    NOT NULL COMMENT '道路标志识别数据',
    `speed`          INT(11) UNSIGNED    NOT NULL COMMENT '车速',
    `height`         INT(11) UNSIGNED    NOT NULL COMMENT '高程',
    `latitude`       INT(11) UNSIGNED    NOT NULL COMMENT '纬度',
    `longitude`      INT(11) UNSIGNED    NOT NULL COMMENT '经度',
    `time`           DATETIME(3)         NOT NULL COMMENT '时间',
    `status_bit`     INT(11) UNSIGNED    NOT NULL COMMENT '状态位',
    `dev_id`         VARCHAR(50)         NOT NULL COMMENT '终端id',
    `mark_time`      DATETIME(3)         NOT NULL COMMENT '报警标志号中的时间',
    `mark_sequence`  INT(11)             NOT NULL COMMENT '报警标志号中的序号',
    `attachment_num` INT(11)             NOT NULL COMMENT '附件数量',
    `reserve`        INT(11)             NOT NULL COMMENT '预留',
    PRIMARY KEY (`id`),
    INDEX `idx_vehicle_no` (`vehicle_no` ASC),
    UNIQUE INDEX `dev_id_mark_time_mark_sequence_UNIQE` (`dev_id` ASC, `mark_time` ASC, `mark_sequence` ASC)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COMMENT = '0x64主动安全报警';

CREATE TABLE IF NOT EXISTS `gps`.`active_alarm_0x66`
(
    `id`             BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
    `alarm_no`       BIGINT(20)          NOT NULL COMMENT '记录唯一编号(平台)',
    `vehicle_no`     BIGINT(20) UNSIGNED NOT NULL COMMENT '车辆id',
    `alarm_id`       INT(11) UNSIGNED    NOT NULL COMMENT '报警id',
    `mark_status`    INT(11) UNSIGNED    NOT NULL COMMENT '标志状态(0-不可用,1-开始标志,2-结束标志)',
    `speed`          INT(11) UNSIGNED    NOT NULL COMMENT '车速',
    `height`         INT(11) UNSIGNED    NOT NULL COMMENT '高程',
    `latitude`       INT(11) UNSIGNED    NOT NULL COMMENT '纬度',
    `longitude`      INT(11) UNSIGNED    NOT NULL COMMENT '经度',
    `time`           DATETIME(3)         NOT NULL COMMENT '时间',
    `status_bit`     INT(11) UNSIGNED    NOT NULL COMMENT '状态位',
    `dev_id`         VARCHAR(50)         NOT NULL COMMENT '终端id',
    `mark_time`      DATETIME(3)         NOT NULL COMMENT '报警标志号中的时间',
    `mark_sequence`  INT(11)             NOT NULL COMMENT '报警标志号中的序号',
    `attachment_num` INT(11)             NOT NULL COMMENT '附件数量',
    `reserve`        INT(11)             NOT NULL COMMENT '预留',
    `event_num`      INT(11) UNSIGNED    NOT NULL COMMENT '报警时间列表总数',
    `event_list`     VARCHAR(255) DEFAULT NULL COMMENT '事件列表(json list)',
    PRIMARY KEY (`id`),
    INDEX `idx_vehicle_no` (`vehicle_no` ASC),
    UNIQUE INDEX `dev_id_mark_time_mark_sequence_UNIQE` (`dev_id` ASC, `mark_time` ASC, `mark_sequence` ASC)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COMMENT = '0x66主动安全报警';
