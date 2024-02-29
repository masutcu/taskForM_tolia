@task12
Feature:Automation Exercises Task12
        #TASK12
        #1. Launch browser
        #2. Navigate to url 'http://automationexercise.com'
        #3. Verify that home page is visible successfully
        #4. Click 'Products' button
        #5. Hover over first product and click 'Add to cart'
        #6. Click 'Continue Shopping' button
        #7. Hover over second product and click 'Add to cart'
        #8. Click 'View Cart' button
        #9. Verify both products are added to Cart
        #10. Verify their prices, quantity and total price


  Scenario: Task12
    Given User goes to homePage
    Then Verify that home page is visible successfully
    And Click 'Products' button
    Then user scrolls down the page
    And Hover over "first" product and click Add to cart
    And Click 'Continue Shopping' button
    And Hover over "second" product and click Add to cart
    And Click 'View Cart' button
    Then Verify both products are added to Cart
    Then Verify their prices, quantity and total price

