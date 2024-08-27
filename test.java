import java.util.Scanner;
class underAgeException extends Exception{
    public String getmessage(){
        return "you are too young";
       } 
}
class overAgeException extends Exception{
    public String getmessage(){
        return "you are too old";
       } 
}
class applicant{
   private  int age;
    void acceptinput(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your age:");
        age=sc.nextInt();
    }
    void validate() throws underAgeException, overAgeException{
        if(age>=18 && age<=60){
            System.out.println("you are eligible to apply");
        }
        else if(age<18){
            underAgeException  uae=new underAgeException ();
            System.out.println(uae.getmessage());
            throw uae;
        }
        else if(age>60){
            overAgeException oae=new overAgeException();
            System.out.println(oae.getmessage());
            throw oae;
        }
    }
}
class RTO{
    void initiate(){
    applicant ap=new applicant();
        for(;;){
            Scanner sc=new Scanner(System.in);
            System.out.println("Do you want to apply license yes/no:");
            String ans=sc.next();
            
            if(ans.equals("yes")){
                try{
                    ap.acceptinput();
                    ap.validate();
                }
                catch(Exception e){

                }
            }
            else{
                System.out.println("invalid input");
                System.out.println("Thanks for visiting!");
                System.exit(0);
            }

        }
        
    }
}
class test{
    public static void main (String args[]){
        RTO r= new RTO();
        r.initiate();

    }
}
