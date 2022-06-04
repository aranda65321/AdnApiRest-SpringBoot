package com.api.rest.test.adn.TestAdnApiRest.web.controller;

import com.api.rest.test.adn.TestAdnApiRest.models.User;
import com.api.rest.test.adn.TestAdnApiRest.dao.UsersManagerService;
import com.api.rest.test.adn.TestAdnApiRest.models.Matrix;
import com.api.rest.test.adn.TestAdnApiRest.models.MatrixManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



/**
 *
 * @author Juan Aranda
 */
@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@Slf4j
public class AdnApiRestController {

    @Autowired
    private UsersManagerService usersManager;
 
    @Autowired
    private MatrixManager matrixManager;

    @GetMapping(value = "/statistics")
    public String getStatistics(){
        return this.usersManager.generateStadisticJson();
    }

    @PostMapping(value = "/login")
    public boolean loginUser(@RequestBody User user){
        log.info("Iniciando Sesion");
        return  usersManager.loginUser(user);
    }
    
    @PostMapping(value = "/create/user")
    public boolean createPersona(@RequestBody User user){
        return usersManager.createUser(user) != null;
    }

    @PostMapping(value = "/validMatrix/{username}")
    public boolean validAdn(@PathVariable String username, @RequestBody Matrix matrix){
        log.info("Recibiendo matrix");
        boolean isValidAdn = matrixManager.isValidAdn(matrix);
        this.usersManager.saveResultAdn(username, isValidAdn, matrix);
        return isValidAdn;
    }


}
