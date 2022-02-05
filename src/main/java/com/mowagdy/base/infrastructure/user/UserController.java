package com.mowagdy.base.infrastructure.user;

import com.mowagdy.base.domain.shared.dto.ResponseWithId;
import com.mowagdy.base.domain.user.dto.UserCreatingRequest;
import com.mowagdy.base.domain.user.dto.UserFetchingResponse;
import com.mowagdy.base.domain.user.port.UserRepoService;
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

    private final UserRepoService userRepoService;

    @Autowired
    public UserController(UserRepoService userRepoService) {
        this.userRepoService = userRepoService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserFetchingResponse> fetchSingleUser(@PathVariable("id") Long id) {
        UserFetchingUseCase userFetchingUseCase = new UserFetchingUseCase(id, userRepoService);
        return new ResponseEntity<>(userFetchingUseCase.execute(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseWithId> createUser(@RequestBody UserCreatingRequest request) {
        UserCreatingUseCase userCreatingUseCase = new UserCreatingUseCase(request, userRepoService);
        return new ResponseEntity<>(userCreatingUseCase.execute(), HttpStatus.CREATED);
    }
}
