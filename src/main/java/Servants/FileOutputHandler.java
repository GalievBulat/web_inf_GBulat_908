package Servants;

import DBClasses.User;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;

public final class FileOutputHandler  implements OutputHandler{
    private final String USERS_FILE;
    public FileOutputHandler(){
        USERS_FILE = "C:\\Users\\Kakad\\Documents\\webb\\src\\main\\java\\users.txt";
    }
    public FileOutputHandler(String filename){
        USERS_FILE = filename;
    }
    public void writeTheUserToTheFile(final User user){
        try (BufferedWriter fW = new BufferedWriter(new FileWriter(USERS_FILE,true))){
            fW.write("<>" + "\n");
            fW.write(user.getAuthor_id()+"\n");
            fW.write(user.getName()+"\n");
            fW.write(user.getLogin()+"\n");
            fW.write(user.getPassword()+"\n");
            fW.write(user.getRegistration_date()+"\n");
            fW.write(user.getBirth_date()+"\n");
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(),e);
        }
    }
}
