# NASApp
Generate random photos from the NASA APOD API!

## Check out the app live on Heroku:

## This is a heroku hobby project so please give it 10-20s for the cold start!

https://nasa-apod-photos.herokuapp.com/

## Development

- Run the Spring Boot application which will run on port 8080
- Run the Vue application (/src/frontend)  which will run on port 3000
- All calls to `/api/**` are proxied to 8080 thanks to `vue.config.js`

## Packaging 

When you run `mvn clean package` the frontend Vue application will build in the `dist` directory. 
The Maven plugin `maven-resources-plugin` will copy the contents of the build directory into `/target/static/classes`

## Deployment

The `system.properties` is a file I used for Heroku to set the Java version and deploy the application. 



