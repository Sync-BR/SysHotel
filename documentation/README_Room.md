# 📦 API de Gerenciamento de Quartos - Sistema Hoteleiro

Esta API permite cadastrar novos quartos no sistema do hotel, validando dados e garantindo que não existam duplicatas. 

---

## 🔗 Endpoint para Cadastro

**URL de requisição:**
```
POST http://186.247.89.58:8081/room
```

> **Nota:** O endpoint oficial mapeado no controller é `/rooms`, então verifique se o deploy atual está redirecionando corretamente.

---

## 📤 Exemplo de Requisição (JSON)

```json
{
  "number": 100,
  "level": 2,
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

- **201 Created**
  ```
  O Quarto foi adicionado com sucesso ao sistema.
  ```

- **400 Bad Request**
  - Quarto com número/letra já existente.
  - Dados inválidos.
  - Usuário ou senha incorreta.
  - 

---

## 🔒 Validações Internas

- Número + letra do quarto não podem se repetir.
- A letra do quarto é automaticamente convertida para MAIÚSCULA.
- Verificação de salvamento com sucesso.
- Disponibilidade do quarto verificada antes da inserção.

---
