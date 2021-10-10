# SuperaApi
# Frameworks utilizados:
- [x] Spring Boot
- [x] Spring MVC
- [x] MySQL DB
- [x] Maven
- [x] GIT


Foi utilizado o FrameWork SpringBoot devido o aumento de produtividade no desenvolvimento de uma API.O SpringBoot é de fácil configuração, fácil para declarar as Anotations 
e injenção de dependências. O Spring também forence outras ferramentas. Ex : Spring Security, Spring JPA, Spring MVC , SERVIDOR embutido " TOMCAT" .



# Gestão Api - ecommerce de games / PRODUTOS

<b> URL : http://localhost:8080/ </b>

- URL : http://localhost:8080/produtos

Métodos : <b> GET </b> // <i>Utilizado para buscar todos os Produtos cadastrados no Banco de Dados</i>

- URL : http://localhost:8080/produtos/id

Métodos : <b> GET </b> // <i>Utilizado para buscar um produto por ID </i>

- URL : http://localhost:8080/produtos

Métodos : <b> POST </b> // <i>Utilizado para cadastro de um novo Produto </i>

Exemplo Resquest : 
````
{
            "name": "@Super Mario Odyssey",
            "price": 197.88,
            "score": 100,
            "image": "super-mario-odyssey.png"
        }
````        



- URL : http://localhost:8080/produtos/id

Métodos : <b> DELETE </b> // <i>utilizado para deletar um produto</i>

- URL : http://localhost:8080/produtos/ordemPrice/ordemPrice

Métodos : <b> GET </b> // <i>Método utilizar para buscar produtos por ordem de Preço</i>

- URL : http://localhost:8080/produtos/ordemAlfabetica/ordemAlfabetica

Métodos : <b> GET </b> // <i>Método utilizar para buscar produtos por ordem alfabética</i>

- URL : http://localhost:8080/produtos/ordemScore/ordemScore

Métodos : <b> GET </b> // <i>Método utilizar para buscar produtos por ordem de Score</i>


# Gestão Api - ecommerce de games / Carrinho

<b> URL : http://localhost:8080/ </b>

- URL : http://localhost:8080/CarrinhoController

Métodos : <b> POST </b> // <i>Utilizado para adicionar um produto no carrinho</i>
Exemplo Request :
````
 {
            "id": 501,
            "name": "Horizon Zero Dawn",
            "price": 115.8,
            "score": 290,
            "image": "horizon-zero-dawn.png"
        }
````


- URL : http://localhost:8080/CarrinhoController/id

Métodos : <b> DELETE </b> // <i>Utilizado para remover um produto no carrinho por ID </i>

- URL : http://localhost:8080/CarrinhoController

Métodos : <b> GET </b> // <i>Utilizado para consultar todos os produtos no carrinho</i>

- URL : http://localhost:8080/CarrinhoController/limparCarrinho

Métodos : <b> POST </b> // <i>Utilizado para esvaziar/limpar os produtos no carrinho</i>

# Passos para Reprodução e Instalação :

- Criar o schema "product" na base de dados.

- Baixar código fonte

````  
git clone https://github.com/Wagneresend13/SuperaApi.git
````  

- Executar o script SQL que se encontra no diretório "sql";

- Executar o mvn springboot:run
