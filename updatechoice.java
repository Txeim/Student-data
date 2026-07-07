package student;

import java.util.Scanner;

public class updatechoice {
    store s=new store();
    public void upchoice(){
        Scanner input=new Scanner(System.in);
        System.out.print("Enter your id number:");
        int idInt=input.nextInt();
        input.nextLine();
        System.out.print("Enter your new name or Just Enter:");
        String name=input.nextLine().toLowerCase().trim();
        System.out.print("Enter your new age or -1:");
        int age=input.nextInt();
        input.nextLine();
        System.out.print("Enter your new course or Just enter:");
        String course=input.nextLine().toLowerCase().trim();
        s.UpdateOneData(idInt,name,age,course);
        input.close();

    }
    
}
