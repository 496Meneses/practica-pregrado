
CREATE TABLE `tbl_publicacion` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `activo` bit(1) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `id_publicacion_tipo` bigint DEFAULT NULL,
  `referencia_bibliografica` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `tbl_persona` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `apellidos` varchar(255) DEFAULT NULL,
  `correo` varchar(255) DEFAULT NULL,
  `nombres` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `tbl_programa_academico` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `alfa` decimal(19,2) DEFAULT NULL,
  `apreciacion_global_factores` varchar(255) DEFAULT NULL,
  `beta` decimal(19,2) DEFAULT NULL,
  `delta` decimal(19,2) DEFAULT NULL,
  `est_numero_aspirantes` int DEFAULT NULL,
  `est_nro_egresados` int DEFAULT NULL,
  `est_nro_estudiantes` int DEFAULT NULL,
  `fecha_actualizacion` date DEFAULT NULL,
  `gamma` decimal(19,2) DEFAULT NULL,
  `id_escala_calificacion` bigint DEFAULT NULL,
  `id_nivel_formacion` bigint DEFAULT NULL,
  `metodologia` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `est_total_estudiantes` int DEFAULT NULL,
  `nro_creditos_electivos_ce` int DEFAULT NULL,
  `nro_creditos_susceptibles` int DEFAULT NULL,
  `nro_creditos_sin_csr` int DEFAULT NULL,
  `nro_modalidades_mg` int DEFAULT NULL,
  `objetivos` varchar(255) DEFAULT NULL,
  `prof_nro_ocasionales_mt` int DEFAULT NULL,
  `prof_nro_catedra` int DEFAULT NULL,
  `prof_nro_ocasionales_tc` int DEFAULT NULL,
  `prof_nro_planta` int DEFAULT NULL,
  `recursos_info_audiovisuales` varchar(255) DEFAULT NULL,
  `recursos_bibliograficos` varchar(255) DEFAULT NULL,
  `recursos_bibliotecas_facultad` varchar(255) DEFAULT NULL,
  `recursos_bibliotecas_universidad` varchar(255) DEFAULT NULL,
  `recursos_infraestructura` varchar(255) DEFAULT NULL,
  `resena_historica` varchar(255) DEFAULT NULL,
  `total_creditos` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `cat_factor` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `cat_caracteristica` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `id_factor` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3w4u8ocog4ulpr2wym5chrnmt` (`id_factor`),
  CONSTRAINT `FK3w4u8ocog4ulpr2wym5chrnmt` FOREIGN KEY (`id_factor`) REFERENCES `cat_factor` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `cat_aspectos` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(1000) DEFAULT NULL,
  `nombre` varchar(500) DEFAULT NULL,
  `id_caracteristica` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpnh6glb39atqro6hxgdj9yx7c` (`id_caracteristica`),
  CONSTRAINT `FKpnh6glb39atqro6hxgdj9yx7c` FOREIGN KEY (`id_caracteristica`) REFERENCES `cat_caracteristica` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `cat_cargo` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `cat_escala_calificacion` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `cat_escalafon` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `codigo` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `cat_estado` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `codigo` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `cat_nivel_formacion` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `codigo` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `cat_publicacion_tipo` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `codigo` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `cat_rol` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `cat_tipo_asignatura` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `cat_tipo_fuente_informacion` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `cat_tipo_fuente_informacion_publico` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `cat_tipo_vinculacion` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `codigo` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `tbl_proceso` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `activo` bit(1) DEFAULT NULL,
  `fecha_finalizacion` date DEFAULT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `id_estado` bigint DEFAULT NULL,
  `id_programa` bigint DEFAULT NULL,
  `justificacion_eval_programa` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKl8u8b5ok99o4mcrqtoi58uit2` (`id_estado`),
  KEY `FKt2u5f37ho90gahuvn895pmh8i` (`id_programa`),
  CONSTRAINT `FKl8u8b5ok99o4mcrqtoi58uit2` FOREIGN KEY (`id_estado`) REFERENCES `cat_estado` (`id`),
  CONSTRAINT `FKt2u5f37ho90gahuvn895pmh8i` FOREIGN KEY (`id_programa`) REFERENCES `tbl_programa_academico` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `tbl_fuente_informacion` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `documental` bit(1) DEFAULT NULL,
  `id_proceso` bigint DEFAULT NULL,
  `id_tipo_fuente_info` bigint DEFAULT NULL,
  `id_fuente_info_public` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3aidcmyydpyoppypmencsfmik` (`id_proceso`),
  KEY `FKsqfpaa8af81kh3y20uqn4lou` (`id_tipo_fuente_info`),
  KEY `FKiwat550aiwm8mbsfcvuwcbjus` (`id_fuente_info_public`),
  CONSTRAINT `FK3aidcmyydpyoppypmencsfmik` FOREIGN KEY (`id_proceso`) REFERENCES `tbl_proceso` (`id`),
  CONSTRAINT `FKiwat550aiwm8mbsfcvuwcbjus` FOREIGN KEY (`id_fuente_info_public`) REFERENCES `cat_tipo_fuente_informacion_publico` (`id`),
  CONSTRAINT `FKsqfpaa8af81kh3y20uqn4lou` FOREIGN KEY (`id_tipo_fuente_info`) REFERENCES `cat_tipo_fuente_informacion` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `tbl_archivo` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `link` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `nro_anexo` bigint DEFAULT NULL,
  `id_fuente_informacion` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcwxyhrrn1sd7m72bsf423lec4` (`id_fuente_informacion`),
  CONSTRAINT `FKcwxyhrrn1sd7m72bsf423lec4` FOREIGN KEY (`id_fuente_informacion`) REFERENCES `tbl_fuente_informacion` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `tbl_asignatura_semestre` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `tbl_plan_estudio` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `fecha_actualizacion` date DEFAULT NULL,
  `id_programa` bigint DEFAULT NULL,
  `id_proceso` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKohvcu624ekjnd2dh0wtivcdcs` (`id_programa`),
  KEY `FK8cqbma8dky7bifpoqoogy4sra` (`id_proceso`),
  CONSTRAINT `FK8cqbma8dky7bifpoqoogy4sra` FOREIGN KEY (`id_proceso`) REFERENCES `tbl_proceso` (`id`),
  CONSTRAINT `FKohvcu624ekjnd2dh0wtivcdcs` FOREIGN KEY (`id_programa`) REFERENCES `tbl_programa_academico` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `tbl_asignatura` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `area_formacion` varchar(255) DEFAULT NULL,
  `creditos` int DEFAULT NULL,
  `docencia_directa_practica` int DEFAULT NULL,
  `docencia_directa_teorica` int DEFAULT NULL,
  `docencia_ind_practica` int DEFAULT NULL,
  `docencia_ind_teorica` int DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `id_asignatura_semestre` bigint DEFAULT NULL,
  `id_plan_estudio` bigint DEFAULT NULL,
  `id_tipo_asignatura` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7hoay6kt4l3h0elu990rg5v6o` (`id_asignatura_semestre`),
  KEY `FK59h2ux15d94j8gn0y138bjcc2` (`id_plan_estudio`),
  KEY `FKohbalhr2ndyu0whiirj58ggnl` (`id_tipo_asignatura`),
  CONSTRAINT `FK59h2ux15d94j8gn0y138bjcc2` FOREIGN KEY (`id_plan_estudio`) REFERENCES `tbl_plan_estudio` (`id`),
  CONSTRAINT `FK7hoay6kt4l3h0elu990rg5v6o` FOREIGN KEY (`id_asignatura_semestre`) REFERENCES `tbl_asignatura_semestre` (`id`),
  CONSTRAINT `FKohbalhr2ndyu0whiirj58ggnl` FOREIGN KEY (`id_tipo_asignatura`) REFERENCES `cat_tipo_asignatura` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `tbl_comite_programa` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nombre_miembro` varchar(255) DEFAULT NULL,
  `id_cargo` bigint DEFAULT NULL,
  `id_programa` bigint DEFAULT NULL,
  `id_proceso` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjmhuvqduley1iocbxb6q8mkyp` (`id_cargo`),
  KEY `FK9if2t2qcieub3ndj2r8j2i5j2` (`id_programa`),
  KEY `fk_tbl_comite_programa_proceso` (`id_proceso`),
  CONSTRAINT `FK9if2t2qcieub3ndj2r8j2i5j2` FOREIGN KEY (`id_programa`) REFERENCES `tbl_programa_academico` (`id`),
  CONSTRAINT `fk_tbl_comite_programa_proceso` FOREIGN KEY (`id_proceso`) REFERENCES `tbl_proceso` (`id`),
  CONSTRAINT `FKjmhuvqduley1iocbxb6q8mkyp` FOREIGN KEY (`id_cargo`) REFERENCES `cat_cargo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `cat_resultado_aprendizaje` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `codigo` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `id_programa` bigint DEFAULT NULL,
  `id_proceso` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKls1dkvdvq96f2t4cg4akf3evo` (`id_programa`),
  KEY `fk_cat_resultado_aprendizaje_proceso` (`id_proceso`),
  CONSTRAINT `fk_cat_resultado_aprendizaje_proceso` FOREIGN KEY (`id_proceso`) REFERENCES `tbl_proceso` (`id`),
  CONSTRAINT `FKls1dkvdvq96f2t4cg4akf3evo` FOREIGN KEY (`id_programa`) REFERENCES `tbl_programa_academico` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `tbl_calificacion` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cal_letra` varchar(255) DEFAULT NULL,
  `cal_numerica_desde` decimal(19,2) DEFAULT NULL,
  `cal_numerica_hasta` decimal(19,2) DEFAULT NULL,
  `grado_cumplimiento` varchar(255) DEFAULT NULL,
  `val_porcentaje_desde` decimal(19,2) DEFAULT NULL,
  `val_porcentaje_hasta` decimal(19,2) DEFAULT NULL,
  `id_proceso` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK62tu0qkfk42i9dki49o753bi0` (`id_proceso`),
  CONSTRAINT `FK62tu0qkfk42i9dki49o753bi0` FOREIGN KEY (`id_proceso`) REFERENCES `tbl_proceso` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `tbl_cronograma_actividades` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `fecha_fin` date DEFAULT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `id_programa` bigint DEFAULT NULL,
  `id_proceso` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6ldha92xx8h48pk85qm1gi4t3` (`id_programa`),
  CONSTRAINT `FK6ldha92xx8h48pk85qm1gi4t3` FOREIGN KEY (`id_programa`) REFERENCES `tbl_programa_academico` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `tbl_docente` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `anios_experiencia_docente` int DEFAULT NULL,
  `anios_experiencia_laboral` int DEFAULT NULL,
  `experticia` varchar(255) DEFAULT NULL,
  `id_escalafon` bigint DEFAULT NULL,
  `id_vinculacion` bigint DEFAULT NULL,
  `titulos_posgrado` varchar(255) DEFAULT NULL,
  `titulos_pregrado` varchar(255) DEFAULT NULL,
  `id_persona` bigint DEFAULT NULL,
  `id_programa` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6g573fuisd6hmtopvou48w00r` (`id_persona`),
  KEY `FK8wdup2esn2r24k3sn2x07pnul` (`id_programa`),
  KEY `FK68t2pomh5470mwudvalpwuafq` (`id_escalafon`),
  KEY `FK174c0jevbdco5fndhj7mgwsh1` (`id_vinculacion`),
  CONSTRAINT `FK174c0jevbdco5fndhj7mgwsh1` FOREIGN KEY (`id_vinculacion`) REFERENCES `cat_tipo_vinculacion` (`id`),
  CONSTRAINT `FK68t2pomh5470mwudvalpwuafq` FOREIGN KEY (`id_escalafon`) REFERENCES `cat_escalafon` (`id`),
  CONSTRAINT `FK6g573fuisd6hmtopvou48w00r` FOREIGN KEY (`id_persona`) REFERENCES `tbl_persona` (`id`),
  CONSTRAINT `FK8wdup2esn2r24k3sn2x07pnul` FOREIGN KEY (`id_programa`) REFERENCES `tbl_programa_academico` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `tbl_docente_publicacion` (
  `id_docente` bigint NOT NULL,
  `id_publicacion` bigint NOT NULL,
  KEY `FKmg3x307m00u5l8rno3nvxgvql` (`id_publicacion`),
  KEY `FKhsiwkagm8cvojvbl82vhiv3ko` (`id_docente`),
  CONSTRAINT `FKhsiwkagm8cvojvbl82vhiv3ko` FOREIGN KEY (`id_docente`) REFERENCES `tbl_docente` (`id`),
  CONSTRAINT `FKmg3x307m00u5l8rno3nvxgvql` FOREIGN KEY (`id_publicacion`) REFERENCES `tbl_publicacion` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `tbl_ponderacion` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `calificacion` decimal(19,2) DEFAULT NULL,
  `debilidades` varchar(255) DEFAULT NULL,
  `evaluacion` decimal(19,2) DEFAULT NULL,
  `fortalezas` varchar(255) DEFAULT NULL,
  `justificacion` varchar(255) DEFAULT NULL,
  `justificacion_evaluacion` varchar(255) DEFAULT NULL,
  `ponderado` bigint DEFAULT NULL,
  `id_aspecto` bigint DEFAULT NULL,
  `id_caracteristica` bigint DEFAULT NULL,
  `id_factor` bigint DEFAULT NULL,
  `id_proceso` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKk0871au0bqpoi6hm9hj4vboh4` (`id_aspecto`),
  KEY `FKgd1adv73wbdbi7yom2myv8mho` (`id_caracteristica`),
  KEY `FKnp1p2rwf8cgmwwnvxpwv92vu7` (`id_factor`),
  KEY `FKoyaq0occa7r1nao279vwjxx3v` (`id_proceso`),
  CONSTRAINT `FKgd1adv73wbdbi7yom2myv8mho` FOREIGN KEY (`id_caracteristica`) REFERENCES `cat_caracteristica` (`id`),
  CONSTRAINT `FKk0871au0bqpoi6hm9hj4vboh4` FOREIGN KEY (`id_aspecto`) REFERENCES `cat_aspectos` (`id`),
  CONSTRAINT `FKnp1p2rwf8cgmwwnvxpwv92vu7` FOREIGN KEY (`id_factor`) REFERENCES `cat_factor` (`id`),
  CONSTRAINT `FKoyaq0occa7r1nao279vwjxx3v` FOREIGN KEY (`id_proceso`) REFERENCES `tbl_proceso` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



