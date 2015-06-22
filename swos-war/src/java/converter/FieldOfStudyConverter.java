package converter;

import com.entity.Faculty;
import com.entity.FieldOfStudy;
import com.model.FacultyFacade;
import com.model.FieldOfStudyFacade;
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
@FacesConverter("fieldOfStudyConverter")
public class FieldOfStudyConverter implements Converter {
    
    FieldOfStudyFacade fieldOfStudyFacade = lookupFieldOfStudyBean();
  
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        if (value != null && value.trim().length() > 0) {
            
            try {
                return fieldOfStudyFacade.find(Integer.parseInt(value));
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
            return String.valueOf(((FieldOfStudy) object).getIdfieldofstudy());
        } else {
            return null;
        }
    }

    private FieldOfStudyFacade lookupFieldOfStudyBean() {
        try {
            Context c = new InitialContext();
            return (FieldOfStudyFacade) c.lookup("java:global/swos/swos-ejb/FieldOfStudyFacade!com.model.FieldOfStudyFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}