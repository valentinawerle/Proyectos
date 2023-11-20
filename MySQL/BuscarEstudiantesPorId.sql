
DELIMITER //

CREATE FUNCTION BuscarEstudiantesPorId(id INT)
RETURNS TEXT
DETERMINISTIC
BEGIN
  DECLARE resultado TEXT DEFAULT '';
  SELECT
    CONCAT('ID: ', idEstudiantes, '\n',
           'Nombre: ', nombre, '\n',
           'Apellido: ', apellido, '\n',
           'Fecha de Nacimiento: ', fecha_nacimiento, '\n',
           'Correo Electrónico: ', correo_electronico, '\n',
           'Teléfono: ', telefono, '\n',
           'DNI: ', dni)
  INTO resultado
  FROM Estudiantes
  WHERE id = idEstudiantes;

  RETURN resultado;
END;

//

DELIMITER ;

SELECT BuscarEstudiantesPorId(2);


