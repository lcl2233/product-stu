package org.bomb.duapp.mp;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
public class User {
    private Long id;

    private String name;

    private String phone;

}
