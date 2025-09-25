package attestation.attestation01.repositories;

import attestation.attestation01.model.User;


import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
// Формат строки файла:
// id|createdAt|login|password|confirmPassword|lastName|firstName|patronymic|age|isWorker
public class UserMapper {
    public static User fromLine(String line) {
        String[] p = line.split("\\|", -1); // сохраняем пустые поля
        if (p.length < 10) throw new IllegalArgumentException("Некорректная строка пользователя: " + line);
        LocalDateTime createdAt;
        try {
            createdAt = p[1] == null || p[1].isBlank() ?
                    LocalDateTime.now() : LocalDateTime.parse(p[1]);
        } catch (DateTimeParseException e) {
            createdAt = LocalDateTime.now();
        }
        Integer age = (p[8] == null || p[8].isBlank()) ? null :
                Integer.parseInt(p[8]);
        Boolean isWorker = Boolean.parseBoolean(p[9]);
        return new User(
                p[0],
                createdAt,
                p[2],
                p[3],
                p[4],
                p[5],
                p[6],
                p[7].isBlank() ? null : p[7],
                age,
                isWorker
        );
    }
    public static String toLine(User u) {
        return String.join("|",
                u.getId(),
                u.getCreatedAt().toString(),
                u.getLogin(),
                u.getPassword(),
                u.getConfirmPassword(),
                u.getLastName(),
                u.getFirstName(),
                u.getPatronymic() == null ? "" : u.getPatronymic(),
                u.getAge() == null ? "" : String.valueOf(u.getAge()),
                String.valueOf(u.isWorker())
        );
    }
}
