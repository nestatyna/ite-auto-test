# Agent API Automation Tests

## Описание проекта

Этот проект представляет собой автоматизированное тестирование REST API агента `agent.exe` – упрощённой имитации агента системы САКУРА.  
Агент предоставляет HTTP-концы для получения информации о рабочем месте, пользователях, установленном ПО и комплаенс-статусе.  
Тесты запускаются локально, проксируются через WireMock. В случае необходимости мок-сервис мокирует запрос.

### Техстек

- Java 17
- Gradle
- Lombok
- RestAssured
- WireMock

## Структура проекта
- `src/test/java/tests` - тестовые классы
- **BugReports.md** – Документ с описанием найденных ошибок.
- **README.md** – Данный файл с описанием проекта.

## Запуск тестов

### Локальный запуск
Запуск всех тестов:
```sh
./gradlew test
```