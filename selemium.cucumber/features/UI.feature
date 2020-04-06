Feature: Test CheckOut Scenario

  Scenario: Scenario For Purchasing Pillow Transaction Successful
    Given Open browser and goto home page
    Then Click on Buy Now button
    Then Click on CheckOut button
    Then Check Sample Store pop-up opens
    Then On Order Summary pop-up opens check iteams and Amount and click on continue
    Then On Select Payment pop-up select credit card as a payment mode
    Then On Credit Card pop-up right card number for Successful Payment
    Then On Credit Card pop-up enter card details and click on pay now button
    Then Check Issuing Bank pop-up is loaded and proceed with OTP
    Then Verify for the Success Message

  Scenario: Scenario For Purchasing Pillow Transaction Failed
    Given Open browser and goto home page
    Then Click on Buy Now button
    Then Click on CheckOut button
    Then Check Sample Store pop-up opens
    Then On Order Summary pop-up opens check iteams and Amount and click on continue
    Then On Select Payment pop-up select credit card as a payment mode
    Then On Credit Card pop-up wrong card number for Successful Payment
    Then On Credit Card pop-up enter card details and click on pay now button
    Then Check Issuing Bank pop-up is loaded and proceed with OTP
    Then Verify for the Failuar Message
