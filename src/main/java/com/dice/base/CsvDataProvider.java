package com.dice.base;

import au.com.bytecode.opencsv.CSVReader;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by asok on 5/15/2018.
 */
public class CsvDataProvider {

    @DataProvider(name = "CsvDataProvider")
    public static Iterator<Object[]> providerData(Method method){
        List<Object[]> list = new ArrayList<Object[]>();
        String parhname = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "test_data"
                + File.separator +method.getDeclaringClass().getSimpleName() + "_" + method.getName() + ".csv";
        File file = new File(parhname);
        try{
            CSVReader reader = new CSVReader(new FileReader(file));
            String[] keys = reader.readNext();
            if(keys != null){
                String[] dataParts;
                while ((dataParts = reader.readNext()) != null){
                    Map<String, String> testData = new HashMap<String, String>();
                    for (int i = 0; i < keys.length; i++){
                        testData.put(keys[i], dataParts[i]);
                    }
                    list.add(new Object[]{ testData });
                }
            }
            reader.close();
        } catch (FileNotFoundException e){
            throw new RuntimeException("File " + parhname + " was not found.\n" + e.getStackTrace().toString());
        } catch (IOException e) {
            throw new RuntimeException("Could not read " + parhname + " file.\n" + e.getStackTrace().toString());
        }

        return list.iterator();
    }
}
