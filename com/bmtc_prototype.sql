CREATE TABLE IF NOT EXISTS `bmtc_prototype`.`bus_stop` (
  `bus_stop_id` INT NOT NULL,
  `bus_stop_name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`bus_stop_id`),
  UNIQUE INDEX `bus_stop_id_UNIQUE` (`bus_stop_id` ASC),
  UNIQUE INDEX `bus_stop_UNIQUE` (`bus_stop_name` ASC))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `bmtc_prototype`.`routes` (
  `route_no` VARCHAR(10) NOT NULL,
  `total_bus_stops` INT NULL,
  `origin_bus_stop_id` INT NOT NULL,
  `destination_bus_stop_id` INT NOT NULL,
  `distance` DECIMAL(8,5) NULL,
  PRIMARY KEY (`route_no`),
  UNIQUE INDEX `route_no_UNIQUE` (`route_no` ASC),
  INDEX `fk_1_idx` (`origin_bus_stop_id` ASC),
  INDEX `fk_2_idx` (`destination_bus_stop_id` ASC),
  CONSTRAINT `fk_1`
    FOREIGN KEY (`origin_bus_stop_id`)
    REFERENCES `bmtc_prototype`.`bus_stop` (`bus_stop_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_2`
    FOREIGN KEY (`destination_bus_stop_id`)
    REFERENCES `bmtc_prototype`.`bus_stop` (`bus_stop_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `bmtc_prototype`.`schedules` (
  `schedules_id` INT NOT NULL AUTO_INCREMENT,
  `route_no` VARCHAR(10) NOT NULL,
  `departure_from_origin` VARCHAR(1000) NOT NULL,
  `arrival_at_destination` VARCHAR(1000) NOT NULL,
  `duration` INT NOT NULL,
  PRIMARY KEY (`schedules_id`),
  UNIQUE INDEX `schedules_id_UNIQUE` (`schedules_id` ASC),
  INDEX `fk_schedules_1_idx` (`route_no` ASC),
  CONSTRAINT `fk_schedules_1`
    FOREIGN KEY (`route_no`)
    REFERENCES `bmtc_prototype`.`routes` (`route_no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE `bus_fare` (
  `fare_stage_number` int(11) NOT NULL,
  `adult` decimal(10,0) DEFAULT NULL,
  `child` decimal(10,0) DEFAULT NULL,
  `senior_citizen` decimal(10,0) DEFAULT NULL, created_on Datetime,
  PRIMARY KEY (`fare_stage_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
