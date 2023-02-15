# spring-jwt-authentication-template

Description: This project is developed to demonstrate spring JWT token Authentication feature.
We have api's to register user and create token. To access department api's need to pass bearer token.

Run : run as normal springboot app to see the logs.

Url endpoints:

User Api's:  To register user and generate Token.

POST - http://hostname:portnumber/api/v1/user/register

POST - http://hostname:portnumber/api/v1/user/token

Department Api's : To access deparment api's we have to pass bearer token.

Header : Authorization : Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwYXNzd29yZCIsImlhdCI6MTY3NDY1NDI1NH0.WDLm9-oY0FQ4ofwvjRv-NjmTSQ3b1Ih5d-RnjShB7rU

POST - http://hostname:portnumber/api/v1/departments
GET - http://hostname:portnumber/api/v1/departments
PUT - http://hostname:portnumber/api/v1/departments/{id}
DELETE- http://hostname:portnumber/api/v1/departments/{id}


