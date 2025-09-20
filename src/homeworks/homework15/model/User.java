package homeworks.homework15.model;

import attestation.exceptions.ValidationException;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.regex.Pattern;


public class User {
    private String id; // гарантированно уникальный
    private LocalDateTime createdAt; // дата добавления в систему
    private String login; // буквы/цифры/подчёркивание, <20, не только цифры
    private String password; // буквы/цифры/подчёркивание, <20, не только буквы
    private String confirmPassword; // должен совпадать с password
    private String lastName; // только буквы
    private String firstName; // только буквы
    private String patronymic; // только буквы, может быть null
    private Integer age; // может быть null
    private boolean isWorker; // по умолчанию false


    // Конструктор для создания нового пользователя (createdAt = now)
    public User(String id,
                String login,
                String password,
                String confirmPassword,
                String lastName,
                String firstName,
                String patronymic,
                Integer age,
                Boolean isWorker) {
        this(id, LocalDateTime.now(), login, password, confirmPassword, lastName, firstName, patronymic, age, isWorker);
    }


    // Полный конструктор (используется маппером для чтения из файла)
    public User(String id,
                LocalDateTime createdAt,
                String login,
                String password,
                String confirmPassword,
                String lastName,
                String firstName,
                String patronymic,
                Integer age,
                Boolean isWorker) {
// Валидации
        validateId(id);
        validateLogin(login);
        validatePassword(password, confirmPassword);
        validateName(lastName, "Фамилия");
        validateName(firstName, "Имя");
        if (patronymic != null) validateName(patronymic, "Отчество");
        if (age != null && age < 0) throw new ValidationException("Возраст не может быть отрицательным");


        this.id = id;
        this.createdAt = createdAt == null ? LocalDateTime.now() : createdAt;
        this.login = login;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.age = age;
        this.isWorker = isWorker != null && isWorker;
    }


    private void validateId(String id) {
        if (id == null || id.isBlank()) throw new ValidationException("ID не может быть пустым");
// Разрешим UUID с дефисами и набор из букв/цифр согласно примеру входных данных
        if (!Pattern.matches("[A-Za-z0-9-]+", id))
            throw new ValidationException("ID должен состоять из букв/цифр/дефиса");
    }


    private void validateLogin(String login) {
        if (login == null || login.length() == 0 || login.length() > 20)
            throw new ValidationException("Некорректный логин: пустой или > 20 символов");
        if (login.matches("\\d+"))
            throw new ValidationException("Логин не может состоять только из цифр");
        if (!Pattern.matches("[A-Za-z0-9_]+", login))
            throw new ValidationException("Логин может содержать только буквы, цифры и подчёркивание");
    }


    private void validatePassword(String pass, String confirm) {
        if (pass == null || pass.length() == 0 || pass.length() > 20)
            throw new ValidationException("Некорректный пароль: пустой или > 20 символов");
        if (!Objects.equals(pass, confirm))
            throw new ValidationException("Пароль и подтверждение не совпадают");
        if (pass.matches("[A-Za-z]+"))
            throw new ValidationException("Пароль не может состоять только из букв");
        if (!Pattern.matches("[A-Za-z0-9_]+", pass))
            throw new ValidationException("Пароль может содержать только буквы, цифры и подчёркивание");
    }


    private void validateName(String name, String field) {
// теперь разрешаем буквы (латиница, кириллица, включая Ёё), дефис и пробел
        if (name == null || !Pattern.matches("[А-Яа-яЁёA-Za-z- ]+", name))
            throw new ValidationException(field + " должно содержать только буквы, пробел или дефис");
    }


    // Getters/Setters (минимально необходимые)
    public String getId() { return id; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public String getLogin() { return login; }
    public String getPassword() { return password; }
    public String getConfirmPassword() { return confirmPassword; }
    public String getLastName() { return lastName; }
    public String getFirstName() { return firstName; }
    public String getPatronymic() { return patronymic; }
    public Integer getAge() { return age; }
    public boolean isWorker() { return isWorker; }


    public void setLogin(String login) { validateLogin(login); this.login = login; }
    public void setPassword(String password, String confirmPassword) { validatePassword(password, confirmPassword); this.password = password; this.confirmPassword = confirmPassword; }
    public void setLastName(String lastName) { validateName(lastName, "Фамилия"); this.lastName = lastName; }
    public void setFirstName(String firstName) { validateName(firstName, "Имя"); this.firstName = firstName; }
    public void setPatronymic(String patronymic) { if (patronymic != null) validateName(patronymic, "Отчество"); this.patronymic = patronymic; }
    public void setAge(Integer age) { if (age != null && age < 0) throw new ValidationException("Возраст не может быть отрицательным"); this.age = age; }
    public void setWorker(boolean worker) { isWorker = worker; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }


    @Override
    public int hashCode() { return Objects.hash(id); }


    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", createdAt=" + createdAt +
                ", login='" + login + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", age=" + age +
                ", isWorker=" + isWorker +
                '}';
    }
}
