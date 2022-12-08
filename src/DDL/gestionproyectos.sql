-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 02-12-2022 a las 19:19:49
-- Versión del servidor: 10.4.17-MariaDB
-- Versión de PHP: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gestionproyectos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `gestion`
--

CREATE TABLE `gestion` (
  `id` int(11) NOT NULL,
  `idproveedor` int(255) NOT NULL,
  `idpieza` int(255) NOT NULL,
  `idproyecto` int(255) NOT NULL,
  `cantidad` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `gestion`
--

INSERT INTO `gestion` (`id`, `idproveedor`, `idpieza`, `idproyecto`, `cantidad`) VALUES
(3, 2, 1, 1, 25),
(4, 1, 1, 1, 10),
(5, 2, 2, 2, 100);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `piezas`
--

CREATE TABLE `piezas` (
  `id` int(255) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `precio` float NOT NULL,
  `descripcion` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `piezas`
--

INSERT INTO `piezas` (`id`, `nombre`, `precio`, `descripcion`) VALUES
(1, 'Rueda', 20, 'Rueda de 16 pulgadas'),
(2, 'Motor', 100, 'Motor de 1.6 litros'),
(3, 'Frenos', 50.6, 'Frenos de disco'),
(4, 'Amortiguadores', 30.5, 'Amortiguadores de gas'),
(5, 'Cambio', 40, 'Cambio de 5 velocidades'),
(6, 'Llantas', 20, 'Llantas de 16 pulgadas'),
(7, 'Parachoques', 30, 'Parachoques delantero'),
(8, 'Retrovisores', 10, 'Retrovisores exteriores'),
(9, 'Volante', 15, 'Volante de cuero'),
(10, 'Asientos', 50, 'Asientos de cuero'),
(11, 'Rueda', 20, 'Rueda de 16 pulgadas'),
(12, 'Motor', 100, 'Motor de 1.6 litros'),
(13, 'Frenos', 50.6, 'Frenos de disco'),
(14, 'Amortiguadores', 30.5, 'Amortiguadores de gas'),
(15, 'Cambio', 40, 'Cambio de 5 velocidades'),
(16, 'Llantas', 20, 'Llantas de 16 pulgadas'),
(17, 'Parachoques', 30, 'Parachoques delantero'),
(18, 'Retrovisores', 10, 'Retrovisores exteriores'),
(19, 'Volante', 15, 'Volante de cuero'),
(20, 'Asientos', 50, 'Asientos de cuero');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedores`
--

CREATE TABLE `proveedores` (
  `id` int(255) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `apellidos` varchar(30) NOT NULL,
  `direccion` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `proveedores`
--

INSERT INTO `proveedores` (`id`, `nombre`, `apellidos`, `direccion`) VALUES
(1, 'Roberto', 'Garcia Perez', 'Calle Bravo Murillo, 123'),
(2, 'Maria', 'Gonzalez Lopez', 'Calle Alcala, 456'),
(3, 'Jose', 'Gomez Sanchez', 'Calle Gran Via, 789'),
(4, 'Luis', 'Fernandez Rodriguez', 'Calle Princesa, 101'),
(5, 'Antonio', 'Martinez Ruiz', 'Calle Alcala, 112'),
(6, 'Juan', 'Hernandez Jimenez', 'Calle Alcala, 123'),
(7, 'Manuel', 'Diaz Garcia', 'Calle Alcala, 134'),
(8, 'Francisco', 'Lopez Fernandez', 'Calle Alcala, 145'),
(9, 'Javier', 'Martinez Lopez', 'Calle Alcala, 156'),
(10, 'Miguel', 'Gonzalez Martinez', 'Calle Alcala, 167'),
(11, 'Roberto', 'Garcia Perez', 'Calle Bravo Murillo, 123'),
(12, 'Maria', 'Gonzalez Lopez', 'Calle Alcala, 456'),
(13, 'Jose', 'Gomez Sanchez', 'Calle Gran Via, 789'),
(14, 'Luis', 'Fernandez Rodriguez', 'Calle Princesa, 101'),
(15, 'Antonio', 'Martinez Ruiz', 'Calle Alcala, 112'),
(16, 'Juan', 'Hernandez Jimenez', 'Calle Alcala, 123'),
(17, 'Manuel', 'Diaz Garcia', 'Calle Alcala, 134'),
(18, 'Francisco', 'Lopez Fernandez', 'Calle Alcala, 145'),
(19, 'Javier', 'Martinez Lopez', 'Calle Alcala, 156'),
(20, 'Miguel', 'Gonzalez Martinez', 'Calle Alcala, 167');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proyectos`
--

CREATE TABLE `proyectos` (
  `id` int(255) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `ciudad` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `proyectos`
--

INSERT INTO `proyectos` (`id`, `nombre`, `ciudad`) VALUES
(1, 'Proyecto 1', 'Madrid'),
(2, 'Proyecto 2', 'Barcelona'),
(3, 'Proyecto 3', 'Valencia'),
(4, 'Proyecto 4', 'Sevilla'),
(5, 'Proyecto 5', 'Zaragoza'),
(6, 'Proyecto 6', 'Malaga'),
(7, 'Proyecto 7', 'Murcia'),
(8, 'Proyecto 8', 'Palma de Mallorca'),
(9, 'Proyecto 9', 'Las Palmas de Gran Canaria'),
(10, 'Proyecto 10', 'Bilbao'),
(11, 'Proyecto 1', 'Madrid'),
(12, 'Proyecto 2', 'Barcelona'),
(13, 'Proyecto 3', 'Valencia'),
(14, 'Proyecto 4', 'Sevilla'),
(15, 'Proyecto 5', 'Zaragoza'),
(16, 'Proyecto 6', 'Malaga'),
(17, 'Proyecto 7', 'Murcia'),
(18, 'Proyecto 8', 'Palma de Mallorca'),
(19, 'Proyecto 9', 'Las Palmas de Gran Canaria'),
(20, 'Proyecto 10', 'Bilbao');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `gestion`
--
ALTER TABLE `gestion`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_idpieza` (`idpieza`),
  ADD KEY `fk_idproyecto` (`idproyecto`),
  ADD KEY `fk_proveedor` (`idproveedor`);

--
-- Indices de la tabla `piezas`
--
ALTER TABLE `piezas`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `proyectos`
--
ALTER TABLE `proyectos`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `gestion`
--
ALTER TABLE `gestion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `piezas`
--
ALTER TABLE `piezas`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `proyectos`
--
ALTER TABLE `proyectos`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `gestion`
--
ALTER TABLE `gestion`
  ADD CONSTRAINT `fk_idpieza` FOREIGN KEY (`idpieza`) REFERENCES `piezas` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_idproyecto` FOREIGN KEY (`idproyecto`) REFERENCES `proyectos` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_proveedor` FOREIGN KEY (`idproveedor`) REFERENCES `proveedores` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
