Feature: Login

  Scenario Outline: LoginTest
    Given user launch the application
    And enter "<username>" and "<password>"
    When clicked on Login button
    Then user should get result as "<result>"
    Examples:
        |username|password|result|
        | test   |test    |There has been an error. Your username or password is incorrect. Please try again... |
        | test   |        |Enter Password                                                                    |
        |        |  test  |Enter Username                                                                       |
        |default |default | successful                                                                          |

