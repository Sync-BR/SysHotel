# 📲 Como Fazer Login na API do Sistema Hotel

Este documento explica como realizar o login na API do sistema utilizando o endpoint `/user/login`.

## 🔐 Endpoint de Login

**URL:**

```
POST http://127.0.0.1:8080/user/login
```

**Descrição:**

Esse endpoint permite que um usuário autenticado acesse o sistema. É necessário enviar um JSON com as credenciais válidas.

---

## 📤 Requisição

### 🔸 Headers

| Chave           | Valor             |
|----------------|-------------------|
| Content-Type    | application/json  |

### 🔸 Body (JSON)

```json
{
    "username": "seu_usuario",
    "password": "sua_senha"
}
```

> Exemplo:
```json
{
    "username": "mariasil2",
    "password": "123564532"
}
```

---

## ✅ Resposta de Sucesso

**Status Code:** `200 OK`

**Body:**
```json
{
    "id": 1,
    "nome": "Maria Silva",
    "username": "mariasil2",
    "email": "maria@email.com",
    "telefone": "71999999999"
}
```

---

## ❌ Respostas de Erro

| Status | Mensagem                              | Motivo                        |
|--------|----------------------------------------|-------------------------------|
| 401    | "Usuário não encontrado."              | Username inválido             |
| 401    | "A senha informada está incorreta. Tente novamente." | Senha incorreta         |
| 409    | "Usuário já cadastrado."               | Tentativa de criar duplicado  |

---

## 🛠️ Implementação (Trecho do Código Backend)

```java
@PostMapping("/login")
public ResponseEntity<?> login(@RequestBody @Valid UserDto user) {
    try {
        ClientEntities searchClient = userService.Login(covertUser(user));
        if (checkPassword(user.getPassword(), searchClient.getDateUser().getPassword())) {
            return ResponseEntity.status(HttpStatus.OK).body(convertEntitiesToDto(searchClient));
        }
    } catch (ClientException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("A senha informada está incorreta. Tente novamente.");
}
```

---

## 📌 Observações

- O login é feito com base no `username` e `password`.
- A senha é verificada com criptografia utilizando `PasswordEncoder`.
- Certifique-se de estar cadastrado antes de tentar fazer o login.

---

