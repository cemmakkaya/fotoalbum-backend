package photoalbum.com.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue
    @NotNull
    private Long userId;

    @Column(nullable = false)
    @Size(max = 255)
    @NotEmpty
    private String username;

    @Column(nullable = false)
    @Size(max = 255)
    @NotEmpty
    private String firstName;

    @Column(nullable = false)
    @Size(max = 255)
    @NotEmpty
    private String secondName;

    @Column(nullable = false)
    @Size(max = 50)
    @NotEmpty
    private String email;

    @Column(nullable = false)
    @NotEmpty
    private String password_hash;
}