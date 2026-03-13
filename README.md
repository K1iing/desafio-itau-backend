🏦 Itaú Unibanco — Desafio de Programação

Este projeto foi desenvolvido como solução para o Desafio de Programação do Itaú Unibanco, cujo objetivo é construir uma API REST que recebe transações e retorna estatísticas das transações realizadas nos últimos 60 segundos.

A aplicação foi desenvolvida utilizando Java + Spring Boot, seguindo rigorosamente todas as regras e restrições definidas no desafio.

🚀 Tecnologias Utilizadas

Java 17+

Spring Boot

Spring Web

Jakarta Validation

API REST

Armazenamento 100% em memória

JSON como formato único de entrada e saída

⚠️ Não foi utilizado nenhum banco de dados ou sistema de cache, conforme exigido no desafio.

📌 Regras do Projeto

✔ Projeto hospedado publicamente no GitHub/GitLab

✔ Sem fork de outros projetos

✔ Mínimo de 3 commits (um para cada endpoint)

✔ Todos os dados armazenados em memória

✔ Apenas JSON como entrada e saída

✔ Seguindo exatamente os nomes dos endpoints e campos especificados

📡 Endpoints da API
1️⃣ Criar Transação
POST /transacao

Recebe uma transação.

Exemplo de Request:
{
  "valor": 123.45,
  "dataHora": "2026-03-13T12:34:56.789-03:00"
}
Regras de Validação:

A transação será aceita apenas se:

✔ valor estiver presente

✔ dataHora estiver presente no maximo até 60 segundos.

✔ valor >= 0

Respostas:

201 Created → Transação válida e registrada

422 Unprocessable Entity → Dados inválidos

400 Bad Request → JSON inválido ou malformado

2️⃣ Limpar Transações
DELETE /transacao

Remove todas as transações armazenadas em memória.

Resposta:

200 OK

3️⃣ Estatísticas
GET /estatistica

Retorna estatísticas das transações realizadas nos últimos 60 segundos.

Exemplo de Response:
{
  "count": 10,
  "sum": 1234.56,
  "avg": 123.456,
  "min": 12.34,
  "max": 123.56
}
Regras:

Considerar apenas transações dos últimos 60 segundos

Caso não existam transações nesse período, todos os valores devem ser 0

Campos retornados:
Campo	Descrição
count	Quantidade de transações
sum	Soma dos valores
avg	Média dos valores
min	Menor valor
max	Maior valor

Para cálculo das estatísticas, foi utilizada a abordagem baseada em DoubleSummaryStatistics.

Resposta:

200 OK com o JSON das estatísticas

🧠 Decisões de Implementação

Armazenamento em memória utilizando estrutura de dados apropriada

Uso de OffsetDateTime para manipulação de data/hora

Filtro temporal baseado em now().minusSeconds(60)

Validações aplicadas conforme regras do desafio

Tratamento de exceções para garantir retorno correto dos códigos HTTP

📂 Estrutura do Projeto

Controller → Camada de endpoints

Service → Regras de negócio

DTOs → Objetos de entrada e saída

Armazenamento em memória

🔒 Observações

Este projeto segue todas as restrições impostas pelo desafio:

Sem banco de dados

Sem cache externo

Sem persistência em disco

Apenas memória da aplicação

📌 Autor

Projeto desenvolvido como parte do desafio técnico do Itaú Unibanco.
