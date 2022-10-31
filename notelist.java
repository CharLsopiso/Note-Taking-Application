package Notes;
import java.util.*;

public class notelist extends noteinfo {

    private List<noteinfo>noteList = new ArrayList<>(); 
    public static Scanner Scanner = new Scanner(System.in); 
    public static String Title, Contents, IntChoose; 
    public static int choose; 

    public notelist() {
        super(Title, Contents);
    }
    
    public void ExistingNotes() 
    {
        noteinfo newnote1 = new noteinfo("Shopping List", "\n-1 Tray Eggs \n-5 kg Chicken Drumsticks \n-Milk \n-Oil \n-Marinade Ingredients \n-Ham \n-Bread \n-Butter \n-Soy Sauce \n-Vinegar");
        noteinfo newnote2 = new noteinfo("Failure", "\nI can accept failure. Everyone fails at something. But I can't accept not trying. \n\n- Michael Jordan");
        noteinfo newnote3 = new noteinfo("Success", "\nEvery failure is a step to success. \n");
        noteinfo newnote4 = new noteinfo("Hardwork", "\nSuccess is often achieved by those who don't know that failure is inevitable. \n");
        noteinfo newnote5 = new noteinfo("Love", "\nWhere there is love, there is life. \n");
        noteList.add(newnote1);
        noteList.add(newnote2);
        noteList.add(newnote3);
        noteList.add(newnote4);
        noteList.add(newnote5);
    }

    private void AddNotesMethod() { 
        System.out.println("\nNote Taking App - Add Note");
        System.out.print("\nEnter Title: ");
        Scanner.nextLine();
        Title = Scanner.nextLine();
    
        for(noteinfo notes : noteList) {

            if(notes.getTitle().equals(Title)) {
                System.out.println("\nNote Title Already Existed! Please Use A Unique Title.");
                System.out.println("\n\n===========[TRY AGAIN!!]===========\n\n\n");
                MainMethod();
            }
        }
    
        System.out.print("\nEnter Contents: ");
        Contents = Scanner.nextLine();

        noteinfo notes = new noteinfo(Title, Contents);
        noteList.add(notes);
        System.out.println("\n\n===========[YOU'VE SUCCESSFULLY ADDED A NOTE!]===========\n\n\n");

        Ask();
    }

    private void Ask() { 

        System.out.println("\nWant To Add More Note?\n\n[1] Yes [2] No, Return to Main Menu");
        System.out.println("\n\nPlease Input Numbers Only: ");
        IntChoose = Scanner.next();
        
        try { 
            choose = Integer.parseInt(IntChoose);
        } catch (Exception e) {
            System.out.println("\nNot A Defined Input.");
            System.out.println("\n\n===========[PLEASE TRY AGAIN!!]===========\n\n");
            Ask();
        }

        switch(choose) {

            case 1: 
                AddNotesMethod();
                break;
           
            case 2: 
                MainMethod();
                break;

            default: 
                System.out.println("\nNot A Defined Input, Please Input [1] or [2] Only.");
                System.out.println("\n\n===========[TRY AGAIN!!]===========\n\n\n");
                Ask();             
        }
    }

    private void ShowMethod() { 

        System.out.println("\n\nNote Taking App - Show All Notes");

        System.out.println("\nATTENTION!! IF IT DOESN'T SHOW ANY NOTES, "
        + "THEN IT MEANS THAT IT DOESN'T HAVE ANY EXISTING NOTES AND FOR IT TO DIPLAYS A NOTE YOU NEED TO "
        + "ADD A NOTE!\n\n");

        System.out.println("\n===========[DISPLAYING NOTES]===========\n");

        for(noteinfo notes : noteList) {

            System.out.print("\nTitle: " + notes.getTitle() 
            +"\nContents: " + notes.getContents()          
            +"\n\n\n");
        }
        MainMethod(); 
    }

    private void DeleteMethod() { 

        System.out.print("\nEnter Note Title to Delete: ");
        Scanner.nextLine();
        Title = Scanner.nextLine();

        Iterator<noteinfo>itr = noteList.iterator(); 

        while(itr.hasNext()) { 
            
            if(itr.next().getTitle().equalsIgnoreCase(Title)) { 
                itr.remove();
                System.out.print("\n\n===========[NOTE SUCCESSFULLY DELETED!]===========\n\n\n");
                return;
            }
        }
        System.out.println("\n\n===========[NOTE TITLE NOT FOUND! PLEASE TRY AGAIN]===========\n\n\n");
        MainMethod(); 
    }

