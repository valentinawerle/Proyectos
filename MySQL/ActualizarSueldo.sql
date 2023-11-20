-- Creamos el trigger para actualizar el sueldo de profesores ya registrados
DELIMITER //
CREATE TRIGGER ActualizarSueldoProfesoresExistentes
AFTER UPDATE ON Profesores
FOR EACH ROW 
BEGIN
    UPDATE Sueldo
    SET salario = salario * 1.10
    WHERE idSueldo = NEW.Sueldo_idSueldo;
END;
//
DELIMITER ;

-- Creamos el trigger para actualizar el sueldo del personal ya registrado
DELIMITER //
CREATE TRIGGER ActualizarSueldoPersonalExistente
AFTER UPDATE ON Personal
FOR EACH ROW
BEGIN
    
    UPDATE Sueldo
    SET salario = salario * 1.10
    WHERE idSueldo = NEW.Sueldo_idSueldo;  
END;
//
DELIMITER ;	

-- Actualizamos el sueldo de un profesor existente 
UPDATE Profesores
SET Sueldo_idSueldo = Sueldo_idSueldo  
WHERE idProfesores = 1;  
SELECT * FROM Sueldo;

UPDATE Personal
SET Sueldo_idSueldo = Sueldo_idSueldo  
WHERE id_Personal = 1;   
SELECT * FROM Sueldo;


