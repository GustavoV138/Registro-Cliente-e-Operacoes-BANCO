# 🏦 Banco API — Registro de Contas & Operações PIX

Este é um projeto backend leve e divertido desenvolvido em Spring Boot para simular o básico de uma experiência bancária: abrir contas e registrar transações de PIX com validações em tempo real.

Tudo isso rodando de forma ágil com banco de dados em memória **H2**.

---

## 🛠️ O que foi usado para construir?

* **Java 21** (usando recursos modernos)
* **Spring Boot 3.5.x** (Web, Data JPA e Validation)
* **H2 Database** (para persistência rápida na memória)
* **Maven** (como construtor)

---

## 🧠 Como o sistema pensa? (Regras de Negócio)

Para manter a saúde financeira do nosso banco de mentirinha, a API segue algumas regrinhas:
1. **Identificação Obrigatória:** Você não pode criar uma conta sem informar o nome do cliente (`nomeCliente` é obrigatório).
2. **Sem PIX Fantasma:** O valor de qualquer transferência PIX deve ser estritamente maior que zero.
3. **Sem Cheque Especial:** Não é permitido fazer um PIX se a conta de origem não tiver saldo suficiente. O sistema calcula a dedução do saldo automaticamente a cada transferência bem-sucedida!

---

## 📁 Estrutura do Projeto

* `entities/`: 
  * `ContaEntity.java` (Guarda o nome do cliente, o número da conta e o saldo)
  * `OperacaoEntity.java` (Registra as movimentações, como o PIX e o valor transferido)
* `repositories/`: Interfaces JPA para comunicação direta com as tabelas de contas e operações.
* `services/`: Onde a mágica acontece. Validações de saldo, busca de histórico e lógica de débito do PIX.
* `controller/`: `ContaController.java` — a porta de entrada que expõe os endpoints REST.

---

## 🚀 Como Rodar o Banco Localmente

1. Tenha o **JDK 21** instalado na sua máquina.
2. Abra a pasta raiz do projeto no terminal e execute:

**No Windows:**
```bash
.\mvnw.cmd spring-boot:run
```

**No Linux/macOS:**
```bash
chmod +x ./mvnw
./mvnw spring-boot:run
```

A API estará pronta para receber requisições na porta **8080**!

---

## 🔌 Guia Rápido de Endpoints (Como interagir)

### 1. Criar uma Nova Conta
* **Método:** `POST`
* **URL:** `http://localhost:8080/banco/contas/adicionarConta`
* **JSON de Envio:**
```json
{
  "nomeCliente": "Gustavo Vieira",
  "numConta": 123456,
  "saldo": 1000
}
```

### 2. Listar Todas as Contas
* **Método:** `GET`
* **URL:** `http://localhost:8080/banco/contas`

### 3. Fazer um PIX (Dedução de Saldo)
* **Método:** `POST`
* **URL:** `http://localhost:8080/banco/operacao/{id_da_conta}/pix`
* **JSON de Envio:**
```json
{
  "tipoOperacao": "PIX",
  "valorTransferencia": 150
}
```
*(Se tudo der certo, o saldo da conta associada diminuirá em R$ 150!)*

### 4. Consultar Extrato/Operações de uma Conta
* **Método:** `GET`
* **URL:** `http://localhost:8080/banco/operacao/{id_da_conta}`
