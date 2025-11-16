## Projeto Spring Boot com integração ao Google Gemini AI

Projeto desenvolvido em Java usando Spring Boot e Maven, o microserviço desenvolvido tem integração com a API Gemini do Google, retornando respostas usando AI.

### Sobre o Gemini

> Gemini é um chatbot desenvolvido pelo Google, baseado na família de modelos de linguagem LaMDA, concorrente ao ChatGPT da OpenAI.

### Tecnologia
- Java 25
- Maven
- Spring Boot 3.5.7

### API

![image](https://github.com/santosjennifer/ai-integration/assets/90192611/905037d7-973b-4683-8515-f61efa54cd16)


## 🚀 Rodando o projeto com Docker

O Docker Compose irá **construir a imagem**, carregar variáveis do `.env` e subir o container automaticamente.

### 🔐 Arquivo `.env`

Antes de rodar o projeto, crie um arquivo `.env` na raiz do repositório com o seguinte conteúdo:
```sh
API_KEY=coloque_sua_api_key_aqui
```

### **Comando:**

```sh
docker-compose up --build
```

### 🧪 Testando a API

Com o container em execução:

Abra o Swagger/OpenAPI:
```sh
http://localhost:6001/swagger-ui/index.html
```
