CREATE TABLE IF NOT EXISTS `cat_aspectos` (
	`id` int NOT NULL AUTO_INCREMENT,
	`nombre` varchar(550) NOT NULL,
	`descripcion` varchar(550) NOT NULL,
	`id_caracteristica` int NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE InnoDB,
  CHARSET utf8mb4,
  COLLATE utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `cat_caracteristica` (
	`id` int NOT NULL AUTO_INCREMENT,
	`nombre` varchar(300) NOT NULL,
	`descripcion` varchar(255),
	`id_factor` int NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE InnoDB,
  CHARSET utf8mb4,
  COLLATE utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `cat_cargo` (
	`id` int NOT NULL AUTO_INCREMENT,
	`nombre` varchar(45) NOT NULL,
	`descripcion` varchar(100),
	PRIMARY KEY (`id`)
) ENGINE InnoDB,
  CHARSET utf8mb4,
  COLLATE utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `cat_dependencia` (
	`id` int NOT NULL AUTO_INCREMENT,
	`nombre` varchar(45) NOT NULL,
	`descripcion` varchar(255),
	PRIMARY KEY (`id`)
) ENGINE InnoDB,
  CHARSET utf8mb4,
  COLLATE utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `cat_escala_calificacion` (
	`id` int NOT NULL AUTO_INCREMENT,
	`nombre` varchar(45) NOT NULL,
	`descripcion` varchar(255),
	`escalas` json NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE InnoDB,
  CHARSET utf8mb4,
  COLLATE utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `cat_escalafon` (
	`id` int NOT NULL AUTO_INCREMENT,
	`codigo` varchar(100) NOT NULL,
	`descripcion` varchar(255),
	PRIMARY KEY (`id`)
) ENGINE InnoDB,
  CHARSET utf8mb4,
  COLLATE utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `cat_estado` (
	`id` int NOT NULL AUTO_INCREMENT,
	`codigo` varchar(100) NOT NULL,
	`descripcion` varchar(100) NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE InnoDB,
  CHARSET utf8mb4,
  COLLATE utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `cat_factor` (
	`id` int NOT NULL AUTO_INCREMENT,
	`nombre` varchar(200) NOT NULL,
	`descripcion` varchar(200),
	PRIMARY KEY (`id`)
) ENGINE InnoDB,
  CHARSET utf8mb4,
  COLLATE utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `cat_nivel_formacion` (
	`id` int NOT NULL AUTO_INCREMENT,
	`codigo` varchar(100),
	`descripcion` varchar(255),
	PRIMARY KEY (`id`)
) ENGINE InnoDB,
  CHARSET utf8mb4,
  COLLATE utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `cat_publicacion_tipo` (
	`id` int NOT NULL AUTO_INCREMENT,
	`codigo` varchar(100) NOT NULL,
	`descripcion` varchar(255),
	PRIMARY KEY (`id`)
) ENGINE InnoDB,
  CHARSET utf8mb4,
  COLLATE utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `cat_resultado_aprendizaje` (
	`id` int NOT NULL AUTO_INCREMENT,
	`descripcion` varchar(50) NOT NULL,
	`id_programa` int NOT NULL,
	`codigo` varchar(100),
	PRIMARY KEY (`id`)
) ENGINE InnoDB,
  CHARSET utf8mb4,
  COLLATE utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `cat_rol` (
	`id` int NOT NULL AUTO_INCREMENT,
	`nombre` varchar(45) NOT NULL,
	`descripcion` varchar(45),
	PRIMARY KEY (`id`)
) ENGINE InnoDB,
  CHARSET utf8mb4,
  COLLATE utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `cat_tipo_asignatura` (
	`id` int NOT NULL AUTO_INCREMENT,
	`nombre` varchar(100) NOT NULL,
	`descripcion` varchar(255),
	PRIMARY KEY (`id`)
) ENGINE InnoDB,
  CHARSET utf8mb4,
  COLLATE utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `cat_tipo_fuente_informacion` (
	`id` int NOT NULL AUTO_INCREMENT,
	`nombre` varchar(45) NOT NULL,
	`descripcion` varchar(100),
	PRIMARY KEY (`id`)
) ENGINE InnoDB,
  CHARSET utf8mb4,
  COLLATE utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `cat_tipo_fuente_informacion_publico` (
	`id` int NOT NULL AUTO_INCREMENT,
	`nombre` varchar(45) NOT NULL,
	`descripcion` varchar(100),
	PRIMARY KEY (`id`)
) ENGINE InnoDB,
  CHARSET utf8mb4,
  COLLATE utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `cat_tipo_vinculacion` (
	`id` int NOT NULL AUTO_INCREMENT,
	`codigo` varchar(100) NOT NULL,
	`descripcion` varchar(255),
	PRIMARY KEY (`id`)
) ENGINE InnoDB,
  CHARSET utf8mb4,
  COLLATE utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `tbl_archivo` (
	`id` int NOT NULL AUTO_INCREMENT,
	`id_fuente_informacion` int NOT NULL,
	`nombre` varchar(100) NOT NULL,
	`link` varchar(500) NOT NULL,
	`nro_anexo` int NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE InnoDB,
  CHARSET utf8mb4,
  COLLATE utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `tbl_asignatura` (
	`id` int NOT NULL AUTO_INCREMENT,
	`nombre` varchar(100) NOT NULL,
	`creditos` int NOT NULL,
	`docencia_directa_practica` int NOT NULL,
	`docencia_directa_teorica` int NOT NULL,
	`docencia_ind_practica` int NOT NULL,
	`docencia_ind_teorica` int NOT NULL,
	`area_formacion` varchar(255) NOT NULL,
	`id_tipo_asignatura` int NOT NULL,
	`id_asignatura_semestre` int NOT NULL,
	`id_plan_estudio` int NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE InnoDB,
  CHARSET utf8mb4,
  COLLATE utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `tbl_asignatura_semestre` (
	`id` int NOT NULL AUTO_INCREMENT,
	`nombre` varchar(100) NOT NULL,
	`descripcion` varchar(255),
	PRIMARY KEY (`id`)
) ENGINE InnoDB,
  CHARSET utf8mb4,
  COLLATE utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `tbl_calificacion` (
	`id` int NOT NULL AUTO_INCREMENT,
	`grado_cumplimiento` varchar(100) NOT NULL,
	`cal_letra` varchar(1),
	`cal_numerica_desde` float,
	`cal_numerica_hasta` float,
	`val_porcentaje_desde` int,
	`val_porcentaje_hasta` int,
	`id_proceso` int NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE InnoDB,
  CHARSET utf8mb4,
  COLLATE utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `tbl_comite_programa` (
	`id` int NOT NULL AUTO_INCREMENT,
	`nombre_miembro` varchar(100) NOT NULL,
	`id_cargo` int NOT NULL,
	`id_programa` int NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE InnoDB,
  CHARSET utf8mb4,
  COLLATE utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `tbl_cronograma_actividades` (
	`id` int NOT NULL AUTO_INCREMENT,
	`nombre` varchar(45) NOT NULL,
	`descripcion` varchar(255) NOT NULL,
	`fecha_inicio` date NOT NULL,
	`fecha_fin` date NOT NULL,
	`id_programa` int NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE InnoDB,
  CHARSET utf8mb4,
  COLLATE utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `tbl_docente` (
	`id` int NOT NULL AUTO_INCREMENT,
	`titulos_pregrado` varchar(100) NOT NULL,
	`titulos_posgrado` varchar(100),
	`anios_experiencia_docente` int,
	`anios_experiencia_laboral` int,
	`experticia` varchar(100),
	`id_persona` int NOT NULL,
	`id_vinculacion` int NOT NULL,
	`id_escalafon` int,
	`id_programa` int NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE InnoDB,
  CHARSET utf8mb4,
  COLLATE utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `tbl_docente_publicacion` (
	`id` int NOT NULL AUTO_INCREMENT,
	`id_docente` int NOT NULL,
	`id_publicacion` int NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE InnoDB,
  CHARSET utf8mb4,
  COLLATE utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `tbl_evaluacion_caracteristica_factor` (
	`id` int NOT NULL AUTO_INCREMENT,
	`aspecto_1` int NOT NULL,
	`aspecto_2` int NOT NULL,
	`aspecto_3` int NOT NULL,
	`aspecto_4` int NOT NULL,
	`justificacion` varchar(255) NOT NULL,
	`id_caracteristica` int NOT NULL,
	`id_factor` int NOT NULL,
	`id_programa` int NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE InnoDB,
  CHARSET utf8mb4,
  COLLATE utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `tbl_evaluacion_caracteristica_factor` (
	`id` int NOT NULL AUTO_INCREMENT,
	`aspecto_1` int NOT NULL,
	`aspecto_2` int NOT NULL,
	`aspecto_3` int NOT NULL,
	`aspecto_4` int NOT NULL,
	`justificacion` varchar(255) NOT NULL,
	`id_caracteristica` int NOT NULL,
	`id_factor` int NOT NULL,
	`id_programa` int NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE InnoDB,
  CHARSET utf8mb4,
  COLLATE utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `tbl_evaluacion_global_factor` (
	`id` int NOT NULL AUTO_INCREMENT,
	`justificacion` varchar(255) NOT NULL,
	`hallazgos_fortalezas` varchar(255) NOT NULL,
	`hallazgos_debilidades` varchar(255) NOT NULL,
	`path_archivo_anexos` varchar(255) NOT NULL,
	`id_factor` int NOT NULL,
	`id_programa` int NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE InnoDB,
  CHARSET utf8mb4,
  COLLATE utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `tbl_fuente_informacion` (
	`id` int NOT NULL AUTO_INCREMENT,
	`descripcion` varchar(255) NOT NULL,
	`id_fuente_info_public` int,
	`id_tipo_fuente_info` int NOT NULL,
	`id_proceso` int NOT NULL,
	`documental` tinyint(1) NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE InnoDB,
  CHARSET utf8mb4,
  COLLATE utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `tbl_informacion_adicional` (
	`id` int NOT NULL AUTO_INCREMENT,
	`titulo` varchar(45) NOT NULL,
	`contenido` varchar(255) NOT NULL,
	`id_factor` int NOT NULL,
	`id_programa` int NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE InnoDB,
  CHARSET utf8mb4,
  COLLATE utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `tbl_pais` (
	`id` int NOT NULL AUTO_INCREMENT,
	`nombre` varchar(100) NOT NULL,
	`codigo` varchar(45),
	PRIMARY KEY (`id`)
) ENGINE InnoDB,
  CHARSET utf8mb4,
  COLLATE utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `tbl_persona` (
	`id` int NOT NULL AUTO_INCREMENT,
	`nombres` varchar(100) NOT NULL,
	`apellidos` varchar(100) NOT NULL,
	`correo` varchar(100),
	`telefono` varchar(45),
	PRIMARY KEY (`id`)
) ENGINE InnoDB,
  CHARSET utf8mb4,
  COLLATE utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `tbl_plan_estudio` (
	`id` int NOT NULL AUTO_INCREMENT,
	`descripcion` varchar(100),
	`fecha_actualizacion` date,
	`id_programa` int NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE InnoDB,
  CHARSET utf8mb4,
  COLLATE utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `tbl_ponderacion` (
	`id` int NOT NULL AUTO_INCREMENT,
	`ponderado` int,
	`justificacion` varchar(255),
	`id_factor` int,
	`id_caracteristica` int,
	`id_proceso` int NOT NULL,
	`id_aspecto` int,
	`calificacion` float,
	`evaluacion` float,
	`fortalezas` varchar(250),
	`debilidades` varchar(250),
	`justificacion_evaluacion` varchar(200),
	PRIMARY KEY (`id`)
) ENGINE InnoDB,
  CHARSET utf8mb4,
  COLLATE utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `tbl_proceso` (
	`id` int NOT NULL AUTO_INCREMENT,
	`fecha_inicio` date NOT NULL,
	`fecha_finalizacion` date,
	`id_programa` int NOT NULL,
	`id_estado` int NOT NULL,
	`activo` tinyint(1),
	PRIMARY KEY (`id`)
) ENGINE InnoDB,
  CHARSET utf8mb4,
  COLLATE utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `tbl_programa_academico` (
	`id` int NOT NULL AUTO_INCREMENT,
	`nombre` varchar(100) NOT NULL,
	`est_numero_aspirantes` int,
	`est_nro_estudiantes` int,
	`est_nro_egresados` int,
	`prof_nro_planta` int,
	`prof_nro_ocasionales_tc` int,
	`prof_nro_ocasionales_mt` int,
	`prof_nro_catedra` int,
	`nro_creditos_sin_csr` int,
	`nro_creditos_electivos_ce` int,
	`nro_creditos_susceptibles` int,
	`nro_modalidades_mg` int,
	`resena_historica` varchar(500),
	`recursos_infraestructura` varchar(500),
	`recursos_info_audiovisuales` varchar(500),
	`recursos_bibliograficos` varchar(500),
	`recursos_bibliotecas_facultad` varchar(500),
	`recursos_bibliotecas_universidad` varchar(500),
	`apreciacion_global_factores` varchar(500),
	`id_nivel_formacion` int,
	`id_escala_calificacion` int,
	`fecha_actualizacion` date,
	`metodologia` varchar(100),
	`objetivos` varchar(100),
	`est_total_estudiantes` int,
	`total_creditos` int,
	`alfa` float,
	`beta` float,
	`gamma` float,
	`delta` float,
	PRIMARY KEY (`id`)
) ENGINE InnoDB,
  CHARSET utf8mb4,
  COLLATE utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `tbl_publicacion` (
	`id` int NOT NULL AUTO_INCREMENT,
	`referencia_bibliografica` varchar(100) NOT NULL,
	`fecha` date NOT NULL,
	`id_publicacion_tipo` int NOT NULL,
	`activo` tinyint(1),
	PRIMARY KEY (`id`)
) ENGINE InnoDB,
  CHARSET utf8mb4,
  COLLATE utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `tbl_responsable_acreditacion` (
	`id` int NOT NULL AUTO_INCREMENT,
	`id_cargo` int NOT NULL,
	`id_programa` int NOT NULL,
	`nombre_responsable` varchar(100) NOT NULL,
	`telefono_responsable` varchar(100) NOT NULL,
	`correo_responsable` varchar(100) NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE InnoDB,
  CHARSET utf8mb4,
  COLLATE utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `tbl_responsable_plan_mejoramiento` (
	`id` int NOT NULL AUTO_INCREMENT,
	`nombre_responsable` varchar(100) NOT NULL,
	`id_cargo` int NOT NULL,
	`dependencia` varchar(100) NOT NULL,
	`id_programa` int NOT NULL,
	`telefono` varchar(50) NOT NULL,
	`correo` varchar(50) NOT NULL,
	`id_proceso` int NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE InnoDB,
  CHARSET utf8mb4,
  COLLATE utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `tbl_resultado_aprendizaje` (
	`id` int NOT NULL AUTO_INCREMENT,
	`id_asignatura` int,
	`id_docente` int,
	`id_cat_resultado_aprendizaje` int NOT NULL,
	`id_programa` int NOT NULL,
	`cumplimiento` tinyint(1),
	PRIMARY KEY (`id`)
) ENGINE InnoDB,
  CHARSET utf8mb4,
  COLLATE utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `tbl_usuario` (
	`id` int NOT NULL AUTO_INCREMENT,
	`correo` varchar(50) NOT NULL,
	`password` varchar(100) NOT NULL,
	`id_rol` int,
	`id_programa` int,
	PRIMARY KEY (`id`)
) ENGINE InnoDB,
  CHARSET utf8mb4,
  COLLATE utf8mb4_0900_ai_ci;

ALTER TABLE tbl_resultado_aprendizaje
ADD COLUMN id_proceso BIGINT;

ALTER TABLE tbl_resultado_aprendizaje
ADD FOREIGN KEY (id_proceso) REFERENCES tbl_proceso(id);

ALTER TABLE tbl_resultado_aprendizaje
ADD CONSTRAINT fk_resultado_aprendizaje_proceso
FOREIGN KEY (id_proceso) REFERENCES tbl_proceso(id);

ALTER TABLE `cat_resultado_aprendizaje`
ADD COLUMN id_proceso BIGINT;

ALTER TABLE cat_resultado_aprendizaje
ADD CONSTRAINT fk_cat_resultado_aprendizaje_proceso
FOREIGN KEY (id_proceso) REFERENCES tbl_proceso(id);

ALTER TABLE `tbl_comite_programa`
ADD COLUMN id_proceso BIGINT;

ALTER TABLE tbl_comite_programa
ADD CONSTRAINT fk_tbl_comite_programa_proceso
FOREIGN KEY (id_proceso) REFERENCES tbl_proceso(id);

ALTER TABLE `tbl_responsable_acreditacion`
ADD COLUMN id_proceso BIGINT;

ALTER TABLE tbl_responsable_acreditacion
ADD CONSTRAINT fk_tbl_responsable_acreditacion_proceso
FOREIGN KEY (id_proceso) REFERENCES tbl_proceso(id);

ALTER TABLE `tbl_cronograma_actividades`
ADD COLUMN id_proceso BIGINT;

ALTER TABLE tbl_responsable_acreditacion
ADD CONSTRAINT fk_tbl_cronograma_actividades_proceso
FOREIGN KEY (id_proceso) REFERENCES tbl_proceso(id);