Feature: Busqueda de productos
  donde encontramos resultados,
  no encontramos resultados,
  filtramos por descuentos
  i ordenamos los resultados

  Scenario: Busqueda
    Given Voy a la pagina de inicio
    When Busco "Barritas"
    And Espero "1" segundo
    Then Deberia ver el texto "Productos"

  Scenario: Busqueda sin productos
    Given Voy a la pagina de inicio
    When Busco "egegegeg"
    And Espero "1" segundo
    Then Deberia ver el texto "Lo sentimos, pero no se han encontrado resultados"

  Scenario: Busqueda numerica
    Given Voy a la pagina de inicio
    When Busco "12"
    And Espero "1" segundo
    Then Deberia ver el texto "Productos"

  Scenario: Busqueda y ordenacion
    Given Voy a la pagina de inicio
    And Espero "2" segundo
    When Busco "Barritas"
    And Espero "1" segundo
    And Ordeno por "Destacados"
    And Espero "2" segundo
    Then Deberia ver el texto "Destacados"

  Scenario: Busqueda y filtro
    Given Voy a la pagina de inicio
    And Espero "2" segundo
    When Busco "Barritas"
    And Espero "1" segundo
    And Filtro por "10% de descuento"
    And Espero "1" segundo
    Then Deberia ver el texto "Filtrar por:"