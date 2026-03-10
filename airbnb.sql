CREATE DATABASE airbnb_db;
GO

USE airbnb_db;
GO

--TABLA DE USURIOS--
CREATE TABLE usuarios (
id INT PRIMARY KEY IDENTITY (1,1),
nombre NVARCHAR (100),
apellido NVARCHAR (100),
correo VARCHAR (100) UNIQUE NOT NULL,
contrasena VARCHAR(MAX) NOT NULL,
rol VARCHAR (20) DEFAULT 'HUESPED',
token_recuperacion VARCHAR (255) NULL,
expiracion_token DATETIME NULL,
estado BIT DEFAULT 1,
fecha_registro DATETIME DEFAULT GETDATE()
);

INSERT INTO usuarios(nombre,apellido,correo,contrasena,rol)
VALUES ('Muñeco','Mu','muneco@gmail.com','23456','ANFITRION');
Select * from usuarios



--TABLA DE HABITACIONES--
CREATE TABLE rooms(
id INT PRIMARY KEY IDENTITY (1,1),
titulo NVARCHAR (255),
ubicacion NVARCHAR (255),
precio DECIMAL (18,2),
puntuacion FLOAT,
imagen_url VARCHAR(MAX),
usuario_id INT NOT NULL,

CONSTRAINT FK_Room_Usuario
FOREIGN KEY (usuario_id) REFERENCES usuarios (id) 
);

INSERT INTO rooms(titulo,ubicacion,precio,puntuacion,imagen_url,usuario_id)
VALUES 
('Cabaña del lago','Guatavita',300000,4.9,'https://images.unsplash.com/photo-1510798831971-661eb04b3739?q=80&w=1000&auto=format&fit=crop',1),
('Cabaña piedra','Hola',600000,4.8,'https://images.unsplash.com/photo-1510798831971-661eb04b3739?q=80&w=1000&auto=format&fit=crop',1);

select * from rooms

Select r.titulo AS [Nombre pues],r.precio,u.nombre AS dueno FROM rooms r JOIN usuarios u ON r.usuario_id=u.id where r.id='1'
SELECT r.id ,r.titulo AS[Nombre habitación pues], u.nombre AS [Dueño] FROM rooms r JOIN usuarios u ON r.usuario_id=u.id where u.id='1';
Delete from rooms where id='2'