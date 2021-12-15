Feature: El usuario entra a la pagina web
  comprueba que su carrito esta vacío
  añade productos al carrito
  comprueba que los productos se han añadido
  elimina los productos
  comprueba que los productos se han eliminado

  Scenario: Carrito vacío
    Given Voy a la pagina de inicio
    When Voy al carrito
    Then Deberia ver el texto "Tu carrito de la compra está vacío.!"
    
  Scenario: Añadir un producto
    Given Voy a la pagina de inicio
    When Busco "100% Real Whey Protein 1000 g"
    And Espero "2" segundo
    And Acepto las cookies
    And Añado el primer producto
    And Espero "2" segundo
    And Voy al carrito
    Then Deberia ver el texto "100% Real Whey Protein 1000 g"

  Scenario: Añado y elimino un producto
    Given Voy a la pagina de inicio
    When Busco "100% Real Whey Protein 1000 g"
    And Espero "2" segundo
    And Acepto las cookies
    And Añado el primer producto
    And Espero "2" segundo
    And Voy al carrito
    And Elimino el primer producto
    And Espero "2" segundo
    Then Deberia ver el texto "Tu carrito de la compra está vacío.!"

