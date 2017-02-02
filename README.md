# BusyFlights

* The choise to use HTTP POST is because when we need to send a body in the HTTP request
* is more casual to use POST than GET. One example is the OkHttp library where you can't
* use HTTP GET to put a body in the body request.
* One option would be to use GET using params, but there is some limitation of characters in the
* params. So, this is not appropriate to use.

TODO 
- valid the date ISO8601 
- valid variables that has max numbers.
- Criar handler/algo assim para separar o tipo de protocolo usado (json)
- Informar que para rodar os testes do projeto BusyFlights, tem que deixar o outro projeto rodando, da API
- passar para mock request..