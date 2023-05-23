# Homework

## E-COMMERCE SERVICE

This project, is an API that proceeds **Users, Products and Comments** (`GET, POST, PUT` and `DELETE`) request.

---
# Build Spring Boot Project with Maven
    mvn package
## `or`
    mvn install / mvn clean install
## Run Spring Boot app using Maven:
    mvn spring-boot:run
## `[optional]` Run Spring Boot app with java -jar command
    java -jar target/mywebserviceapp-0.0.1-SNAPSHOT.jar

---
## Endpoints

 You can make API request via API test tools.( Postman or cURL):

**User**
- `[POST] api/v1.0/users`: Saves user. 
- `[GET] api/v1.0/users`: Gets user by username.
- `[GET] api/v1.0/users/all`: Gets all users.
- `[GET] api/v1.0/users/{id}`: Gets user by id.
- `[PUT] api/v1.0/users/{id}`: Updates user data.
- `[DELETE] api/v1.0/users`: Deletes user with username and phone number.
  
**Product**
- `[POST] api/v1.0/products`: Saves product. 
- `[GET] api/v1.0/products`: Gets all products.
- `[GET] api/v1.0/products/{id}`: Gets product by id.
- `[PUT] api/v1.0/products/{id}`: Updates product data.
- `[DELETE] api/v1.0/products/{id}`: Deletes product by id.

**Comment**
- `[POST] api/v1.0/comments`: Saves comment. 
- `[GET] api/v1.0/comments/user/{userid}/all`: Gets all comments of user.
- `[GET] api/v1.0/comments/product/{productid}/all`: Gets all comments of product.
- `[DELETE] api/v1.0/comments/{id}`: Deletes comment.
  
****
## Custom Exceptions

- `UserDataNotPairingException` : if username and phone number are not pairing for signed user throws this exception

- `ThereIsNoCommentOnUserException` : if user has no comments throws this exception

- `ThereIsNoCommentOnProductException` : if product has no comment throws this exception

---
If you have any questions or feedback regarding the project, please feel free to reach out to me. You can contact me through the following:

`Email:` dikbykmert@gmail.com

`Twitter:` @**mertdkb**