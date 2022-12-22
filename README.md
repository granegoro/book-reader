[![Build status](https://ci.appveyor.com/api/projects/status/mqithpvlbffsi64j?svg=true)](https://ci.appveyor.com/project/granegoro/books-beeline)

### Автоматизация тестирования комплексного сервиса, взаимодействующего с СУБД и API Банка

SUT — веб-сервис, который предлагает купить тур по определённой цене двумя способами:
- Обычная оплата по дебетовой карте
- Dыдача кредита по данным банковской карты

Приложение в собственной СУБД должно сохранять информацию о том, успешно ли был совершён платёж и каким способом.
Само приложение не обрабатывает данные по картам, а пересылает их в симулятор банковских сервисов Paymetn Gate и Credit Gate.

### Документация

[Перечень автоматизированных тестовых сценариев](https://github.com/granegoro/books-beeline/blob/main/docs/Plan.md)


# Процедура запуска автотестов

## Подготовка окружения
Необходимо установить следующее ПО:
1. [Java](https://adoptium.net/temurin/releases/?utm_source=pocket_reader&version=11)
2. [Intellij IDEA](https://www.jetbrains.com/idea/download/)

## Запуск тестов
1. Клонировать репозиторий с проектом в Intellij IDEA
2. Дважды нажать клавишу `Ctrl`, в открывшемся окне ввести команду:
```
./gradlew clean test
```
## Формирование Allure Report
Дважды нажать клавишу `Ctrl`, в открывшемся окне ввести команду:
```
./gradlew allureServe
```
