package converter;

import com.entity.Faculty;
import com.entity.LabGroup;
import com.entity.Lecturer;
import com.model.FacultyFacade;
import com.model.LabGroupFacade;
import com.model.LecturerFacade;
import controller.FacultyController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.Query;


/**
 *
 * @author akis
 */
@FacesConverter("lecturerConverter")
public class LecturerConverter implements Converter {
    LecturerFacade lecturerFacade = lookupLabGroupFacadeBean();
    

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        if (value != null && value.trim().length() > 0) {          
            try {
                return lecturerFacade.find(Integer.parseInt(value));
            } catch (NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion error", "Zly wybor."));
            }
        } else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object object) {
        if (object != null) {
            return String.valueOf(((Lecturer) object).getIdlecturer());
        } else {
            return null;
        }
    }

    private LecturerFacade lookupLabGroupFacadeBean() {
        try {
            Context c = new InitialContext();
            return (LecturerFacade) c.lookup("java:global/swos/swos-ejb/LecturerFacade!com.model.LecturerFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }



}