# BusyFlights Application

## Goal of this application
- Is to obtain flight results from 2 different suppliers (CrazyAir and ToughJet) consuming services from the CrazyAirAndToughJetAPI application using HTTP.

## Creation of a Web Application using the following technologies:
- Spring Boot
- Maven
- REST (POST protocol)

## Why these technologies?
- The choise to use HTTP POST is because when we need to send a body in the HTTP request, is more casual to use POST than GET. One example is the OkHttp library where you can't use HTTP GET to put a body in the body request.
- One suggest would be to use GET using parameters, but there is some limitation of characters in the parameters So, this is not appropriate to use GET with params.
- This application connects to the CrazyAirAndToughJetAPI project via HTTP protocol, using the method POST.

## TODO 
- Create handler or like that to separate the kind of protocol used (JSON).

## How to execute all tests of BusyFlights Application ( Execute via shell the following steps ):
- # Please, check if the CrazyAirAndtoughJetAPI project is running, because when the tests is executed, this application consumes services via REST from CrazyAirAndtoughJetAPI project. For more information see the README -> https://github.com/alexandreJavaDeveloper/CrazyAirAndToughJetAPI/blob/master/README.md
- git clone https://github.com/alexandreJavaDeveloper/BusyFlights.git
- cd BusyFlights/
- mvn clean package