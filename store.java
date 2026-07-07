package student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * store
 */
public class store {
    List<blueprint> students=new ArrayList<>();
    public void AddStudent(){

        Scanner input=new Scanner(System.in);

        System.out.print("Enter your id:");
        int id=input.nextInt();
        input.nextLine();

        System.out.print("Enter your name:");
        String name=input.nextLine();

        System.out.print("Enter your age:");
        int age=input.nextInt();
        input.nextLine();

        System.out.print("Enter your course:");
        String course=input.nextLine();

        input.close();

        students.add(new blueprint(id, name, age, course));

        for(blueprint bp:students){
            System.out.println(bp.id+" "+bp.name+" "+bp.age+" "+bp.course);
        }
    } 
    public void DataListSave() throws IOException{

        try(
            BufferedWriter bw=new BufferedWriter(new FileWriter("student/data.txt",true))){
            for(blueprint bp:students){
                bw.write(bp.id+" "+bp.name+" "+bp.age+" "+bp.course);
                bw.newLine();
            }
        }
    }
    public void DataReader()throws IOException{
        try(
            BufferedReader bf=new BufferedReader(new FileReader("student/data.txt"))){
                String line;
                while((line=bf.readLine())!=null){
                    System.out.println(line);
                }
            }
    }
    public void UpdateOneData(int IdToChange,String NameToChange,int AgeToChange,String CourseToChange){
        File OldFile=new File("student/data.txt");
        File NewFile=new File("student/temp.txt");
        boolean found=false;
        String changed="";

        try(
            BufferedReader br=new BufferedReader(new FileReader(OldFile));
            BufferedWriter bw=new BufferedWriter(new FileWriter(NewFile));
        ){
            String line;
            while((line=br.readLine())!=null){
                String [] S=line.split(" ");
                int Idfetch=Integer.parseInt(S[0].trim());
                if(Idfetch==IdToChange){
                    if(!NameToChange.isBlank()){
                        found=true;
                        S[1]=NameToChange;
                        line = String.join(" ", S);                        
                        changed=line;
                    }
                    if(AgeToChange!=-1){
                        found=true;
                        S[2]=String.valueOf(AgeToChange);
                        line = String.join(" ", S);                        
                        changed=line;
                    }
                    if(!CourseToChange.isBlank()){
                        found=true;
                        S[3]=String.valueOf(CourseToChange);
                        line = String.join(" ", S);                        
                        changed=line;
                    }
                }
                bw.write(line);
                bw.newLine();
                        
            }
        }
        catch(IOException e){
            System.out.println(e);
        }
        if(OldFile.delete()){
            NewFile.renameTo(OldFile);
        }
        if (found){
            System.out.println("Record with ID " + IdToChange + " Updated Sucessfully.");
            System.out.println(changed);
        }
        else
            System.out.println("No record found with ID " + IdToChange);
    }
    
    public void DeleteAllData(int IdToChange){
        Boolean found=false;
        File OldFile=new File("student/data.txt");
        File NewFile=new File("student/TempFile.txt");
        try(
            BufferedReader br=new BufferedReader(new FileReader(OldFile));
            BufferedWriter br2=new BufferedWriter(new FileWriter(NewFile));
        ){
            String line;
            while((line=br.readLine())!=null){
                String [] S=line.split(" ",2);
                int ID=Integer.parseInt(S[0].trim());

                if(ID==IdToChange){
                    found=true;
                    continue;
                }
                br2.write(line);
                br2.newLine();
            }
        }catch (IOException e) {
            System.out.println("Error in deleting"+e);
            return;
        }
        if(OldFile.delete()){
            NewFile.renameTo(OldFile);
        }
        if (found)
            System.out.println("Record with ID " + IdToChange + " deleted successfully.");
        else
            System.out.println("No record found with ID " + IdToChange);
    }
    
}
