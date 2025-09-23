package attestation.attestation01.repositories;

import attestation.attestation01.exceptions.FileOperationException;
import attestation.attestation01.exceptions.UserNotFoundException;
import attestation.attestation01.model.User;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;
public class UsersRepositoryFileImpl implements UsersRepository {
    private final String fileName; // имя файла задаётся конструктором или используется умолчание
    private List<User> users = new ArrayList<>();
    public static final String DEFAULT_FILE = "users.txt";
    public UsersRepositoryFileImpl() {
        this(DEFAULT_FILE);
    }
    public UsersRepositoryFileImpl(String fileName) {
        this.fileName = fileName;
        loadFromFile();
    }
    private void loadFromFile() {
        users.clear();
        File file = new File(fileName);
        if (!file.exists()) return; // пустой список, если файла нет
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            users = reader.lines()
                    .filter(line -> !line.isBlank())
                    .map(UserMapper::fromLine)
                    .collect(Collectors.toCollection(ArrayList::new));
        } catch (IOException e) {
            throw new FileOperationException("Ошибка чтения файла: " + fileName, e);
        }
    }
    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new
                OutputStreamWriter(new FileOutputStream(fileName, false),
                StandardCharsets.UTF_8))) {
            for (User u : users) {
                writer.write(UserMapper.toLine(u));
                writer.newLine();
            }
        } catch (IOException e) {
            throw new FileOperationException("Ошибка записи файла: " + fileName, e);
        }
    }
    @Override
    public void create(User user) {
// базовая валидация уже в User, здесь только логика
        users.add(user);
        saveToFile();
    }
    @Override
    public User findById(String id) {
        return users.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("Пользователя с заданным идентификатором не существует"));
    }
    @Override
    public List<User> findAll() { return new ArrayList<>(users); }
    @Override
    public void update(User user) {
// найти по id — заменить; если не найден — вывести сообщение исоздать нового
        OptionalInt idxOpt = OptionalInt.empty();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(user.getId())) { idxOpt =
                    OptionalInt.of(i); break; }
        }
        if (idxOpt.isPresent()) {
            users.set(idxOpt.getAsInt(), user);
        } else {
            System.out.println("Пользователь с id " + user.getId() + " не найден. Создаём нового пользователя.");
                    users.add(user);
        }
// если внутри user некорректные поля — ValidationException уже будет выброшено конструктором/сеттером
        saveToFile();
    }
    @Override
    public void deleteById(String id) {
        boolean removed = users.removeIf(u -> u.getId().equals(id));
        if (!removed) throw new UserNotFoundException("Пользователя с заданным идентификатором не существует");
            saveToFile();
    }

    @Override
    public void deleteAll() {
        users.clear();
        saveToFile();
    }
    @Override
    public List<User> findByAge(int age) {
        return users.stream().filter(u -> u.getAge() != null && u.getAge()
                == age).collect(Collectors.toList());
    }
    @Override
    public List<User> findByIsWorker(boolean isWorker) {
        return users.stream().filter(u -> u.isWorker() ==
                isWorker).collect(Collectors.toList());
    }
}
