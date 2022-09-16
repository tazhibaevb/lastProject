package kg.megacom.lastproject.services;

import kg.megacom.lastproject.models.User;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {
    User save(User user);

    User findById(Long id);

    User update(User user);

    User addUser(User user, MultipartFile file);
}
