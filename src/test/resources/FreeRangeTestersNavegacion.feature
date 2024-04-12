Feature:  Nav BAR
    Soo this is importat

    Scenario Outline: Escenario
        Given  I navigate
        When    I go to <section> using the navigation bar
        Examples:
            | section |
            | Cursos | 
            | Recursos | 
            | Udemy |
            | Mentorías |
            | Newsletter |