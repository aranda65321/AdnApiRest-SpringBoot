package com.api.rest.test.adn.TestAdnApiRest.models;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Aranda
 */
@Service
public class MatrixManager {
    public boolean isValidAdn(Matrix matrix){
        ArrayNode matrixProcess = (ArrayNode) matrix.getMatrix();
        return  this.validRowsMatrix(matrixProcess)&&this.validColumnsMatrix(matrixProcess)&&this.validObliquesMatrix(matrixProcess);
    }

    private boolean validRowsMatrix(ArrayNode matrixProcess){
        for(int i = 0; i < matrixProcess.size(); i++){
            int countLetter = 0;
            String previousLetter = "";
            for(int j = 0; j < matrixProcess.size(); j++){
                previousLetter = matrixProcess.get(i).get(j).asText();
                String nextLetter  = j+1 < matrixProcess.size() ?  matrixProcess.get(i).get(j+1).asText(): "";
                countLetter = previousLetter.equalsIgnoreCase(nextLetter) ? countLetter + 1 : 0;
                if(countLetter >= 3){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean validColumnsMatrix(ArrayNode matrixProcess){
        for(int i = 0; i < matrixProcess.size(); i++){
            int countLetter = 0;
            String previousLetter = "";
            for(int j = 0; j < matrixProcess.size(); j++){
                previousLetter = matrixProcess.get(j).get(i).asText();
                String nextLetter  = j+1 < matrixProcess.size() ?  matrixProcess.get(j+1).get(i).asText(): "";
                countLetter = previousLetter.equalsIgnoreCase(nextLetter) ? countLetter + 1 : 0;
                if(countLetter >= 3){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean validObliquesMatrix(ArrayNode matrixProcess) {
        return this.validObliquesOne(matrixProcess)&& this.validObliquesTwo(matrixProcess);
    }
   
    private boolean validObliquesOne(ArrayNode matrixProcess) {
        int countLetter = 0;
        int countObliques = 0;
        String previousLetter = "";
        for(int i = 0; i < matrixProcess.size(); i++){
           previousLetter = matrixProcess.get(i).get(countObliques).asText();
           String nextLetter  = countObliques+1 < matrixProcess.size() && i+1 < matrixProcess.size() ?  matrixProcess.get(i+1).get(countObliques + 1).asText(): "";
           countLetter = previousLetter.equalsIgnoreCase(nextLetter) ? countLetter + 1 : 0;
           if(countLetter >= 3){
               return false;
           }
           countObliques++;
        }
           return true;
    }

    private boolean validObliquesTwo(ArrayNode matrixProcess) {
        int countLetter = 0;
        int countObliques = matrixProcess.size();
        String previousLetter = "";
        for(int i = 0; i < matrixProcess.size(); i++){
           previousLetter = matrixProcess.get(i).get(countObliques-1).asText();
           String nextLetter  = countObliques-1 > 0 ?  matrixProcess.get(i+1).get(countObliques - 2).asText(): "";
           countLetter = previousLetter.equalsIgnoreCase(nextLetter) ? countLetter + 1 : 0;
           if(countLetter >= 3){
               return false;
           }
           countObliques--;
        }
        return  true;
    }
}

