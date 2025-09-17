package main.java.homeworks.homework15;


import attestation.exceptions.UserNotFoundException;
import attestation.exceptions.ValidationException;
import attestation.model.User;
import attestation.repositories.UsersRepository;
import attestation.repositories.UsersRepositoryFileImpl;

import java.util.List;
import java.util.UUID;

public class App {
    public static void main(String[] args) {
        UsersRepository repo = new UsersRepositoryFileImpl();

        try {
            // 1. Создание пользователей
            User user1 = new User(
                    UUID.randomUUID().toString(),
                    "noisemc_99",
                    "789ghs",
                    "789ghs",
                    "Крылов",
                    "Виктор",
                    "Павлович",
                    25,
                    true
            );

            User user2 = new User(
                    UUID.randomUUID().toString(),
                    "alex_dev",
                    "abc123",
                    "abc123",
                    "Иванов",
                    "Алексей",
                    null,
                    30,
                    false
            );

            repo.create(user1);
            repo.create(user2);

            // 2. Поиск по ID
            System.out.println("Поиск по ID:");
            User found = repo.findById(user1.getId());
            System.out.println(found);

            // 3. Получение всех пользователей
            System.out.println("\nВсе пользователи:");
            List<User> users = repo.findAll();
            users.forEach(System.out::println);

            // 4. Обновление пользователя
            System.out.println("\nОбновление пользователя:");
            user1.setLastName("Сидоров");
            repo.update(user1);
            System.out.println(repo.findById(user1.getId()));

            // 5. Удаление пользователя по ID
            System.out.println("\nУдаление пользователя по ID:");
            repo.deleteById(user2.getId());
            repo.findAll().forEach(System.out::println);

            // 6. Удаление всех пользователей
            System.out.println("\nУдаление всех пользователей:");
            repo.deleteAll();
            System.out.println("Пользователей осталось: " + repo.findAll().size());

        } catch (ValidationException e) {
            System.err.println("Ошибка валидации: " + e.getMessage());
        } catch (UserNotFoundException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Неизвестная ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }
}