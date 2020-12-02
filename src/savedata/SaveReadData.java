/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package savedata;

import VO.AlgorithmObject;
import VO.AlgorithmVo;
import VO.KeyByCrypted;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author felipe
 */
public class SaveReadData {
    
    public boolean mainRule(String unencryptedKey, String cryptedValue, String algorithm)throws FileNotFoundException, IOException{
        AlgorithmVo vo = new AlgorithmVo();
        setObject(unencryptedKey, cryptedValue, algorithm, vo);
        setFilePath(vo);
        verifyIfFileExists(vo);
        return true;
    }
    
    public KeyByCrypted findMode(String value, String algorithm)throws FileNotFoundException, IOException{
        KeyByCrypted keyByCrypted = null;
        
        AlgorithmVo vo = new AlgorithmVo();
        
        vo.setAlgorithm(algorithm);
        
        setFilePath(vo);
        
        AlgorithmObject algorithmObject = parseFileContentStringToJsonObject(vo);
        
        for( var algorithmVo : algorithmObject.getAlgorithmVo() ){
            if (algorithmVo.getCrypted().equals(value) || algorithmVo.getUnencrypted().equals(value)){
                keyByCrypted = new KeyByCrypted();
                keyByCrypted.setKeyCrypted(algorithmVo.getCrypted());
                keyByCrypted.setValue(algorithmVo.getUnencrypted());
            }
        }
        
        return keyByCrypted;
    }
    
    private void setObject(String unencryptedKey, String cryptedValue, String algorithm, AlgorithmVo vo){
        
        Date date = new Date();
        
        HashMap<String , String> mapUnencryptedKey = new HashMap<>();
        mapUnencryptedKey.put(unencryptedKey, cryptedValue);
        
        HashMap<String , String> mapKeyByCrypted = new HashMap<>();
        mapKeyByCrypted.put(cryptedValue, unencryptedKey);
        
        vo.setKeyByUnencrypted(mapUnencryptedKey);
        
        vo.setKeyByCrypted(mapKeyByCrypted);
        
        vo.setCrypted(cryptedValue);
        
        vo.setUnencrypted(unencryptedKey);
        
        vo.setDateCreation(date);
        
        vo.setAlgorithm(algorithm);
    }
    
    private void setFilePath(AlgorithmVo vo) throws IOException{
        
        String userName = getProcessResult(Runtime.getRuntime().exec("whoami"));
        
        switch (vo.getAlgorithm()) {
            case "md5":
                vo.setCompletePath("/home/"+userName+"/data-base-json/md5/md5.json");
                break;
            case "sha-1":
                vo.setCompletePath("/home/"+userName+"/data-base-json/sha-1/sha-1.json");
                break;
            default:
                vo.setCompletePath("/home/"+userName+"/data-base-json/sha-256/sha-256.json");
                break;
        }
    }
    
    private void verifyIfFileExists(AlgorithmVo vo)throws FileNotFoundException, IOException{
        if(!new File(vo.getCompletePath()).exists())
            saveData(vo);
        else
            updateData(vo);
    }
    
    private boolean saveData(AlgorithmVo vo) throws FileNotFoundException, IOException{
        
        File file = new File(vo.getCompletePath());
        file.createNewFile();
        Gson gson = new Gson();
        ArrayList<AlgorithmVo> voArray = new ArrayList<>();
        voArray.add(vo);
        AlgorithmObject algorithmObject = new AlgorithmObject(voArray);
        try (FileWriter writer = new FileWriter(vo.getCompletePath())) {
            writer.write(gson.toJson(algorithmObject));
            writer.close();
        }
        return true;
    }
    
    private boolean updateData(AlgorithmVo vo) throws FileNotFoundException, IOException{
        
        AlgorithmObject algorithmObject = parseFileContentStringToJsonObject(vo);
        
        algorithmObject.getAlgorithmVo().add(vo);
        
        try (FileWriter writer = new FileWriter(vo.getCompletePath())) {
            writer.write(new Gson().toJson(algorithmObject));
            writer.close();
        }
        
        return true;
    }
    
    private AlgorithmObject parseFileContentStringToJsonObject(AlgorithmVo vo)throws FileNotFoundException, IOException{
        String line = "";
        try (BufferedReader buffRead = new BufferedReader(new FileReader(vo.getCompletePath()))) {
            while (buffRead.ready()) 
                line += buffRead.readLine();
            return new Gson().fromJson(line, AlgorithmObject.class);
        }
    }
    
    public String getProcessResult(Process process) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        String processResult = "";
        while ((line = reader.readLine()) != null) {
            processResult += line;
        }
        return processResult;
    }
}
