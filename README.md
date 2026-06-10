# Backend E-commerce Senac - Java 21 + Spring Boot + MySQL

Projeto backend REST criado a partir da estrutura SQL informada, usando Java 21, Spring Boot, Spring Data JPA, MySQL e SpringDoc Swagger/OpenAPI.

## Tecnologias

- Java 21
- Spring Boot 3.5.14
- Spring Web
- Spring Data JPA / Hibernate
- Bean Validation
- MySQL Connector/J 8.0.33
- SpringDoc OpenAPI Swagger UI 2.8.17

## Regra de status e apagamento lógico

O projeto usa a seguinte convenção em todos os CRUDs:

- `1` = registro ativo
- `0` = registro inativo
- `-1` = registro apagado logicamente

O método `DELETE` não remove fisicamente o registro. Ele apenas altera o status para `-1`.

Observação importante: o SQL original não possuía coluna de status em `endereco` e `itens_pedido`. Para cumprir a regra de apagamento lógico em todas as tabelas, o projeto mapeia também:

- `endereco.endereco_status`
- `itens_pedido.item_pedido_status`

Em desenvolvimento, `spring.jpa.hibernate.ddl-auto=update` pode criar essas colunas automaticamente. Em ambiente controlado, execute manualmente o arquivo:

```sql
src/main/resources/db/manual/alter_status_columns_mysql57.sql
```

## Como configurar o banco

Edite `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://edumysql.acesso.rj.senac.br:3306/20261_prjint3_manha_gabrielsilva?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&characterEncoding=latin1
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
```

Para testar localmente com Docker:

```bash
docker compose up -d
cp src/main/resources/application-local.properties.example src/main/resources/application-local.properties
mvn spring-boot:run -Dspring-boot.run.profiles=local
```

Para executar com o banco remoto:

```bash
mvn spring-boot:run
```

## Swagger

Depois de iniciar a aplicação, acesse:

```text
http://localhost:8080/swagger-ui.html
```

O JSON OpenAPI fica em:

```text
http://localhost:8080/v3/api-docs
```

## Endpoints gerados

Cada recurso possui os mesmos endpoints padrão:

```text
GET    /api/{recurso}
GET    /api/{recurso}/ativos
GET    /api/{recurso}/inativos
GET    /api/{recurso}/{id}
POST   /api/{recurso}
PUT    /api/{recurso}/{id}
PATCH  /api/{recurso}/{id}/ativar
PATCH  /api/{recurso}/{id}/inativar
DELETE /api/{recurso}/{id}
```

Recursos disponíveis:

```text
/api/categorias
/api/clientes
/api/enderecos
/api/produtos
/api/pedidos
/api/itens-pedido
/api/pagamentos
/api/entregas
```

## Exemplos de JSON

Criar categoria:

```json
{
  "categoriaNome": "Eletrônicos",
  "categoriaDescricao": "Produtos eletrônicos em geral",
  "categoriaStatus": 1
}
```

Criar cliente:

```json
{
  "clienteNome": "João Silva",
  "clienteEmail": "joao@email.com",
  "clienteSenha": "123456",
  "clienteTelefone": "21999999999",
  "clienteCpf": "123.456.789-00",
  "clienteStatus": 1
}
```

Criar produto vinculado à categoria 1:

```json
{
  "produtoNome": "Mouse Gamer",
  "produtoDescricao": "Mouse óptico USB",
  "produtoPreco": 99.90,
  "produtoEstoque": 10,
  "produtoStatus": 1,
  "categoria": {
    "categoriaId": 1
  }
}
```

Criar endereço vinculado ao cliente 1:

```json
{
  "cliente": {
    "clienteId": 1
  },
  "enderecoRua": "Rua A",
  "enderecoNumero": "100",
  "enderecoBairro": "Centro",
  "enderecoCidade": "Rio de Janeiro",
  "enderecoEstado": "RJ",
  "enderecoCep": "20000-000",
  "enderecoStatus": 1
}
```

Criar pedido vinculado ao cliente 1:

```json
{
  "cliente": {
    "clienteId": 1
  },
  "pedidoStatus": 1,
  "pedidoValorTotal": 199.80
}
```

Criar item de pedido:

```json
{
  "pedido": {
    "pedidoId": 1
  },
  "produto": {
    "produtoId": 1
  },
  "itemPedidoQuantidade": 2,
  "itemPedidoPreco": 99.90,
  "itemPedidoStatus": 1
}
```

Criar pagamento:

```json
{
  "pedido": {
    "pedidoId": 1
  },
  "pagamentoMetodo": "PIX",
  "pagamentoStatus": 1,
  "pagamentoData": "2026-06-03T10:00:00"
}
```

Criar entrega:

```json
{
  "pedido": {
    "pedidoId": 1
  },
  "entregaTransportadora": "Correios",
  "entregaCodigoRastreio": "BR123456789",
  "entregaStatus": 1,
  "entregaDataEnvio": "2026-06-03T10:00:00"
}
```

## Observações de produção

1. Troque `ddl-auto=update` por `ddl-auto=validate` depois que o schema estiver estabilizado.
2. Não grave senha de cliente em texto puro em produção. Use BCrypt/Spring Security.
3. Evite retornar `clienteSenha` nas respostas em produção. Neste projeto acadêmico ela foi mantida para espelhar diretamente a estrutura SQL informada.
4. Para banco remoto institucional, confirme usuário, senha, porta e liberação de IP.

## SQL reordenado

Também deixei um script reordenado para criação limpa do banco, já com as colunas de status faltantes:

```text
src/main/resources/db/manual/schema_reordenado_com_status.sql
```
