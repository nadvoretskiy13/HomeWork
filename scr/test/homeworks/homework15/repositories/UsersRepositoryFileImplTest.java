package homeworks.homework15.repositories;

import attestation.exceptions.UserNotFoundException;
import attestation.exceptions.ValidationException;
import attestation.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class UsersRepositoryFileImplTest {
    private UsersRepositoryFileImpl repo;
    private String tempFile;
    @BeforeEach
    void setUp() {
        tempFile = "users_test_" + System.nanoTime() + ".txt";
        repo = new UsersRepositoryFileImpl(tempFile);
        repo.deleteAll();
    }
    @AfterEach
    void tearDown() {
        new File(tempFile).delete();
    }
    @Test
    void createAndFindById_positive() {
        User user = new User(UUID.randomUUID().toString(), "login_1", "pass1_", "pass1_", "Иванов", "Иван", null, 30, false);
        repo.create(user);
        User found = repo.findById(user.getId());
        assertEquals("login_1", found.getLogin());
    }
    @Test
    void update_existing_replaces() {
        User u = new User(UUID.randomUUID().toString(), "login_2", "pass2_", "pass2_", "Петров", "Пётр", null, 22, true);
        repo.create(u);
        User upd = new User(u.getId(), u.getCreatedAt(), "login_22", "pass22_", "pass22_", u.getLastName(), u.getFirstName(), u.getPatronymic(),
                u.getAge(), true);
        repo.update(upd);
        assertEquals("login_22", repo.findById(u.getId()).getLogin());
    }
    @Test
    void deleteById_removesOrThrows() {
        User u = new User(UUID.randomUUID().toString(), "login_3", "pass3_",
                "pass3_", "Сидоров", "Сидор", null, 40, false);
        repo.create(u);
        repo.deleteById(u.getId());
        assertThrows(UserNotFoundException.class, () -> repo.findById(u.getId()));
    }
    @Test
    void validation_throwsOnBadFields() {
// логин только цифры — ошибка
        assertThrows(ValidationException.class, () -> new User(UUID.randomUUID().toString(), "123456", "abc_1", "abc_1", "Wrong", "User", null, null, null));
// пароль только буквы — ошибка
        assertThrows(ValidationException.class, () -> new User(UUID.randomUUID().toString(), "ok_login", "onlyletters", "onlyletters", "Иванов", "Иван", null, null, false));
    }
}
