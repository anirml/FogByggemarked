package PresentationLayer;

import FunctionLayer.LoginSampleException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put( "login", new Login() );
        commands.put( "register", new Register() );
        commands.put( "nav", new Nav() );
        commands.put( "makeRequest" , new MakeRequest() );
        commands.put( "choice", new ChoiceJ());
        commands.put( "calculate", new CalculateJ());
        commands.put( "toolshedchoice", new ToolshedChoice() );
        commands.put( "makeRequestBack", new MakeRequest() );
        commands.put( "mypage", new MyPage() );
        commands.put( "makewood", new MakeWood());
    }

    static Command from( HttpServletRequest request ) {
        String commandName = request.getParameter( "command" );
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand() );
    }

    abstract String execute( HttpServletRequest request, HttpServletResponse response ) 
            throws LoginSampleException;

}
