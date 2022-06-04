
package com.api.rest.test.adn.TestAdnApiRest.dao;

import com.api.rest.test.adn.TestAdnApiRest.models.ResultsAdn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Juan Aranda
 */
public interface IResultsAdn extends JpaRepository<ResultsAdn, Long> {
    @Modifying
    @Query(value = "INSERT INTO RESULT_ADN  VALUES(:id, :isValid, :jsonContent)",  nativeQuery = true)
    public void insertNewResult(@Param("id") Long id, @Param("isValid") boolean isValid, @Param("jsonContent") String jsonContent);
    @Query(value = "select count(*) from RESULT_ADN  where IS_VALID=TRUE", nativeQuery = true)
    public Long countAdnValid();
    @Query(value = "select count(*) from RESULT_ADN  where IS_VALID=FALSE", nativeQuery = true)
    public Long countAdnInvalid();
}