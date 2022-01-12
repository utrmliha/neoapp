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
Para subir a aplicação em docker voce precisa criar o .jar usando o maven caso instalado, na raiz da aplicação use :
```
mvn clean package
```
Ou só 
```
mvn package
```
Os Goals ```clean package``` tambem podem ser executados usando o processo de build da sua propia IDE.<br />
Caso use Intellij, veja esse processo no tópico <b>[Run a Maven goal or a set of goals via Run configuration](https://www.jetbrains.com/help/idea/work-with-maven-goals.html#trigger_goal)<b/> <br />
Caso use Eclipse,
