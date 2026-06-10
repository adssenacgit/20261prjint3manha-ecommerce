USE `20261_prjint3_manha_gabrielsilva`;

-- O SQL original já possui status em: categoria, cliente, produto, pedido, pagamentos e entregas.
-- Para que o apagamento lógico funcione também em endereco e itens_pedido,
-- estas duas colunas precisam existir.

ALTER TABLE `endereco`
  ADD COLUMN IF NOT EXISTS `endereco_status` INT(11) DEFAULT 1;

ALTER TABLE `itens_pedido`
  ADD COLUMN IF NOT EXISTS `item_pedido_status` INT(11) DEFAULT 1;

UPDATE `endereco` SET `endereco_status` = 1 WHERE `endereco_status` IS NULL;
UPDATE `itens_pedido` SET `item_pedido_status` = 1 WHERE `item_pedido_status` IS NULL;
