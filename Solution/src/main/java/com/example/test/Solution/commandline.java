package com.example.test.Solution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

@Component
public class commandline implements CommandLineRunner{

    @Autowired
    private fruitsVitaminsRepo repo;

    @Override
    public void run(String... args) throws Exception {

        File file = new File(
                "C:\\Users\\admin\\Documents\\test.txt");
        BufferedReader br
                = new BufferedReader(new FileReader(file));

        Map<String,String> map = new HashMap<>();

        String st;
        while ((st = br.readLine()) != null)
        {
            String data[] = st.split(" ");
            map.put(data[0],data[1]);
        }
 //       System.out.println(map);

        for (Map.Entry m : map.entrySet()){
           String str = (String) m.getKey();
           String str1 = (String) m.getValue();
           savedb(str1,str);


        }
        System.out.println(repo.findAll());

    }

    @Async
    public void savedb(String str1, String str){

               fruitsVitamins obj = new fruitsVitamins(str1,str);
               repo.save(obj);

    }


}
