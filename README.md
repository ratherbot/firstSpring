Студент: Бухарбаев Ильмир Ильнурович<br>

Преподаватель: Иванов Никита<br>

Основные параметры, которые предоставляет @SpringBootApplication:

1. @EnableAutoConfiguration<br>
Это ключевая аннотация, которая позволяет Spring Boot автоматически конфигурировать ваше приложение, исходя из библиотек, доступных в classpath, и других факторов. Например, если в проекте есть зависимость от Spring Data JPA, Spring Boot автоматически настроит соединение с базой данных.<br>
Пример:<br>
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})

2. @ComponentScan
Эта аннотация указывает Spring, где искать компоненты, такие как @Component, @Service, @Repository, @Controller, и другие аннотации. По умолчанию она сканирует пакет, в котором находится класс с аннотацией @SpringBootApplication, и все его подпакеты.<br>
Пример:<br>
@ComponentScan(basePackages = "com.myapp")

3. @Configuration
Это стандартная аннотация Spring, которая помечает класс как конфигурационный для контекста Spring. В классе с аннотацией @Configuration могут быть размещены бины и настройки.<br>
Пример:<br>
@SpringBootApplication(proxyBeanMethods = false)
