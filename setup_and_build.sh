#!/bin/bash

# Папки Maven
mkdir -p src/main/java/homeworks/homework16/cars
mkdir -p src/main/java/homeworks/homework16/garage
mkdir -p src/main/java/homeworks/homework16/races
mkdir -p src/main/java/homeworks/homework16/repository
mkdir -p src/test/java/homeworks/homework16/repository

# Перемещаем исходники
mv scr/homeworks/homework16/App16.java src/main/java/homeworks/homework16/
mv scr/homeworks/homework16/cars/*.java src/main/java/homeworks/homework16/cars/
mv scr/homeworks/homework16/garage/*.java src/main/java/homeworks/homework16/garage/
mv scr/homeworks/homework16/races/*.java src/main/java/homeworks/homework16/races/
mv scr/homeworks/homework16/repository/*.java src/main/java/homeworks/homework16/repository/

# Перемещаем тесты
mv scr/test/homeworks/homework16/repository/*.java src/test/java/homeworks/homework16/repository/

# Проверка структуры
echo "Структура src/main/java/homeworks/homework16:"
find src/main/java/homeworks/homework16

echo "Структура src/test/java/homeworks/homework16:"
find src/test/java/homeworks/homework16

# Чистая сборка и компиляция
mvn -f pom16.xml clean compile

# Проверка .class файлов
echo "Скомпилированные классы:"
find target/classes -name "*.class"

# Сборка fat JAR
mvn -f pom16.xml package

echo "Готово! Fat JAR должен появиться в target/cars-races-1.0-SNAPSHOT-shaded.jar"
