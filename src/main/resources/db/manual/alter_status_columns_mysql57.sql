USE `20261_prjint3_manha_gabrielsilva`;

-- Versão compatível com MySQL 5.7: execute cada ALTER apenas se a coluna ainda não existir.
ALTER TABLE `endereco` ADD COLUMN `endereco_status` INT(11) DEFAULT 1;
ALTER TABLE `itens_pedido` ADD COLUMN `item_pedido_status` INT(11) DEFAULT 1;

UPDATE `endereco` SET `endereco_status` = 1 WHERE `endereco_status` IS NULL;
UPDATE `itens_pedido` SET `item_pedido_status` = 1 WHERE `item_pedido_status` IS NULL;
