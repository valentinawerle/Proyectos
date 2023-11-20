
INSERT INTO Direccion (nombreCalle, numeroCalle)
VALUES
('Calle Principal', 123),
('Avenida Central', 456),
('Calle Secundaria', 789);
select * from direccion; 

INSERT INTO Cargo (nombre_cargo)
VALUES
('Director'),
('Docente'),
('Administrativo');
select * from cargo;

INSERT INTO Sueldo (salario)
VALUES
(2500.00),
(2800.00),
(3000.00);

select * from sueldo; 

INSERT INTO Aula (capacidad)
VALUES
(30),
(25),
(35);
select * from aula; 

INSERT INTO Grado (division, anio)
VALUES
('A', '4 anio'),
('B', '2 anio'),
('C', '2 anio');
select * from grado; 

INSERT INTO Profesores (nombre, apellido, correo_electronico, fecha_nacimiento, telefono, Sueldo_idSueldo, Direccion_idDireccion)
VALUES ('Micaela', 'Zwaig', 'mica2@gmail.com', '1980-05-25', 123456789, 1, 1);

INSERT INTO Profesores (nombre, apellido, correo_electronico, fecha_nacimiento, telefono, Sueldo_idSueldo, Direccion_idDireccion)
VALUES ('Emma', 'Seo', 'emma2@gmail.com', '1985-08-15', 987654321, 1, 2);

INSERT INTO Profesores (nombre, apellido, correo_electronico, fecha_nacimiento, telefono, Sueldo_idSueldo, Direccion_idDireccion)
VALUES ('Juan', 'Perez', 'juan2@gmail.com', '1990-02-10', 555555555, 1, 3);

select * from profesores;

INSERT INTO Personal (nombre, apellido, correo_electronico, fecha_nacimiento, telefono, Cargo_idCrago, Direccion_idDireccion, Sueldo_idSueldo)
VALUES ('Carlos', 'Real', 'carlos@gmail.com', '1975-12-05', '111111111', 1, 1, 3);

INSERT INTO Personal (nombre, apellido, correo_electronico, fecha_nacimiento, telefono, Cargo_idCrago, Direccion_idDireccion, Sueldo_idSueldo)
VALUES ('Agustina', 'Armenia', 'Agustina@gmail.com', '1982-04-30', '222222222', 2, 2, 2);

INSERT INTO Personal (nombre, apellido, correo_electronico, fecha_nacimiento, telefono, Cargo_idCrago, Direccion_idDireccion, Sueldo_idSueldo)
VALUES ('Matias', 'Rinaldi', 'Matias@gmail.com', '1995-10-20', '333333333', 3, 3, 2);
select * from personal;

INSERT INTO Estudiantes (nombre, apellido, fecha_nacimiento, correo_electronico, telefono, dni, Nota_idNota, Direccion_idDireccion, Grado_idGrado)
VALUES
('Valentina', 'Werle', '2005-01-15', 'Valentina@gmail.com', '123456789', 12345678, 1, 1, 1),
('Mariana', 'Mendoza', '2006-03-20', 'mariana@gmail.com', '987654321', 23456789, 2, 2, 2),
('Martin', 'Katz', '2004-07-10', 'martin@gmail.com', '555555555', 34567890, 3, 3, 3);
select * from estudiantes;

INSERT INTO Materia (nombre, descripcion, Profesores_idProfesores, Grado_idGrado, Aula_id_Aula)
VALUES
('Matemáticas', 'Clases de matemáticas', 1, 1, 1),
('Historia', 'Clases de historia', 2, 2, 2),
('Ciencias', 'Clases de ciencias', 3, 3, 3);
select * from materia; 

INSERT INTO Nota (calificacion, Estudiantes_idEstudiantes, Materia_idMateria)
VALUES
(10, 1, 1),
(8, 2, 2),
(9, 3, 3),
(4, 1, 2);
select * from nota; 


INSERT INTO Matricula (estado_matricula, Estudiantes_idEstudiantes)
VALUES
('Matriculado', 1),
('Matriculado', 2),
('Matriculado', 3);
select * from matricula; 

INSERT INTO Asistencia (cantidad_asistencias, Materia_idMateria, Estudiantes_idEstudiantes)
VALUES
('90%', 1, 1),
('85%', 2, 2),
('78%', 3, 3);
select * from asistencia;

