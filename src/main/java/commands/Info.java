package commands;
public class Info implements Commands {
    @Override
    public ResultOfCommand<String> execute() throws Exception {
        System.out.println("Welcome to info.Here is the main information about our program:\nThis program called Knights and " +
                "it`s specified on choosing all equipment and weapon for yor knights.\nAfter enter your login,or registration in the base," +
                " you can select and equipment and weapon for the existing knights,\ncreate new weapon and equipment,update or delete existed ones.\nHave a great time.");
        ResultOfCommand<String> result = new ResultOfCommand<String>("Succeeded","Info works",true);
        return result;
    }
}
