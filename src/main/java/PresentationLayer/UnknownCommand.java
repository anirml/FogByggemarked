package PresentationLayer;

import FunctionLayer.FogException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UnknownCommand extends Command  {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws FogException {
        String msg = "Unknown command. Contact IT";
        throw new FogException( msg );
    }
}