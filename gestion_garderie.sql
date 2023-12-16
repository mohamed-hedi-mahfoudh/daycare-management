-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 11 jan. 2022 à 12:03
-- Version du serveur : 10.4.21-MariaDB
-- Version de PHP : 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gestion_garderie`
--

-- --------------------------------------------------------

--
-- Structure de la table `animateur`
--

CREATE TABLE `animateur` (
  `CIN` varchar(25) NOT NULL,
  `nom` varchar(25) NOT NULL,
  `prenom` varchar(25) NOT NULL,
  `prenom_pere` varchar(25) NOT NULL,
  `date_naissance` date NOT NULL,
  `sexe` varchar(25) NOT NULL,
  `numero` int(11) NOT NULL,
  `numero_rue` int(25) NOT NULL,
  `designation` varchar(25) NOT NULL,
  `ville` varchar(25) NOT NULL,
  `code_postal` int(11) NOT NULL,
  `gouvernorat` varchar(25) NOT NULL,
  `image` varchar(35) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `animateur`
--

INSERT INTO `animateur` (`CIN`, `nom`, `prenom`, `prenom_pere`, `date_naissance`, `sexe`, `numero`, `numero_rue`, `designation`, `ville`, `code_postal`, `gouvernorat`, `image`) VALUES
('111111', 'ahmed', 'ben ahmed', 'iokuy', '2021-12-23', 'Masculin', 56565656, 32784, 'opi', 'oiujy', 78542, 'okiju', 'D:i13394.png'),
('4444444', 'mahfoudh', 'flen', 'hhhh', '2022-01-14', 'Masculin', 98765432, 78524, 'iuj', 'sousse', 4021, 'sousse', 'D:i13394.png'),
('555555', 'ben salem', 'malek', 'flen', '2022-01-20', 'Masculin', 12345678, 123, 'sousse', 'sousse', 4520, 'sousse', 'D:i13394.png'),
('66666666', 'ben flen', 'mahmoud', 'hhhh', '2022-01-14', 'Masculin', 98765432, 78524, 'iuj', 'sousse', 4021, 'sousse', 'D:i13394.png'),
('7777777', 'ben salem', 'maelk', 'hhhh', '2022-01-14', 'Masculin', 98765432, 78524, 'iuj', 'sousse', 4021, 'sousse', 'D:i13394.png'),
('7852', 'ben mahmoud', 'frere', 'hhhh', '2022-01-14', 'Feminin', 98765432, 78524, 'iuj', 'sousse', 4021, 'sousse', 'D:i13394.png'),
('78578', 'ben flen', 'flen', 'iokuy', '2021-12-04', 'Masculin', 12365498, 875, 'opi', 'oiujy', 8524, 'okiju', 'D:i13394.png'),
('7857852', 'oiuj', 'ujyhtg', 'ujyhtgr', '2022-01-14', 'Masculin', 12345678, 7827, 'jhg', 'jhygtr', 4021, 'hjgf', 'D:i13394.png'),
('786524', 'ben salah', 'flen', 'iokuy', '2021-12-04', 'Feminin', 98765432, 778524, 'opi', 'oiujy', 78524, 'okiju', 'D:i13394.png'),
('888888', 'ben ajmi', 'aymen', 'iokuy', '2021-12-04', 'Masculin', 98765123, 785, 'opi', 'oiujy', 785, 'okiju', 'D:i13394.png'),
('8888888', 'ben salah', 'rihab', 'hhhh', '2022-01-14', 'Feminin', 98765432, 78524, 'iuj', 'sousse', 4021, 'sousse', 'D:i13394.png'),
('91919191', 'ben chokri', 'flena', 'hhhh', '2022-01-14', 'Feminin', 98765432, 78524, 'iuj', 'sousse', 4021, 'sousse', 'D:i13394.png'),
('9852785', 'iujyh', 'iuyjtr', 'ujytr', '2022-01-13', 'Masculin', 7852, 7852, 'yut', 'jyuhtr', 7852, 'kujuh', 'D:i13394.png'),
('9999999', 'ben masoud', 'ramzi', 'iokuy', '2021-12-31', 'Feminin', 77777777, 869524, 'opi', 'oiujy', 524, 'okiju', 'D:i13394.png');

-- --------------------------------------------------------

--
-- Structure de la table `anim_classes_cours`
--

CREATE TABLE `anim_classes_cours` (
  `cinanim` varchar(25) NOT NULL,
  `codecours` varchar(25) NOT NULL,
  `nomclasse` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `anim_classes_cours`
--

INSERT INTO `anim_classes_cours` (`cinanim`, `codecours`, `nomclasse`) VALUES
('111111', 'c', '1t6'),
('111111', 'c', '2info'),
('111111', 'c', '4sc2'),
('111111', 'c', '4t3'),
('66666666', 'c', '4sc2'),
('66666666', 'c', '7b6'),
('66666666', 'mt', '4t3'),
('7777777', 'jv', '2info'),
('7777777', 'jv', '4t3'),
('7777777', 'phi', '8b5'),
('7852', 'mu', '8b9'),
('7852', 'phi', '1t6'),
('8888888', 'mt', '4t3'),
('91919191', 'mu', '1t6'),
('91919191', 'mu', '2info'),
('91919191', 'mu', '4sc2'),
('91919191', 'mu', '4t3'),
('91919191', 'mu', '7b12'),
('91919191', 'mu', '7b6'),
('91919191', 'mu', '8b5'),
('91919191', 'mu', '8b9'),
('91919191', 'phy', '7b12'),
('91919191', 'phy', '7b6'),
('91919191', 'sp', '2info'),
('9999999', 'mu', '7b6'),
('9999999', 'mu', '8b9'),
('9999999', 'phi', '8b5'),
('9999999', 'sp', '2info');

-- --------------------------------------------------------

--
-- Structure de la table `classe`
--

CREATE TABLE `classe` (
  `nom_classe` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `classe`
--

INSERT INTO `classe` (`nom_classe`) VALUES
('1t6'),
('2info'),
('4sc2'),
('4t3'),
('7b12'),
('7b6'),
('8b5'),
('8b9');

-- --------------------------------------------------------

--
-- Structure de la table `cours`
--

CREATE TABLE `cours` (
  `code` varchar(25) NOT NULL,
  `designation` varchar(25) NOT NULL,
  `prix` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `cours`
--

INSERT INTO `cours` (`code`, `designation`, `prix`) VALUES
('c', 'languae c', 100),
('jv', 'java', 100),
('mt', 'mathematiqqqqqqque', 111111),
('mu', 'music', 10),
('phi', 'philo', 100),
('phy', 'physique', 100),
('sp', 'sport', 80);

-- --------------------------------------------------------

--
-- Structure de la table `directeur`
--

CREATE TABLE `directeur` (
  `login` varchar(50) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  `nom` varchar(50) DEFAULT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `directeur`
--

INSERT INTO `directeur` (`login`, `password`, `nom`, `prenom`, `type`) VALUES
('admin', 'admin', 'Mahfoudh', 'Nejib', 'administrateur');

-- --------------------------------------------------------

--
-- Structure de la table `eleve`
--

CREATE TABLE `eleve` (
  `id_eleve` varchar(25) NOT NULL,
  `nom` varchar(25) NOT NULL,
  `prenom` varchar(25) NOT NULL,
  `prenom_pere` varchar(25) NOT NULL,
  `date_naissance` date NOT NULL,
  `sexe` varchar(25) NOT NULL,
  `CIN_pere` int(11) NOT NULL,
  `num_pere` int(11) NOT NULL,
  `prenom_grand_pere_pere` varchar(25) NOT NULL,
  `prenom_grand_pere_mere` varchar(25) NOT NULL,
  `classe` varchar(25) NOT NULL,
  `numero_rue` int(11) NOT NULL,
  `designation` varchar(25) NOT NULL,
  `ville` varchar(25) NOT NULL,
  `code_postal` int(11) NOT NULL,
  `gouvernorat` varchar(25) NOT NULL,
  `image` varchar(35) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `eleve`
--

INSERT INTO `eleve` (`id_eleve`, `nom`, `prenom`, `prenom_pere`, `date_naissance`, `sexe`, `CIN_pere`, `num_pere`, `prenom_grand_pere_pere`, `prenom_grand_pere_mere`, `classe`, `numero_rue`, `designation`, `ville`, `code_postal`, `gouvernorat`, `image`) VALUES
('0101010101', 'mahfoudh', 'mohamed', 'likujyh', '2021-12-11', 'Masculin', 88888, 12345678, 'poikujyhtg', 'ikujhygtfr', '7b6', 876, 'kjhujyh', 'uiyjht', 7855, 'jhgf', '7b6'),
('48587578', 'ben salem', 'malek', 'likujyh', '2021-06-11', 'Masculin', 785785, 785785, 'hedihefdi\n', 'hedi', '8b9', 8574, 'kjhujyh', 'uiyjht', 7858, 'jhgf', '8b9'),
('5785', 'mahfoudh', 'nejib', 'likujyh', '2021-06-11', 'Feminin', 7685, 7685, 'hefdi\n', 'hedi', '7b6', 886975, 'jhug', 'hgf', 7858, 'jyft', '7b6'),
('757575757', 'mahfoudh', 'nejib', 'likujyh', '2021-06-11', 'Feminin', 7685888, 7685, '7685', '7685', '7b6', 886975, 'jhug', 'hgf', 7858, 'jyft', '7b6'),
('78578', 'ouisleti', 'sofien', 'likujyh', '2021-06-11', 'Masculin', 785785, 785785, 'hefdi\n', 'hedi', '8b9', 8574, 'kjhujyh', 'uiyjht', 7858, 'jhgf', '8b9'),
('785782', 'hhhhhhhhh', 'xxxxxxxx', 'likujyh', '2021-12-11', 'Feminin', 68584, 68584, 'hefdi\n', 'hedi', '8b5', 876, 'kjhujyh', 'uiyjht', 785, 'jhgf', '7b6'),
('78652', 'xxxx', 'pppp', 'likujyh', '2021-12-11', 'Feminin', 68584, 68584, 'hefdi\n', 'hedi', '8b9', 876, 'kjhujyh', 'uiyjht', 785, 'jhgf', '7b6'),
('86785', 'noumi', 'majdi', 'likujyh', '2021-06-11', 'Masculin', 785, 785, 'hefdi\n', 'hedi', '4t3', 8574, 'kjhujyh', 'uiyjht', 7858, 'jhgf', '4t3'),
('87675', 'boukabous', 'rania', 'likujyh', '2021-12-11', 'Masculin', 68584, 68584, 'hefdi\n', 'hedi', '7b6', 876, 'kjhujyh', 'uiyjht', 785, 'jhgf', '7b6'),
('87785', 'kkkkk', 'loool', 'likujyh', '2021-12-11', 'Masculin', 68584, 68584, 'hefdi\n', 'hedi', '8b5', 876, 'kjhujyh', 'uiyjht', 785, 'jhgf', '7b6'),
('8796372', 'yyyyy', 'zzzzz', 'likujyh', '2021-12-11', 'Masculin', 68584, 68584, 'hefdi\n', 'hedi', '7b6', 876, 'kjhujyh', 'uiyjht', 785, 'jhgf', '7b6'),
('89652782', 'hhhhhh', 'jjjjjjj', 'likujyh', '2021-12-11', 'Masculin', 68584, 68584, 'hefdi\n', 'hedi', '4sc2', 876, 'kjhujyh', 'uiyjht', 785, 'jhgf', '7b6'),
('89678', 'abid', 'arij', 'likujyh', '2021-06-11', 'Masculin', 785, 785, 'hefdi\n', 'hedi', '4t3', 8574, 'kjhujyh', 'uiyjht', 7858, 'jhgf', '4t3'),
('89752785287', 'pppppppp', 'ooooooo', 'likujyh', '2021-12-11', 'Masculin', 68584, 68584, 'hefdi\n', 'hedi', '7b12', 876, 'kjhujyh', 'uiyjht', 785, 'jhgf', '7b6');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `animateur`
--
ALTER TABLE `animateur`
  ADD PRIMARY KEY (`CIN`);

--
-- Index pour la table `anim_classes_cours`
--
ALTER TABLE `anim_classes_cours`
  ADD PRIMARY KEY (`cinanim`,`codecours`,`nomclasse`),
  ADD KEY `CIN` (`cinanim`,`codecours`,`nomclasse`),
  ADD KEY `id_classe` (`nomclasse`),
  ADD KEY `code_cours` (`codecours`);

--
-- Index pour la table `classe`
--
ALTER TABLE `classe`
  ADD PRIMARY KEY (`nom_classe`);

--
-- Index pour la table `cours`
--
ALTER TABLE `cours`
  ADD PRIMARY KEY (`code`);

--
-- Index pour la table `directeur`
--
ALTER TABLE `directeur`
  ADD PRIMARY KEY (`login`);

--
-- Index pour la table `eleve`
--
ALTER TABLE `eleve`
  ADD PRIMARY KEY (`id_eleve`),
  ADD KEY `classe` (`classe`);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `anim_classes_cours`
--
ALTER TABLE `anim_classes_cours`
  ADD CONSTRAINT `anim_classes_cours_ibfk_1` FOREIGN KEY (`cinanim`) REFERENCES `animateur` (`CIN`),
  ADD CONSTRAINT `anim_classes_cours_ibfk_2` FOREIGN KEY (`nomclasse`) REFERENCES `classe` (`nom_classe`),
  ADD CONSTRAINT `anim_classes_cours_ibfk_3` FOREIGN KEY (`codecours`) REFERENCES `cours` (`code`);

--
-- Contraintes pour la table `eleve`
--
ALTER TABLE `eleve`
  ADD CONSTRAINT `eleve_ibfk_1` FOREIGN KEY (`classe`) REFERENCES `classe` (`nom_classe`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
