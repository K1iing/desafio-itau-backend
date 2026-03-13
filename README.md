<div align="center">

<img src="https://img.shields.io/badge/Java-17+-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"/>
<img src="https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"/>
<img src="https://img.shields.io/badge/REST_API-In--Memory-0052CC?style=for-the-badge&logo=api&logoColor=white"/>
<img src="https://img.shields.io/badge/Status-Concluído-00C49A?style=for-the-badge"/>

# 🏦 Itaú Unibanco — API de Transações

> Desafio técnico de programação — API REST para controle e estatísticas de transações em tempo real.

</div>

---

## 📋 Sobre o Projeto

Esta aplicação foi desenvolvida como solução para o **Desafio de Programação do Itaú Unibanco**. O objetivo é construir uma **API REST** que recebe transações financeiras e retorna estatísticas em tempo real das transações realizadas nos **últimos 60 segundos**.

Toda a lógica opera **100% em memória**, sem uso de bancos de dados ou sistemas de cache externos.

---

## 🚀 Tecnologias

| Tecnologia | Versão | Finalidade |
|---|---|---|
| Java | 17+ | Linguagem principal |
| Spring Boot | 3.x | Framework Web |
| Spring Web | — | Camada REST |
| Jakarta Validation | — | Validação de dados |
| Maven / Gradle | — | Gerenciamento de dependências |

---

## 📡 Endpoints da API

### `POST /transacao` — Criar Transação

Registra uma nova transação. Aceita apenas transações com data/hora nos últimos 60 segundos.

**Request Body:**
```json
{
  "valor": 123.45,
  "dataHora": "2026-03-13T12:34:56.789-03:00"
}
```

**Regras de validação:**

- `valor` é obrigatório e deve ser `>= 0`
- `dataHora` é obrigatória e deve estar dentro dos últimos 60 segundos

**Respostas:**

| Código | Descrição |
|---|---|
| `201 Created` | Transação válida e registrada com sucesso |
| `422 Unprocessable Entity` | Dados inválidos (valor negativo, data futura, etc.) |
| `400 Bad Request` | JSON inválido ou malformado |

---

### `DELETE /transacao` — Limpar Transações

Remove **todas** as transações armazenadas em memória.

**Resposta:** `200 OK`

---

### `GET /estatistica` — Estatísticas

Retorna estatísticas das transações dos **últimos 60 segundos**.

**Response Body:**
```json
{
  "count": 10,
  "sum": 1234.56,
  "avg": 123.456,
  "min": 12.34,
  "max": 123.56
}
```

| Campo | Descrição |
|---|---|
| `count` | Quantidade de transações no período |
| `sum` | Soma total dos valores |
| `avg` | Média dos valores |
| `min` | Menor valor registrado |
| `max` | Maior valor registrado |

> ⚠️ Se não houver transações nos últimos 60 segundos, todos os campos retornam `0`.

**Resposta:** `200 OK`

## 📂 Estrutura do Projeto

```
src/
└── main/
    └── java/
        └── com/itau/transacoes/
            ├── controller/       # Endpoints REST
            ├── service/          # Regras de negócio
            ├── dto/              # Objetos de entrada e saída
            └── storage/          # Armazenamento em memória
```

---

## ▶️ Como Executar

**Pré-requisitos:** Java 17+ e Maven instalados.

```bash
# Clone o repositório
git clone https://github.com/K1iing/desafio-itau-backend.git

# Acesse o diretório
cd seu-repositorio

# Execute a aplicação
./mvnw spring-boot:run
```

A API estará disponível em: `http://localhost:8080`

---

## 🧪 Exemplos de Uso

**Criar uma transação:**
```bash
curl -X POST http://localhost:8080/transacao \
  -H "Content-Type: application/json" \
  -d '{"valor": 150.00, "dataHora": "2026-03-13T15:00:00.000-03:00"}'
```

**Consultar estatísticas:**
```bash
curl http://localhost:8080/estatistica
```

**Limpar todas as transações:**
```bash
curl -X DELETE http://localhost:8080/transacao
```

---

## 🔒 Restrições do Desafio

| Restrição | Status |
|---|---|
| Sem banco de dados | ✅ |
| Sem cache externo | ✅ |
| Sem persistência em disco | ✅ |
| Apenas armazenamento em memória | ✅ |
| Apenas JSON como entrada/saída | ✅ |
| Mínimo de 3 commits | ✅ |
| Projeto público no GitHub | ✅ |

---

## ✅ Checklist do Projeto

- [x] `POST /transacao` implementado com todas as validações
- [x] `DELETE /transacao` implementado
- [x] `GET /estatistica` implementado com janela de 60 segundos
- [x] Retorno `0` para estatísticas sem transações no período
- [x] Códigos HTTP corretos para todos os cenários
- [x] 100% sem banco de dados ou cache externo

---

<div align="center">

**Desenvolvido como parte do desafio técnico do Itaú Unibanco 🧡**

</div>