    private void FindNoteMethod() { 

        System.out.print("\nEnter Note Title To Find: ");
        Scanner.nextLine();
        String noteSearch = Scanner.nextLine();

        for(noteinfo notes : noteList) { 

            if(notes.getTitle().equals(noteSearch)) {
                System.out.println("\n\n===========[NOTE FOUND!]===========\n\n\n");
                System.out.print("\nNote Title: " + notes.getTitle());
                System.out.print("\nContents: " + notes.getContents() + "\n");
                return;
            }
        }
        System.out.println("\n\n===========[NOTE NOT FOUND! PLEASE TRY AGAIN]===========\n\n\n");
        MainMethod();
    }

    private void UpdateEditNotes() { 
        
    
    while(choose!=99) {

        System.out.println("\n\nWhat do you want to Update? \n[1] :: Title\n[2] :: Content \n[3] :: Return to Main Menu");
        

        System.out.println("\nPlease Input Numbers Only: ");
        IntChoose = Scanner.next();

        try{
            choose = Integer.parseInt(IntChoose);

        }catch(Exception e) {
            System.out.print("\n\n===========[You Selected An Invalid Choice, Please Try Again!]===========\n\n\n");
            UpdateEditNotes(); 
        }

        switch(choose) {

            case 1: 
                
                System.out.print("\nEnter the Title of the Note to be edited: "); 
                Scanner.nextLine(); 
                String title = Scanner.nextLine();
        
                for(noteinfo notes : noteList) { 
                

                    if(notes.getTitle().equals(title)) { 
                    
                        System.out.println("\nEnter New Title: "); 
                        Title = Scanner.nextLine();
                        notes.setTitle(Title); 

                        System.out.println("\nYou've Successfully Edited The Title Of This Note");
                        UpdateEditNotes(); 

                }
            }
                    System.out.println("\n\n===========[NOTE TITLE NOT FOUND! PLEASE TRY AGAIN]===========\n\n\n");
                    break;
        
            case 2: 
               
                System.out.println("\nEnter The Note Title of the content you want to update: ");
                

                Scanner.nextLine();
                String TITLE = Scanner.nextLine();  
            
                for(int i=0; i<noteList.size(); i++){
                    

                    if(noteList.get(i).getTitle().equalsIgnoreCase(TITLE)){

                        System.out.println("\nEnter New Content: "); 
                        Contents = Scanner.nextLine();
                        noteList.get(i).setContents(Contents); 

                        System.out.println("\nYou've Successfully Edited The Contents Of This Note");
                        UpdateEditNotes(); 
                }
            }
            System.out.println("\n\n===========[NOTE TITLE NOT FOUND! PLEASE TRY AGAIN]===========\n\n\n");
            break;

            case 3: 
            MainMethod();

            default: 
            System.out.println("\nNot A Defined Input, Please Input Numbers From 1-3 Only.");
        }
    }
    }
    
    private void Exit() { 
        System.out.println("\n\n===========[CLOSED APP SUCCESSFULLY!]===========\n\n\n");
        System.exit(0);
    }

    public void MainMethod() {

        while(true){
            System.out.println("\n===================");
            System.out.println("  NOTE-TAKING APP  ");
            System.out.println("===================");
            System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("|                                 |");
            System.out.println("|  [1] Add Note                   |");
            System.out.println("|  [2] Show All Notes             |");
            System.out.println("|  [3] Delete Note                |");
            System.out.println("|  [4] Find Note                  |");
            System.out.println("|  [5] Update/Edit Note           |");
            System.out.println("|  [6] Exit Note                  |");
            System.out.println("|                                 |");
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("\nEnter Choice (numbers only): ");
            IntChoose = Scanner.next();

            try {
                choose = Integer.parseInt(IntChoose);

            }catch (Exception e){ 
                System.out.print("\n\n===========[You Selected An Invalid Choice, Please Try Again!]===========\n\n\n");
                MainMethod(); 
            }
            
            switch(choose){ 

                case 1: 
                    AddNotesMethod();
                    break; 
                case 2:
                    ShowMethod(); 
                    break;
                case 3:
                    DeleteMethod(); 
                    break;
                case 4:
                    FindNoteMethod();
                    break;
                case 5:
                    UpdateEditNotes(); 
                    break;
                case 6:
                    Exit();
                    break;
                default:
                System.out.print("\n\n===========[You Selected An Invalid Choice, Please Try Again!]===========\n\n\n");
            }
        }
    }
}
