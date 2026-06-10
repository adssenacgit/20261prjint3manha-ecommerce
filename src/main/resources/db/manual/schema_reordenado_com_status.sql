CREATE DATABASE IF NOT EXISTS `20261_prjint3_manha_gabrielsilva` DEFAULT CHARACTER SET latin1;
USE `20261_prjint3_manha_gabrielsilva`;

CREATE TABLE IF NOT EXISTS `categoria` (
  `categoria_id` int(11) NOT NULL AUTO_INCREMENT,
  `categoria_nome` varchar(100) NOT NULL,
  `categoria_descricao` text,
  `categoria_status` int(11) DEFAULT 1,
  PRIMARY KEY (`categoria_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `cliente` (
  `cliente_id` int(11) NOT NULL AUTO_INCREMENT,
  `cliente_nome` varchar(100) NOT NULL,
  `cliente_email` varchar(100) NOT NULL,
  `cliente_senha` varchar(255) NOT NULL,
  `cliente_telefone` varchar(20) DEFAULT NULL,
  `cliente_cpf` varchar(14) DEFAULT NULL,
  `cliente_data_cadastro` datetime DEFAULT CURRENT_TIMESTAMP,
  `cliente_status` int(11) DEFAULT 1,
  PRIMARY KEY (`cliente_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `produto` (
  `produto_id` int(11) NOT NULL AUTO_INCREMENT,
  `produto_nome` varchar(150) NOT NULL,
  `produto_descricao` text,
  `produto_preco` decimal(10,2) NOT NULL,
  `produto_estoque` int(11) DEFAULT NULL,
  `produto_status` int(11) DEFAULT 1,
  `categoria_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`produto_id`),
  KEY `categoria_id` (`categoria_id`),
  CONSTRAINT `produto_ibfk_1` FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`categoria_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `endereco` (
  `endereco_id` int(11) NOT NULL AUTO_INCREMENT,
  `cliente_id` int(11) DEFAULT NULL,
  `endereco_rua` varchar(150) DEFAULT NULL,
  `endereco_numero` varchar(10) DEFAULT NULL,
  `endereco_bairro` varchar(100) DEFAULT NULL,
  `endereco_cidade` varchar(100) DEFAULT NULL,
  `endereco_estado` varchar(50) DEFAULT NULL,
  `endereco_cep` varchar(10) DEFAULT NULL,
  `endereco_status` int(11) DEFAULT 1,
  PRIMARY KEY (`endereco_id`),
  KEY `cliente_id` (`cliente_id`),
  CONSTRAINT `endereco_ibfk_1` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`cliente_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `pedido` (
  `pedido_id` int(11) NOT NULL AUTO_INCREMENT,
  `cliente_id` int(11) DEFAULT NULL,
  `pedido_data` datetime DEFAULT CURRENT_TIMESTAMP,
  `pedido_status` int(11) DEFAULT 1,
  `pedido_valor_total` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`pedido_id`),
  KEY `cliente_id` (`cliente_id`),
  CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`cliente_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `itens_pedido` (
  `item_pedido_id` int(11) NOT NULL AUTO_INCREMENT,
  `pedido_id` int(11) DEFAULT NULL,
  `produto_id` int(11) DEFAULT NULL,
  `item_pedido_quantidade` int(11) DEFAULT NULL,
  `item_pedido_preco` decimal(10,2) DEFAULT NULL,
  `item_pedido_status` int(11) DEFAULT 1,
  PRIMARY KEY (`item_pedido_id`),
  KEY `pedido_id` (`pedido_id`),
  KEY `produto_id` (`produto_id`),
  CONSTRAINT `itens_pedido_ibfk_1` FOREIGN KEY (`pedido_id`) REFERENCES `pedido` (`pedido_id`),
  CONSTRAINT `itens_pedido_ibfk_2` FOREIGN KEY (`produto_id`) REFERENCES `produto` (`produto_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `pagamentos` (
  `pagamento_id` int(11) NOT NULL AUTO_INCREMENT,
  `pedido_id` int(11) DEFAULT NULL,
  `pagamento_metodo` varchar(50) DEFAULT NULL,
  `pagamento_status` int(11) DEFAULT 1,
  `pagamento_data` datetime DEFAULT NULL,
  PRIMARY KEY (`pagamento_id`),
  KEY `pedido_id` (`pedido_id`),
  CONSTRAINT `pagamentos_ibfk_1` FOREIGN KEY (`pedido_id`) REFERENCES `pedido` (`pedido_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `entregas` (
  `entrega_id` int(11) NOT NULL AUTO_INCREMENT,
  `pedido_id` int(11) DEFAULT NULL,
  `entrega_transportadora` varchar(100) DEFAULT NULL,
  `entrega_codigo_rastreio` varchar(100) DEFAULT NULL,
  `entrega_status` int(11) DEFAULT 1,
  `entrega_data_envio` datetime DEFAULT NULL,
  PRIMARY KEY (`entrega_id`),
  KEY `pedido_id` (`pedido_id`),
  CONSTRAINT `entregas_ibfk_1` FOREIGN KEY (`pedido_id`) REFERENCES `pedido` (`pedido_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
