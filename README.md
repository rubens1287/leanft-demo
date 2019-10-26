# NOME-DO-SISTEMA

Aplique uma breve descrição do projeto/sistema que você está desenvolvendo, explicando o contexto.


## PRÉ-REQUISITOS

Descreva abaixo os requisitos de software e hardware que é necessário para executar este projeto de automação

*   Java 1.8 SDK
*   Maven 3.5.*
*   Node.js 8.*
*   Intellij 2017.3
*   git bash

## INSTALAR PACOTE DE SDK'S DO LEANFT NO MAVEN LOCAL

Copie as linhas de comando abaixo depois abra o aplicativo git bash e cole dentro, depois só pressionar o botão "Enter" para que seja instalado todas as depedências necessárias para usar o leanFT.

```
mvn install:install-file -Dfile="C:\Program Files (x86)\Micro Focus\LeanFT\SDK\Maven\com.hp.lft.common-14.53.0.jar" -DpomFile="C:\Program Files (x86)\Micro Focus\LeanFT\SDK\Maven\com.hp.lft.common-14.53.0-pom.xml" 
mvn install:install-file -Dfile="C:\Program Files (x86)\Micro Focus\LeanFT\SDK\Maven\com.hp.lft.reportbuilder-14.53.0.jar" -DpomFile="C:\Program Files (x86)\Micro Focus\LeanFT\SDK\Maven\com.hp.lft.reportbuilder-14.53.0-pom.xml" 
mvn install:install-file -Dfile="C:\Program Files (x86)\Micro Focus\LeanFT\SDK\Maven\com.hp.lft.report-14.53.0.jar" -DpomFile="C:\Program Files (x86)\Micro Focus\LeanFT\SDK\Maven\com.hp.lft.report-14.53.0-pom.xml" 
mvn install:install-file -Dfile="C:\Program Files (x86)\Micro Focus\LeanFT\SDK\Maven\com.hp.lft.sdk-14.53.0.jar" -DpomFile="C:\Program Files (x86)\Micro Focus\LeanFT\SDK\Maven\com.hp.lft.sdk-14.53.0-pom.xml" 
mvn install:install-file -Dfile="C:\Program Files (x86)\Micro Focus\LeanFT\SDK\Maven\com.hp.lft.unittesting-14.53.0.jar" -DpomFile="C:\Program Files (x86)\Micro Focus\LeanFT\SDK\Maven\com.hp.lft.unittesting-14.53.0-pom.xml" 
mvn install:install-file -Dfile="C:\Program Files (x86)\Micro Focus\LeanFT\SDK\Maven\com.hp.lft.verifications-14.53.0.jar" -DpomFile="C:\Program Files (x86)\Micro Focus\LeanFT\SDK\Maven\com.hp.lft.verifications-14.53.0-pom.xml"
```

## PAGE OBJECTS

*   Login
    * [logar](src/main/java/br/comprimecontrol/Login.java)
*   MenuPrincipal
    * [validaMenuPrincipal](src/main/java/br/comprimecontrol/MenuPrincipal.java)


## EMPRESA DESENVOLVEDORA

Coloque o nome da empresa ou parceiro que desenvolveu esta automação

## AUTORES

* **Fulano 1**
* **Fulano 2**
* **Fulano 3**
* **Fulano ...**