package attestation.repositories;

import attestation.attestation01.attestation01.User;

import java.util.List;
public interface UsersRepository {
    void create(User user);
    User findById(String id);
    List<User> findAll();
    void update(User user);
    void deleteById(String id);
    void deleteAll();
    // Дополнительно
    List<User> findByAge(int age);
    List<User> findByIsWorker(boolean isWorker);
}