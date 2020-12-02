/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

/**
 *
 * @author felipe
 */
public class KeyByCrypted {
    private String keyCrypted;
    private String value;

    public KeyByCrypted(String keyCrypted, String value) {
        this.keyCrypted = keyCrypted;
        this.value = value;
    }
    
    public KeyByCrypted() {
    }

    public String getKeyCrypted() {
        return keyCrypted;
    }

    public String getValue() {
        return value;
    }

    public void setKeyCrypted(String keyCrypted) {
        this.keyCrypted = keyCrypted;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
