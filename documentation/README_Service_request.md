# 📦 API  de solicitações de serviços

Esta API permite solicitar pedidos no sistema do hotel, validando dados e garantindo que não existam duplicatas. 

---

## 🔗 Endpoint para Cadastro

**URL de requisição:**
```
POST http://127.0.0.1:8080/services/request
```

> **Nota:** O endpoint oficial mapeado no controller é `/services`, então verifique se o deploy atual está redirecionando corretamente.

---

## 📤 Exemplo de Requisição (JSON)

```json

{
  "serviceImage": "fyMFmMFagMcpIoJzutcxm96I29Euf0ekjjhE82iaNF6L96rliaegWiubQC5wQ38",
  "serviceName": "Café da manhã",
  "serviceDescription": "Serviço de café da manhã servido diretamente no quarto, com menu personalizado.",
  "serviceCategory": "CAFE_DA_MANHA_NO_QUARTO",
  "isActive": true,
  "servicePrice": 49.90,
  "client":{
    "clientName": "Maria da Silva",
    "clientCpf": "12345678101",
    "clientEmail": "eduardofreitasfr@gmail.com",
    "clientPhone": "71981590149",
    "isActive":false,
    "address": {
      "clientStreet": "Rua das Flores",
      "clientComplement": "2",
      "clientNeighborhood": "Centro",
      "clientLocality": "Salvador",
      "clientState": "rh",
      "clientPostalCode": "40000000"
    },
    "clientUser": {
      "username": "mariasil2",
      "password": "123564532"
    }
  }
}



```

---

## ✅ Respostas Esperadas

- **200 Created**
  ```
  Serviço adicionado com sucesso!
  ```

- **400 Bad Request**
  - Erro de validação.
  - Usuário ou senha incorreta.

---

# 📦 API de consulta de serviços solicitados

Esta API permite consultar serviços pedidos no sistema do hotel, validando dados.

---

## 🔗 Endpoint para Cadastro

**URL de requisição:**
```
GET http://127.0.0.1:8080/services/request
```

> **Nota:** O endpoint oficial mapeado no controller é `/services`, então verifique se o deploy atual está redirecionando corretamente.

---

## 📤 Exemplo de Requisição (JSON)

```json

{
  "clientName": "Maria da Silva",
  "clientCpf": "12345678101",
  "clientEmail": "eduardofreitasfr@gmail.com",
  "clientPhone": "71981590149",
  "isActive":false,
  "address": {
    "clientStreet": "Rua das Flores",
    "clientComplement": "2",
    "clientNeighborhood": "Centro",
    "clientLocality": "Salvador",
    "clientState": "rh",
    "clientPostalCode": "40000000"
  },
  "clientUser": {
    "username": "mariasil2",
    "password": "123564532"
  }
}



```

---

## ✅ Respostas Esperadas

- **200 Created**
  ```
  Serviço adicionado com sucesso!
  ```

- **400 Bad Request**
  - Erro de validação.
  - Usuário ou senha incorreta.
  - Usuário sem permissão.

---





