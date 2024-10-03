-- Insertar catalogo de roles
INSERT INTO cat_rol (nombre, descripcion) VALUES ('administrador', 'Rol de administrador con todos los permisos');
INSERT INTO cat_rol (nombre, descripcion) VALUES ('coordinador', 'Rol de coordinador con permisos limitados');

-- Insertar usuario administrador por defecto
INSERT INTO tbl_usuario (correo, password, id_rol) VALUES ('administrador@unicauca.edu.co', '$2a$10$YNHEExCPHbhgGByNSRJqhe23pBJcI7Gx4D2O12afjzm9kapuV24Lu', 1);

-- Insertar cat_factor

INSERT INTO cat_factor (nombre,descripcion) VALUES
	 ('Proyecto educativo del programa e identidad institucional','Proyecto educativo del programa e identidad institucional'),
	 ('Estudiantes','Estudiantes'),
	 ('Profesores','Profesores'),
	 ('Egresados','Egresados'),
	 ('Aspectos académicos y resultados de aprendizaje','Aspectos académicos y resultados de aprendizaje'),
	 ('Permanencia y graduación','Permanencia y graduación'),
	 ('Interacción con el entorno nacional e internacional','Interacción con el entorno nacional e internacional'),
	 ('Aportes de la investigación, la innovación, el desarrollo tecnológico y
la creación, asociados al programa académico.','Aportes de la investigación, la innovación, el desarrollo tecnológico y
la creación, asociados al programa académico.'),
	 ('Bienestar de la comunidad académica del programa','Bienestar de la comunidad académica del programa'),
	 ('Medios educativos y ambientes de aprendizaje','Medios educativos y ambientes de aprendizaje');
INSERT INTO cat_factor (nombre,descripcion) VALUES
	 ('Organización, administración y financiación del programa
académico','Organización, administración y financiación del programa
académico'),
	 ('Recursos físicos y tecnológicos','Recursos físicos y tecnológicos');


-- Insertar cat_caracteristica
INSERT INTO cat_caracteristica (nombre,descripcion,id_factor) VALUES
	 ('Proyecto educativo del Programa','Proyecto educativo del Programa',1),
	 ('Relevancia académica y pertinencia social del
Programa Académico','Relevancia académica y pertinencia social del
Programa Académico',1),
	 ('Participación en actividades de formación integral','Participación en actividades de formación integral',2),
	 ('Orientación y seguimiento a estudiantes.','Orientación y seguimiento a estudiantes.',2),
	 ('Capacidad de trabajo autónomo.','Capacidad de trabajo autónomo.',2),
	 ('Reglamento estudiantil y política académica.','Reglamento estudiantil y política académica.',2),
	 ('Estímulos y apoyos para estudiantes.','Estímulos y apoyos para estudiantes.',2),
	 ('Selección, vinculación y permanencia de profesores','Selección, vinculación y permanencia de profesores',3),
	 ('Estatuto profesoral','Estatuto profesoral',3),
	 ('Número, dedicación, nivel de formación y experiencia
de los profesores','Número, dedicación, nivel de formación y experiencia
de los profesores',3);
INSERT INTO cat_caracteristica (nombre,descripcion,id_factor) VALUES
	 ('Desarrollo profesoral','Desarrollo profesoral',3),
	 ('Estímulos a la trayectoria profesoral.','Estímulos a la trayectoria profesoral.',3),
	 ('Producción, pertinencia, utilización e impacto de
material docente','Producción, pertinencia, utilización e impacto de
material docente',3),
	 ('Remuneración por méritos','Remuneración por méritos',3),
	 ('Evaluación de profesores','Evaluación de profesores',3),
	 ('Seguimiento de los egresados','Seguimiento de los egresados',4),
	 ('Impacto de los egresados en el medio social y
académico','Impacto de los egresados en el medio social y
académico',4),
	 ('Integralidad de los aspectos curriculares','Integralidad de los aspectos curriculares',5),
	 ('Flexibilidad de los aspectos curriculares','Flexibilidad de los aspectos curriculares',5),
	 ('Interdisciplinariedad.','Interdisciplinariedad.',5);
INSERT INTO cat_caracteristica (nombre,descripcion,id_factor) VALUES
	 ('Estrategias pedagógicas','Estrategias pedagógicas',5),
	 ('Sistema de evaluación de estudiantes.','Sistema de evaluación de estudiantes.',5),
	 ('Resultados de aprendizaje','Resultados de aprendizaje',5),
	 ('Competencias','Competencias',5),
	 ('Evaluación y autorregulación del programa
académico.','Evaluación y autorregulación del programa
académico.',5),
	 ('Vinculación e interacción social','Vinculación e interacción social',5),
	 ('Políticas, estrategias y estructura para la
permanencia y la graduación','Políticas, estrategias y estructura para la
permanencia y la graduación',6),
	 ('Caracterización de estudiantes y sistema de alertas
tempranas','Caracterización de estudiantes y sistema de alertas
tempranas',6),
	 ('Ajustes a los aspectos curriculares','Ajustes a los aspectos curriculares',6),
	 ('Mecanismos de selección','Mecanismos de selección',6);
INSERT INTO cat_caracteristica (nombre,descripcion,id_factor) VALUES
	 ('Inserción del programa en contextos académicos
nacionales e internacionales.','Inserción del programa en contextos académicos
nacionales e internacionales.',7),
	 ('Relaciones externas de profesores y estudiantes','Relaciones externas de profesores y estudiantes',7),
	 ('Habilidades comunicativas en una segunda lengua','Habilidades comunicativas en una segunda lengua',7),
	 ('Formación para la investigación, desarrollo
tecnológico, la innovación y la creación','Formación para la investigación, desarrollo
tecnológico, la innovación y la creación',8),
	 ('Compromiso con la investigación, desarrollo
tecnológico, la innovación y la creación.','Compromiso con la investigación, desarrollo
tecnológico, la innovación y la creación.',8),
	 ('Programas y servicios','Programas y servicios',9),
	 ('Participación y seguimiento','Participación y seguimiento',9),
	 ('Estrategias y recursos de apoyo a profesores','Estrategias y recursos de apoyo a profesores',10),
	 ('Estrategias y recursos de apoyo a estudiantes.','Estrategias y recursos de apoyo a estudiantes.',10),
	 ('Recursos bibliográficos y de información','Recursos bibliográficos y de información',10);
INSERT INTO cat_caracteristica (nombre,descripcion,id_factor) VALUES
	 ('Organización y administración','Organización y administración',11),
	 ('Dirección y gestión','Dirección y gestión',11),
	 ('Sistemas de comunicación e información','Sistemas de comunicación e información',11),
	 ('Estudiantes y capacidad institucional','Estudiantes y capacidad institucional',11),
	 ('Financiación del programa académico','Financiación del programa académico',11),
	 ('Aseguramiento de la alta calidad y mejora continua.','Aseguramiento de la alta calidad y mejora continua.',11),
	 ('Recursos de infraestructura física y tecnológica','Recursos de infraestructura física y tecnológica',12),
	 ('Recursos informáticos y de comunicación','Recursos informáticos y de comunicación',12);

-- cat aspectos
INSERT INTO unicauca.cat_aspectos (nombre,descripcion,id_caracteristica) VALUES
	 ('factor_1','Demostrar coherencia del Proyecto Educativo del Programa (PEP) o el que haga sus veces, con los lineamientos y
políticas institucionales, así como en la definición de objetivos de formación y resultados de aprendizaje y
la manera cómo el PEP ha ido mejorando, como resultado de los procesos de aseguramiento de la calidad,
la consolidación de la identidad institucional
y la relación que mantiene con la comunidad y sus grupos de interés.',1),
	 ('factor_1','Análisis sobre las tendencias, necesidades y líneas de desarrollo de la disciplina o profesión, en el contexto regional, nacional e internacional.',2),
	 ('factor_1','Estudio de la pertinencia social del programa desde la perspectiva de la comunidad académica y de sus grupos
		de interés con el fin de identificar necesidades y requerimientos del entorno local, regional o
		nacional en términos productivos y de competitividad, tecnológicos, culturales, científicos y de talento humano.',2),
	 ('factor_1','Evidencia de las transformaciones sociales pertinentes para el contexto y el territorio en el que se ofrece el programa académico, y del entorno tanto nacional como internacional.',2);

INSERT INTO unicauca.cat_aspectos (nombre,descripcion,id_caracteristica) VALUES
('factor_2', 'Apreciación de los estudiantes en relación con su participación en las actividades de investigación,
desarrollo tecnológico, creación artística, culturales, deportivas y de extensión,
que contribuyen a su formación integral, junto con las acciones emprendidas como resultado de dichas apreciaciones.', 3),
('factor_2', 'Resultados del análisis de la participación y principales logros de los estudiantes en actividades de investigación,
desarrollo tecnológico, innovación, creación artística, culturales y deportivas.', 3),
('factor_2', 'Resultados del análisis de la participación y principales logros de los
estudiantes en proyectos de desarrollo empresarial, relacionamiento nacional e internacional.', 3),
('factor_2', 'Resultados del análisis de la participación y principales logros de los estudiantes
en otras acciones de formación complementaria, que promuevan la comprensión de la realidad social, la empatía, la ética,
habilidades blandas, así como el relacionamiento con otras culturas y lenguas,
de acuerdo con el nivel de formación y la modalidad del programa.', 3),
('factor_2', 'Evidencia de los efectos en la formación de los estudiantes,
a partir de los procesos de orientación y seguimiento de los estudiantes,
teniendo como referencia sus características de ingreso.', 4),
('factor_2', 'Evidencia de los resultados de las estrategias de seguimiento y
evaluación de los resultados de aprendizaje en el
desarrollo de capacidades para el del trabajo autónomo del estudiante.', 5),
('factor_2', 'Apreciación de estudiantes y profesores del programa sobre la pertinencia, vigencia y aplicación del reglamento estudiantil y las políticas académicas y,
sobre las estrategias de divulgación de dicha reglamentación, junto
con las acciones emprendidas como resultado de dichas apreciaciones', 6),
('factor_2', 'Evidencia de los mecanismos para la aplicación, actualización y divulgación del reglamento estudiantil.', 6),
('factor_2', 'Evidencia de los beneficios generados por el otorgamiento de estímulos académicos y apoyos socioeconómicos a los estudiantes.', 7),
('factor_2', 'Apreciación de los estudiantes del programa frente a la aplicación de los estímulos académicos y apoyos socioeconómicos, y el cumplimiento
institucional de estas medidas, junto con las acciones emprendidas como resultado de dichas apreciaciones.', 7);


INSERT INTO unicauca.cat_aspectos (nombre,descripcion,id_caracteristica) VALUES
('factor_3', 'Evidencia de la aplicación de los procesos de selección, vinculación y permanencia de los profesores,
en coherencia con el nivel de formación, modalidad del programa académico y lugar de desarrollo.', 8),
('factor_3', 'Apreciación de los profesores sobre la aplicación, pertinencia y vigencia de las políticas,
 normas y criterios académicos establecidos por la institución para su selección,
vinculación y permanencia, junto con las acciones emprendidas como resultado de dichas apreciaciones.', 8),
('factor_3', 'Evidencia que demuestren los resultados de la aplicación del estatuto profesoral, o
el que haga sus veces, sobre la trayectoria profesoral, la inclusión,
el reconocimiento de méritos y el ascenso en el escalafón, de acuerdo con el nivel de formación y la modalidad del programa.', 9),
('factor_3', 'Resultados en el mejoramiento de la calidad del programa, a partir de la aplicación de un estatuto que promueve
la trayectoria profesoral, la inclusión, el reconocimiento de los méritos y el ascenso en el escalafón.', 9),
('factor_3', 'Apreciación de los profesores sobre la aplicación y pertinencia del estatuto profesoral y de las políticas que establecen
distinciones, estímulos que promueven la trayectoria profesoral, junto con las acciones emprendidas como resultado de dichas apreciaciones.', 9),
('factor_3', 'Evidencia de la coherencia entre el número, dedicación, nivel de formación
y experiencia de los profesores de tiempo completo,
con el número de estudiantes, nivel de formación y modalidad del programa académico.', 10),
('factor_3', 'Evidencia de la existencia de un núcleo básico de profesores de tiempo completo,
preferiblemente con contratación a término indefinido, y su relación con la formación
de la comunidad académica del programa y el cumplimiento con alta calidad de las funciones esenciales del programa.', 10),
('factor_3', 'Evidencia de la vinculación de una planta profesoral pertinente con el área disciplinar del
 programa con título de especialista y experiencia pedagógica y profesional certificada en los campos de formación
 del programa, que garantice del logro de los resultados de aprendizaje de los estudiantes y el cumplimiento
de las funciones asignadas en condiciones de calidad,
atendiendo a estándares internacionales, en coherencia con el nivel de formación y modalidad del programa.', 10),
('factor_3', 'Evidencia de la vinculación de una planta profesoral pertinente con el área disciplinar del programa
con título de especialistas, magísteres y/o doctores con experiencia o formación pedagógica y profesional certificada, que
garantice el logro de los resultados de aprendizaje de los estudiantes y el cumplimiento de las funciones
asignadas en condiciones de calidad, atendiendo a estándares internacionales, en coherencia con el nivel de formación y modalidad del programa.', 10),
('factor_3', 'Evidencia de la vinculación de una planta profesoral pertinente con el área disciplinar
del programa con título de medicina y especialidad médico-quirúrgica, con experiencia o formación pedagógica y profesional certificada
en el campo de práctica de la especialidad, que garantice el logro de los resultados de aprendizaje de los estudiantes y el cumplimiento de las funciones asignadas en
condiciones de calidad, atendiendo a estándares internacionales, en coherencia con el nivel de formación y modalidad del programa.', 10),
('factor_3', 'Evidencia de la vinculación de una planta profesoral pertinente con el área disciplinar del programa
con título de maestría y/o doctorado con experiencia o formación pedagógica, investigativa y profesional certificada y experiencia en investigación, que garantice el logro de los resultados de aprendizaje de los estudiantes y el cumplimiento
de las funciones asignadas en condiciones de calidad, atendiendo a estándares internacionales, en coherencia con el nivel de formación y modalidad del programa.', 10),
('factor_3', 'Evidencia de la vinculación de una planta profesoral pertinente con el área disciplinar del
programa con título de doctorado y con experiencia en la dirección de tesis doctorales, así como publicaciones en revistas indexadas y libros e10Gn los campos de conocimiento, reconocidos en el Ministerio de Ciencia, Tecnología e Innovación (Minciencias), con experiencia o formación pedagógica, que garantice el logro de los resultados de aprendizaje de los estudiantes y el cumplimiento de las funciones asignadas en condiciones de calidad,
atendiendo a estándares internacionales, en coherencia con el nivel de formación y modalidad del programa.', 10),
('factor_3', 'Análisis de los resultados de la aplicación de políticas y estrategias institucionales en materia de desarrollo integral
del profesorado, que incluya la capacitación y la actualización
en los aspectos académicos, profesionales y pedagógicos relacionados con la naturaleza, nivel de formación y modalidad del programa.', 11),
('factor_3', 'Evidencia de cómo el desarrollo profesoral atiende a la diversidad de los estudiantes, a las modalidades de la docencia y a los requerimientos
de internacionalización y de inter y multiculturalidad de profesores y estudiantes.', 11),
('factor_3', 'Apreciación de directivos y profesores del programa sobre los resultados que han tenido las acciones orientadas
al desarrollo integral de los profesores, en el mejoramiento de las competencias pedagógicas,
científicas y sociales para el sostenimiento de las funciones misionales, junto con las acciones emprendidas como resultado de dichas apreciaciones.', 11),
('factor_3', 'Evidencia de los efectos generados en el desempeño de las labores de docencia, investigación y extensión con el otorgamiento de estímulos a los profesores.', 12),
('factor_3', 'Apreciación de directivos y profesores del programa, sobre el efecto que ha tenido el régimen
de estímulos al profesorado en el ejercicio cualificado de la docencia, la investigación, la innovación, la creación artística y
cultural, la extensión o proyección social, en los aportes al desarrollo técnico y tecnológico y la cooperación internacional,
junto con las acciones emprendidas como resultado de dichas apreciaciones.', 12),
('factor_3', 'Evidencia de la efectividad de los criterios de evaluación del material producido por los profesores en la
calidad de los aprendizajes de los estudiantes, de acuerdo con el nivel de formación y modalidad del programa académico.', 13),
('factor_3', 'Presentación de los resultados de evaluación de los materiales académicos producidos por los profesores para el desarrollo de las
diversas actividades académicas, que soportan los ambientes de aprendizaje, de acuerdo con el nivel de formación y modalidad.', 13),
('factor_3', 'Apreciación de los estudiantes y directivos del programa sobre la pertinencia y calidad del material académico producido,
de acuerdo con el nivel de formación y la modalidad del programa, junto con
las acciones emprendidas como resultado de dichas apreciaciones.', 13),
('factor_3', 'La remuneración que reciben los profesores está de acuerdo con sus méritos académicos y profesionales, el aporte en el desarrollo de los componentes formativos,
pedagógicos y de evaluación, la interacción y relevancia social, el nivel de formación y
la modalidad del programa académico.', 14),
('factor_3', 'Apreciación de los profesores, directivos y estudiantes sobre los criterios y mecanismos
para la evaluación de los profesores; su transparencia, equidad y eficacia y; su coherencia con
la naturaleza de la institución, el nivel de formación y la modalidad del
programa, junto con las acciones emprendidas como resultado de dichas apreciaciones.', 15),
('factor_3', 'Demostración del mejoramiento continuo del programa, a partir de las evaluaciones permanentes realizadas a los
profesores, en coherencia con el nivel de formación y modalidad.', 15);


INSERT INTO unicauca.cat_aspectos (nombre,descripcion,id_caracteristica) VALUES
('factor_4', 'Resultado de los estudios sistémicos aplicados sobre el desarrollo profesional y laboral de los
egresados, el alcance de las competencias adquiridas,
la correspondencia entre el desempeño de los egresados y el perfil de egreso o resultados de aprendizaje del programa.', 16),
('factor_4', 'Apreciación de los egresados en relación con el perfil de formación, las competencias adquiridas y las
posibilidades que les ha ofrecido su formación
para su desarrollo profesional y laboral, junto con las acciones emprendidas como resultado de dichas apreciaciones.', 16),
('factor_4', 'Evidencia del impacto de los egresados en el medio social y académico,
científico y cultural, como un mecanismo
para establecer los aportes del programa a la solución de problemas de la sociedad y/o la creación e innovación de conocimiento.', 17),
('factor_4', 'Apreciación de empleadores sobre el desempeño destacado de los egresados
y su aporte en la solución de los problemas académicos,
ambientales, tecnológicos, sociales y culturales, junto con las acciones emprendidas como resultado de dichas apreciaciones.', 17);

INSERT INTO unicauca.cat_aspectos (nombre,descripcion,id_caracteristica) VALUES
('factor_5', 'Resultados de la aplicación de ejercicios continuos de evaluación de la integralidad del currículo que conduzcan a
la realización de ajustes y mejoras que impactan a la formación en valores, actitudes, aptitudes, conocimientos, métodos, capacidades y
 habilidades, de acuerdo con el estado del arte y con el ejercicio de la disciplina, profesión, ocupación u oficio, y
 que busca la formación integral del estudiante en coherencia con la misión institucional y los objetivos propios del programa académico.', 18),
 ('factor_5', 'Evaluación de las estrategias y acciones del programa para el mejoramiento de las competencias definidas por el programa.', 18),
  ('factor_5', 'Evidencia de procesos de flexibilización como, doble titulación; articulación pregrado-posgrado;
reconocimiento de créditos, homologación y oferta de cursos electivos en distintas modalidades y lugares de desarrollo entre otros, que permiten
al estudiante interactuar con otros programas a nivel institucional, nacional e internacional.', 19),
  ('factor_5', 'Apreciación de estudiantes, profesores y egresados sobre las rutas de formación alternativas y
adoptadas por los estudiantes a partir de sus necesidades e intereses, derivadas de las estrategias de
flexibilidad curricular definidas por la institución, junto con las acciones emprendidas como resultado de dichas apreciaciones.', 19),
('factor_5', 'Evidencia de la implementación de las estrategias que promueven y estimulan la
interdisciplinariedad curricular del programa, y el resultado de su aplicación en las diferentes rutas formativas seguidas por
los estudiantes.
', 20),
('factor_5', 'Apreciación de los estudiantes y profesores frente a los mecanismos y criterios dispuestos por la
institución para la interdisciplinariedad curricular del programa, los resultados de su análisis y la evidencia de los logros en el mejoramiento en la calidad del programa.
', 20),
('factor_5', 'Apreciación de profesores y estudiantes sobre la coherencia de las estrategias pedagógicas utilizadas que facilitan el logro de los resultados de aprendizaje esperados, incluyendo los escenarios de práctica para los programas que lo requieren, valorando la calidad, la pertinencia, el acompañamiento y el cumplimiento de la normatividad específica para su desarrollo, junto con las acciones emprendidas como resultado de dichas apreciaciones.
Evidencia de la evaluación y el mejoramiento de las estrategias y prácticas pedagógicas, a partir de los aportes de la investigación pedagógica y de los procesos de actualización de los profesores.
', 21),
('factor_5', 'En el caso de programas académicos del área de la salud, presentar análisis de la incidencia de las actividades desarrolladas en
el marco de los convenios de docencia servicio con los distintos escenarios de práctica (con énfasis en el escenario principal, cuando aplique)
en los procesos de formación. Los análisis se deben realizar entre las partes que participan en el convenio
', 21),
('factor_5', 'Apreciación de profesores y estudiantes sobre los sistemas de evaluación
de los resultados de aprendizaje que desarrolla o implementa el programa, junto con las acciones
emprendidas como resultado de dichas apreciaciones.
', 22),
('factor_5', 'Evidencia de los resultados obtenidos a partir de la
implementación de los sistemas de evaluación de estudiantes basado en
políticas y normas claras, universales y transparentes.
', 22),
('factor_5', 'Evidencia de sistemas de evaluación que integran la innovación para generar transformaciones
profundas en el aprendizaje, y que acogen dinámicas en referencia a cambios en el conocimiento.
', 22),
('factor_5', 'Evidencia de la aplicación de una política institucional que establezca parámetros para la
formulación, evaluación y mejora continua de los resultados de aprendizaje establecidos
en el programa, en alineación con el perfil de formación y acorde con el nivel y la modalidad de formación.
', 23),
('factor_5', 'Evidencia del proceso de mejoramiento continuo relacionado con la evaluación entre los resultados de
aprendizaje esperados y los alcanzados por los estudiantes, el sistema de evaluación de estudiantes y
las acciones de ajuste de los aspectos curriculares y las metodologías de enseñanza - aprendizaje derivadas de dicha evaluación.
', 23),
('factor_5', 'Evidencia del resultado de la aplicación de estrategias para el desarrollo de las competencias previstas acordes con el perfil de formación del programa.
', 24),
('factor_5', 'Evidencia del cumplimiento de planes de mejoramiento y de innovación producto del proceso de autoevaluación del programa.
', 25),
('factor_5', 'Apreciación de los profesores y estudiantes sobre la calidad y pertinencia del proceso de evaluación y
autorregulación del programa, junto con las acciones emprendidas como resultado de dichas apreciaciones.
', 25),
('factor_5', 'Evidencia de la participación de los profesores y estudiantes en la proyección social del programa.
', 26),
('factor_5', 'Evidencia del efecto de las estrategias y acciones de proyección social como un mecanismo para
establecer los aportes del programa a la solución de problemas de la sociedad y a las mejoras de los aspectos curriculares.
', 26);


INSERT INTO unicauca.cat_aspectos (nombre,descripcion,id_caracteristica) VALUES
('factor_6', 'Análisis del efecto de las políticas, estrategias y acciones orientadas al mejoramiento de la permanencia y la graduación en el programa, que incluyan el comportamiento en los últimos seis años o en la vigencia de la acreditación si se trata de una
renovación, de la tasa de deserción interanual, tasa de deserción por cohorte y la tasa de graduación acumulada del programa.
', 27),
('factor_6', 'Evidencia de la existencia e implementación de un sistema de alertas tempranas que permita reconocer las particularidades de los estudiantes según su contexto sociocultural y la puesta en marcha de acciones
que faciliten su proceso formativo, de acuerdo, al menos, con las normas nacionales vigentes en materia de inclusión y diversidad.
', 28),
('factor_6', 'Apreciación de estudiantes y profesores sobre la contribución de las estrategias del sistema de alertas tempranas
 en su permanencia y graduación, junto con las acciones emprendidas como resultado de dichas apreciaciones.
', 28),
('factor_6', 'Presentación del análisis de los resultados derivados del sistema de alertas tempranas y su impacto en el currículo,
 para mejorar el desempeño académico de los estudiantes, su permanencia y graduación.
', 28),
('factor_6', 'Evidencia de la evaluación y el mejoramiento de los aspectos curriculares
derivados de los análisis del desempeño académico de los estudiantes, la permanencia y la graduación.
', 29),
('factor_6', 'Evidencia y análisis de la evolución de la matrícula total de estudiantes del programa y de la relación
entre aspirantes inscritos, admitidos y matriculados en cada periodo, a fin de establecer la tasa de selectividad y/o absorción del programa.
', 30),
('factor_6', 'Análisis de la correlación entre los mecanismos de selección, de desempeño académico,
permanencia y graduación que resulte en ajustes a los procesos de selección del programa.
', 30);


INSERT INTO unicauca.cat_aspectos (nombre,descripcion,id_caracteristica) VALUES
('factor_7', 'Evidencia del efecto de la aplicación de políticas y estrategias de cooperación con comunidades, nacionales e internacionales, en el desarrollo de labores formativas, académicas, docentes, científicas, culturales, deportivas y de extensión, así como en aspectos curriculares y
en la revisión de tendencias y referentes nacionales e internacionales que contribuyan al mejoramiento continuo del programa.
', 31),
('factor_7', 'Evidencia y análisis de los resultados de la cooperación académica y científica del programa, mediante convenios,
proyectos conjuntos, intercambios de profesores, estudiantes y la participación en redes científicas, culturales y de extensión.
', 32),
('factor_7', 'Apreciación de profesores, estudiantes y egresados sobre los resultados de la cooperación académica y
científica derivados de la aplicación de políticas y estrategias que favorezcan la interacción de profesores y
estudiantes con sus homólogos, a nivel nacional e internacional, junto con las acciones emprendidas como resultado de dichas apreciaciones.
', 32),
('factor_7', 'Evidencia de la incidencia de las estrategias empleadas para el desarrollo
de las competencias comunicativas en una segunda lengua y las interacciones de profesores
y estudiantes con otras comunidades no hispanohablantes de acuerdo con el nivel de formación y modalidad del programa.
', 33);

INSERT INTO unicauca.cat_aspectos (nombre,descripcion,id_caracteristica) VALUES
('factor_8', 'Evidencia de las estrategias implementadas para el desarrollo de las competencias investigativas, de innovación o
creación artística y cultural de los estudiantes, en coherencia con la naturaleza,
nivel de formación y la modalidad de oferta del programa.
', 34),
('factor_8', 'Apreciación de los estudiantes acerca de la formación para la investigación, el desarrollo de un pensamiento crítico, creativo e innovador, así como el
desarrollo tecnológico, la innovación y la creación promovida en el programa, junto con las acciones emprendidas como resultado de dichas apreciaciones.
', 34),
('factor_8', 'Evidencia de la existencia de un reglamento de propiedad intelectual, de grupos de investigación categorizados y de profesores investigadores reconocidos en las convocatorias de medición de Minciencias,
acorde con el Proyecto Educativo del Programa, el nivel de formación y la modalidad del programa.
', 35),
('factor_8', 'Evidencia de resultados de investigación, desarrollo tecnológico, innovación o creación de los profesores del programa, que contribuyan al fortalecimiento de los aspectos curriculares, la formación de los estudiantes y a la generación de nuevo conocimiento o a la solución de problemas de la
sociedad, en coherencia con el Proyecto Educativo del Programa, el nivel de formación y la modalidad del programa.
', 35);

INSERT INTO unicauca.cat_aspectos (nombre,descripcion,id_caracteristica) VALUES
('factor_9', 'Análisis sistemáticos de la participación de estudiantes
y profesores en las actividades de bienestar en cada uno de los escenarios de práctica.
', 36),
('factor_9', 'Apreciación de los estudiantes, profesores y personal administrativo sobre la
incidencia de la implementación de políticas, programas y servicios de bienestar, en coherencia con las condiciones y
necesidades de la comunidad en cada uno de los lugares y escenarios de práctica donde desarrolla sus labores, en correspondencia con
el nivel de formación y la modalidad del programa, junto con las acciones emprendidas como resultado de dichas apreciaciones.
', 36),
('factor_9', 'Análisis sistemáticos de la participación de la comunidad del programa en los planes y las actividades de bienestar,
de acuerdo con las particularidades de la población estudiantil, académica y administrativa.
', 37),
('factor_9', 'Evaluación de la calidad y pertinencia de la infraestructura, espacios y servicios de bienestar por parte
de la comunidad del programa, junto con las acciones emprendidas como resultado de dicha evaluación.
', 37);

INSERT INTO unicauca.cat_aspectos (nombre,descripcion,id_caracteristica) VALUES
('factor_10', 'Demostración de los resultados y la incidencia de la implementación de las estrategias y recursos de apoyo (pedagógico-didáctico) en los contextos de actuación
 de los profesores para el mejoramiento de sus prácticas de enseñanza-aprendizaje teniendo en cuenta la diversidad y la inclusión.
', 38),
('factor_10', 'Apreciación de los profesores y los estudiantes en relación con las estrategias pedagógicas, tecnológicas y de acompañamiento dispuestas por el programa para el desarrollo de las habilidades comunicativas y de interacción de los profesores con los
estudiantes, junto con las acciones emprendidas como resultado de dichas apreciaciones.
', 38),
('factor_10', 'En el caso de programas académicos del área de la salud, análisis de las acciones que realizan conjuntamente el programa
con los escenarios de práctica, en sus procesos de certificación, acreditación, reconocimiento como hospital universitario y acciones de mejora.
', 38),
('factor_10', 'Evidencia de la disponibilidad y capacidad de talleres, laboratorios, equipos, medios audiovisuales, sitios de práctica, estaciones y granjas experimentales, escenarios de simulación virtual, entre otros, para el
adecuado desarrollo de la actividad docente, investigativa y de extensión, según requerimientos del programa.
', 39),
('factor_10', 'Apreciación de los estudiantes sobre la utilidad y pertinencia de las estrategias y recursos
de apoyo brindados por la institución para el desarrollo de su proceso formativo en diferentes contextos,
junto con las acciones emprendidas como resultado de dichas apreciaciones.
', 39),
('factor_10', 'En el caso de los programas académicos del área de la salud, evidencia de la disponibilidad de laboratorios especializados y/o de simulación en los
distintos lugares de desarrollo y los escenarios de práctica, y análisis del nivel de uso por parte de profesores y estudiantes.
', 39),
('factor_10', 'Análisis de la correspondencia entre la inversión en recursos bibliográficos y de información, su utilización por parte de la comunidad del programa, demostrando la suficiencia y
pertinencia para el desarrollo de actividades de docencia, investigación y extensión, de acuerdo con el nivel de formación y modalidad del programa.
', 40),
('factor_10', 'Apreciación de estudiantes y profesores acerca de la pertinencia, actualización y suficiencia del material bibliográfico con que cuenta el programa, para apoyar el desarrollo de las distintas actividades académicas, de acuerdo con su nivel de formación y
modalidad, junto con las acciones emprendidas como resultado de dichas apreciaciones.
', 40);

INSERT INTO unicauca.cat_aspectos (nombre,descripcion,id_caracteristica) VALUES
('factor_11', 'Evidencia de la participación de representantes de la comunidad académica, a través de estructuras organizacionales
efinidas por la institución, y de su contribución, en el desarrollo y mejoramiento del programa.
', 41),
('factor_11', 'Apreciación de estudiantes, profesores y egresados sobre su participación en cuerpos colegiados, y en decisiones orientadas
al mejoramiento del programa, junto con las acciones emprendidas como resultado de dichas apreciaciones.
', 41),
('factor_11', 'Evidencia de los mecanismos existentes para la dirección y gestión del programa que contribuyen al mejoramiento de
las dinámicas administrativas y académicas y al relacionamiento con los grupos de interés.
', 42),
('factor_11', 'Apreciación de profesores y estudiantes sobre la eficiencia, eficacia y orientación de los procesos
 administrativos hacia el desarrollo de las labores formativas, académicas, docentes,
científicas, culturales y de extensión, junto con las acciones emprendidas como resultado de dichas apreciaciones.
', 42),
('factor_11', 'Presentación de estudios de
satisfacción de profesores y estudiantes del programa acerca de la suficiencia y calidad de los recursos y sistemas de comunicación e información.
', 43),
('factor_11', 'Presentación de estadísticas y análisis del uso de los sistemas de comunicación e información, y de la implementación
de estrategias que garanticen la conectividad a los miembros de la comunidad académica del programa.
', 43),
('factor_11', 'Evidencia de la aplicación de mecanismos de gestión documental, organización, actualización y seguridad de
los registros y archivos académicos de estudiantes, profesores, personal directivo y administrativo.
', 43),
('factor_11', 'Presentación de estadísticas y análisis de las capacidades institucionales en materia de recursos humanos (planta docente y personal administrativo),
técnicos, tecnológicos y financieros, que favorecen la permanencia, el desarrollo académico y la graduación de los estudiantes.
', 44),
('factor_11', 'Apreciación de profesores y estudiantes del programa con respecto a la correspondencia entre las capacidades institucionales en materia de sus recursos humanos, técnicos, tecnológicos y financieros, y el número de estudiantes
matriculados, en cumplimiento del Proyecto Educativo del Programa, junto con las acciones emprendidas como resultado de dichas apreciaciones.
', 44),
('factor_11', 'Demostración de la consistencia entre la asignación y distribución presupuestal del programa, y el desarrollo de las actividades de docencia, investigación, creación artística y cultural, deportiva, proyección social,
bienestar institucional e internacionalización, y la implementación de los planes de mejoramiento.
', 45),
('factor_11', 'Presentación de la proyección y la ejecución del presupuesto de inversión y de funcionamiento del programa y los mecanismos de seguimiento y control.
', 45),
('factor_11', 'Evidencia de la consolidación de un Sistema Interno de Aseguramiento de la Calidad que permita verificar, mediante unos procesos periódicos y participativos de autoevaluación, la alta calidad en cada uno de
los factores y características del modelo del Consejo Nacional de Acreditación, en el programa
', 46),
('factor_11', 'En el caso de los programas académicos del área de la salud, evidencia de los procesos de autoevaluación sobre el funcionamiento del convenio
docencia servicio en cada uno de los escenarios de práctica y su incidencia en los procesos de mejoramiento.
', 46);

INSERT INTO unicauca.cat_aspectos (nombre,descripcion,id_caracteristica) VALUES
('factor_12', 'Demostración de la existencia de aulas, laboratorios, talleres, centros de simulación,
plataformas tecnológicas, biblioteca y salas de estudio, para el cumplimiento de las labores formativas,
académicas, docentes, científicas, culturales y de extensión, en coherencia con el nivel de formación y la modalidad de oferta del programa
', 47),
('factor_12', 'Evidencia de planes y proyectos realizados o en ejecución para la conservación, expansión, mejoras y mantenimiento de la planta física para
el programa, de acuerdo con las normas técnicas respectivas y con el nivel de formación y la modalidad de oferta del programa.
', 47),
('factor_12', 'Evidencia de la coherencia entre los recursos informáticos y de comunicación, y las necesidades para el desarrollo y cumplimiento de las labores formativas, académicas,
docentes, científicas, culturales del programa académico en el lugar de desarrollo y en los escenarios de práctica.
', 48),
('factor_12', 'Apreciación de directivos, profesores y estudiantes del programa sobre la pertinencia, correspondencia y
suficiencia de los recursos informáticos y de comunicación con que cuenta el programa académico
', 48);


-- insert cargo

INSERT INTO cat_cargo (nombre,descripcion) VALUES
	 ('Coordinador','Coordinador'),
	 ('Jefe de departamento','Jefe de departamento'),
	 ('Profesor','Profesor');

-- cat escalafon

INSERT INTO unicauca.cat_escalafon (codigo,descripcion) VALUES
	 ('1','Auxiliar'),
	 ('2','Asistente'),
	 ('3','Asociado'),
	 ('4','Titular');

-- estado

INSERT INTO unicauca.cat_estado (codigo,descripcion) VALUES
	 ('FIN','FINALIZADO'),
	 ('PRO','PROCESO');

-- nivel formación

INSERT INTO unicauca.cat_nivel_formacion (codigo,descripcion) VALUES
	 ('1','Tecnológico'),
	 ('2','Profesional'),
	 ('3','Especializado'),
	 ('4','Médico Quirurjica'),
	 ('5','Maestria'),
	 ('6','Doctorado');

-- tipo publicacion

INSERT INTO unicauca.cat_publicacion_tipo (codigo,descripcion) VALUES
	 ('1','Libro'),
	 ('2','Capitulo de libro'),
	 ('3','Artículo'),
	 ('4','Cuaderno'),
	 ('5','Revista'),
	 ('6','Electrónica'),
	 ('7','Ponencia');

-- tipo asignatura
INSERT INTO unicauca.cat_tipo_asignatura (nombre,descripcion) VALUES
	 ('obligatoria','Obligatoria'),
	 ('Electiva','Electiva'),
	 ('Optativa','Optativa');

-- tipo fuente informacion
INSERT INTO unicauca.cat_tipo_fuente_informacion (nombre,descripcion) VALUES
	 ('Plan de mejoramiento','Plan de mejoramiento'),
	 ('Lineamientos','Lineamientos'),
	 ('Acuerdos','Acuerdos'),
	 ('Resoluciones','Resoluciones'),
	 ('Decretos','Decretos'),
	 ('Actas','Actas'),
	 ('Documentos de condiciones de calidad','Documentos de condiciones de calidad'),
	 ('Informe autoevaluacion','Informe autoevaluacion'),
	 ('Otro','Otro');

-- tipo vinculacion
INSERT INTO unicauca.cat_tipo_vinculacion (codigo,descripcion) VALUES
	 ('1','Término indefinido'),
	 ('2','Término fijo'),
	 ('3','Por Horas');

INSERT INTO unicauca.tbl_asignatura_semestre (nombre,descripcion) VALUES
	 ('SEMESTRE 1','SEMESTRE 1'),
	 ('SEMESTRE 2','SEMESTRE 2'),
	 ('SEMESTRE 3','SEMESTRE 3'),
	 ('SEMESTRE 4','SEMESTRE 4'),
	 ('SEMESTRE 5','SEMESTRE 5'),
	 ('SEMESTRE 6','SEMESTRE 6'),
	 ('SEMESTRE 7','SEMESTRE 7'),
	 ('SEMESTRE 8','SEMESTRE 8'),
	 ('SEMESTRE 9','SEMESTRE 9'),
	 ('SEMESTRE 10','SEMESTRE 10');
