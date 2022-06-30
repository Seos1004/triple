-- triple_traveler.code_d definition

CREATE TABLE `code_d` (
  `CD_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CM_ID` int(11) NOT NULL,
  `CD_CD` varchar(100) DEFAULT NULL,
  `CD_NM` varchar(100) DEFAULT NULL,
  `CD_ORDER` int(11) DEFAULT NULL,
  `CD_USE_YN` varchar(100) DEFAULT NULL,
  `CD_CREATE_ID` varchar(100) DEFAULT NULL,
  `CD_CREATE_DATE` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`CD_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='코드 디테일';

-- triple_traveler.code_m definition

CREATE TABLE `code_m` (
  `CM_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CM_GROUP_ID` varchar(100) NOT NULL,
  `CM_NM` varchar(100) NOT NULL,
  `CM_CREATE_DATE` datetime DEFAULT CURRENT_TIMESTAMP,
  `CM_CREATE_ID` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`CM_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='코드 마스터 테이블';

-- triple_traveler.place definition

CREATE TABLE `place` (
  `PLACE_ID` varchar(36) NOT NULL,
  `PLACE_NAME` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`PLACE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='장소 테이블';

-- triple_traveler.point_d definition

CREATE TABLE `point_d` (
  `PD_ID` int(11) NOT NULL AUTO_INCREMENT,
  `PM_ID` int(11) NOT NULL,
  `USER_ID` varchar(36) NOT NULL,
  `PD_POINT` int(11) DEFAULT NULL,
  `PD_SYSTEM_TYPE` varchar(100) DEFAULT NULL,
  `CREATE_DATE` datetime DEFAULT CURRENT_TIMESTAMP,
  `PD_POINT_TYPE` varchar(100) DEFAULT NULL,
  `REVIEW_ID` varchar(36) NOT NULL,
  `PLACE_ID` varchar(36) NOT NULL,
  PRIMARY KEY (`PD_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 COMMENT='포인트 디테일 테이블';

-- triple_traveler.point_m definition

CREATE TABLE `point_m` (
  `PM_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_ID` varchar(36) NOT NULL,
  `UPDATE_DATE` datetime DEFAULT NULL,
  `PM_POINT` int(11) DEFAULT '0',
  `CREATE_DATE` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`PM_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='포인트 마스터 테이블';

-- triple_traveler.review definition

CREATE TABLE `review` (
  `REVIEW_ID` varchar(36) NOT NULL,
  `REVIEW_CONTENT` mediumtext,
  `USER_ID` varchar(36) NOT NULL,
  `ATTACHED_PHOTO_IDS` mediumtext,
  `PLACE_ID` varchar(36) NOT NULL,
  `REVIEW_DELETE_YN` varchar(1) DEFAULT 'N',
  `UPDATE_DATE` datetime DEFAULT NULL,
  `CREATE_DATE` datetime DEFAULT CURRENT_TIMESTAMP,
  `DELETE_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`REVIEW_ID`,`USER_ID`,`PLACE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='리뷰 테이블';

-- triple_traveler.`user` definition

CREATE TABLE `user` (
  `USER_ID` varchar(36) NOT NULL,
  `USER_NAME` varchar(100) DEFAULT NULL,
  `CREATE_DATE` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`USER_ID`),
  KEY `user_USER_ID_IDX` (`USER_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='사용자 테이블';






