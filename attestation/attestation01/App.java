package attestation.attestation01;


import attestation.attestation01.User;
import attestation.attestation01.repositories.UsersRepository;
import attestation.attestation01.repositories.UsersRepositoryFileImpl ;
import java.util.List;
import java.util.UUID;
public class App {
    public static void main(String[] args) {
// a) Сформировать файл с набором пользователей (файл создастся при первой записи)
        UsersRepository repo = new UsersRepositoryFileImpl(UsersRepositoryFileImpl.DEFAULT_FILE);
// начисто
        repo.deleteAll();
        User u1 = new User(UUID.randomUUID().toString(), "noisemc_99", "789ghs", "789ghs", "Крылов", "Виктор", "Павлович", 25, true);
        User u2 = new User(UUID.randomUUID().toString(), "alice_1", "abc123_", "abc123_", "Иванова", "Алиса", null, 30, false);
        User u3 = new User(UUID.randomUUID().toString(), "bob_2", "qwe123_", "qwe123_", "Петров", "Борис", null, 25, true);
        repo.create(u1);
        repo.create(u2);
        repo.create(u3);
// b) Проверка функций
        System.out.println("Все пользователи:");
        repo.findAll().forEach(System.out::println);
        System.out.println("\nПоиск по id u1:");
        System.out.println(repo.findById(u1.getId()));
        System.out.println("\nОбновление u2 (смена логина и статуса сотрудника):");
        User u2upd = new User(u2.getId(), u2.getCreatedAt(), "alice_dev", "abc123_", "abc123_", u2.getLastName(), u2.getFirstName(), u2.getPatronymic(), u2.getAge(), true);
        repo.update(u2upd);
        System.out.println(repo.findById(u2.getId()));
        System.out.println("\nПоиск по возрасту = 25:");
        List<User> age25 = repo.findByAge(25);
        age25.forEach(System.out::println);
        System.out.println("\nПоиск сотрудников (isWorker=true):");
        repo.findByIsWorker(true).forEach(System.out::println);
        System.out.println("\nУдаление u3:");
        repo.deleteById(u3.getId());
        repo.findAll().forEach(System.out::println);
        System.out.println("\nУдаление всех пользователей:");
        repo.deleteAll();
        System.out.println("Размер списка: " + repo.findAll().size());
// Демонстрация обновления несуществующего пользователя (создание нового)
        System.out.println("\nUpdate несуществующего — будет создан новый:");
        User phantom = new User(UUID.randomUUID().toString(), "new_user_1", "pass_1", "pass_1", "Сидоров", "Семён", null, null, false);
        repo.update(phantom);
        System.out.println(repo.findById(phantom.getId()));
    }
}