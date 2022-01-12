# Api RestFul de gerenciamento de clientes
 - ACESSO A API

Link da aplicação: https://neoapplication.herokuapp.com <br />
OBS: Ela fica adomercida após 30min sem requisições, então a primeira requisição demorará um pouco até q o servidor inicie o Dyno

 - DOCUMENTAÇÃO

A documentação se encontra na raiz do projeto, nela esta descrita o funcionamento da api
<br /><br />
<img src="https://uploaddeimagens.com.br/images/003/625/529/full/imagem_2022-01-11_235948.png?1641956390" width = 800/>

- GUIA DE USO

Clone o repositorio para algum local usando:
```git
git clone git@github.com:utrmliha/neoapp.git
```
Para subir a aplicação em docker voce precisa criar o .jar da aplicação usando o maven caso instalado, na raiz da aplicação use :
```
mvn clean package
```
Ou só 
```
mvn package
```
Os Goals ```clean package``` tambem podem ser executados usando o processo de build da sua propia IDE.<br />
Caso use Intellij, veja esse processo no tópico <b>[Run a Maven goal or a set of goals via Run configuration](https://www.jetbrains.com/help/idea/work-with-maven-goals.html#trigger_goal)</b> <br />
Caso use Eclipse, <b>[Clique aki](https://kkjavatutorials.com/how-to-create-a-runnable-jar-file-with-maven/)</b>

Gerando o ```neoapp.jar``` na pasta ```/target``` ja está pronto para criar a imagem da aplicação.<br />
Na pasta raiz da aplicação execulte o comando, substituindo ```igor/neoapp``` pelo nome do container de sua preferência:
```
docker build -t igor/neoapp .
```
Agora use: 
```docker run -p 8080:8080 -e SPRING_PROFILES_ACTIVE='prod' -e DATABASE_URL='jdbc:h2:mem:neoappdb' -e DATABASE_USERNAME='sa' -e DATABASE_PASSWORD='' -e JWT_EXPIRATION='86400000' -e JWT_SECRET='b21fd5bc-f3f3-4f9e-99d6-e46df3e5e340' igor/neoapp``` <br />
E acesse http://localhost:8080/clientes
<br /><br />
OBS: a aplicação usa o H2(Banco em memória) para persistência, caso queira usar o mysql tera que modificar o ```pom.xml``` adicionando o driver do mysql e os dados dos parametros acima
