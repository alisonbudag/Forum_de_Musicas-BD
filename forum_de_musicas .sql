-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 28-Jun-2018 às 08:58
-- Versão do servidor: 10.1.33-MariaDB
-- PHP Version: 7.2.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `forum_de_musicas`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `logins`
--

CREATE TABLE `logins` (
  `idLogin` int(11) NOT NULL,
  `user` varchar(12) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `logins`
--

INSERT INTO `logins` (`idLogin`, `user`, `password`) VALUES
(1, 'Alison', '123');

-- --------------------------------------------------------

--
-- Estrutura da tabela `mensagens`
--

CREATE TABLE `mensagens` (
  `idMensagem` int(11) NOT NULL,
  `corpoMensagem` varchar(1200) NOT NULL,
  `idTopico` int(11) NOT NULL,
  `idPerfil` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `perfis`
--

CREATE TABLE `perfis` (
  `idPerfil` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `idade` int(11) NOT NULL,
  `cidade` varchar(40) NOT NULL,
  `estado` varchar(40) NOT NULL,
  `pais` varchar(40) NOT NULL,
  `isAdm` tinyint(1) NOT NULL,
  `isMod` tinyint(1) NOT NULL,
  `isBanned` tinyint(1) NOT NULL,
  `idLogin` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `perfis`
--

INSERT INTO `perfis` (`idPerfil`, `nome`, `email`, `idade`, `cidade`, `estado`, `pais`, `isAdm`, `isMod`, `isBanned`, `idLogin`) VALUES
(1, 'Alison Rafael Cândido Budag', 'alison.rafaelc@gmail.com', 23, 'Blumenau', 'Santa Catarina', 'Brasil', 1, 1, 0, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `subsessoes`
--

CREATE TABLE `subsessoes` (
  `idSubsessao` int(11) NOT NULL,
  `nomeSubsessao` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `subsessoes`
--

INSERT INTO `subsessoes` (`idSubsessao`, `nomeSubsessao`) VALUES
(1, 'Discussão'),
(2, 'Ouvindo Agora'),
(3, 'Bandas'),
(4, 'Composições'),
(5, 'Photoshop'),
(6, 'Bugs'),
(7, 'Melhorias');

-- --------------------------------------------------------

--
-- Estrutura da tabela `topicos`
--

CREATE TABLE `topicos` (
  `idTopico` int(11) NOT NULL,
  `tituloTopico` varchar(40) NOT NULL,
  `mensagemTopico` varchar(1200) NOT NULL,
  `idSubsessao` int(11) NOT NULL,
  `idPerfil` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `logins`
--
ALTER TABLE `logins`
  ADD PRIMARY KEY (`idLogin`);

--
-- Indexes for table `mensagens`
--
ALTER TABLE `mensagens`
  ADD PRIMARY KEY (`idMensagem`),
  ADD KEY `mensagens_fk0` (`idTopico`),
  ADD KEY `mensagens_fk1` (`idPerfil`);

--
-- Indexes for table `perfis`
--
ALTER TABLE `perfis`
  ADD PRIMARY KEY (`idPerfil`),
  ADD KEY `perfis_fk0` (`idLogin`);

--
-- Indexes for table `subsessoes`
--
ALTER TABLE `subsessoes`
  ADD PRIMARY KEY (`idSubsessao`);

--
-- Indexes for table `topicos`
--
ALTER TABLE `topicos`
  ADD PRIMARY KEY (`idTopico`),
  ADD KEY `topicos_fk0` (`idSubsessao`),
  ADD KEY `topicos_fk1` (`idPerfil`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `logins`
--
ALTER TABLE `logins`
  MODIFY `idLogin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `mensagens`
--
ALTER TABLE `mensagens`
  MODIFY `idMensagem` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `perfis`
--
ALTER TABLE `perfis`
  MODIFY `idPerfil` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `subsessoes`
--
ALTER TABLE `subsessoes`
  MODIFY `idSubsessao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `topicos`
--
ALTER TABLE `topicos`
  MODIFY `idTopico` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `mensagens`
--
ALTER TABLE `mensagens`
  ADD CONSTRAINT `mensagens_fk0` FOREIGN KEY (`idTopico`) REFERENCES `topicos` (`idTopico`),
  ADD CONSTRAINT `mensagens_fk1` FOREIGN KEY (`idPerfil`) REFERENCES `perfis` (`idPerfil`);

--
-- Limitadores para a tabela `perfis`
--
ALTER TABLE `perfis`
  ADD CONSTRAINT `perfis_fk0` FOREIGN KEY (`idLogin`) REFERENCES `logins` (`idLogin`);

--
-- Limitadores para a tabela `topicos`
--
ALTER TABLE `topicos`
  ADD CONSTRAINT `topicos_fk0` FOREIGN KEY (`idSubsessao`) REFERENCES `subsessoes` (`idSubsessao`),
  ADD CONSTRAINT `topicos_fk1` FOREIGN KEY (`idPerfil`) REFERENCES `perfis` (`idPerfil`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
