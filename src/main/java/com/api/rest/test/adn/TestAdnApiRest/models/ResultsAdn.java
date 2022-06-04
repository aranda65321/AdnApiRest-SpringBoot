package com.api.rest.test.adn.TestAdnApiRest.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Juan Aranda
 */
@Entity
@Table(name = "RESULT_ADN")
public class ResultsAdn implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;
    @Column(name="IS_VALID")
    private boolean isValidAdn;
    @Column(name = "CONTENT_ADN")
    private String contentAdn;

    public ResultsAdn() {
    }

    public ResultsAdn(Long id, boolean isValidAdn, String contentAdn) {
        this.id = id;
        this.isValidAdn = isValidAdn;
        this.contentAdn = contentAdn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isIsValidAdn() {
        return isValidAdn;
    }

    public void setIsValidAdn(boolean isValidAdn) {
        this.isValidAdn = isValidAdn;
    }

    public String getContentAdn() {
        return contentAdn;
    }

    public void setContentAdn(String contentAdn) {
        this.contentAdn = contentAdn;
    }

}
