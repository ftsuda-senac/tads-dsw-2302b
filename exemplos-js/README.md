# Exemplos Javascript

Projeto Spring Boot contendo exemplos de códigos Javascript

Contém também um exemplo básico inicial de criação de `@Controller` e `@RestController`

## Requisitos

- Java JDK 17 ou superior instalado na máquina

## Criação do projeto inicial via Spring Initializr

Acessar o seguinte endereço: [http://start.spring.io](https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.1.3&packaging=jar&jvmVersion=17&groupId=br.senac.tads.dswb&artifactId=exemplos-js&name=exemplos-js&description=Demo%20project%20for%20Spring%20Boot&packageName=br.senac.tads.dswb.exemplos&dependencies=devtools,lombok,configuration-processor,web,thymeleaf,validation) (neste caso, já está pré-configurado com as opções apresentadas em aula)

## Para rodar

- Abrir o projeto na IDE de preferência
- Executar o arquivo ExemploApplication.java e acompanhar o log de inicialização
- Acessar as seguintes URLs pelo navegador:
    - http://localhost:8080 - Acessa index.html (arquivo disponível em `/src/main/resources/static`) com os exemplos Javascript
    - http://localhost:8080/tradicional - Rota para enviar requisição ao `TradicionalController.java` - Template da tela apresentada está em `/src/main/resources/template`
    - http://localhost:8080/ws - Rota para enviar requisição ao `WebServiceController.java`
