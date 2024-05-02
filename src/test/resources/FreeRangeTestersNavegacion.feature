Feature:  Nav BAR
    Soo this is importat

    # Scenario Outline: Escenario
    #     Given  I navigate
    #     When    I go to <section> using the navigation bar
    #     Examples:
    #         | section |
    #         | Cursos | 
    #         | Recursos | 
    #         | Udemy |
    #         | Mentorías |
    #         | Newsletter |
    # Scenario: Courses are presented correctly to potential customers
    #     Given I navigate
    #     When I go to Cursos using the navigation bar
    #     And  select Introduccion al Testing
    Scenario: Users can select a plan when signing up
        Given I navigate
        And  I select Elegir Plan