package kg.megacom.lastproject.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Data
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class User {

    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String imageUri;
    String email;
    @Enumerated(value = EnumType.STRING)
    Status status;
}
