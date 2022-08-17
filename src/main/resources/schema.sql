CREATE SCHEMA IF NOT EXISTS `aurosks` DEFAULT CHARACTER SET utf8;
USE `aurosks`;
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for Knowledge_Packages
-- ----------------------------

DROP TABLE IF EXISTS `knowledge_package`;
CREATE TABLE `knowledge_package` (
                                     `id` bigint(0) UNSIGNED NOT NULL AUTO_INCREMENT,
                                     `creation_date` date NOT NULL,
                                     `description` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                                     `title` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                                     PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for Knowledge_Package_Sets
-- ----------------------------

DROP TABLE IF EXISTS `knowledge_package_set`;
CREATE TABLE `knowledge_package_set` (
                                         `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
                                         `title` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                                         PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for Knowledge_Package_Sets_Knowledge_Packages
-- ----------------------------

DROP TABLE IF EXISTS `knowledge_package_set_knowledge_package`;
CREATE TABLE `knowledge_package_set_knowledge_package` (
                                                           `package_set_id` bigint UNSIGNED NOT NULL,
                                                           `package_id` bigint UNSIGNED NOT NULL,
                                                           PRIMARY KEY (`package_set_id`,`package_id`) USING BTREE,
                                                           INDEX `package_set_id`(`package_set_id`) USING BTREE,
                                                           INDEX `package_id`(`package_id`) USING BTREE,

                                                           CONSTRAINT `package_set_id` FOREIGN KEY (`package_set_id`) REFERENCES `knowledge_package_set` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
                                                           CONSTRAINT `package_id` FOREIGN KEY (`package_id`) REFERENCES `knowledge_package` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;