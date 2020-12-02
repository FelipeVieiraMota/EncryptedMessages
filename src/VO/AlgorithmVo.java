/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author felipe
 */
public class AlgorithmVo {
    private Long index;
    private String algorithm;
    private Date dateCreation;
    private String crypted;
    private String unencrypted;
    private HashMap<String, String> keyByCrypted;
    private HashMap<String, String> keyByUnencrypted;
    private String completePath;

    public AlgorithmVo(Long index, String algorithm, Date dateCreation, String crypted, String unencrypted, HashMap<String, String> keyByCrypted, HashMap<String, String> keyByUnencrypted, String completePath) {
        this.index = index;
        this.algorithm = algorithm;
        this.dateCreation = dateCreation;
        this.crypted = crypted;
        this.unencrypted = unencrypted;
        this.keyByCrypted = keyByCrypted;
        this.keyByUnencrypted = keyByUnencrypted;
        this.completePath = completePath;
    }

    public AlgorithmVo() {
    }

    public Long getIndex() {
        return index;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public String getCrypted() {
        return crypted;
    }

    public String getUnencrypted() {
        return unencrypted;
    }

    public HashMap<String, String> getKeyByCrypted() {
        return keyByCrypted;
    }

    public HashMap<String, String> getKeyByUnencrypted() {
        return keyByUnencrypted;
    }
    
    public String getCompletePath(){
        return completePath;
    }

    public void setIndex(Long index) {
        this.index = index;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public void setCrypted(String crypted) {
        this.crypted = crypted;
    }

    public void setUnencrypted(String unencrypted) {
        this.unencrypted = unencrypted;
    }

    public void setKeyByCrypted(HashMap<String, String> keyByCrypted) {
        this.keyByCrypted = keyByCrypted;
    }

    public void setKeyByUnencrypted(HashMap<String, String> unencryptedKey) {
        this.keyByUnencrypted = unencryptedKey;
    }
    
     public void setCompletePath(String completePath) {
        this.completePath = completePath;
    }
}
