package converter;

import com.entity.Faculty;
import com.entity.FieldOfStudy;
import com.entity.LabGroup;
import com.model.FacultyFacade;
import com.model.FieldOfStudyFacade;
import com.model.LabGroupFacade;
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
@FacesConverter("labGroupConverter")
public class LabGroupConverter implements Converter {
    
    LabGroupFacade labGroupFacade = lookupLabGroupBean();
  
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        if (value != null && value.trim().length() > 0) {
            
            try {
                return labGroupFacade.find(Integer.parseInt(value));
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
            return String.valueOf(((LabGroup) object).getIdlabgroup());
        } else {
            return null;
        }
    }

    private LabGroupFacade lookupLabGroupBean() {
        try {
            Context c = new InitialContext();
            return (LabGroupFacade) c.lookup("java:global/swos/swos-ejb/LabGroupFacade!com.model.LabGroupFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}