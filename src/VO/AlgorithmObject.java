/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public class AlgorithmObject {
    private ArrayList<AlgorithmVo> jsonDataBase;

    public AlgorithmObject(ArrayList<AlgorithmVo> jsonDataBase) {
        this.jsonDataBase = jsonDataBase;
    }

    public ArrayList<AlgorithmVo> getAlgorithmVo() {
        return jsonDataBase;
    }

    public void setAlgorithmVo(ArrayList<AlgorithmVo> jsonDataBase) {
        this.jsonDataBase = jsonDataBase;
    }
}
