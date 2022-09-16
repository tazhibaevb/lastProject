package kg.megacom.lastproject.services.impl;

import kg.megacom.lastproject.microservices.FileServiceFeign;
import kg.megacom.lastproject.microservices.json.Response;
import kg.megacom.lastproject.models.User;
import kg.megacom.lastproject.repositories.UserRepo;
import kg.megacom.lastproject.services.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service

public class UserServiceImpl implements UserService {
    public final UserRepo userRepo;
    private FileServiceFeign fileServiceFeign;


    public UserServiceImpl(UserRepo userRepo, FileServiceFeign fileServiceFeign) {
        this.userRepo = userRepo;
        this.fileServiceFeign = fileServiceFeign;
    }

    @Override
    public User save(User user) {
        User user1 = userRepo.save(user);
        return user1;
    }

    @Override
    public User findById(Long id) {
        return userRepo.findById(id).orElseThrow();
    }

    @Override
    public User update(User user) {
        if (userRepo.existsById(user.getId())) {
            return userRepo.save(user);
        }
        return null;
    }

    @Override
    public User addUser(User user, MultipartFile file) {
        Response response = fileServiceFeign.upload(file);
        user.setImageUri(response.getDownloadUri());

        return save(user);
    }

}
