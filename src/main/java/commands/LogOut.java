package commands;

public class LogOut implements Commands {
    @Override
    public ResultOfCommand<String> execute()   {
        System.out.println("Succeeded!You logged out");
        ResultOfCommand<String> result = new ResultOfCommand<String>("Succeeded","Log out works",true);
        return result;
    }
}
