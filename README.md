[![Build status](https://ci.appveyor.com/api/projects/status/mqithpvlbffsi64j?svg=true)](https://ci.appveyor.com/project/granegoro/books-beeline)

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
