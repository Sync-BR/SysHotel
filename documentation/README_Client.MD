
# 📘 User Registration API - Sistema Hotel

Este projeto expõe um endpoint para registrar clientes no sistema de hotelaria, com validação de dados e tratamento de exceções.

## 🚀 Endpoint

**URL:**  
`http://127.0.0.1:8080/user`  
**Método:** `POST`  
**Descrição:** Cadastra um novo cliente no sistema.

---

## 📥 Requisição

### Headers

```
Content-Type: application/json
```

### Body (Exemplo de JSON)

```json
{
  "clientName": "Maria da Silva",
  "clientCpf": "12345678101",
  "clientEmail": "eduardofreitasfr@gmail.com",
  "clientPhone": "71999999999",
  "address": {
    "clientStreet": "Rua das Flores",
    "clientComplement": "123",
    "clientNeighborhood": "Centro",
    "clientLocality": "Salvador",
    "clientState": "BA",
    "clientPostalCode": "40000000"
  },
  "clientUser": {
    "username": "mariasil2",
    "password": "123564532"
  }
}
```

---

## ✅ Respostas

- **201 Created**
    - Mensagem: `Usuário registrado com sucesso.`

- **409 Conflict**
    - Quando CPF, e-mail ou nome de usuário já estiverem cadastrados:
    - Mensagens possíveis:
        - `CPF already exists`
        - `Email already exists`
        - `Username already exists`

---

## 🔒 Validações

- `clientName`: mínimo 8 caracteres
- `clientCpf`: exatamente 11 dígitos
- `clientPhone`: exatamente 11 dígitos
- `clientEmail`: não pode estar vazio
- `username`: entre 5 e 10 caracteres
- `password`: mínimo 8 caracteres
- Todos os campos de endereço são obrigatórios

---

## 📎 Observações

- Todos os campos são obrigatórios.
- A senha é criptografada antes de ser salva no banco de dados.
