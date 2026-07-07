package student;

import java.io.IOException;
import java.util.Scanner;

public class mainfolder {
    public static void main(String[] args) {
        choice c=new choice();
        store s=new store();
        updatechoice upc=new updatechoice();
        c.MakeChoice();

        Scanner input=new Scanner(System.in);
        System.out.print("Enter your choice:");
        int choice=input.nextInt();

        if(choice==1){
            s.AddStudent();
            try{
            s.DataListSave();
            }catch(IOException e){
                System.out.println("Error");;
            }
        }else if(choice==2){
            try{
                s.DataReader();
            }catch(IOException e){
                System.out.println("Error reading");
            }

        }else if(choice==3){
            upc.upchoice();
            // s.UpdateOneData(idInt, name);

        }else if(choice==4){
            System.out.print("Enter the id you want to delte:");
            int id=input.nextInt();
            s.DeleteAllData(id);
        }
        input.close();
    }
}
