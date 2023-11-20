DELIMITER //

CREATE PROCEDURE CalcularPromedioNotas(IN estudiante_id INT, OUT promedio FLOAT)
BEGIN
  -- Declaramos las variables para almacenar el total de las calificaciones y la cantidad de materias.
  DECLARE total_calificaciones FLOAT;
  DECLARE cantidad_materias INT;
  
  -- Inicializamos las variables.
  SET total_calificaciones = 0;
  SET cantidad_materias = 0;
  
  -- Calculamos el total de las calificaciones y la cantidad de materias para el estudiante especificado.
  SELECT SUM(calificacion), COUNT(*) 
  INTO total_calificaciones, cantidad_materias
  FROM Nota
  WHERE Estudiantes_idEstudiantes = estudiante_id;
  
  -- Calculamos el promedio.
  IF cantidad_materias > 0 THEN
    SET promedio = total_calificaciones / cantidad_materias;
  ELSE
    SET promedio = 0; -- Evitar la división por cero si el estudiante no tiene calificaciones.
  END IF;
END;
//

DELIMITER ;

-- Llamada al procedimiento para calcular el promedio de un estudiante con ID 1.
CALL CalcularPromedioNotas(1, @resultado);

-- Resultado del procedimiento:
SELECT @resultado;

