# 📦 Sistema de Gerenciamento de Estoque

Bem-vindo ao **Sistema de Gerenciamento de Estoque**! Este projeto foi desenvolvido em **Java + Spring Boot** com foco em organização, escalabilidade e boas práticas de API REST.

Ele permite o controle de produtos, categorias, usuários administradores e histórico de movimentações dentro de um estoque.

---

## 🚀 Tecnologias Utilizadas

* **Java 21+**
* **Spring Boot** (Web, JPA, Validation)
* **H2 Database** ou **PostgreSQL** (dependendo da sua configuração)
* **Lombok**
* **Maven**
* **JWT** para autenticação (caso esteja implementado)

---

## 📁 Estrutura do Projeto

```
src/
 └── main/
     ├── java/com/anm/estoque/
     │    ├── controller/
     │    ├── service/
     │    ├── repository/
     │    ├── dto/
     │    └── model/
     └── resources/
          ├── application.properties
          └── data.sql (opcional)
```

---

## 🗄️ Entidades Principais

### **Produto**

* `id`
* `nome`
* `preco`
* `modelo`
* `descricao`

### **Categoria**

* `id`
* `nome`
* `descricao`

### **Admin**

* `id`
* `nome`
* `email`
* `senha` (hash)

### **Histórico de Movimentação**

* `id`
* `produto`
* `tipoMovimentacao` (ENTRADA / SAIDA)
* `quantidade`
* `dataHora`

---

## ⚙️ Como Rodar o Projeto

### 🔧 **Pré-requisitos**

* Java 17 instalado
* Maven instalado
* IDE recomendada: IntelliJ ou VS Code

---

## ▶️ Passo a Passo

### **1️⃣ Clonar o repositório**

```bash
git clone https://github.com/seu-usuario/estoque-backend.git
cd estoque-backend
```

### **2️⃣ Instalar dependências**

```bash
mvn clean install
```

### **3️⃣ Configurar o Banco de Dados**

#### Opção 1 — Usar **H2** (memória)

No `application.properties`, deixe:

```
spring.datasource.url=jdbc:h2:mem:estoque
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true
```

#### Opção 2 — Usar **PostgreSQL**

```
spring.datasource.url=jdbc:postgresql://localhost:5432/estoque
spring.datasource.username=postgres
spring.datasource.password=SUA_SENHA
spring.jpa.hibernate.ddl-auto=update
```

---

## ▶️ **4️⃣ Rodar a aplicação**

```bash
mvn spring-boot:run
```

A API ficará disponível em:

```
http://localhost:8080
```

---

## 📌 Endpoints Principais

### **/produtos**

* `GET /produtos` → lista produtos
* `POST /produtos` → cria produto
* `PUT /produtos/{id}` → atualiza produto
* `DELETE /produtos/{id}` → remove produto

### **/categorias**

* CRUD completo

### **/admins**

* Registro e autenticação (se JWT implementado)

### **/movimentacoes**

* Registro de entrada e saída de produtos

---

## 🧪 Testes com H2

Se quiser popular dados para teste, adicione arquivo `data.sql`:

```sql
INSERT INTO tb_produtos(id, nome, preco, modelo, descricao) VALUES
(1, 'Mouse Gamer', 120.00, 'Redragon', 'Mouse RGB 7200 DPI');
```

---

## 🔐 Autenticação (JWT)

Caso esteja usando JWT, a autenticação segue este fluxo:

* `POST /auth/login` → retorna token
* Enviar token no header: `Authorization: Bearer SEU_TOKEN`

---

## 📄 Licença

Este projeto está sob a licença MIT. Sinta-se livre para usar e modificar.

---

## 🤝 Contribuição

Pull requests são bem-vindos! Fique à vontade para melhorar o código, documentação e sugestões.

---

## 💬 Suporte

Se precisar de ajuda, abra uma **issue** no GitHub ou me chame!
