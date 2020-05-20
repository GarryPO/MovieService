# MovieService
Example project of testing Movie Service API
Java doc can be found at https://garrypo.github.io/MovieService/

# Run
Make sure you have java 8 and maven installed 
1. From root folder of the project via comand line execute :" mvn clean test"
2. After test suit is finished you can generate report via "mvn clean allure:report"
Report should be located in "allure-report' folder - just open index.html
3. Test class can be found via src/test/java/SimpleTest.java


# Test Plan:

1. Test if user can get existing movie details by index via GET method
  Expected result: Movie details should be returned, response code should be 200
  
2. Test if user tries to get movie details which doesn't exist in the service he recives correct responce.
   Expected result: no movie details should be returned, response conde should be 404
   
3. Test if user can insert new movie details via POST method.
    Expected result: new movie datails are added to the service, responce code is 200, response body contains movie index
    
4. Test if user can get newly created movie from previous test by its index via GET method;
    Expected result: newly created movie details should be successfly returned to user, response status code should be 200
5. Test if user can modify exiting movie details via PUT method.
    Expected result: Movie details should be successfuly modified according to users request, responce status code should be 200
6. Test if user is able to delete movie from service by its index via DELETE method
    Expected result: Movie details should be seccessfuly deleted from service, responcse status should be 200 , if user request this movie by its index responce status should be 404

7. Test if user request for deleted movie details by its index via GET method he recives correct response.
    Expected result: no movie details is returned to user, response status code is 404
8.Test if user is not able to POST movie details with additional fields not defined by JSON scheme 
  Expected result: user unable to POST movie details with additional fields not defined by JSON scheme , response code should be 400
9. Test that user is not able to insert via POST or PUT new movie with negative date.
    Expected resut: user unable to insert movie details with negative date, response status code should be 400 

  
    
