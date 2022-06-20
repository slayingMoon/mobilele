package bg.softuni.mobilele.model.mapper;

import bg.softuni.mobilele.model.dto.UserRegisterDto;
import bg.softuni.mobilele.model.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-20T14:10:38+0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User userDtoToUserEntity(UserRegisterDto registerDto) {
        if ( registerDto == null ) {
            return null;
        }

        User user = new User();

        user.setPassword( registerDto.getPassword() );
        user.setFirstName( registerDto.getFirstName() );
        user.setLastName( registerDto.getLastName() );
        user.setEmail( registerDto.getEmail() );

        user.setActive( true );

        return user;
    }
}
