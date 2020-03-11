# UI Test Cases 

The UI test automation framework is based on Selenium Java and Junit 4 and it is following the Page Object design pattern where each one of the pages in the web application has its own class with all the actions/iteractions defined as methods.

I have choosen www.myers.com.au as the e-commerce site for this test and have written automated test cases for 2 scenarios ( a product search and adding one product to the cart ) . Unfortunately, I have no time to write the test for the third scenario. 
1. Product Searching test scenario (testSearchForTv)
   1. open www.myers.com.au
   2. click on the search button , enter the product name and click enter ( no wait for the product suggestion list ).
   3. Check if the product page is found 
  
2. Add Product to the cart (testAddProductToCart)
   1. open a page for a specific product
   2. Add the product to the card selecting the correct button
   3. go to the cart and check if the product information is correct
   
   *Note*: There is a strange behaviour when adding a product to the cart. It looks the cart page has different behaviours based on the flow and execution. It shows "Your Bag" or "My Bag" as title in Cart page causing the tests to fail sometimes. I need to understand the requirements/UX of the page to implement a more reliable test script.
   
I have tried to run the tests using SauceLabs and BrowserStack , but I was not able to open an account using my personal email address.
## How to run 
just run **"mvn test"** or direct from your IDE ( in my case, IntelliJ)
   
# Bug
1. Description: Searching is returning incorrect product
2. Steps : 
   1. search for "4k smart tv" on myers.com.au website
3. Expected results: 
   * the result page should ONLY show TVs with 4k smart tv in their description / title
4. Actual Results
   * a BlueRay player is returned in the product listing page.
   
# API Tests
All the scenarions have been implemented using Java and RestAssured ( http://rest-assured.io/ ) to validate the API responses.
## How to run 
just run **"mvn test"** or direct from your IDE ( in my case, IntelliJ)
