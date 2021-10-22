package hu.me.iit.webalk.random_proverb.repository;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class RepositoryImpl implements Repository {

    @Override
    public List<String> readAllStudents() {
        File studentsFile = new File("students.txt");
        return readFromFile(studentsFile);
    }

    @Override
    public List<String> readAllProverbs() {
        File proverbsFile = new File("proverbs.txt");
        return readFromFile(proverbsFile);
    }

    private List<String> readFromFile(File file){
        List<String> list = new ArrayList<>();

        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while((line = br.readLine()) != null){
                list.add(line);

            }
            br.close();
        } catch(IOException e){
            e.printStackTrace();
        }
        return list;
    }
}
