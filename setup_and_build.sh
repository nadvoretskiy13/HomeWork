#!/bin/bash

# Создаем папки для исходников и тестов
mkdir -p src/main/java/homeworks/homework16/cars
mkdir -p src/main/java/homeworks/homework16/garage
mkdir -p src/main/java/homeworks/homework16/races
mkdir -p src/main/java/homeworks/homework16/repository
mkdir -p src/test/java/homeworks/homework16

echo "Папки созданы."

# Перемещаем файлы (поменяй пути, если файлы в другом месте)
mv App16.java src/main/java/homeworks/homework16/
mv cars/*.java src/main/java/homeworks/homework16/cars/
mv garage/*.java src/main/java/homeworks/homework16/garage/
mv races/*.java src/main/java/homeworks/homework16/races/
mv repository/*.java src/main/java/homeworks/homework16/repository/
mv CarRepositoryTest.java src/test/java/homeworks/homework16/

echo "Файлы перемещены."

# Проверяем структуру
echo "Текущая структура src/main/java/homeworks/homework16/:"
tree src/main/java/homeworks/homework16/

# Чистая сборка и компиляция
mvn -f pom16.xml clean compile

# Проверка .class файлов
echo "Скомпилированные классы:"
find target/classes -name "*.class"

# Сборка fat JAR
mvn -f pom16.xml package

echo "Готово! Fat JAR в target/cars-races.jar"