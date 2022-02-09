package com.mowagdy.base.infrastructure.user;

import com.mowagdy.base.domain.shared.dto.ResponseWithId;
import com.mowagdy.base.domain.user.dto.UserCreatingRequest;
import com.mowagdy.base.domain.user.dto.UserFetchingResponse;
import com.mowagdy.base.domain.user.repo.UserRepo;
import com.mowagdy.base.domain.user.usecase.UserCreatingUseCase;
import com.mowagdy.base.domain.user.usecase.UserFetchingUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.mowagdy.base.infrastructure.shared.constant.RestConstants.USERS_BASE_URL_V1;

@RestController
@RequestMapping(USERS_BASE_URL_V1)
public class UserController {

    private final UserRepo userRepo;

    @Autowired
    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserFetchingResponse> fetchSingleUser(@PathVariable("id") Long id) {
        UserFetchingUseCase userFetchingUseCase = new UserFetchingUseCase(id, userRepo);
        return new ResponseEntity<>(userFetchingUseCase.execute(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseWithId> createUser(@RequestBody UserCreatingRequest request) {
        UserCreatingUseCase userCreatingUseCase = new UserCreatingUseCase(request, userRepo);
        return new ResponseEntity<>(userCreatingUseCase.execute(), HttpStatus.CREATED);
    }
}
