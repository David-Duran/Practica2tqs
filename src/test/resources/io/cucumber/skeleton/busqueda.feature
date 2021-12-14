Feature: Busqueda de productos
  donde encontramos resultados,
  no encontramos resultados,
  filtramos por descuentos
  i ordenamos los resultados

  Scenario: Busqueda
    Given Voy a la pagina de inicio
    When Busco "Barritas"
    When Espero "1" segundo
    Then Deberia ver el texto "Productos"

  Scenario: Busqueda sin productos
    Given Voy a la pagina de inicio
    When Busco "egegegeg"
    When Espero "1" segundo
    Then Deberia ver el texto "Lo sentimos, pero no se han encontrado resultados"

  Scenario: Busqueda numerica
    Given Voy a la pagina de inicio
    When Busco "12"
    When Espero "1" segundo
    Then Deberia ver el texto "Productos"

  Scenario: Busqueda y ordenacion
    Given Voy a la pagina de inicio
    Given Espero "2" segundo
    Given Acepto las cookies
    When Busco "Barritas"
    When Espero "1" segundo
    When Ordeno por "Destacados"
    When Espero "1" segundo
    Then Deberia ver el texto "Destacados"

  Scenario: Busqueda y filtro
    Given Voy a la pagina de inicio
    Given Espero "2" segundo
    Given Acepto las cookies
    When Busco "Barritas"
    When Espero "1" segundo
    When Filtro por "10% de descuento"
    When Espero "1" segundo
    Then Deberia ver el texto "Filtrar por:"