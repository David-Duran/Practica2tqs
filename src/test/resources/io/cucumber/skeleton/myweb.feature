Feature: Autenticacion
  Como usuario de la página web
  queremos registrarnos y logearnos
  para comprobar el funcionamiento de la web

  Scenario: Registro
    When Voy a la pagina de inicio
    Then Deberia ver el boton de "Crear cuenta"
    #Then Voy a la pagina de registro
    #Then Deberia ver el boton de "yt1"




#  Scenario: My website has a "About Me" section
#    Given I go to the home page
#    When I click on "Oubiti" button
#    Then I should see a "About Me" text
#    And I take a screenshot with filename "About Me"
