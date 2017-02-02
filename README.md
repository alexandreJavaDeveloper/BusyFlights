# BusyFlights Application

## Creation of a Web Application using the following technologies:
- Spring Boot
- Maven
- REST (POST protocol)

## Why these technologies?
- The choise to use HTTP POST is because when we need to send a body in the HTTP request, is more casual to use POST than GET. One example is the OkHttp library where you can't use HTTP GET to put a body in the body request.
- One option would be to use GET using params, but there is some limitation of characters in the params. So, this is not appropriate to use GET with params.
- This application connects to the CrazyAirAndToughJetAPI project via HTTP protocol, using the method POST.

## TODO 
- Criar handler/algo assim para separar o tipo de protocolo usado (json)

## How to run all tests the BusyFlights Application ( Execute via shell the following steps ):
- # Please, check if the CrazyAirAndtoughJetAPI project is running, because when the tests is executed, this application consumes services via REST from CrazyAirAndtoughJetAPI project. For more information see the README -> https://github.com/alexandreJavaDeveloper/CrazyAirAndToughJetAPI/blob/master/README.md
- git clone https://github.com/alexandreJavaDeveloper/BusyFlights.git
- cd BusyFlights/
- mvn clean package
