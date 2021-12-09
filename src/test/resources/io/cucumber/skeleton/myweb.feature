Feature: Autenticacion
  Como usuario de la página web
  queremos registrarnos y logearnos
  para comprobar el funcionamiento de la web

  Scenario: Registro
    When Voy a la pagina de inicio
    Then Deberia ver el boton de "Crear cuenta"
    #Then Voy a la pagina de registro
    #Then Deberia ver el boton de "yt1"

#Feature: Carrito
#  El usuario entra a la pagina web
#  comprueba que su carrito esta vacío
#  añade productos al carrito
#  comprueba que los productos se han añadido
#  elimina los productos
#  comprueba que los productos se han eliminado

  Scenario: Carrito vacío
    Given Voy a la pagina de inicio
    When Voy al carrito
    Then Deberia ver el texto "Tu carrito de la compra está vacío.!"



#  Scenario: My website has a "About Me" section
#    Given I go to the home page
#    When I click on "Oubiti" button
#    Then I should see a "About Me" text
#    And I take a screenshot with filename "About Me"
