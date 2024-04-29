Feature: Тестирование проведение транзации (перевод с карты на карту)
  Scenario: Проверка баланса обеих карт, проведение успешной операцией, повторная проверка баланса карт

    When get balance from card "3000400020001000"
    Then response is success
    And balance equals "5000"
    When get balance from card "2490120398736251"
    Then response is success
    And balance equals "100"
    When create transaction with body "transactionBody.json"
    Then response is success
    And response equals "Ok"
    When get balance from card "3000400020001000"
    Then response is success
    And balance equals "1000"
    When get balance from card "2490120398736251"
    Then response is success
    And balance equals "4100"

