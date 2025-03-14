# Validador de Senha

API desenvolvida para validar senhas conforme os seguintes critérios:

✅ Nove ou mais caracteres\
✅ Ao menos 1 dígito\
✅ Ao menos 1 letra minúscula\
✅ Ao menos 1 letra maiúscula\
✅ Ao menos 1 caractere especial (!@#\$%^&\*()-+)\
✅ Não possuir caracteres repetidos

## Como executar

1. Importe o projeto no Eclipse.
2. Utilize o comando abaixo para iniciar a aplicação:

```
mvn spring-boot:run
```

3. Utilize o Postman para fazer uma requisição `POST` na rota:

```
POST /validate-password
```

## Exemplo de Requisição

```json
{
  "password": "Senha@123"
}
```

## Exemplo de Resposta

**Status 200 OK**\
`true`

**Status 400 Bad Request**\
`false`

## Observação

Caso a senha seja enviada com aspas (ex.: `"Senha@123"`), o resultado será `false` porque as aspas fazem parte da string enviada.

