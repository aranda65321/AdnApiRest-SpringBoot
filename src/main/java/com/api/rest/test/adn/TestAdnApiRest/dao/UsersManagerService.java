package com.api.rest.test.adn.TestAdnApiRest.dao;

import com.api.rest.test.adn.TestAdnApiRest.models.Matrix;
import com.api.rest.test.adn.TestAdnApiRest.models.ResultsAdn;
import com.api.rest.test.adn.TestAdnApiRest.models.User;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Juan Aranda
 */
@Service
@Slf4j
public class UsersManagerService {

    @Autowired
    private IUsersRepository usersRepository;
    @Autowired 
    private IResultsAdn resultAdnRepository;
  
    @Transactional(readOnly = true)
    public boolean loginUser(User user){
        return usersRepository.getUserByAuthtenticate(user.getUsername(), user.getPassword()) != null;
    }

    public User createUser(User user){
       return usersRepository.countUser(user.getUsername()) > 0 ? null : this.usersRepository.save(user);
    }

    @Transactional
    public void saveResultAdn(String username, boolean isValid, Matrix matrix){
       User user = usersRepository.getUserByUsername(username);
       resultAdnRepository.insertNewResult(user.getId(), isValid, matrix.getJsonMatrix());
    }

    @Transactional
    public String generateStadisticJson(){
        Long countValids = resultAdnRepository.countAdnValid();
        Long countInvalids = resultAdnRepository.countAdnInvalid();
        return "{\"count_correct_dna\":"+countValids+",\"count_defect_dna\":"+countInvalids+",\"ratio\":"+countValids/countInvalids+"}";
    } 
}
