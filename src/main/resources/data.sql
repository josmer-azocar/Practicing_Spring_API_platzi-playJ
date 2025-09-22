INSERT INTO platzi_play_peliculas (titulo, duracion, genero, clasificacion, fecha_estreno, estado)
VALUES ('Avatar', 162, 'CIENCIA_FICCION', 4.8, '2009-12-18', 'D')
ON CONFLICT (titulo) DO NOTHING;

INSERT INTO platzi_play_peliculas (titulo, duracion, genero, clasificacion, fecha_estreno, estado)
VALUES ('El Señor de los Anillos', 201, 'DRAMA', 4.9, '2001-12-19', 'N')
ON CONFLICT (titulo) DO NOTHING;

INSERT INTO platzi_play_peliculas (titulo, duracion, genero, clasificacion, fecha_estreno, estado)
VALUES ('Pulp Fiction', 154, 'TERROR', NULL, '1994-10-14', 'D')
ON CONFLICT (titulo) DO NOTHING;

INSERT INTO platzi_play_peliculas (titulo, duracion, genero, clasificacion, fecha_estreno, estado)
VALUES ('Forrest Gump', 142, 'DRAMA', 4.8, '1994-07-06', 'D')
ON CONFLICT (titulo) DO NOTHING;

INSERT INTO platzi_play_peliculas (titulo, duracion, genero, clasificacion, fecha_estreno, estado)
VALUES ('Interstellar', 169, 'CIENCIA_FICCION', 4.9, '2014-11-07', 'N')
ON CONFLICT (titulo) DO NOTHING;

INSERT INTO platzi_play_peliculas (titulo, duracion, genero, clasificacion, fecha_estreno, estado)
VALUES ('El Origen', 148, 'CIENCIA_FICCION', NULL, '2010-07-16', 'D')
ON CONFLICT (titulo) DO NOTHING;

INSERT INTO platzi_play_peliculas (titulo, duracion, genero, clasificacion, fecha_estreno, estado)
VALUES ('Gladiador', 155, 'ACCION', 4.7, '2000-05-05', 'N')
ON CONFLICT (titulo) DO NOTHING;

INSERT INTO platzi_play_peliculas (titulo, duracion, genero, clasificacion, fecha_estreno, estado)
VALUES ('Matrix', 136, 'CIENCIA_FICCION', 4.8, '1999-03-31', 'D')
ON CONFLICT (titulo) DO NOTHING;

INSERT INTO platzi_play_peliculas (titulo, duracion, genero, clasificacion, fecha_estreno, estado)
VALUES ('La La Land', 128, 'COMEDIA', 4.6, '2016-12-09', 'N')
ON CONFLICT (titulo) DO NOTHING;

INSERT INTO platzi_play_peliculas (titulo, duracion, genero, clasificacion, fecha_estreno, estado)
VALUES ('Parásitos', 132, 'TERROR', 4.9, '2019-05-30', 'D')
ON CONFLICT (titulo) DO NOTHING;