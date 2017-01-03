-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: 03-Jan-2017 às 17:49
-- Versão do servidor: 10.1.16-MariaDB
-- PHP Version: 5.5.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `maquina_de_alimentos`
--
CREATE DATABASE IF NOT EXISTS `maquina_de_alimentos` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `maquina_de_alimentos`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `alimento`
--

CREATE TABLE `alimento` (
  `id_tipo_alimento` int(11) NOT NULL,
  `id_maquina` int(11) NOT NULL,
  `data_cadastro` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `id_bandeja` int(11) NOT NULL,
  `quantidade` int(11) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `alimento`
--

INSERT INTO `alimento` (`id_tipo_alimento`, `id_maquina`, `data_cadastro`, `id_bandeja`, `quantidade`) VALUES
(1, 1, '2016-12-12 21:02:25', 1, 4),
(2, 1, '2016-12-12 20:30:55', 2, 4),
(3, 1, '2016-12-12 20:28:50', 3, 4);

-- --------------------------------------------------------

--
-- Estrutura da tabela `bandeja`
--

CREATE TABLE `bandeja` (
  `id_bandeja` int(11) NOT NULL,
  `id_maquina` int(11) NOT NULL,
  `numero` varchar(45) NOT NULL,
  `id_tipo_alimento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `bandeja`
--

INSERT INTO `bandeja` (`id_bandeja`, `id_maquina`, `numero`, `id_tipo_alimento`) VALUES
(1, 1, '1', 1),
(2, 1, '2', 2),
(3, 1, '3', 3),
(4, 1, '4', 4);

-- --------------------------------------------------------

--
-- Estrutura da tabela `maquina`
--

CREATE TABLE `maquina` (
  `id_maquina` int(11) NOT NULL,
  `cinquenta_centavo` int(11) NOT NULL DEFAULT '0',
  `um_real` int(11) NOT NULL DEFAULT '0',
  `dois_real` int(11) NOT NULL DEFAULT '0',
  `cinco_real` int(11) NOT NULL DEFAULT '0',
  `dez_real` int(11) NOT NULL,
  `dinheiro_vendas` double DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `maquina`
--

INSERT INTO `maquina` (`id_maquina`, `cinquenta_centavo`, `um_real`, `dois_real`, `cinco_real`, `dez_real`, `dinheiro_vendas`) VALUES
(1, 27, 47, 1, 0, 20, 23),
(2, 10, 2, 0, 0, 12321, 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `operador`
--

CREATE TABLE `operador` (
  `id_operador` int(11) NOT NULL,
  `nome` varchar(300) NOT NULL,
  `login` varchar(10) NOT NULL,
  `senha` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `operador`
--

INSERT INTO `operador` (`id_operador`, `nome`, `login`, `senha`) VALUES
(1, 'Master', '12345', '12345'),
(2, 'operador sem acesso', 'asdf', 'asdf'),
(3, 'maq2', '4567', '4567');

-- --------------------------------------------------------

--
-- Estrutura da tabela `operador_maquina`
--

CREATE TABLE `operador_maquina` (
  `id_operador` int(11) NOT NULL,
  `id_maquina` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `operador_maquina`
--

INSERT INTO `operador_maquina` (`id_operador`, `id_maquina`) VALUES
(1, 1),
(1, 2),
(3, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tipo_alimento`
--

CREATE TABLE `tipo_alimento` (
  `id_tipo_alimento` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `validade_dias` int(11) NOT NULL,
  `preco` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tipo_alimento`
--

INSERT INTO `tipo_alimento` (`id_tipo_alimento`, `nome`, `validade_dias`, `preco`) VALUES
(1, 'batata', 90, 5),
(2, 'cebola', 90, 3.5),
(3, 'refrigerante', 180, 4),
(4, 'biscoito', 30, 2.5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `alimento`
--
ALTER TABLE `alimento`
  ADD PRIMARY KEY (`id_bandeja`,`id_maquina`,`id_tipo_alimento`),
  ADD KEY `id_alimento_idx` (`id_tipo_alimento`),
  ADD KEY `id_maquina_idx` (`id_maquina`),
  ADD KEY `id_bandeja_idx` (`id_bandeja`);

--
-- Indexes for table `bandeja`
--
ALTER TABLE `bandeja`
  ADD PRIMARY KEY (`id_bandeja`,`id_maquina`,`numero`),
  ADD KEY `id_maquina` (`id_maquina`),
  ADD KEY `id_tipo_alimento_idx` (`id_tipo_alimento`);

--
-- Indexes for table `maquina`
--
ALTER TABLE `maquina`
  ADD PRIMARY KEY (`id_maquina`);

--
-- Indexes for table `operador`
--
ALTER TABLE `operador`
  ADD PRIMARY KEY (`id_operador`);

--
-- Indexes for table `operador_maquina`
--
ALTER TABLE `operador_maquina`
  ADD KEY `fk_operador_maquina_1_idx` (`id_operador`),
  ADD KEY `fk_operador_maquina_2_idx` (`id_maquina`);

--
-- Indexes for table `tipo_alimento`
--
ALTER TABLE `tipo_alimento`
  ADD PRIMARY KEY (`id_tipo_alimento`),
  ADD UNIQUE KEY `nome_UNIQUE` (`nome`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bandeja`
--
ALTER TABLE `bandeja`
  MODIFY `id_bandeja` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `maquina`
--
ALTER TABLE `maquina`
  MODIFY `id_maquina` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `operador`
--
ALTER TABLE `operador`
  MODIFY `id_operador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `tipo_alimento`
--
ALTER TABLE `tipo_alimento`
  MODIFY `id_tipo_alimento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `alimento`
--
ALTER TABLE `alimento`
  ADD CONSTRAINT `id_alimento` FOREIGN KEY (`id_tipo_alimento`) REFERENCES `tipo_alimento` (`id_tipo_alimento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `id_bandeja` FOREIGN KEY (`id_bandeja`) REFERENCES `bandeja` (`id_bandeja`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `id_maquina` FOREIGN KEY (`id_maquina`) REFERENCES `maquina` (`id_maquina`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `bandeja`
--
ALTER TABLE `bandeja`
  ADD CONSTRAINT `bandeja_ibfk_1` FOREIGN KEY (`id_maquina`) REFERENCES `maquina` (`id_maquina`),
  ADD CONSTRAINT `id_tipo_alimento` FOREIGN KEY (`id_tipo_alimento`) REFERENCES `tipo_alimento` (`id_tipo_alimento`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `operador_maquina`
--
ALTER TABLE `operador_maquina`
  ADD CONSTRAINT `fk_operador_maquina_1` FOREIGN KEY (`id_operador`) REFERENCES `operador` (`id_operador`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_operador_maquina_2` FOREIGN KEY (`id_maquina`) REFERENCES `maquina` (`id_maquina`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
