Feature: El usuario abre el menu y interacciona con el
  seleccionando una categoria
  y entrando a una opcion de esa categoria

  Scenario: Abro el menu
    Given Voy a la pagina de inicio
    And Espero "2" segundo
    When Abro el menu
    And Espero "2" segundo
    Then Deberia ver el texto "Alimentación Saludable"
    And Deberia ver el texto "Nutrición Deportiva"

  Scenario: Selecciono categoria de menu
    Given Voy a la pagina de inicio
    And Espero "2" segundo
    And Abro el menu
    And Espero "2" segundo
    When Selecciono la categoria "2"
    And Espero "1" segundo
    Then Veo el submenu

Scenario: Selecciono una opcion de una categoria del menu
  Given Voy a la pagina de inicio
  And Espero "2" segundo
  And Abro el menu
  And Espero "2" segundo
  And Selecciono la categoria "3"
  And Espero "1" segundo
  When Hago clic en el boton de "Vitaminas"
  And Espero "1" segundo
  Then Deberia ver el texto "Vitaminas"