CREATE TABLE `tbl_responsable_acreditacion` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `correo_responsable` varchar(255) DEFAULT NULL,
  `nombre_responsable` varchar(255) DEFAULT NULL,
  `telefono_responsable` varchar(255) DEFAULT NULL,
  `id_cargo` bigint DEFAULT NULL,
  `id_programa` bigint DEFAULT NULL,
  `id_proceso` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqh1byojxhjfi12clkki41wr26` (`id_cargo`),
  KEY `FKfn6bn2wid2r65tqp791pthp2r` (`id_programa`),
  KEY `fk_tbl_cronograma_actividades_proceso` (`id_proceso`),
  CONSTRAINT `fk_tbl_cronograma_actividades_proceso` FOREIGN KEY (`id_proceso`) REFERENCES `tbl_proceso` (`id`),
  CONSTRAINT `fk_tbl_responsable_acreditacion_proceso` FOREIGN KEY (`id_proceso`) REFERENCES `tbl_proceso` (`id`),
  CONSTRAINT `FKfn6bn2wid2r65tqp791pthp2r` FOREIGN KEY (`id_programa`) REFERENCES `tbl_programa_academico` (`id`),
  CONSTRAINT `FKqh1byojxhjfi12clkki41wr26` FOREIGN KEY (`id_cargo`) REFERENCES `cat_cargo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `tbl_responsable_plan_mejoramiento` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `correo` varchar(255) DEFAULT NULL,
  `dependencia` varchar(255) DEFAULT NULL,
  `nombre_responsable` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `id_cargo` bigint DEFAULT NULL,
  `id_proceso` bigint DEFAULT NULL,
  `id_programa` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKltsv487ear4ak9slygehpsbhd` (`id_cargo`),
  KEY `FK37at5rc0i8vq7b288v2cxhtb9` (`id_proceso`),
  KEY `FKcctko3c1xra8lwcyss3qe0q9d` (`id_programa`),
  CONSTRAINT `FK37at5rc0i8vq7b288v2cxhtb9` FOREIGN KEY (`id_proceso`) REFERENCES `tbl_proceso` (`id`),
  CONSTRAINT `FKcctko3c1xra8lwcyss3qe0q9d` FOREIGN KEY (`id_programa`) REFERENCES `tbl_programa_academico` (`id`),
  CONSTRAINT `FKltsv487ear4ak9slygehpsbhd` FOREIGN KEY (`id_cargo`) REFERENCES `cat_cargo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `tbl_resultado_aprendizaje` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cumplimiento` bit(1) DEFAULT NULL,
  `id_asignatura` bigint DEFAULT NULL,
  `id_cat_resultado_aprendizaje` bigint DEFAULT NULL,
  `id_docente` bigint DEFAULT NULL,
  `id_programa` bigint DEFAULT NULL,
  `id_proceso` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKs2ium7qb17o2fd9rtevckj5ii` (`id_asignatura`),
  KEY `FKuf2jkjjxjo7dj1ylsl5p3ca4` (`id_cat_resultado_aprendizaje`),
  KEY `FKdvuw7yshp2bf38f19uq4fh5lx` (`id_docente`),
  KEY `FK70m0l7bfvc8by71qdkrufr64j` (`id_programa`),
  KEY `fk_resultado_aprendizaje_proceso` (`id_proceso`),
  CONSTRAINT `FK70m0l7bfvc8by71qdkrufr64j` FOREIGN KEY (`id_programa`) REFERENCES `tbl_programa_academico` (`id`),
  CONSTRAINT `fk_resultado_aprendizaje_proceso` FOREIGN KEY (`id_proceso`) REFERENCES `tbl_proceso` (`id`),
  CONSTRAINT `FKdvuw7yshp2bf38f19uq4fh5lx` FOREIGN KEY (`id_docente`) REFERENCES `tbl_docente` (`id`),
  CONSTRAINT `FKs2ium7qb17o2fd9rtevckj5ii` FOREIGN KEY (`id_asignatura`) REFERENCES `tbl_asignatura` (`id`),
  CONSTRAINT `FKuf2jkjjxjo7dj1ylsl5p3ca4` FOREIGN KEY (`id_cat_resultado_aprendizaje`) REFERENCES `cat_resultado_aprendizaje` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `tbl_usuario` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `correo` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `id_programa` bigint DEFAULT NULL,
  `id_rol` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3i6u22m4wm4r9v6ihtqplqbft` (`id_programa`),
  KEY `FKiuegn5gdxsw2sao6noil1yc7b` (`id_rol`),
  CONSTRAINT `FK3i6u22m4wm4r9v6ihtqplqbft` FOREIGN KEY (`id_programa`) REFERENCES `tbl_programa_academico` (`id`),
  CONSTRAINT `FKiuegn5gdxsw2sao6noil1yc7b` FOREIGN KEY (`id_rol`) REFERENCES `cat_rol` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
