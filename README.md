# Swapi Integration with spring boot

 This is a spring boot application that integrates [SWAPI](https://swapi.dev/) the famous Star Wars public API.


## Documentation

For API reference visit 
[Swagger UI](https://starwars-api-v2dt.onrender.com/swagger-ui/index.html). The application is hosted in Render.
It is a free instance of a web service so it will spin down with inactivity, which can delay requests by 50 seconds or more.


## Pre-requisites

- Java 17


## Installation

Clone this project and run it with your IDE, preferably use IntelliJ for running this application locally. 

Remember to configure Lombok plugin:

 ![App Screenshot](https://i.imgur.com/6iltNTY.png)

    
## Run Locally

Clone the project

```bash
  git clone https://github.com/MartinMarandola/starwars-api.git
```

## Environment Variables

To run this project, you will need to add the following environment variables to your .env file to the root directory

`SPRING_PROFILES_ACTIVE`

`DB_URL`

`DB_USERNAME`

`DB_PASSWORD`

### For a .env example
```javascript
SPRING_PROFILES_ACTIVE=dev
DB_URL=jdbc:mysql://localhost:3306/bbdd_starwars_api?createDatabaseIfNotExist=true
DB_USERNAME=root
DB_PASSWORD=root
