package converter;

import com.entity.Faculty;
import com.model.FacultyFacade;
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
@FacesConverter("facultyConverter")
public class FacultyConverter implements Converter {
    
    FacultyFacade facultyFacade = lookupFacultyFacadeBean();
    
    @Inject
    private FacultyController faculty = new FacultyController();
    
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        if (value != null && value.trim().length() > 0) {
            
            try {
//        Integer jeden = new Integer(1);
        
//        Query q = em.createNamedQuery("Faculty.findByIdfaculty").setParameter("idfaculty", jeden);
//                Faculty f = new Faculty();
//                facultyFacade.find(1);
               Faculty f = facultyFacade.find(Integer.parseInt(value));
//                Faculty f = faculty.find(Integer.parseInt(value));
                return f;
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
            return String.valueOf(((Faculty) object).getIdfaculty());
        } else {
            return null;
        }
    }

    private FacultyFacade lookupFacultyFacadeBean() {
        try {
            Context c = new InitialContext();
            return (FacultyFacade) c.lookup("java:global/swos/swos-ejb/FacultyFacade!com.model.FacultyFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}