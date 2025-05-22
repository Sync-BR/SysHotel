# 📦 API  de solicitações de quartos

Esta API permite solicitar quarto no sistema do hotel, validando dados e garantindo que não existam duplicatas. 

---

## 🔗 Endpoint para solicitar um quarto

**URL de requisição:**
```
POST http://127.0.0.1:8080/request/room
```

> **Nota:** O endpoint oficial mapeado no controller é `/request/room`, então verifique se o deploy atual está redirecionando corretamente.

---

## 📤 Exemplo de Requisição (JSON)

```json

{
  "number": 100,
  "level": 3,
  "letter": "a",
  "capacity": 2,
  "price": 350.0,
  "available": true,
  "smoker": false,
  "accessibility": true,
  "image": "https://hotelapi.com/images/room202B.jpg",
  "title": "Suíte Luxo com Vista para o Mar",
  "description": "Suíte equipada com cama king-size, hidromassagem, TV 50”, frigobar e varanda com vista para o mar.",
  "typeRoom": "Couple",
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

- **201 OK**
  ```
  Serviço adicionado com sucesso!
  ```

- **400 Bad Request**
  - Erro de validação.
  - Usuário ou senha incorreta.
  - Quarto não existe
  - Quarto alugado

---
