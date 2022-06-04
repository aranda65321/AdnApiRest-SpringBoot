
package com.api.rest.test.adn.TestAdnApiRest.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.Serializable;

/**
 *
 * @author Juan Aranda
 */

public class Matrix implements Serializable{
    private JsonNode matrix;

    public Matrix() {
    }

    public Matrix(JsonNode matrix) {
        
    }
    public JsonNode getMatrix() {
        return matrix;
    }

    public void setMatrix(JsonNode matrix) {
        this.matrix = matrix;
    }

    public String getJsonMatrix(){
        ObjectMapper mapper = new ObjectMapper();
        String valueJson = "";
        try {
            valueJson = mapper.writeValueAsString(this.matrix);
        } catch (JsonProcessingException e) {
            System.out.println(e);
        }
        return valueJson;
    }

}
